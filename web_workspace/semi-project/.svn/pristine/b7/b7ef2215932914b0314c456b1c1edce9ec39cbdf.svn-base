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
<%@ include file="/common/adminProcess.jsp" %>
<%@ include file="/common/navibar.jsp" %>
<%@ include file="/common/fixedbar.jsp" %>
<div class="container">
	<div class="row justify-content-center">
		<h4>notice</h4>
	</div>
	<form method="post" action="noticeProcess.jsp">
		<div class="row">
			<div class="form-group">
			    <label>제목</label>
			    <input type="text" class="form-control" name="title" required>
	  		</div>
		</div>
  		<div class="form-group">
		  	<label for="comment">글 내용:</label>
		  	<textarea class="form-control" rows="20" name="content" style="width: 100%" required></textarea>
		</div>
		<div class="row justify-content-end">
			<button type="submit" class="btn btn-primary">글 등록</button>
		</div>
	</form>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>