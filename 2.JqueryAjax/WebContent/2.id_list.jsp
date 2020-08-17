<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#b1').change(function () {
				var name = $('#b1 option:selected').val();
				var data = 'id=' + name;
				
				$.ajax({
					type : "POST",
					url : "/2.JqueryAjax/FindMemberController",
					
					data : data,
					success : function (data) {
						m = $.parseJSON(data);
						$('div').html(m.id+"/"+m.address+"/"+m.name);
					}
				});
			});
		});
	</script>

</head>
<body>
	<%--
		select option에 회원 id를 표현
		option change 될 때 ajax 방식으로 서버에서 회원 정보를 조회해 온다. (이름과 주소)
	--%>
	<select id="b1">
		<option> - 아이디 - </option>
		<c:forEach var="list" items="${list }">
			<option value="${list.id }">${list.id }</option>
		</c:forEach>
	</select>
	<div></div>
</body>
</html>