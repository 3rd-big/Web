<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그아웃 되었습니다.</h3>
	<%
		// session.removeAttribute("result");
		// session.removeAttribute("id");
		session.invalidate();
	%>
	<a href="loginResult.jsp">loginResult.jsp로 이동</a>
</body>
</html>