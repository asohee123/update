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
	.field-error{
		border: 1px solid red;
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
			<form id ="user-form" method="post" action="register.jsp" onsubmit="checkField(event)">
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
	<script type="text/javascript">
		function checkField(event) {
			
			clearErrorField();
			
			var nameField = document.querySelector("input[name=]");
			var eamilField = document.querySelector("input[name=email]");
			var idField = document.querySelector("input[name=id]");
			var pwdField = document.querySelector("input[name=pwd]");
			
			var isPassed = true;
			
			if(!nameField.value){
				nameField.classList.add("field-error");
				isPassed = false;
			}
			if(!eamilField.value){
				eamilField.classList.add("field-error");
				isPassed = false;
			}
			if(!idField.value){
				idField.classList.add("field-error");
				isPassed = false;
			}
			if(!pwdField.value){
				pwdField.classList.add("field-error");
				isPassed = false;
			}
		
			if(!isPassed){
				event.preventDefault();
			}
		}
		
		function clearErrorField(){
			var fields = document.querySelectorAll(".form-group input");
			for(var i=0; i<fields.length; i++){
				var input = fields[i];
				input.classList.add("field-error");
			}
		}
	</script>
</div>
</body>
</html>