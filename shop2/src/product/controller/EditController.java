package product.controller;

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

import model.Product;
import product.service.Service;
import product.service.ServiceImpl;

@WebServlet(name = "ProdEditController", urlPatterns = { "/seller/Edit" })
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		
		Product p = new Product();
		
		p.setNum(Integer.parseInt(request.getParameter("num")));
		p.setName(request.getParameter("name"));
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setContent(request.getParameter("content"));
		
		service.editProduct(p);
		response.sendRedirect("/shop2/seller/List");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
