<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login</h3>
	<form action="<%=request.getContextPath()%>/LoginController" method="post">
		id: <input type="text" name="id"><br>
		pwd: <input type="text" name="pwd"><br>
		<input type="submit" value="로그인"><br>
	</form>
	<a href="<%=request.getContextPath()%>/member/form.jsp">회원가입</a>
</body>
</html>