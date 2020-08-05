package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import service.JoinService;
import service.JoinServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		// 기능을 제공할 서비스 객체 생성
		JoinService service = new JoinServiceImpl();
		
		boolean flag = false;
		
		// 세션 생성
		HttpSession session = request.getSession();
		
		// 로그인에 필요한 요청 파라미터를 읽는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// id로 멤버 검색
		Member m = service.getMember(id);
		
		// id가 동일한 멤버가 있고 비밀번호도 동일하면 로그인 성공
		if(m != null && pwd.equals(m.getPwd())) {
			// 로그인 성공한 id를 세션에 저장
			session.setAttribute("id", id);
			
			// 로그인 성공 여부를 flag에 저장
			flag = true;
		}
		
		// 세션에 로그인 성공 여부를 저장
		session.setAttribute("flag", flag);
		
		// 메뉴 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/result.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
