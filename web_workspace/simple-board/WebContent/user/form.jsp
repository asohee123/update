<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
	.error {
		color: red;
		font-weight: bold;
		font-style: italic;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>회원가입 정보</h1>
	</div>
	<div class="body">
		<div class="error">
		
		<%
			String error = request.getParameter("error");
		%>
		<%
			if("dup".equals(error)){
		%>
			<p  style="color:red; font-style: italic;">이미 사용중인 아이디입니다.</p>
		<%
			}
		%>
		</div>
	
		<p>사용자 정보를 입력하세요</p>
		<div class="well">
			<form method="post" action="register.jsp">
				<div class="form-group">
					<label>이름</label>
					<div><input type="text" name="name" /></div>
				</div>
				<div class="form-group">
					<label>이메일</label>
					<div><input type="text" name="email" /></div>
				</div>
				<div class="form-group">
					<label>아이디</label>
					<div><input type="text" name="id" /></div>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<div><input type="text" name="pwd" /></div>
				</div>
				<div class="text-right">
					<button type="submit">회원가입</button>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>