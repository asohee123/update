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
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1>web.xml에 설정된 초기화파라미터 값 조회하기</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<div>회사명 : ${initParam.company_name }</div>
			<div>관리자 이메일 : ${initParam.admin_email }</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<h1>PageConetex 객체</h1>
		</div>
	</div>
</div>
</body>
</html>