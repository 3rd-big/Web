package img.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import img.service.Service;
import img.service.ServiceImpl;
import model.Img;

@WebServlet("/WriteController")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WriteController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImpl();
		
		Img img = new Img();
		
		String imgName = "";
		
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest multi = null;
		String uploadPath = "C:\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\rep_img";
		
		try {
			// request, 파일저장경로, 용량, 인코딩타입, 중복파일명에 대한 기본 정책
			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			img.setTitle(multi.getParameter("title"));
			img.setWriter(multi.getParameter("writer"));
			
			// 전송한 전체 파일이름들을 가져옴
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				// form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
				String file1= (String) files.nextElement();	// 파일 input에 지정한 이름을 가져옴
				
				// 그에 해당하는 실제 파일 이름을 가져옴
				imgName = multi.getOriginalFileName(file1); 
				
				//파일 업로드
				File file = multi.getFile(file1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		img.setPath("/rep_img/" + imgName);
		service.addImg(img);
		response.sendRedirect("/ImgRep2/ImgList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
