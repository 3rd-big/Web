<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		private int count;
	%>
	<font size=6 color=red>
		count: <%=count++%>, 현재시간: <%=new Date().toString() %>
	</font>
</body>
</html>