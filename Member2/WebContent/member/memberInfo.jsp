<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>내 정보 수정</h3>
	<form action="${pageContext.request.contextPath }/EditController" method="post">
		id: <input type="text" name="id" value="${m.id }" readonly><br>
		pwd: <input type="text" name="pwd" value="${m.pwd }"><br>
		name: <input type="text" name="name" value="${m.name }"><br>
		email: <input type="text" name="email" value="${m.email }"><br>
		<input type="submit" value="수정"><br>
	</form>
</body>
</html>