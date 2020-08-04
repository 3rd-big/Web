package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import model.MemberVO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		MemberDao dao = new MemberDao();
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String address = request.getParameter("userAddress");
		MemberVO vo = new MemberVO(id, pw, name, address);
		
		dao.addMemberList(vo);
		out.print(name + "님 회원가입을 축하드립니다.");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
