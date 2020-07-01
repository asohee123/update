<%@page import="java.util.ArrayList"%>
<%@page import="com.sapmle.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h1>forEach 태그</h1>
		</div>
	</div>
	<%
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(100, "자바의 정석", "남궁성", 35000, 10));
		books.add(new Book(100, "이것이 자바다", "홍길동", 35000, 10));
		books.add(new Book(100, "실전 리액트 코딩", "이순신", 35000, 10));
		books.add(new Book(100, "파이썬 기초", "김유신", 35000, 10));
		books.add(new Book(100, "vue.js", "강감찬", 35000, 10));
		
		request.setAttribute("bookList", books);
	%>
	
	<div class="row">
		<div class="col-12">
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>저자</th>
						<th>가격</th>
						<th>재고현황</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList }">
						<tr>
							<td>${book.no }</td>
							<td>${book.title }</td>
							<td>${book.writer }</td>
							<td>${book.price }</td>
							<td>${book.stock }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>