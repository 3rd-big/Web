package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberVO;
import service.Service;
import service.ServiceImpl;

@WebServlet("/IdCheckController")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IdCheckController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
	
		Service service = new ServiceImpl();
		MemberVO vo = null;
		
		String id = request.getParameter("id");
		System.out.println(id);
		vo = service.findMember(id);
		System.out.println(vo);
		boolean flag = false;
		if(vo == null) {
			flag = true;
		}
	
		request.setAttribute("flag", flag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("5.check.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
