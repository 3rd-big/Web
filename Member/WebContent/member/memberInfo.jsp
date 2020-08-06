<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Member m = (Member) request.getAttribute("m");
	%>
	<h3>내정보 수정</h3>
	<form action="<%=request.getContextPath()%>/EditController" method="post">
		id: <input type="text" name="id" value="<%=m.getId()%>" readonly><br>
		pwd: <input type="text" name="pwd" value="<%=m.getPwd()%>" ><br>
		name: <input type="text" name="name" value="<%=m.getName()%>" ><br>
		email: <input type="text" name="email" value="<%=m.getEmail()%>"><br>
		<input type="submit" value="수정"><br>
	</form>
</body>
</html>