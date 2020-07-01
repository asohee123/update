<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<h1>detail</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<table class="table">
				<thead>
					<tr>
						<th colspan="3">책 제목</th>
						<td>${book.title }</td>
					</tr>
					<tr>
						<th>저자</th>
						<td>${book.writer }</td>
						<th>출판사</th>
						<td>${book.publisher }</td>
					</tr>
					<tr>
						<th>평점</th>
						<td><fmt:formatNumber value="${book.point }" pattern="0.0" /></td>
						<th>추천수</th>
						<td><fmt:formatNumber value="${book.likes }" /> 개</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><fmt:formatNumber value="${book.price }" /></td>
						<th>할인가격</th>
						<td><fmt:formatNumber value="${book.discountPrice }" /> 원</td>
					</tr>
					<tr>
						<th>재고</th>
						<td><fmt:formatNumber value="${book.stock }" /> 권</td>
						<th>등록일</th>
						<td><fmt:formatDate value="${book.registeredDate }" pattern="yyyy.MM.dd"/> </td>
					</tr>
				</thead>
			</table>
			<div class="mt-3 text-right">
				<a href="list.hta" class="btn btn-primary">목록</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>