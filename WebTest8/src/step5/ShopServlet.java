package step5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;
import model.MemberVO;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("userId") == null) {
			out.print("<script type='text/javascript'>");
			out.print("alert('아이디를 입력하세요~');");
			out.print("location.href='login.html');");
			out.print("</script>");
		}else {
			ArrayList<MemberVO> list = (ArrayList)session.getAttribute("userId");
			out.println(list.get(0).getAddress() + "에 사는 " + list.get(0).getName() + "님 쇼핑몰 입장환영");
			out.print("<hr><a href=LogoutServlet>로그아웃</a>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
