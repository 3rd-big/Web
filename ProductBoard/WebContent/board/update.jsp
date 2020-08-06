<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductVO m = (ProductVO)request.getAttribute("m");
	%>
	
	<form action="<%=request.getContextPath()%>/control?pno=<%=m.getPno()%>" method="post">
		<input type="hidden" name="type" value="edit">
		상품이름: <input type="text" name="pname" value="<%=m.getPname()%>"><br>
		상표: <input type="text" name="pmaker" value="<%=m.getPmaker()%>"><br>
		상품가격: <input type="text" name="pprice" value="<%=m.getPprice()%>"><br>
		상세정보: <input type="text" name="pdetail" value="<%=m.getPdetail()%>"><br>
		<input type="button" value="수정">
	</form>
</body>
</html>