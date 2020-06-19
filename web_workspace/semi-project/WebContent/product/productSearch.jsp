<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dto.ProductDto"%>
<%@page import="java.util.List"%>
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
  <style type="text/css">
  	.top {
  		margin-top: 200px;
  	}
  	.tops {
  		margin-top: 50px;
  		margin-bottom: 200px;
  	}
  	
	p {
		font-size: 13px;
	}
	del {
		color:lightgray;
		font-size: 13px;
	}
	a {
		color: black;
	}
  </style>
</head>
<body>
<%@ include file="../common/navibar.jsp" %>
<div class="container">  
	

	<div class="text-center">
		<h3>search</h3>
	</div>
	<br>
	<div class="row justify-content-md-center">
		<div class="col-5">
			<div class="row">
				<div class="col-10">
					<form >
						<div class="row">
							<div class="col-12">
								<div>
									<select class="form-control" id="searchOption" name="searchOption">									
					    				<option value=""> All </option>
					    				<option value="10000" > Outer </option>
									    <option value="10001" > Tops </option>
									    <option value="10002" > Dress </option>
									    <option value="10003" > Knit </option>
									    <option value="10004" > Bottoms </option>
					  				</select>
								</div>
							</div>
						</div>
						<br>
						<div id="search-input">
						<div class="row">
							<div class="col-4">
								<label class="form-control">상품명</label>
							</div>
							<div class="col-8">
								<input type="search" class="form-control" placeholder="검색할 단어를 쓰세요." name="searchname" required>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-5">
								<input type="search" class="form-control" placeholder="최소판매가격" name="minmoney" required>
							</div>
							<div class="col-5">
								<input type="search" class="form-control" placeholder="최대판매가격" name="maxmoney" required>
							</div>
						</div>
						</div>
						<br>
						<div class="row">
							<div class="col-12">
								<select class="form-control" name="selectOption">
									<option value="" selected="selected" disabled="disabled">※기준 선택※</option>
									<option value="1">신상품 순</option>
									<option value="2">상품명 순</option>
									<option value="3">낮은가격 순</option>
									<option value="4">높은가격 순</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="col-2">
					<button type="button" onclick="search()" class="btn">search</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="top">
	<div class="row">
		<div class="col-12">
			<div class="row">
				<div class="col-12">
					<div class="text-left" id="total-product">
						<h6><strong>total |ITEMS</strong></h6>
					</div>
					<br>
					<div class="tops"> 
						<div class="text-center" id="search-result">
							<h6><small>검색결과가 없습니다.</small></h6>
							<h6><small>정확한 검색어 인지 확인하시고 다시 검색해 주세요.</small></h6>
							<p></p>
							<h6 style="color:LightGray;"><small>검색어/제외검색어의 입력이 정확한지 확인해 보세요.</small></h6>
							<h6 style="color:LightGray;"><small>두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</small></h6>
							<h6 style="color:LightGray;"><small>검색옵션을 다시 확인해 보세요. </small></h6>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>

<script type="text/javascript">
	function search() {

		var categoryEl = document.querySelector("select[name=searchOption]").value;
		var pnameEl = document.querySelector("input[name=searchname]").value;
		var minEl = document.querySelector("input[name=minmoney]").value;
		var maxEl = document.querySelector("input[name=maxmoney]").value;
		var orderEl = document.querySelector("select[name=selectOption]").value;
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				var check = JSON.parse(text);
				
				var rows = ""; 
				var total = 0;
				
				if(!check) {
					
				} else {
					
					rows += "<div class=row>";
					
					for (var i = 0; i<check.length; i++) {
						rows += "<div class=col-sm-4 text-center>";
						var product = check[i];	
								
						rows += "<a href=detail.jsp?productno="+product.productNo+"><p><img class='img-thumbnail' src=../resources/"+product.img+"></p></a>";
						rows += "<a href=detail.jsp?productno="+product.productNo+"><p>"+product.pName+"</a></p>";
						rows += "<a href=detail.jsp?productno="+product.productNo+"><p>"+product.description+"</a></p>";
						rows += "<del>"+product.price+" won</del>"
						rows += "<p>"+product.discountPrice+" won</p>"
						
						total++;
						
						rows += "</div>";
					}		
					
					rows += "</div>"
					total = "<h6><strong>total "+total+"개 |ITEMS</strong></h6>"
					document.querySelector("#search-result").innerHTML = rows;
					document.querySelector("#total-product").innerHTML = total;
				}
			}
		}
		
		xhr.open("GET", "searchCategory.jsp?categoryno=" + categoryEl + "&searchname=" + pnameEl + "&minmoney=" + minEl + "&maxmoney=" + maxEl + "&orderby=" + orderEl);
		
		xhr.send();

	}

</script>
</body>
</html>