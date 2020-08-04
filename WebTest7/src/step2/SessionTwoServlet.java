package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTwoServlet")
public class SessionTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionTwoServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 기존 세션 있으면 리턴, 없으면 null 리턴
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("user");
		out.print("session으로부터 정보를 getting.." + user);
		out.print("<hr><a href=SessionThreeservlet>SessionThreeServlet</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
