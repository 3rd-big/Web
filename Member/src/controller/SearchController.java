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

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		JoinService service = new JoinServiceImpl();
		
		// 세션 생성
		HttpSession session = request.getSession(false);
		
		// 세션에 저장한 id 즉, 로그인한 id를 읽는다.
		String id = (String) session.getAttribute("id");
		
		// 로그인한 id로 멤버 정보 검색
		Member m = service.getMember(id);
		
		// 검색 결과인 객체 m을 request객체에 이름 "m"으로 저장
		request.setAttribute("m", m);
		
		// 정보 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberInfo.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
