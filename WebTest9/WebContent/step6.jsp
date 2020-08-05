<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public ArrayList getList(){
			ArrayList list = new ArrayList();
			list.add("태연"); list.add("서현"); list.add("윤아");
			list.add("제시카"); list.add("써니"); list.add("유리");
			list.add("수영"); list.add("티파니"); list.add("효연");
			return list;
		}
	%>
	<table border="2">
	<%
		ArrayList list = getList();
		for(int i=0; i<list.size(); i++){
	%>
	<tr>
		<td><%=i%></td><td><%=list.get(i)%></td>
	</tr>
	<% 
		}
	%>
	</table>
</body>
</html>