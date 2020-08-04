package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
		if(id.equals("java") && password.equals("abcd")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", "이진우");
			out.print(id + "님 로그인 성공");
			out.print("<hr><a href=ShopServlet>ShopServlet</a>");
		}else {
			out.print("로그인 실패");
			out.print("<hr><a href=login.html>로그인페이지로</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
