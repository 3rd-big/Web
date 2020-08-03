package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServlet5")
public class MyServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet5() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<h3>이동 전</h3>");
		out.print("</body></html>");
		
		// HttpServletResponse를 사용하면 sendRedirect() 메서드를 이용하여 지정한 경로로 제어를 이동시킬 수 있다.
		// 그러나, sendRedirect()는 HTTP 리다이렉션을 이용하기 때문에 하나의 요청 범위 안에서 처리를 하는 것이 아니라 브라우저에게
		// Response 후 브라우저측에서 지정받은 요청 경로롤 다시 재요청을 하는 방식이기에 두 번의 HTTP 트랜잭션이 발생하며,
		// 서버측에서는 최초에 받은 요청중에 처리한 내용을 리다이렉트 된 요청안에서 공유할 수 없는 문제가 있다.
		
		response.sendRedirect(request.getContextPath() + "/NextRedirect");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
