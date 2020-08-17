package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomServlet3")
public class WelcomServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomServlet3() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("uname");
		String password = request.getParameter("password");
		System.out.println(id);
		if(id.equals("java") && password.equals("abcd")) {
			out.print(id + "님 로그인 OK!");
		}else {
			out.print("로그인 실패");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
