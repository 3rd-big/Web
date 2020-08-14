package order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Product;
import order.service.Service;
import order.service.ServiceImpl;

@WebServlet("/order/myList")
public class MyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyListController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		product.service.Service service_prod = new product.service.ServiceImpl();

		int o_state = Integer.parseInt(request.getParameter("o_state"));
		HttpSession session = request.getSession(false);
		String o_id = (String) session.getAttribute("id");
		ArrayList<Order> list = service.orderList(o_id, o_state);
		for(Order o : list) {
			Product p = service_prod.getProduct(o.getPro_num());
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
		}
		request.setAttribute("list", list);
		request.setAttribute("o_state", o_state);
		String path = "/view/order/myList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
