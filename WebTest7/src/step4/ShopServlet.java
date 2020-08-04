package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShopServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);	// true 세션 새로 생성, false 기존 세션을 사용하겠다
		// 두가지를 반드시 처리해야 로그인 완료
		// 회원이 가입한 외에는 카페 외에는 내용 확인 불가 자세한 내용은 VO객체에 저장
		
		String user = (String) session.getAttribute("userName");
		out.println(user + "님 쇼핑몰 입장환영");
		
		out.print("로그인 하세요");
		out.print("<hr><a href=login.html> 로그인 페이지로! </a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
