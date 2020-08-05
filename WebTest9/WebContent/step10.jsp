<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 요청의 전송방식
		String method = request.getMethod();
		out.print("전송방식: " + method + "<br>");
		// 요청 헤더에 저장된 모든 정보의 이름을 Enumeration 형태로 반환
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			// 요청의 헤더에 저장된 파라미터 정보를 읽는다. 파라미터 정보의 이름을 지정한다.
			String value = request.getHeader(name);
			out.print("name: " + name + ", value: " + value + "<br>");
		}
	%>
</body>
</html>