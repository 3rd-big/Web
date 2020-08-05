<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>시작페이지</h3>
	<%
		// 이 부분 좀 자세하게 알아봐야 할듯.. 두가지 방식의 차이점
		request.setAttribute("age", 23);
	
		// 페이지만 연결 다른 데이터는 전달하지 않음
		response.sendRedirect("step12.jsp?name=Hong");
	%>
</body>
</html>