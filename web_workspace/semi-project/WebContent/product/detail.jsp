<%@page import="semi.dto.QuestionDto"%>
<%@page import="semi.dao.QuestionDao"%>
<%@page import="java.util.List"%>
<%@page import="semi.dto.ReviewDto"%>
<%@page import="semi.dao.ReviewDao"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dto.ProductImgDto"%>
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
	int productNo = Integer.parseInt(request.getParameter("productno"));	
	ProductDao productDao = new ProductDao();
	ProductImgDto product = productDao.getProductByNo(productNo);

	ItemDao itemDao = new ItemDao();
			
%>

<div class="container">  
	<div class="row">
		<div class="col-sm-6 text-center "  >
	    	<img class="img-thumbnail" src="../resources/<%=product.getImg() %>" style="width:85%;">	    	
	    </div>
	    
		<div class="col-sm-6  " >
			<div class="card">
			<!-- 상품 컨텐츠정보 시작 -->
				<div class="card-body">
					<p class="font-weight-bold mb-1 d-inline"><%=product.getProductName() %></p>					
					<div class="d-inline text-right">
					<%
						int[] newProductNos = productDao.getNewProductNos(product.getCategoryNo());					
						for (int i = 0; i < newProductNos.length; i++) {
							if (productNo == newProductNos[i]) {
					%>
						<span class="badge badge-pill badge-danger">New</span>
						<span class="badge badge-pill badge-dark">주인장추천</span>	
					<%						
							}
						}
					%>
					</div>					
					<hr />
										<!-- 가격정보 시작 -->
					<div class="mb-2">
						<div>
							<strong>상품간략설명: </strong> <span class="float-right font-weight-bolder">얼리버드 3차분 오픈!/주문량 폭주!</span>						
						</div>
						<div>
							<strong>소비자가: </strong> <del  class="float-right"><%=NumberUtil.numberWithComma(product.getPrice()) %> won</del>
						</div>
						<div>
							<strong>판매가: </strong> <span  class="float-right font-weight-bolder"><%=NumberUtil.numberWithComma(product.getDiscountPrice()) %> won</span>
						</div>
						<div>
							<strong>적립금: </strong> <span  class="float-right"><%=product.getPoint() %> won(1%)</span>
						</div>
						<div>
							<strong>요약설명: </strong> <span  class="float-right"><%=product.getDescription() %></span>
						</div>										
						<hr />
						<div class="mb-2">
							<strong>재고: </strong> <span  class="float-right font-weight-bolder" id="sample-stock">
							<%=itemDao.getItemBySizeAndColor(productNo, "white", "M").getStock() %> 개</span>
						</div>														
					</div>
					
									
					<form id="itemForm" method="post" action="../order/addBucket.jsp">
						<input type="hidden" name="productNo" value="<%=productNo %>">
						<div class="form-group">
							<label for="size-sample" >size</label>
							<select class="form-control" name="size"  id="size-sample" onchange="changeStockDisplay()">
								<option value="" disabled>-- [필수] size 선택 --</option>
								<option value="M"> M</option>
								<option value="L"> L</option>
								<option value="XL"> XL</option>
							</select>
						</div>
						<div class="form-group">
							<label for="color-sample">color</label>
							<select class="form-control" name="color"  id="color-sample" onchange="changeStockDisplay()">
								<option value="" disabled>-- [필수] color 선택 --</option>
								<option value="white"> white</option>
								<option value="black"> black</option>							
							</select>
						</div>
						<hr />
						<div class="form-group">
							<label for="amount-sample" >수량</label>
							<!-- 
							
							<input class="form-control" type="number" name="amount" value="1" min="1" id="amount-sample" onblur="checkamount()">
							 -->
							<input class="form-control" type="number" name="amount" value="1" min="1" id="amount-sample">
						</div>						
						
						<div class="text-right">						
						
						<!--  
							<button type="button" onclick="selectPath('../order/order.jsp?buynow=true')" class="btn btn-primary">BUY IT NOW </button>
							<button type="button" onclick="selectPath('../order/addBucket.jsp')" class="btn btn-primary">ADD TO CART </button>	
						-->
						  
							<button type="button" onclick="checkamount('../order/order.jsp?buynow=true')" class="btn btn-primary">BUY IT NOW </button>
							<button type="button" onclick="checkamount('../order/addBucket.jsp')" class="btn btn-primary">ADD TO CART </button>					
							<button type="button" class=""></button>							
						</div>
					</form>	
					<div class="mt-2">
						<a href="#reviewPage" class="d-inline px-2">Review (5)</a>
						<a href="#qnaPage" class="d-inline">Q & A (76)</a>
					</div>													
				</div>			
				<!-- 상품정보를 포함하는 카드 끝 -->							
			</div>				
		</div>	
	</div>
	
	<!-- 리뷰 시작  -->
	<%	
		ReviewDao reviewDao = new ReviewDao();
		List<ReviewDto> reviews = reviewDao.getReviewsByProdNo(productNo);
	%>
	<div class="row mt-5">	
		<div class="col-12 mt-5">			
			<h4 class="text-center" id="reviewPage">REVIEW</h4>
			<div>
				<table class="table mt-5">
					<colgroup>
						<col width="10%">
						<col width="80%">
						<col width="10%">
					</colgroup>
					<thead >
						<tr>
							<th>no</th>
							<th class="text-center">subject</th>
							<th>name</th>
						</tr>
					</thead>
					<tbody class="table-borderless">
					<%
						if(reviews.isEmpty()){
					%>
						<tr>
							<td></td>
							<td class="text-center">등록된 리뷰가 존재하지 않습니다.<br><br><br><br><br></td>
						</tr>
					<%
						} else {
							for (ReviewDto reviewDto : reviews) {	
					%>
						<tr>
							<td><%=reviewDto.getReviewNo() %></td>
							<td><%=reviewDto.getContent() %></td>
							<td><%=reviewDto.getHiddenName() %></td>
						</tr>
					<%
							}
						}
					%>
					</tbody>
				</table>
			</div>
			<div class="text-right">
				<a class="btn btn-primary " href="../board/insertReview.jsp?productno=<%=productNo %>" role="button">상품후기쓰기</a>
				<a class="btn btn-primary " href="#" role="button">전체글보기</a>			
			</div>
			
			<div class="text-center mt-3">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
			
		</div>
		
		
	</div>
	<!-- 리뷰 끝 -->
	
	<hr />
	
	<!-- Q & A 시작 -->
	<%
		QuestionDao questionDao = new QuestionDao();
		List<QuestionDto> questions = questionDao.getQuestionsByProdNo(productNo);
	%>
	<div class="row mt-5">	
		<div class="col-12 mt-5">			
			<h4 class="text-center" id="qnaPage">Q & A</h4>
			<div>
				<table class="table mt-5">
					<colgroup>
						<col width="10%">
						<col width="80%">
						<col width="10%">
					</colgroup>
					<thead >
						<tr>
							<th>no</th>
							<th class="text-center">subject</th>
							<th>name</th>
						</tr>
					</thead>
					<tbody class="table-borderless">						
						<%
						if(questions.isEmpty()){
					%>
						<tr>
							<td></td>
							<td class="text-center">등록된 Q & A가 존재하지 않습니다.<br><br><br><br><br></td>
						</tr>
					<%
						} else {
							for (QuestionDto questionDto : questions) {	
					%>
						<tr>
							<td><%=questionDto.getQuestionNo() %></td>
							<td><%=questionDto.getContent() %></td>
							<td><%=questionDto.getHiddenName() %></td>
						</tr>
					<%
							}
						}
					%>
					</tbody>
				</table>
			</div>
			<div class="text-right">
				<a class="btn btn-primary " href="../board/insertQuestion.jsp?productno=<%=productNo %>" role="button">상품문의하기</a>
				<a class="btn btn-primary " href="#" role="button">전체글보기</a>			
			</div>
			
			<div class="text-center mt-3">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>			
		</div>	
	</div>
</div>
<%@ include file="/common/footer.jsp" %>
<script type="text/javascript">

	function changeStockDisplay() {
		console.log('change');
		
		var inputAmount = document.querySelector("#amount-sample").value;		
		var productNo = document.querySelector("input[name=productNo]").value;
		var productSize = document.querySelector("select[name=size]").value;
		var productColor = document.querySelector("select[name=color]").value;
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var findText = JSON.parse(text);
				if ("0" == findText) {
					document.getElementById("sample-stock").textContent="0 개";
					
				} else {
					document.getElementById("sample-stock").textContent=findText+" 개";
					
				}
			}
		}
		
		xhr.open("GET", "getStock.jsp?productNo="+productNo
				+"&productSize="+productSize+"&productColor="+productColor);
		
		xhr.send();
	}	

	function selectPath(url) {
		var form = document.getElementById("itemForm");
		form.setAttribute("action", url);
		form.submit();		
	}	


	function checkamount(url) {
		
		var inputAmount = document.querySelector("#amount-sample").value;
		
		var productNo = document.querySelector("input[name=productNo]").value;
		var productSize = document.querySelector("select[name=size]").value;
		var productColor = document.querySelector("select[name=color]").value;
			
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			
			if (xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var findText = JSON.parse(text);
				if ("Y" == findText) {
					alert("주문수량보다 재고가 부족합니다.");
					return;
				}else {
					selectPath(url);
					return;
				}
				
			}
		}
		
		xhr.open("GET", "checkStock.jsp?inputAmount=" + inputAmount + "&productNo=" + productNo + "&productSize=" + productSize + "&productColor=" + productColor);
		
		xhr.send();
		
	}
</script>
</body>
</html>