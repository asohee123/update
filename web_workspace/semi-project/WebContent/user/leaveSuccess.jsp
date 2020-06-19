<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap 4 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%
	session.invalidate();
%>
<div class="container">
	<div class="row">
		<div class="col-12">
			<div class="navi" >
    				<%@ include file="../common/navibar.jsp" %>
    		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12 h2 text-center pb-3">
				탈퇴완료
		</div>
	</div>
	<div class="row">
		<div class="col-12 text-center">
			<div class="row">
				<div class="col-12">
					정상적으로 처리되었습니다.
				</div>
			</div>
			<div class="row text-center">
				<div class="col-12">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-3"></div> 
		<div class="col-6 pt-3 pb-3">
		</div>
		<div class="col-3"></div> 
	</div>
	<div class="row pb-5">
		<div class="col-4"></div>
		<div class="col-4 text-center">
				<a href="../home.jsp"><button type="button" class="btn btn-success">홈으로 돌아가기</button></a>
		</div>
		<div class="col-4"></div>
	</div>
	<div class="row">
		<div class="col-12">
			<div class="navi">
    				<%@ include file="../common/footer.jsp" %>
    		</div>
		</div>
	</div>
</div>

</body>
</html>