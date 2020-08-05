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
		pageContext.setAttribute("pageScope", "page data");
		request.setAttribute("requestScope", "request data");
		session.setAttribute("sessionScope", "session data");
		application.setAttribute("applicationScope", "application data");
		
		String myPage = (String) pageContext.getAttribute("pageScope");
		String myRequest = (String) request.getAttribute("requestScope");
		String mySession = (String) session.getAttribute("sessionScope");
		String myApplication = (String) application.getAttribute("applicationScope");
	%>
	
	pageScope = <%=myPage%><br>
	requestScope = <%=myRequest%><br>
	sessionScope = <%=mySession%><br>
	applicationScope = <%=myApplication%><br>
</body>
</html>