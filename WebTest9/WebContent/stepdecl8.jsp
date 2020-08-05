<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public void jspInit(){
			Member m = new Member("id1", "pwd2", "name1", "email1");
			ServletContext context = getServletContext();
			context.setAttribute("m", m);
		}
	%>
	<h3>jspInit() 메서드에서 생성한 객체</h3>
	<%
		Member m = (Member) application.getAttribute("m");
		out.print("id: " + m.getId() + "<br>");
		out.print("pwd: " + m.getPwd() + "<br>");
		out.print("name: " + m.getName() + "<br>");
		out.print("email: " + m.getEmail() + "<br>");
	%>
</body>
</html>