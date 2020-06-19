<%@page import="semi.dao.ProductDao"%>
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
<%@ include file="/common/navibar.jsp" %>

<%
	
%>

<div class="container">  
	<form action="productRegister.jsp" method="post" enctype="multipart/form-data">
		<h4 class="card-title text-center" >상품등록</h4>
		<hr>
		<div class="form-group">
			<label>상품명</label>
			<input type="text" name="productname" required>
		</div>	
		<div class="form-group">
			<label>소비자가격</label>
			<input type="number" name="price" required>
		</div>	
		<div class="form-group">
			<label>판매가격</label>
			<input type="number" name="discountprice" required>
		</div>	
		<div class="form-group">
			<label>포인트</label>
			<input type="number" name="point" required>
		</div>	
		<div class="form-group">
			<label>상품설명</label>
			<textarea class="form-control" rows="10" name="description" style="width: 500px;" required></textarea>
		</div>	
		<label>카테고리</label>	
		<input type="radio" name="category" value="10000" checked>Outer
		<input type="radio" name="category" value="10001">Tops
		<input type="radio" name="category" value="10002">Dress
		<input type="radio" name="category" value="10003">Knit
		<input type="radio" name="category" value="10004">Bottoms
		<br>
		<hr>
		<div class="form-group">
			<label>상품이미지</label>
			<div>
				<input type="file" name="productimg" />
			</div>
		</div>
		<br>
		<hr>
		<table>
			<thead>
				<tr>
					<th>사이즈</th>
					<th>색상</th>
					<th>재고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>M</td>
					<td>Black</td>
					<td><input type="text" name="mb" required></td>
					
				</tr>
				<tr>
					<td>M</td>
					<td>White</td>
					<td><input type="text" name="mw" required></td>
				</tr>
				<tr>
					<td>L</td>
					<td>Black</td>
					<td><input type="text" name="lb" required></td>
				</tr>
				<tr>
					<td>L</td>
					<td>White</td>
					<td><input type="text" name="lw" required></td>
				</tr>
				<tr>
					<td>XL</td>
					<td>Black</td>
					<td><input type="text" name="xb" required></td>
				</tr>
				<tr>
					<td>XL</td>
					<td>White</td>
					<td><input type="text" name="xw" required></td>
				</tr>
			</tbody>
		</table>
		<br>
		<hr>
    		<input type="checkbox" value="주인장 추천" name="tag1">
    		<label style="margin-right: 30px;">주인장 추천</label>
    		<input type="checkbox" value="EARLYBIRD OPEN" name="tag2">
    		<label style="margin-right: 30px;">EARLYBIRD OPEN</label>
    		<input type="checkbox" value="자체제작" name="tag3">
    		<label style="margin-right: 30px;">자체제작</label>
    		<input type="checkbox" value="TIME SALE" name="tag4">
    		<label style="margin-right: 30px;">TIME SALE</label>
   		<br>
   		<hr>
        <button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>