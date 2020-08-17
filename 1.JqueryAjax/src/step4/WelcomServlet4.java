package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomServlet4")
public class WelcomServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomServlet4() {

    }

    private HashMap<String, String> nickMap = new HashMap<>();
    
    @Override
    public void init() throws ServletException {
    	nickMap.put("백승석", "백박사");
    	nickMap.put("장여진", "구리스탈");
    	nickMap.put("이준우", "오토플러쉬");
    	nickMap.put("이진우", "회식킹");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		boolean flag = nickMap.containsKey(name);
		if(flag) {
			out.print(name + "님의 별명은 " + nickMap.get(name));
		}else {
			out.print("해당하는 이름의 별명이 없습니다.");
		}
		out.println("");
		out.println("서버응답 데이터");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
