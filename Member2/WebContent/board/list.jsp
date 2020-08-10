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
		<h3>글 목록</h3>
		<a href="${pageContext.request.contextPath }/board/form.jsp">글 작성</a>
		<br>
		<c:if test="${not empty list }">
			<table border="1" cellspacing="0">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
				<c:forEach var="b" items="${list }">
					<tr>
						<td>${b.num }</td>
						<td>
							<a href="${pageContext.request.contextPath }/ReadController?num=${b.num }">${b.title }</a>
						</td>
						<td>
							${b.writer }
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty list }">
			작성 된 글이 없습니다.
		</c:if>
</body>
</html>