package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionThreeServlet")
public class SessionThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionThreeServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 세션을 무효화 시킨다.
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			out.print("세션을 무효화");
		}else {
			out.print("세션 없음");
		}
		out.print("<hr><a href=SessionTwoServlet>SessionTwoServlet</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
