<%@page import="semi.vo.User"%>
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
<%
	User user = (User)session.getAttribute("joinInfo");
%>

<%@ include file="/common/navibar.jsp" %>
<div class="container">  
	<div class="row justify-content-center" style="margin-bottom:40px;">
		<h2>Join Result</h2>
	</div>
	<div class="row justify-content-center" style="margin-bottom:40px;">
		<div class="text-center">
			<p>회원가입이 완료되었습니다.</p>
			<p><strong><%=user.getName() %></strong> 님은 [일반회원]회원이십니다.</p>
		</div>
	</div>
	<div class="row justify-content-center" style="margin-bottom:40px;">
		<div class="container p-3 my-3 border justify-content-center" style="width: 800px;">
			<div class="d-flex justify-content-center">
				<table class="table table-borderless" style="width:500px;">
				    <tbody>
				    	<tr>
					    	<th>ID</th>
					    	<td><%=user.getUserId() %></td>
				    	</tr>
				    	<tr>
					    	<th>NAME</th>
					    	<td><%=user.getName() %></td>
				    	</tr>
				    	<tr>
					    	<th>E-MAIL</th>
					    	<td><%=user.getEmail() %></td>
				    	</tr>
				    </tbody>
		  		</table>
			</div>
		</div>
	</div>
	<div class="row justify-content-end" style="margin-bottom:40px;">
		<button type="button" class="btn btn-primary" onclick="location.href='../home.jsp'">홈으로</button>
	</div>
</div>
<%@ include file="/common/footer.jsp" %>
<%
	session.invalidate();
%>
</body>
</html>