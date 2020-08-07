<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("data", "pageContext");
		request.setAttribute("data", "pageContext");
		session.setAttribute("data", "pageContext");
		application.setAttribute("data", "pageContext");
	%>
	
	현재 프로그램의 기본 경로: ${pageContext.request.contextPath }<br><br>
	
	scope를 지정하지 않았을 때의 data 값: ${data }<br><br>
	
	scope를 pageContext로 지정했을 때의 data 값: ${pageScope.data }<br><br>
	scope를 request로 지정했을 때의 data 값: ${request.data }<br><br>
	scope를 session로 지정했을 때의 data 값: ${session.data }<br><br>
	scope를 application로 지정했을 때의 data 값: ${application.data }<br><br>
</body>
</html>