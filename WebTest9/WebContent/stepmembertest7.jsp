<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Member"%>
<%
	request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Member m = new Member(id, pwd, name, email);
    %>
    <h3>회원정보</h3>
    <table border="1">
        <tr>
            <th>id</th><th>pwd</th><th>name</th><th>email</th>
            <tr>
                <td>
                    <%=m.getId()%>
                </td>
                <td>
                    <%=m.getPwd()%>
                </td>
                <td>
                    <%=m.getName()%>
                </td>
                <td>
                    <%=m.getEmail()%>
                </td>
            </tr>
        </tr>

    </table>
</body>
</html>