package img.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rep;
import rep.service.Service;
import rep.service.ServiceImpl;

@WebServlet("/RepController")
public class RepController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RepController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Service service = new ServiceImpl();
		Rep rep = new Rep();
		rep.setWriter(request.getParameter("writer"));
		rep.setImg_num(Integer.parseInt(request.getParameter("img_num")));
		rep.setContent(request.getParameter("content"));
		service.addRep(rep);
		ArrayList<Rep> reps = service.getRepsByImg_num(rep.getImg_num());
		request.setAttribute("reps", reps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/imgBoard/repList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
