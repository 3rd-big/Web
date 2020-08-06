<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/control?type=update" method="post">
		상품번호: <input type="text" name="pno">
		<input type="submit" value="전송">
	</form>
	
	<form action="<%=request.getContextPath()%>/control?type=delete" method="post">
		삭제할 제품범호: <input type="text" name="pno">
		<input type="submit" value="전송">
	</form>
</body>
</html>