<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		/*	
			$()는 문서의 일부를 선택하는 데 사용, $('body')HTML파일내의 모든 문단 엘리먼트를 접근
			$('div')HTML파일내의 모든 div 엘리먼트를 접근, $('#A')id=A인 모든 HTML엘리먼트에 접근
			$('.b')class=b 인 모든 HTML엘리먼트에 접근
			$(document).ready(function()) 준비된 상태라는 것을 알려주는 사용
			$.ajax()멤서드는 HTTP 요청으로 원격지의 페이지를 불러오고 XMLHttpRequest객체를 생성하여 반환하고 인자로는 요청을 초기화하고 처리하는데 
			사용하는 키/값 쌍으로 이루어진 객체를 받는다.
			type 요청에 사용할 HTTP메서드를 정의하는 문자열, 즉 GET 또는 POST 디폴트 타입은 GET 메서드
			url 요청을 보낼 페이지의 url을 담는 문자열
			data 요청과 함께 보낼 맵 또는 문자열
			success 서버에 보내진 요청이 성공하면 수행 될 콜백함수(서버에서) 반환된 데이터는 콜백함수의 파라미터 값이 된다.
			append자식 노드에 붙이고
		*/
		
		$(document).ready(function () {
			$('#b1').click(function () {
				var name = $('.uname').val();
				var data = 'uname=' + name;
				alert(data);
				
				$.ajax({
					type : "POST",
					url : "/1.JqueryAjax/WelcomServlet",
					
					data : data,
					success : function (data) {
						$('body').append(data);
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