<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/common/navibar.jsp" %>
<div class="container">  	
<%
	request.setCharacterEncoding("utf-8");
	
	String type = request.getParameter("type");
	String userId = request.getParameter("id");
	String name = request.getParameter("name");	
	
	UserDao dao = new UserDao();
	User user = dao.getUserById(userId);
	
	if ((user==null) || (!name.equals(user.getName()))) {		
		response.sendRedirect("findPasswordForm.jsp?error=notFound");
		return;
	}
	
	if ("emailType".equals(type)) {
		String email = request.getParameter("email");
		if (!email.equals(user.getEmail())) {
			response.sendRedirect("findPasswordForm.jsp?error=notFound");
			return;
		}
	} else if ("phoneType".equals(type)) {
		String phone = request.getParameter("phone");
		if (!phone.equals(user.getPhone())) {
			response.sendRedirect("findPasswordForm.jsp?error=notFound");
			return;
		}
	}	
%>	
	<div class="row justify-content-md-center">
		<div class="col-7">
			
			<h2 class="text-center mb-5">Change Password</h2>			
					
			<form id="pwdForm" action="changePassword.jsp" method="post"
				onsubmit="return checkValidation();">	
				<input type="hidden" name="id" value="<%=userId %>">		
				<div class="form-group row">
			    	<label for="pwd" class="col-sm-3 ">새 비밀번호:</label>
			    	<div class="col-sm-9">
			    		<input type="password" class="form-control" placeholder="Enter password" 
			    		name="newPassword" id="newpwd1" onkeyup="valueCheck()"
			    		onchange="matchCheck()">
			    		<!-- 
			    		<button type="button" class="btn btn-success" onclick="availablepasswordcheck()">비밀번호 체크</button>
			    		
			    		 -->
		    			<small>영문,숫자,특수문자 혼합하여 8자리~20자리 이내</small>
		    			<p id="checkPwdStateMsg"></p>
			    	</div>
			  	</div>
				<div class="form-group row">
			    	<label for="pwd" class="col-sm-3 col-form-label">비밀번호 확인:</label>
			    	<div class="col-sm-9">
				    	<input type="password" class="form-control" placeholder="Enter password" 
				    	name="newPassword2" id="newpwd2" onkeyup="matchCheck()">
						<p id="checkPwd2StateMsg"></p>    		
			    	</div>
			  	</div>	 
			  	
			  	<div id="errorText">			  		
			  	</div>	
			  	
			  	<div class="mt-4 row text-right  justify-content-md-center mb-5">
			  	
				<!-- 
			  		<div class="col-sm-9"></div>				
				 -->			  	
				  	<button type="submit" class="btn btn-primary col-sm-3">ok</button>			  			  		
			  	</div> 	
			</form>					
			
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp" %>

<script type="text/javascript">
	
	// 새 비밀번호 유효성 검사
	function valueCheck() {
		var pwd = document.querySelector("#newpwd1").value;
		var pwdError = document.querySelector("#checkPwdStateMsg");
		
	    if (pwd.length >= 1 && pwd.length < 8) {
	    	pwdError.textContent = "길이가 너무 짧습니다.";
	        pwdError.style.color = "red";
	        return false;
	    } else if (pwd.length == 0) {
		    pwdError.textContent = "새 비밀번호를 입력해주세요";
		    pwdError.style.color = "red";
	        return false;
	    } else if (pwd.length > 16) {
	    	pwdError.textContent = "16글자를 넘을 수 없습니다."
	    	pwdError.style.color = "red";
	    	return false
	   	} else if (pwd.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
	    	pwdError.textContent = "사용가능한 비밀번호 입니다.";
	    	pwdError.style.color = "green";
	    	return true;
	    } else {
	    	pwdError.textContent = "영문, 숫자 및 특수문자를 혼합하여 작성해주세요.";
	    	pwdError.style.color = "red";
	    	return false;
	    }
	}	
	
	function matchCheck() {
		var pwd = document.getElementById("newpwd1");
		var pwd2 = document.getElementById("newpwd2");
		
		console.log("pwd: "+ pwd.value);
		console.log("pwd2: "+ pwd2.value);
		
		if (pwd.value != pwd2.value) {
			document.getElementById("checkPwd2StateMsg").textContent="비밀번호가 일치하지 않습니다.";
			document.getElementById("checkPwd2StateMsg").style.color="red";
			
			return false;
		} 
		
		document.getElementById("checkPwd2StateMsg").textContent="비밀번호가 일치합니다.";
		document.getElementById("checkPwd2StateMsg").style.color="green";
		return true;
	}
	
	
	function checkValidation() {
		var finalResult = false;		
		var pwdResult = valueCheck();
		var pwdResult2 = matchCheck();
		
		if ((pwdResult == true) && (pwdResult2 == true)) {
			return true;
		} 
		
		alert("사용할 수 없는 비밀번호입니다.");
		return false;
	}
	
	
	
	
	function checkPassword() {
		
		var pwd = document.getElementById("newpwd1");
		var pwd2 = document.getElementById("newpwd2");
		
		if (pwd.value != pwd2.value) {
			document.getElementById("checkPwd2StateMsg").textContent="비밀번호가 일치하지 않습니다.";
			document.getElementById("checkPwd2StateMsg").style.color="red";
			
			return false;
		} 	
		return true;		
	}	
	

	
</script>
</body>
</html>