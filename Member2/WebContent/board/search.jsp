<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function del(num) {
			location.href = "${pageContext.request.contextPath}/DelBoardController?num=" + num;
		}
	</script>
</head>
<body>
	<%-- 
		현재 글의 작성자와 로그인한 id가 동일하지 않으면 지금 글을 읽는 사람한테는 자신의 글이 아니다.
		이 조건이 만족하면 <c:set>으로 선언한 변수 str의 값으로 readonly를 할당한다. 이것이 자신의 글이 아니면 글 정보를 수정하지 못하고
		읽을 수만 있게 설정하기 위해서 변수 str에 readonly를 저장한다. 만약, 작성자와 로그인 id가 동일하면 자신의 글을 읽는 경우이므로 이떄에는 
		str에 아무 문자도 할당되지 않는다.
		<c:if>는 조건을 만족할 때에만 실행되기 때문
	--%>
	<c:set var="str">
		<c:if test="${sessionScope.id != b.writer }">
			readonly
		</c:if>
	</c:set>
	
	<h3> 글 읽기 </h3>
	<form action="${pageContext.request.contextPath }/EditBoardController" method="post">
		<table border="1" cellspacing="0">
			<tr>
				<th>글 번호</th>
				<td>
					<input type="text" value="${b.num }" name="num" size="45" readonly>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" value="${b.writer }" name="writer" size="45" readonly>
				</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td>
					<input type="text" value="${b.w_date }" size="45" readonly>
				</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" value="${b.title }" name="title" size="45" ${str }>
				</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td>
					<textarea rows="15" cols="45" name="content" ${str }>${b.content }</textarea>
				</td>
			</tr>
			<c:if test="${sessionScope.id == b.writer }">
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="삭제" onclick="del(${b.num})">
					</td>
				</tr>
			</c:if>
		</table>
	</form>
	
	
</body>
</html>