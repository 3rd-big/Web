package step5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet2() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 세션 객체를 획득한다. getSession()의 파라미터 false로 설정하면 현재 세션이 있을경우 이를 반환하고 없으면 null을 반환한다.
		// 만약 파라미터가 없거나 true이면 세션이 없을 경우 새로 생성한 세션 객체를 반환한다.
		HttpSession session = request.getSession(false);
		boolean result = false;
		
		// id와 pwd가 "aaa", "123"이면 로그인이 성공하여 result변수에 true를 저장하고 세션에 id를 저장한ㄷ.
		if(id.equals("aaa") && pwd.equals("123")) {
			result = true;
			session.setAttribute("id", id);
		}
		
		// 세션에 로그인 결과인 result값을 저장한다. 로그인이 성공했으면 true, 실패했으면  false를 저장한다.
		session.setAttribute("result", result);
		
		// 페이지 이동을 실행할 Dispatcher객체를 생성한다. 이동할 페이지는 loginREsult.jsp로 설정
		// Dispatcher객체가 null이 아니면 forward로 이동한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
