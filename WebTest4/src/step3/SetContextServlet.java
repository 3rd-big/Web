package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetContextServlet")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetContextServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletContext에 데이터를 setting
		ServletContext context=this.getServletContext();
		context.setAttribute("info", "손연재");
		out.print("ServletContext에 data setting...");
		out.print("<a href=GetContextServlet>GetContextServlet으로 이동</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
