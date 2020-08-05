<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>6.scopeTest.jsp</h3>
	<%
		String myPage = (String) pageContext.getAttribute("pageScope");
		String myRequest = (String) request.getAttribute("requestScope");
		String mySession = (String) session.getAttribute("sessionScope");
		String myApplication = (String) application.getAttribute("applicationScope");
	%>
	
	pageScope = <%=myPage%><br>
	requestScope = <%=myRequest%><br>
	sessionScope = <%=mySession%><br>
	applicationScope = <%=myApplication%><br>
	
	<a href="7.scopeTest.jsp">다음 페이지로 이동</a>
</body>
</html>