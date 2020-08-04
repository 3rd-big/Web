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

@WebServlet("/SetProductServlet")
public class SetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetProductServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		context.setAttribute("product", new ProductVO("nexus", "넥서스S", 100));
		out.print("ServletContext에 data setting...");
		out.print(this.getServletName() + "ServletContext에 vo setting" + "<hr>");
		out.print("<a href=GetProductServlet>GetProductServlet으로 이동</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
