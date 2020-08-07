<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberVO" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO vo = new MemberVO("java", "abcd", "아이유", "선릉");
		request.setAttribute("mvo", vo);
	%>
	EL 연습 -> 이름: ${requestScope.mvo.name }
	주소: ${requestScope.mvo.address }
	<hr>
	JSTL choose(if~ else if~ els) : when = if,
	otherwise = else<br>
	<c:choose>
		<c:when test="${requestScope.mvo.address=='판교' }">
			성남
		</c:when>
		<c:when test="${requestScope.mvo.address=='선릉' }">
			강남
		</c:when>
		<c:otherwise>
			else를 의미한다.
		</c:otherwise>
	</c:choose>


</body>
</html>