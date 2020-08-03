package step7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PersonVO;

@WebServlet("/ListViewServlet")
public class ListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// init() 에서 ServletContext로 부터 list를 받아 할당한다.
	private ArrayList list;
	
    public ListViewServlet() {
        
    }

    @Override
    	public void init() throws ServletException {
    		ServletContext context = this.getServletContext();
    		list = (ArrayList)context.getAttribute("table");
    	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(list == null) {
			out.print("입장명단이 없습니다.");
		}else {
			int count = 1;
			out.print("<table border = 1>");
			out.println("<td> 인원수 </td><td>아이디</td><td>닉네임</td>");
			for(int i=0; i<list.size(); i++) {
				PersonVO vo = (PersonVO)list.get(i);
				out.print(" <tr>");
				out.println("<td>" + count + "</td>");
				out.println("<td>" + vo.getId() + "</td>");
				out.println("<td>" + vo.getNick() + "</td>");
				out.print(" </tr>");
				count++;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
