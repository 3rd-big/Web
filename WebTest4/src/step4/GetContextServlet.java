package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetContextServlet")
public class GetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetContextServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletContext로 부터 info data를 getting...
		ServletContext context = this.getServletContext();
		String info = (String)context.getAttribute("info");
		out.print(this.getServletName());
		out.print("ServletContext로부터 info 정보를 획득..." + info);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
