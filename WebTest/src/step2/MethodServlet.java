package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodServlet
 */
@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

    public MethodServlet() {
        super();
    }

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		final PrintWriter out = response.getWriter();
		out.println("get 방식으로 요청했군요!!");
		out.println(request.getParameter("user"));	// setp2.html 의 아이디(name: user)를 받아옴
		out.println("<img ");
		out.close();
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// POST 방식일 때 요청정보 한글 처리 (클라이언트에서 입력받는 한글이 깨지는 것을 방지)
		request.setCharacterEncoding("utf-8");
		// 응답시 문서타입과 한글처리
		response.setContentType("text/html;charset=utf-8");
		final PrintWriter out = response.getWriter();
		out.println("post방식으로 요청했군요!");
		// 클라이언트의 요청 정보에서 아이디를 얻어온다.
		out.println(request.getParameter("userId"));
		out.close();
	}

}
