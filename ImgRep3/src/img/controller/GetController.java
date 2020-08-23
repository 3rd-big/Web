package img.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.Service;
import img.service.ServiceImpl;
import model.Img;

@WebServlet("/GetController")
public class GetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		
		int num = Integer.parseInt(request.getParameter("num"));
		Img i = service.getImg(num);
		
		request.setAttribute("i", i);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/imgBoard/addImg.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
