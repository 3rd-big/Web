package step4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet6")
public class MyServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet6() {

    }

    // TODO 이 부분 아주 중요함!! 무조건 이해하고 넘어갈 것
    // 114p 내용. Scope 영역. 페이지 이동 시 사용 할 수 있는 변수?(전역변수)로 이해하면 될 듯
    // ex) 1.jsp 에서 사용했던 변수값을 2.jsp 에서도 사용 가능한지 등등 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 요청에 대한 응답이 전달되기 전까지 유효
		request.setAttribute("requestInfo", "test1");
		
		// 현재 session 객체 획득
		HttpSession session = request.getSession();
		
		// session에 정보 저장
		// 클라이언트와 연결이 끊길 때까지 유효
		session.setAttribute("sessionInfo", "test2");
		
		// ServletContext 객체 획득. 어플리케이션 전체에 대한 정보 공유
		ServletContext application = getServletContext();
		
		// application 객체에 저장
		// 이 어플리케이션이 종료할 때까지 모든 파일이 공유
		application.setAttribute("applicationInfo", "test3");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MyServlet7");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
