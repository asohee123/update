<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 등록 폼</h1>
	
	<h3>신규 유저 정보를 입력하세요</h3>
	<form action="userregister.jsp" method="post">
		<div>
			<label>아이디</label>
			<div><input type="text" name="id"></div>
		</div>
		
		<div>
			<label>이름</label>
			<div><input type="text" name="name"></div>
		</div>
		
		<div>
			<label>비밀번호</label>
			<div><input type="text" name="password"></div>
		</div>
		
		<div>
			<label>이메일</label>
			<div><input type="text" name="email"></div>
		</div>
		
		<div>
			<button type="submit">회원가입</button>
		</div>
	</form>
	
</body>
</html>