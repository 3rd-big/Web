package img.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.Service;
import img.service.ServiceImpl;
import model.Img;

@WebServlet("/ImgList")
public class ImgList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ImgList() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		//rep.service.Service rep_service = new rep.service.ServiceImpl();
		ArrayList<Img> imgs = service.getAll();
		request.setAttribute("imgs", imgs);
		String path = "/imgBoard/imgList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
