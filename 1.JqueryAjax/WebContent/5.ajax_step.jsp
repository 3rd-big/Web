<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#b1').click(function () {
				var id = $('.id').val();
				var data = 'id=' + id;
				alert(data);
				
				$.ajax({
					type : "POST",
					url : "/1.JqueryAjax/WelcomServlet5",
					
					data : data,
					success : function (data) {
						$('div').append(data);
					}
				});
			});
		});
	</script>
</head>
<body>
	이름: <input type="text" class="id">
	<input type="button" id="b1" value="회원정보검색">
	<div></div>
</body>
</html>