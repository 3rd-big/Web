<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<ProductVO> list = (ArrayList<ProductVO>)request.getAttribute("data");
	%>
	<br>
	<table border=1>
		<tr>
			<th>pno</th><th>pname</th><th>pmaker</th><th>pprice</th><th>pdetail</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
				ProductVO x = list.get(i);
		%>
				<tr>
					<td><%= x.getPno() %></td>
					<td><%= x.getPname() %></td>
					<td><%= x.getPmaker() %></td>
					<td><%= x.getPprice() %></td>
					<td><%= x.getPdetail() %></td>
				</tr>
		<%
			}
		%>
	</table>
	<form action="<%=request.getContextPath()%>/control" method="post">
		<input type="hidden" name="type" value="logout">
	</form>
</body>
</html>