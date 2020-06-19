<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>변수 선언하기</h1>
	
	<script>
		var username;
		var tel;
		
		// 변수를 생성하고, 초기화하지 않으면
		// 변수에 저장되어 있는 값은 항상 undefinde 값이다.
		console.log("이름", username);
		console.log("전화번호", tel);
		
		// 변수의 초기화
		// 자바스크립트에서는 문자타입은 없고, 문타열타입만 존재한다.
		// 문자열은 ""나 ''로 감싸져 있는 텍스트다.
		username = "홍길동";
		tel = '010-1111-1111';
		console.log("이름", username);
		console.log("전화번호", tel);
		
		var title, writer, price;
		title = "이것이 자바스크립트다.";
		writer = "홍길동";
		price = 35000;
		console.log("제목", title, "저자", writer, "가격", price);
		
		// 여러 변수를 한 번에 선언하고, 초기화하기
		var id = "hong", empName = "홍길동", salary = 35000, married = false;
		console.log("아이디", id,"이름", empName,"급여", salary,"결혼여부", married);	
		
		var x;
		console.log("x의 값", x, "x의 타입", typeof x);
		x = 100;
		console.log("x의 값", x, "x의 타입", typeof x);
		x = "안녕";
		console.log("x의 값", x, "x의 타입", typeof x);
		x = true;
		console.log("x의 값", x, "x의 타입", typeof x);
	</script>
</body>
</html>