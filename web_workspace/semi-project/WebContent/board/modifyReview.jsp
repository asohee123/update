<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dto.ProductImgDto"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.dto.ReviewDto"%>
<%@page import="semi.dao.ReviewDao"%>
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
	int productNo = Integer.parseInt(request.getParameter("productno"));
	int reviewNo = Integer.parseInt(request.getParameter("reviewno"));
			
	ProductDao productDao = new ProductDao();
	ProductImgDto product = productDao.getProductByNo(productNo);	
%>

<div class="container">  
	<h5>상품후기수정</h5>
	<br>
	<div class="row">
		<div class="col-6">
			<div class="row">
				<div class="col-3">
					<img class="img-thumbnail" src="../resources/<%=product.getImg() %>">
				</div>
				<div class="col-9">
					<div class="row">
						<div class="col-12">
							<p class="font-weight-bold mb-1 d-inline"><%=product.getProductName() %></p>
							<div class="row">
								<div class="col-4">
									<p class=""><%=NumberUtil.numberWithComma(product.getDiscountPrice()) %> won</p>
								</div>
								<div class="col-8">
									<span class="badge badge-pill badge-danger">EARLYBIRD OPEN</span>
									<span class="badge badge-pill badge-dark">주인장추천</span>	
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<a class="btn btn-outline-info btn-sm " href="../product/detail.jsp?productno=<%=productNo%>" role="button">상품상세보기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<br>
	<div>
		<form action="modifyReviewRegister.jsp" method="post">
			<input type="hidden" name="productno" value="<%=productNo %>">
			<input type="hidden" name="reviewno" value="<%=reviewNo %>">
			subject
			<div>
				<input type="text" style="width:100%;" class="border border-gray"  name="title"> 
			</div>
			content
			<div>
				<textarea rows="15" style="width:100%;" class="border border-gray" name="content"></textarea>
			</div>
			<br>
			<div class="text-right">
				<button class="btn btn-primary" type="submit">수정</button>
				<a class="btn btn-primary " href="../product/detail.jsp?productno=<%=productNo %>" role="button">CANCEL</a>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
</script>
<%@ include file="/common/footer.jsp" %>
</body>
</html>