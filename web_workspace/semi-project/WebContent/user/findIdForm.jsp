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
	String error = request.getParameter("error");	
%>	
	<div class="row justify-content-md-center">
		<div class="col-5">			
			<h2 class="text-center mb-5">Find ID</h2>			
		<%
			if ("notFound".equals(error)) {
		%>		
			<div class="alert alert-danger">
  				<strong>오류!</strong> 사용자 정보를 찾을 수 없습니다.
			</div>
		<% 	
			}
		%>			
			<form action="findId.jsp" method="post">
			
				<label>타입:</label>
				
				<div class="form-group">
				
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="findEmail" 
							name="type" value="emailType" checked="checked" onclick="selectType(event)">
						<label class="custom-control-label" for="findEmail">이메일</label>						
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="findPhone" 
							name="type" value="phoneType" onclick="selectType(event)">
						<label class="custom-control-label" for="findPhone">휴대전화번호</label>						
					</div>
				</div>				
				
			  <div class="form-group">
			    <label for="name">이름:</label>
			    <input type="text" class="form-control" placeholder="Enter name" name="name" id="name">
			  </div>
			  
			  <div class="form-group" id="emailForm">
			    <label for="email">이메일:</label>
			    <input type="email" class="form-control" placeholder="Enter email" name="email" id="email">
			  </div>
			  
			  <div class="form-group" id="phoneForm" style="display:none;">
			    <label for="phone">휴대전화번호:</label>
			    <input type="tel" class="form-control" id="phone" name="phone" title="Enter phoneNumber" 
			    pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" placeholder="Enter PhoneNumber" maxlength="13"
			    onkeyup="this.value=autoHypenPhone(this.value);"/>
			    <!-- 
			    onkeyup="this.value=this.value.replace(/[^0-9]/g,'');" 
			     -->
			  </div>
			  
			  <button type="submit" class="btn btn-primary btn-block">ok</button>
			</form>				
		</div>
	</div>
</div>

<script type="text/javascript">
	
	function autoHypenPhone(str) {
		//var telText = document.getElementById("phone");
		
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
	    if( str.length < 4){
	    	return str;
	    }else if(str.length < 7){
	    	tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3);
	        return tmp;
		}else if(str.length < 11){
	        tmp += str.substr(0, 3);
	        tmp += '-';
          	tmp += str.substr(3, 3);
          	tmp += '-';
          	tmp += str.substr(6);
          	return tmp;
	    }else{              
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3, 4);
	        tmp += '-';
	        tmp += str.substr(7);
	        return tmp;
	     }
	    
	    return str;
	}

	function selectType(event) {
		
		if (event.target.id == "findEmail") {
			document.getElementById("emailForm").style.display="block";
			document.getElementById("phoneForm").style.display="none";
			
		} else if (event.target.id == "findPhone") {
			document.getElementById("emailForm").style.display="none";
			document.getElementById("phoneForm").style.display="block";			
		}		
	}
</script>
<%@ include file="/common/footer.jsp" %>
</body>
</html>