package step6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OneServlet() {

    }
    
    private HashMap<String, String> map = new HashMap<>();
    
    @Override
    public void init() throws ServletException {
    	map.put("1", "1200원");
    	map.put("2", "720원");
    	map.put("3", "1000원");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("doGet()...");
		String line = request.getParameter("line");
		if(map.containsKey(line)) {
			out.print(map.get(line));
		}else {
			out.print("호선 입력하세요");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
