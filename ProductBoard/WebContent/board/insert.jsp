<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		function checkInsert(r) {
			if(r.pname.value == ""){
				alert("상품명을 입력하세요~!!");
				r.pname.focus();
				return;
			}else if(r.pmaker.value == ""){
				alert("제조사를 입력하세요~!!");
				r.pmaker.focus();
				return;
			}else if(r.pprice.value == ""){
				alert("가격을 입력하세요~!!");
				r.pprice.focus();
				return;
			}else if(r.pdetail.value == ""){
				alert("상세정보를 입력하세요~!!");
				r.pdetail.focus();
				return;
			}
			r.submit();
		}
	</script>
</body>
	<form action="<%=request.getContextPath()%>/control?type=insert" method="post" name="x">
		<table>
			<tr>
				<td>상품명: <input type="text" name="pname"><br><br></td>
			</tr>
			<tr>
				<td>제조사: <input type="text" name="pmaker"><br><br></td>
			</tr>
			<tr>
				<td>가격: <input type="text" name="pprice"><br><br></td>
			</tr>
			<tr>
				<td>상세정보: <textarea rows="5" cols="40" name="pdetail"></textarea></td>
			</tr>
		</table>
		<input type="button" onclick="checkInsert(this.form)" value="상품입력">
	</form>

</html>