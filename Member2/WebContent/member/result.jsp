<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>
	<c:if test="${not empty sessionScope.id }">
		${sessionScope.id }님 로그인
		<br>
		<a href="${pageContext.request.contextPath }/SearchController">내정보수정</a>
		<br>
		<a href="${pageContext.request.contextPath }/LogoutController">로그아웃</a>
		<br>
		<a href="${pageContext.request.contextPath }/DelController">탈퇴</a>
		<br>
		<c:import url="/ListController"></c:import>
	</c:if>
	
	<c:if test="${empty sessionScope.id }">
		<h3>로그인 실패</h3>
		<a href="${pageContext.request.contextPath }/member/loginForm.jsp">로그인 폼</a>
	</c:if>
</body>
</html>