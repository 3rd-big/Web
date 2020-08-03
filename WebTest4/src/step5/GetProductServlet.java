package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ProductVO;

/**
 * Servlet implementation class GetProductServlet
 */
@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetProductServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		ProductVO vo = (ProductVO) context.getAttribute("product");
		out.print(this.getServletName() + "ServletContext로 부터 vo getting");
		out.print("<hr>");
		out.print("아이디: " + vo.getId() + "<hr>");
		out.print("이름: " + vo.getName() + "<hr>");
		out.print("가격: " + vo.getPrice() + "<hr>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
