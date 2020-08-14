    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/view/member/result.jsp">
		내정보
	</a><br>
	
	<h3>전체 상품</h3>
	<table border="1">
		<tr>
			<th>상품이미지</th><th>상품명</th><th>가격</th>
		</tr>
		<c:forEach var="p" items="${products }">
		<tr>
			<td>
				<img src="${p.img }" width="50" height="50">
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/seller/detail?num=${p.num}">
					${p.name }
				</a><br>
			</td>
			<td>
				${p.price }<br>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>