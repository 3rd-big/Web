<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>redirect 예제</h3>
		<c:url var="url" value="step10.jsp"/>
		<c:redirect url="${url }">
			<c:param name="name" value="aaa"></c:param>
			<c:param name="age" value="10"></c:param>
		</c:redirect>
</body>
</html>