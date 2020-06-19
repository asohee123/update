<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	외부 javascript 파일을 HTML에 포함시키기
 -->
<script type="text/javascript" src="sample.js"></script>

<!-- 
	스크릡트 코드를 추가해야 하는 경우 새로운 <script></script> 태그를 생성해서 사용해야 한다.
 -->
<script type="text/javascript">
	function yourfunction(){
		alert("내부 함수 실행");
	}
</script>
</head>
<body>
	<h1>외부 자바스크립트 실행</h1>
	<p>
		<button onclick="myfunction()">실행</button>
		<button onclick="yourfunction()">실행</button>
	</p>
</body>
</html>