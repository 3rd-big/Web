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
		Member m = new Member("aaa", "111", "nara", "nara@email.com");
		pageContext.setAttribute("m", m);
	%>
	
	id: ${m["id"] }<br> 
	pwd: ${m["pwd"] }<br>
	name: ${m["name"] }<br>
	email: ${m["email"] }<br>
	
	
	
	${"aaa" }<br>
	${25 }<br>
	${true }<br>
	${"\"str\"" }<br>
</body>
</html>