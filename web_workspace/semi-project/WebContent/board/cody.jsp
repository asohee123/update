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
  <%@ include file="/common/navibar.jsp" %>
  <style type="text/css">
  	board {
  	
  		border-style: dotted;
	
	}
	p {
		font-size: 13px;
	}
  </style>
</head>
<body>
<div class="container">
	<div class="top">
		<div class="row board">
			<div class="col-12">
				<div class="row">
					<div class="col sm-4 text-center">
						<a href="detail.jsp?productno="><p><img class="img-thumbnail" src=../resources/골지브이반팔가디건.jpg></p></a>
						<a href="detail.jsp?productno="><p>골지브이반팔가디건</p></a>
						
					</div>
					<div class="col sm-4 text-center">
					
					</div>
					<div class="col sm-4 text-center">
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>