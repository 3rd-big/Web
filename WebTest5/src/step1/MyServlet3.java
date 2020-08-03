package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet3")
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet3() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<h3>body 내용</h3>");
		out.print("내용<br>");
		out.print("내용<br>");
		out.print("내용<br>");
		// RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나,
		// 특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스입니다. 즉, /a.jsp로 들어온 요청을 /a.jsp 내에서 
		// RequestDispatcher를 사용하여 b.jsp로 요청을 보낼 수 있다. 또는 a.jsp에서 b.jsp로 처리를 요청하고 b.jsp에서 처리한 결과내용을
		// a.jsp의 결과에 포함시킬 수 있다.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Banner");
		if(dispatcher != null) {
			dispatcher.include(request, response);
		}
		
		out.print("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
