<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>리다이렉트로 이동한 페이지</h3>
	<%
		int age = 0;
		String name = request.getParameter("name");
		String age_s = (String) request.getAttribute("age");
		if(age_s != null && !age_s.equals("")){
			age = Integer.parseInt(age_s);
		}
	%>
	name: <%=name%>
	age: <%=age%>
</body>
</html>