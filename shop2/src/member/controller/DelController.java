package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.Service;
import member.service.ServiceImpl;

@WebServlet("/DelController")
public class DelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		
		HttpSession session = request.getSession(false);
		
		String id = (String) session.getAttribute("id");
		
		session.invalidate();
		
		service.remMember(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/member/loginForm.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
