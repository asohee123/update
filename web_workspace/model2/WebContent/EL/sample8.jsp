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
			<h1>요청객체의 속성에 저장된 다양한 타입의 값을 EL로 표현하기</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<h3>속성에 저장된 배열을 표현하기</h3>
			<div>${bookNames }</div>
			<ol>
				<li>${bookNames[0] }</li>
				<li>${bookNames[1] }</li>
				<li>${bookNames[2] }</li>
			</ol>
			
			<h3>속성에 저장된 객체을 표현하기</h3>
			<div>${book }</div>
			<dl>
				<dt>번호</dt><dd>${book.no }</dd>
				<dt>제목</dt><dd>${book.title }</dd>
				<dt>저자</dt><dd>${book.writer }</dd>
				<dt>가격</dt><dd>${book.price }</dd>
				<dt>할인율</dt><dd>${book.discountRate }</dd>
				<dt>구매가격</dt><dd>${book.discountPrice }</dd>
				<dt>재고</dt><dd>${book.stock }</dd>
				<dt>절판여부</dt><dd>${book.soldOut }</dd>
				<dt>출판일</dt><dd>${book.pubDate }</dd>
			</dl>
			
			<h3>속성에 저장된 Map을 표현하기</h3>
			<div>${member }</div>
				<dl>
					<dt>아이디</dt><dd>${member.id }</dd>
					<dt>이름</dt><dd>${member.name }</dd>
					<dt>연락처</dt><dd>${member.tel }</dd>
					<dt>이메일</dt><dd>${member.email }</dd>
					<dt>소속부서</dt><dd>${member.dept }</dd>
				</dl>

			<h3>속성에 저장된  List을 표현하기</h3>
			<div>${movies }</div>
				<ul>
					<li>${movies[0] }</li>
					<li>${movies[1] }</li>
					<li>${movies[2] }</li>
					<li>${movies[3] }</li>
					<li>${movies[4] }</li>
				</ul>
		</div>
	</div>
</div>
</body>
</html>