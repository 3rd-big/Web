<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		int x = 10;
		int y = 20;
		pageContext.setAttribute("list1", list1);
		pageContext.setAttribute("list2", list2);
		pageContext.setAttribute("x", x);
		pageContext.setAttribute("y", y);
	%>
	
	list1은 비었는가? ${empty list1 }<br>
	list2은 비었는가? ${empty list2 }<br>
	list2 데이터: ${list2[0] } / ${list2[1] } / ${list2[2] }<br>
	x = ${x } / y = ${y }<br>
	x + y = ${x + y }<br>
	x / y = ${x / y } 또는 ${x div y }<br>
	x > y = ${x > y }<br>
	x == y = ${x == y }<br>


</body>
</html>