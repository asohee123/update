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
<%@ include file="../common/navibar.jsp" %>
<%@ include file="/common/fixedbar.jsp" %>
<%
	int productNo = Integer.parseInt(request.getParameter("productno"));
	ProductDao productDao = new ProductDao();
	ProductImgDto product = productDao.getProductByNo(productNo);
%>
<div class="container">  
	<form action="modifyProcess.jsp" method="post">
		<input type="hidden" name="productno" value="<%=productNo%>">
		<h4 class="card-title text-center" >상품수정</h4>
		<hr>
		<div class="form-group">
			<label>상품명</label>
			<input type="text" name="productname" value="<%=product.getProductName() %>" required>
		</div>	
		<div class="form-group">
			<label>소비자가격</label>
			<input type="number" name="price" value="<%=product.getPrice() %>" required>
		</div>	
		<div class="form-group">
			<label>판매가격</label>
			<input type="number" name="discountprice" value="<%=product.getDiscountPrice() %>" required>
		</div>			
		<div class="form-group">
			<label>상품설명</label>
			<textarea class="form-control" rows="10" name="description" style="width: 500px;" required><%=product.getDescription() %></textarea>
		</div>	
		<hr>
		<table>
			<thead>
				<tr>
					<th>사이즈</th>
					<th>색상</th>
					<th>재고 추가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>M</td>
					<td>Black</td>
					<td><input type="text" name="mb" ></td>
					
				</tr>
				<tr>
					<td>M</td>
					<td>White</td>
					<td><input type="text" name="mw" ></td>
				</tr>
				<tr>
					<td>L</td>
					<td>Black</td>
					<td><input type="text" name="lb" ></td>
				</tr>
				<tr>
					<td>L</td>
					<td>White</td>
					<td><input type="text" name="lw" ></td>
				</tr>
				<tr>
					<td>XL</td>
					<td>Black</td>
					<td><input type="text" name="xb" ></td>
				</tr>
				<tr>
					<td>XL</td>
					<td>White</td>
					<td><input type="text" name="xw" ></td>
				</tr>
			</tbody>
		</table>
		<hr>
    		<input type="checkbox" value="주인장 추천" name="tag1">
    		<label style="margin-right: 30px;">주인장 추천</label>
    		<input type="checkbox" value="EARLYBIRD OPEN" name="tag2">
    		<label style="margin-right: 30px;">EARLYBIRD OPEN</label>
    		<input type="checkbox" value="자체제작" name="tag3">
    		<label style="margin-right: 30px;">자체제작</label>
    		<input type="checkbox" value="TIME SALE" name="tag4">
    		<label style="margin-right: 30px;">TIME SALE</label>
   		<hr>
        <button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>