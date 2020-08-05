<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO vo = new MemberVO("java", "1234", "아이유", "판교");
		// 현 회원의 아이디가 java이고 패스워드가 1234이면 회원정보를 보여주고 아니면 회원이 아닙니다 라는 정보를 보여준다.
	%>
	
	<%
		if(vo.getId().equals("java") && vo.getPassword().equals("1234")){ 
	%>
		회원 아이디: <%= vo.getId() %><br>
		회원 이름: <%= vo.getPassword()%><br>
		회원 주소: <%= vo.getAddress()%><br>
	<%
		}else{
	%>
	회원이 아닙니다.
	<%
		}
	%>
</body>
</html>