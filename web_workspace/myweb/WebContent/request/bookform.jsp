<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책정보 등록 폼</h1>
	
	<h3>신규 책정보를 입력하세요.</h3>
	<form action="bookregister.jsp" method="post">
		<!-- 제목, 저자, 쟝르, 출판사, 가격, 할인가격, 입고수량을 입력받는 폼을 만드시오. -->
		<div>
			<label>제목</label>
			<div><input type="text" name="title"></div>
		</div>
		
		<div>
			<label>저자</label>
			<div><input type="text" name="writer"></div>
		</div>
		
		<div>
			<label>쟝르</label>
			<div>
				<select name="genre">
					<option value="mellow">멜로</option>
					<option value="game">게임</option>
					<option value="Reasoning">추리</option>
				</select>
			</div>
		</div>
		
		<div>
			<label>출판사</label>
			<div><input type="text" name="publisher"></div>
		</div>
		
		<div>
			<label>가격</label>
			<div><input type="number" name="price"></div>
		</div>
		
		<div>
			<label>할인가격</label>
			<div><input type="number" name="discountPrice"></div>
		</div>
		
		<div>
			<label>입고수량</label>
			<div><input type="number" name="stock"></div>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
		
	</form>
</body>
</html>