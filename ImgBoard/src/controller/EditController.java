package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.Service;
import service.ServiceImpl;

@WebServlet(name = "ProdEditController", urlPatterns = {"/seller/Edit"})
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ServiceImpl();
		
		Product p = new Product();
		
		p.setNum(Integer.parseInt(request.getParameter("num")));
		p.setName(request.getParameter("name"));
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setContent(request.getParameter("content"));
		
		service.editProduct(p);
		response.sendRedirect("/ImgBoard/seller/List");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
