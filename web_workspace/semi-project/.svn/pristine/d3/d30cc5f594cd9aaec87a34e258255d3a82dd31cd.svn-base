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
	<div class="row justify-content-center">
		<h3>Join</h3>
	</div>
	<form action="joinProcess.jsp" method="post">
	  	<div class="form-group">
		    <label>아이디</label>
		    <input type="text" class="form-control" placeholder="ID (영문소문자/숫자, 4~16자)" name="userid" id="userid" onchange="idCheck()" required>
	  	</div>
	  	<div class="form-group">
		    <label>비밀번호</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="pwd" onchange="passwordCheck1()" onkeyup="valueCheck()"  required>
		    <p id="message1"></p><p id="message3"></p>
	  	</div>	  	
	  	<div class="form-group">
		    <label>비밀번호 확인</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="pwdCheck" onchange="equalCheck()" required>
	  	</div>	  	
	  	<div class="form-group">
		    <label>이름</label>
		    <input type="text" class="form-control" name="name" required>
	  	</div>
	  	<div class="form-group">
		    <label>주소</label>
		    <input type="text" class="form-control" name="addr" required>
	  	</div>
	  	<div class="form-group">
		    <label>전화번호</label>
		    <input type="text" class="form-control" placeholder="010-XXXX-XXXX" name="phone" required>
	  	</div>
	  	<div class="form-group">
		    <label>이메일</label>
		    <input type="email" class="form-control" placeholder="aaa@bbb.ccc" name="email" required>
	  	</div>
	  	<div class="form-group">
		    <label>생년월일</label>
		    <input type="text" class="form-control" placeholder="YYMMDD" name="birth" maxlength="6" required>
	  	</div>
  		<button type="submit" class="btn btn-primary">가입</button>
	</form>
</div>
<%@ include file="/common/footer.jsp" %>
<script type="text/javascript">
	function idCheck() {
		var userid = document.querySelector("input[name=userid]").value;
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var check = JSON.parse(text);
				console.log(check);
				if(check) {
					alert("이미 사용중인 아이디 입니다!");
					document.querySelector("input[name=userid]").value = "";
				} else {
					alert("사용 가능한 아이디 입니다!");
				}
			}
		}
		
		// XHR 초기화
		xhr.open("GET", "idCheck.jsp?userid=" + userid);
		// 서버로 요청보내기
		xhr.send();
	} 
	
	
	function valueCheck() {
	      var text = document.querySelector("input[name=pwd]").value;
	      var el = document.querySelector("#message1");
	      
	      if (text.length >= 1 && text.length < 8) {
	         el.textContent = "길이가 너무 짧습니다.";
	         el.style.color = "red";
	         return;
	      } else if (text.length == 0) {
	         el.textContent = "";
	         return;
	      } else if (text.length > 16) {
	    	  el.textContent = "16글자를 넘을 수 없습니다."
	    	  el.style.color = "red";
	      } else if (text.length >= 8 && text.length <= 16) {
	    	  el.textContent = "";
	      }
   }
	
   function passwordCheck1() {
	   	var pwd1 = document.querySelector("input[name=pwd]").value;
		
		if(pwd1.length<8) {
		    alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
		    document.querySelector("input[name=pwd]").value = "";
		    return 0;
		} else if(!pwd1.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
		    alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
		    document.querySelector("input[name=pwd]").value = "";
		    return 0;  
		} else {
			 return 1;
		}
	}
		
	function equalCheck() {
		var pwd1 = document.querySelector("input[name=pwd]").value;
		var pwd2 = document.querySelector("input[name=pwdCheck]").value;
		
		if(pwd1 != pwd2) {
			alert("비밀번호가 동일하지 않습니다.");
			document.querySelector("input[name=pwd]").value = "";
			document.querySelector("input[name=pwdCheck]").value = "";
		}
		
	} 
	
</script>
</body>
</html>