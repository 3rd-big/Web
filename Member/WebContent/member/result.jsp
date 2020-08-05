<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>
	<%
		boolean flag = false;
		if(!session.isNew()){
			flag = (boolean) session.getAttribute("flag");
		}
		if(flag){
			String id = (String) session.getAttribute("id");
	%>
		<%=id%>님 로그인
		<br>
		<a href="<%=request.getContextPath()%>/SearchController">내 정보 수정</a>
		<br>
		<a href="<%=request.getContextPath()%>/LogoutController">로그아웃</a>
		<br>
	<%
		} else {	
	%>
		<h3>로그인 실패</h3>
		<a href="<%=request.getContextPath()%>/member/loginForm.jsp">로그인 폼</a>
	<%
		}
	%>
</body>
</html>