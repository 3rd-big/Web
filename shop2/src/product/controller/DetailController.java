package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import product.service.Service;
import product.service.ServiceImpl;

@WebServlet("/seller/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = "/view/seller/detail.jsp";
		
		HttpSession session = request.getSession(false);
		
		int type = (Integer) session.getAttribute("memberType");
		int num = Integer.parseInt(request.getParameter("num"));
		
		Service service = new ServiceImpl();
		
		Product p = service.getProduct(num);
		request.setAttribute("p", p);
		if(type == 2) {
			path = "/view/order/detail.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
