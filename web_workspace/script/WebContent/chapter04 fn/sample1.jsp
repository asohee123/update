<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>자바스크립트 함수</h1>
	<script type="text/javascript">
		var x = plus(100, 200)
		console.log("결과값 : ", x);
		
		notice("롤하고싶다.");
		// 매개변수와 return문이 있는 함수
		function plus(num1, num2){
			var result = num1 + num2;
			return result;
		}
		
		// 매개변수가 있는 함수
		function notice(message){
			alert("메세지 : " + message);
		}

	</script>
</body>
</html>