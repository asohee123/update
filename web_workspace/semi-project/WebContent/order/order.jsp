<%@page import="semi.dao.BucketDao"%>
<%@page import="semi.dto.BucketDto"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.dto.ProductImgDto"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.util.StringUtil"%>
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
  <style type="text/css">
  	.table tbody td {vertical-align: middle;}
  </style>
</head>
<body>
<%@ include file="/common/loginProcess.jsp" %>
<%@ include file="/common/navibar.jsp" %>
<%
	
	String userId = (String) session.getAttribute("아이디");
		
	UserDao userDao = new UserDao();
	User findUser = userDao.getUserById(userId);
	
	ProductDao productDao = new ProductDao();
	ItemDao itemDao = new ItemDao();
	//BucketDao bucketDao = new BucketDao();
	
	String buyNow = StringUtil.nullToBlank(request.getParameter("buynow"));
	
	System.out.println(buyNow);
	
	int totalPrice = 0;
	
%>
<div class="container">
	<div class="row justify-content-md-center">
    	<div class="col-12">
    		<div class="header text-center">
    			<div class="row">
    				<div class="col-12 pb-3 h2">
    					Order
    				</div>
    			</div>
    			<div class="row">
    				<div class="col-12 pb-3">    					
    					<div class="row">
    						<div class="col-3"></div>
    							<div class="col-6">
    								<div class="row">
    									<div class="col-6 my-auto">
    										<a href="../user/profile.jsp" style="color: black;"><strong><%=findUser.getName() %></strong>님의 주문결제</a>
    									</div>
    									<div class="col-6">
											<div class="row">
												<div class="col-12"><a class="text-dark" href="../user/pointHistory.jsp">
													<strong>보유포인트</strong>
												</a></div>
											</div>
											<div class="row">
												<div class="col-12">
													<%=findUser.getPoint() %>
												</div>
											</div>    									
    									</div>
    								</div>
    							</div>
    							<div class="col-3"></div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>	
    	</div>
    	
    	<div class="row">
    		<div class="col-12">
    			<div class="body text-center">
					<div class="row">
						<div class="col-12">
							<h5 class="pt-3 pb-3 h5">주문결제목록</h5>							
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<form id="orderForm" method="post" action="insertOrder.jsp">
								<table class="table table-bordered" id="contact-table">
									<thead>
								    <tr>
								      <th scope="col" style="width: 7%">순번</th>								      
								      <th scope="col" style="width: 11%">이미지</th>
								      <th scope="col" style="width: 19%">상품명</th>
								      <th scope="col" style="width: 10%">주문가격</th>
								      <th scope="col" style="width: 10%">색상</th>
								      <th scope="col" style="width: 10%">사이즈</th>
								      <th scope="col" style="width: 10%">수량</th>
								      <th scope="col" style="width: 13%">적립예정포인트</th>
								      <th scope="col" style="width: 10%">총 금액</th>								     
								    </tr>
								  </thead>
								  <tbody>
								<%
									if ("true".equals(buyNow)) {
										// 바로 구매 한 경우
										int productNo = Integer.parseInt(request.getParameter("productNo"));	
										
										ProductImgDto product = productDao.getProductByNo(productNo);										
										String size = request.getParameter("size");
										String color = request.getParameter("color");
										int amount = Integer.parseInt(request.getParameter("amount"));
																							
										Item item = itemDao.getItemBySizeAndColor(productNo, color, size);
										
										System.out.println("itemNo: "+item.getNo());
										totalPrice = product.getDiscountPrice()*amount;
								%>
									<tr class="text-justify text-center">
										<td>1</td>
										<input type="hidden" name="itemNo" value="<%=item.getNo() %>">
										<input type="hidden" name="amount" value="<%=amount %>">
										<input type="hidden" name="price" value="<%=product.getDiscountPrice() %>">
										
										<td><img src="../resources/<%=product.getImg()%>" width="100" height="100"></td>
										<td><%=product.getProductName() %></td>
										<td><%=NumberUtil.numberWithComma(product.getDiscountPrice()) %> 원</td>
										<td><%=item.getColor() %></td>
										<td><%=item.getSize() %></td>
										<td><%=amount %> 개</td>
										<td><%=product.getPoint() * amount %> 점</td>
										<td><%=NumberUtil.numberWithComma(product.getDiscountPrice() * amount)%> 원</td>
									</tr>		
								<%		
									} else {
										// 장바구니에서 구매를 누른 경우
										//String[] bucketNos = request.getParameterValues("bucketNo");
										//int point = NumberUtil.stringToInt(request.getParameter("point"));
										//int i = 1;
																				
										//for (String no : bucketNos) {
										//	int bucketNo = Integer.parseInt(no);
										//	BucketDto dto = bucketDao.
											
								%>
								    <tr class="text-justify text-center">
								      <td></td>
								      <td><img src="" width="100" height="100"></td>
								      <td></td>
								      <td></td>								      
								      <td></td>								      
								      <td></td>								 							      
								      <td></td>
								      <td></td>
								      <td></td>								      
								     </tr>
								<%
										
									}			  	
								%>
								  </tbody>
								</table>
								
								<div class="row mt-4">
									<div class="col-12">
										<h5 class="pt-3 pb-3 h5 mt-3 mb-2">결제 예정 금액</h5>							
									</div>
								</div>
																
								<table class="table table-bordered">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
										<tr>
											<th>보유포인트</th>
											<td class="text-right pr-5"><%=findUser.getPoint() %> 점</td>
										</tr>
								</table>
								
								<table class="table table-bordered">
									<tbody>
										<tr>
											<th class="text-info">총 주문금액</th>											
											<th>사용포인트</th>
											<th class="text-danger">결재예정금액</th>
										</tr>
										<tr>
											<input type="hidden" id="total" name="totalPrice" value="<%=totalPrice %>">										
											<td><%=NumberUtil.numberWithComma(totalPrice) %> 원</td>											
											<td><input class="text-right" type="number" min="0" 
											max="<%=findUser.getPoint()>=totalPrice? totalPrice : findUser.getPoint()
											%>" value="0" name="point" onchange="changePoint(event)"> 점</td>
											<td id="pay"><%=totalPrice %> 원</td>
										</tr>
									</tbody>
								</table>
								<div class="text-center mt-5 mb-5">
									<button type="button" class="btn btn-danger mr-4" onclick="backToPage()">결제취소</button>	
									<a href=""><button type="submit" class="btn btn-primary ml-4">상품결제</button></a>																					
								</div>								
							</form>
						</div>
					</div>
    			</div>
    		</div>
    	</div>
</div>
<%@ include file="/common/footer.jsp" %>

<script type="text/javascript">

	function changePoint(event) {		
		var point = event.target.value;
		var totalPrice = document.getElementById("total").value
		
		document.getElementById("pay").textContent = (totalPrice-point)+" 원";
	}
	
	function backToPage() {
		history.go(-1);
	}
	
</script>
</body>
</html>