package img.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.Service;
import img.service.ServiceImpl;
import model.Img;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String pwd = request.getParameter("pwd");
		Img i = new Img(num, writer, pwd, title, null, null);
		service.editImg(i);
		response.sendRedirect("GetController?num=" + num);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
