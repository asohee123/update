<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>논리 연산자 사용하기</h1>
	<script type="text/javascript">
		var grade = '';
		var orderPrice = 1000000;
		
		var result1 = (grade != '' || orderPrice > 500000);
		var result2 = (grade || orderPrice > 500000);
		
		console.log("결과1", result1);
		console.log("결과2", result2);
		
		grade = "VIP";
		result1 = (grade != '' || orderPrice > 500000);
		result2 = (grade || orderPrice > 500000);
		
		console.log("결과1", result1);
		console.log("결과2", result2);
		
		if (grade != '' || orderPrice > 500000){
			
			console.log("사은품 지급");
			
		}
		if(grade || orderPrice > 500000){
			
			console.log("사은품 지급");
			
		}
		if(''){
			console.log("값이 있음");
		} else {
			console.log("값이 없음");
		}

		grade = '';
		orderPrice = 300000;
		if(grade != '' || orderPrice > 500000){
			console.log("사은품 지급");
		} else {
			console.log("사은품 지급아님");
		}
		if(grade || orderPrice > 500000){
			console.log("사은품 지급");
		} else {
			console.log("사은품 지급아님");
		}
	</script>
</body>
</html>