package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckBoxServlet")
public class CheckBoxServlet extends HttpServlet {

    public CheckBoxServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str1 = "";
		String menu[] = request.getParameterValues("menu");
		for(int i=0; i<menu.length; i++){
			str1 += menu[i];
		}
		out.println(str1 + " " + " 선택");
	}

}
