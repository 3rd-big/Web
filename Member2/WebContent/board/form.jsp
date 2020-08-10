<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 작성</h3>
	<form action="${pageContext.request.contextPath }/WriteController" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" value="${sessionScope.id }" name="writer" size="45" readonly>
				</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" name="title" size="45">
				</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td>
					<textarea rows="15" cols="45" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="reset" value="취소">
					<input type="submit" value="작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>