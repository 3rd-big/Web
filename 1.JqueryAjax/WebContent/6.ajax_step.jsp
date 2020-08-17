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
			$('#line').change(function () {
				var name = $('#line option:selected').val();
				var data = 'line=' + name;
				alert(data);
				
				$.ajax({
					type : "POST",
					url : "/1.JqueryAjax/OneServlet",
					
					data : data,
					success : function (data) {
						$('span').html(data);
					}
				});
			});
		});
	</script>
</head>
<body>
	<select id="line">
		<option value="">호선</option>
		<option value="1">1호선</option>
		<option value="2">2호선</option>
		<option value="3">3호선</option>
	</select>
	<span></span>
</body>
</html>