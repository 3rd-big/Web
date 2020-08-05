<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		private String name = "손연재";
		public int getAge(){
			return 19;
		}
	%>
	이름: <%=name%>, 나이: <%=getAge()%>세
</body>
</html>