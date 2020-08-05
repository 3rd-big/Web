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
	<h3>jspInit() 메서드에서 생성한 객체를 폼에 출력</h3>
	<%
		Member m = (Member) application.getAttribute("m");
	%>
	
	<form>
		<table border="1">
			<tr>
				<th>id</th>
				<td>
					<input type="text" name="id" value="<%=m.getId()%>">
				</td>
			</tr>
			<tr>
				<th>pwd</th>
				<td>
					<input type="text" name="pwd" value="<%=m.getPwd()%>">
				</td>
			</tr>
			<tr>
				<th>name</th>
				<td>
					<input type="text" name="name" value="<%=m.getName()%>">
				</td>
			</tr>
			<tr>
				<th>email</th>
				<td>
					<input type="text" name="email" value="<%=m.getEmail()%>">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>