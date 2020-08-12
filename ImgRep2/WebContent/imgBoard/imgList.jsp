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
	<h3>이미지 게시판</h3>
	<a href="${pageContext.request.contextPath }/imgBoard/imgWrite.jsp">이미지 올리기</a><br>
	<c:forEach var="img" items="${imgs }">
		<table border="1">
			<tr>
				<td>제목</td>
				<td>${img.title }</td>
			</tr>
			<tr>
				<td>게시자</td>
				<td>${img.writer }</td>
			</tr>
			<tr>
				<td>게시날짜</td>
				<td>${img.u_date }</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<img src="${img.path}" width="300" height="300">	
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="${pageContext.request.contextPath }/RepController?img_num=${img.num}" method="post">
						<input type="text" name="content">
						<input type="submit" value="댓글">
					</form>
				</td>
			</tr>
			<c:forEach var="rep" items="${img.reps }">
			<tr>
				<td>작성자: ${rep.writer }</td>
				<td>내용: ${rep.content }</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</c:forEach>
</body>
</html>