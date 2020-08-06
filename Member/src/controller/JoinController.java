package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.JoinService;
import service.JoinServiceImpl;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		// 기능을 제공할 서비스 객체 생성
		JoinService service = new JoinServiceImpl();
		
		// 요청 파라미터 값 읽기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// 요청 파라미터로 읽은 값으로 Member 객ㅊ ㅔ생성
		Member m = new Member(id, pwd, name, email);
		
		// 서비스의 회원가입 기능 실행
		service.join(m);
		
		// 로그인 폼으로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginForm.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}