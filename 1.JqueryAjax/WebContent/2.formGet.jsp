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
				var name = $('.uname').val();
				var test = 'uname=' + name;
				alert(test);
				
				$.ajax({
					type : "GET",
					url : "/1.JqueryAjax/WelcomServlet2",
					
					data : test,
					success : function (data) {
						$('body').text(data);
					}
				});
			});
		});
	</script>
</head>
<body>
    <form>
    	<label>Enter your Name</label>
    	<input type="text" name="uname" class="uname">
    	<input type="button" id="b1" value="click"><br>
    </form>
</body>
</html>