package order.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Order;
import order.service.Service;
import order.service.ServiceImpl;

@WebServlet("/order/add")
public class OrderAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderAddController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		HttpSession session = request.getSession(false);
		String o_id = (String) session.getAttribute("id");
		Order o = new Order();

		o.setPro_num(Integer.parseInt(request.getParameter("num")));
		o.setOrder_num(Integer.parseInt(request.getParameter("quantity")));
		o.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		o.setO_id(o_id);
		o.setO_state(Integer.parseInt(request.getParameter("o_state")));
		service.addOrder(o);
		String path = "/shop2/order/myList?o_state=";
		path += o.getO_state();
		response.sendRedirect(path);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
