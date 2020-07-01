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
			<h1>요청파라미터 표현</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3>EL로 표현하기</h3>
			<div>번호 : ${param.no }</div>
			<div>검색옵션 : ${param.opt }</div>
			<div>검색키워드 : ${param.keyword }</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3>요청 헤더정보 표현하기</h3>
			<div>host : ${header.host }</div>
			<div>user-agent : ${header['user-agent'] }</div>
			<div>accept : ${header['accept'] }</div>
			<div>accept-encoding : ${header['accept-encoding'] }</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3>표현식으로 표현하기</h3>
			<%
				String no = request.getParameter("no");
				String opt = request.getParameter("opt");
				String keyword = request.getParameter("keyword");
			%>
			<div>번호 : <%=no %></div>
			<div>검색옵션 : <%=opt %></div>
			<div>검색키워드 : <%=keyword %></div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3>EL로 표현</h3>
			<div>번호 : ${param.no3 }</div>
			<div>검색옵션 : ${param.opt3 }</div>
			<div>키워드 : ${keyword3 }</div>
		</div>
	</div>
</div>
</body>
</html>