<%@page import="com.google.gson.Gson"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dao.BucketDao"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="semi.dto.BucketDto"%>
<%@page import="java.util.List"%>
<%@page import="semi.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap 4 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body onload="totalprice()">
<% 
	String loginedUserID = (String)session.getAttribute("아이디");

	UserDao userDao = new UserDao();
	User findUser = userDao.getUserById(loginedUserID);
	
	BucketDao buckets = new BucketDao();
	List<BucketDto> findbuckets = buckets.displayBucketListByUserId(loginedUserID);
	
%>
<%@ include file="/common/loginProcess.jsp" %>
<%@ include file="../common/navibar.jsp" %>
<%@ include file="/common/fixedbar.jsp" %>
<div class="container">
  <div class="row">
    <div class="col-12">
    	<div class="row">
    		<div class="col-12">
				<div class="navi text-center" >
	    		</div>
    		</div>
    	</div>
    	<div class="row">
    		<div class="col-12">
    			<div class="header text-center">
    				<div class="row">
    					<div class="col-12 pb-3 h2">
    						Cart
    					</div>
    				</div>
    				<div class="row">
    					<div class="col-12 pb-3">
    						<div class="row">
    							<div class="col-3"></div>
    							<div class="col-6">
    								<div class="row">
    									<div class="col-6 my-auto">
    										<strong><%=findUser.getName() %></strong>님의 장바구니
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
    	<% 
    		if (findbuckets.isEmpty()) {
    	%>
    		<div class="text-center h4 mb-4"><label style="text-align: center;">장바구니가 비어있습니다</label></div>
    		<div class="text-center mb-5" >
    		<a href="../home.jsp"><button class="btn btn-primary">홈으로 돌아가기</button></a>
    		</div>
    	<% 
    		} else {
    	%>
    	<div class="row">
    		<div class="col-12">
    			<div class="body text-center">
					<div class="row">
						<div class="col-12">
							<table>
								<tbody>
									<tr id="hover">
										<td style="width: 1.5%"></td>
										<td style="width: 13%" class="pt-3 pb-3 h5"
										 onmouseover="hover()" onmouseleave="leave()">장바구니리스트</td>
										<td style="width: 62.4%"></td>
										<td><small>장바구니에 담긴 상품은 3일동안 보관됩니다.</small></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<form id="my-form" method="post" action="">
								<table class="table table-bordered" id="contact-table">
								  <thead>
								    <tr>
								      <th scope="col" style="width: 3.3%">
								      <input type="checkbox" name="checkall" onchange="toggleChecked()"></th>
								      <th scope="col" style="width: 6%">image</th>
								      <th scope="col" style="width: 19.0%">product name</th>
								      <th scope="col" style="width: 9.1%">price</th>
								      <th scope="col" style="width: 6.6%">색상</th>
								      <th scope="col" style="width: 6.2%">사이즈</th>
								      <th scope="col" style="width: 6.6%">주문수량</th>
								      <th scope="col" style="width: 8.7%">적립포인트</th>
								      <th scope="col" style="width: 8.6%">total</th>
								      <th scope="col" style="width: 5%">order</th>
								    </tr>
								  </thead>
								  <tbody>
								  <%
								  	for (BucketDto bucket : findbuckets) {
								  %>
								    <tr id="contact-<%=bucket.getBucketNo()%>" class="parent">
								      <td style="vertical-align: middle;" ><input type="checkbox" name="items" value="<%=bucket.getBucketNo() %>" 
								      onchange="changeAllCheckbox(); displayTotalAmount(); selectedprice()"></td>
								      <td><img src="../resources/<%=bucket.getProductImage() %>" width="100" height="100"></td>
								      <td id="pName"><%=bucket.getProductName() %></td>
								      <input type="hidden" name="productNo" value="<%=bucket.getProductNo()%>">
								      <td id="pPrice" title="<%=bucket.getProductPrice()%>"><%=NumberUtil.numberWithComma(bucket.getProductPrice()) %>원
								      <br/>
								      <small id="pPoint" title="<%=bucket.getProductPoint() %>"></small></td>
								      <td id="pColor"><input type="hidden" name=color value="<%=bucket.getProductColor()%>"><%=bucket.getProductColor() %></td>
								      <td id="pSize"><input type="hidden" name="size" value="<%=bucket.getProductSize()%>"><%=bucket.getProductSize() %></td>
								      <td>
								      	<input type="number" class="input-group-text mb-3" min="0" max="<%=bucket.getProductStock() %>" 
								      	value="<%=bucket.getProductAmount()%>" id="stock" name="amount" onkeyup="checkStock(); changepointandtotalprice(); qntcheck()" onclick="changepointandtotalprice(); qntcheck()">
								      	<small><label id="stockquantity" title="<%=bucket.getProductStock()%>">현재재고 :<%=bucket.getProductStock() %></label></small>
								      </td>
								      <td id="accumulatepoint"><%=NumberUtil.numberWithComma((int)((bucket.getProductPrice() * bucket.getProductAmount())*0.01))%></td>
								      <td id="totalprice" title="<%=bucket.getProductPrice() * bucket.getProductAmount()%>">
								      <%=NumberUtil.numberWithComma(bucket.getProductPrice() * bucket.getProductAmount()) %>원</td>
								      <td><button type="button" class="btn btn-block btn-primary" onclick="buyitnow(event)"
								      		value="<%=bucket.getBucketNo() %>" style="margin-bottom: 5px;">buy it now</button>
								          <button type="button" class="btn btn-block btn-danger" name="<%=bucket.getBucketNo() %>"
								          onclick="removeRow(<%=bucket.getBucketNo()%>); removeRowUsedAJAX(event)">delete</button></td>
								     </tr>
								     
								  <%
								  	}
								  %>
								  </tbody>
								</table>
								<table class="table">
									<tr>
										<td style="text-align: left;"><label style="margin-left: -15px;"></label><button type="button" 
										class="btn btn-danger ml-1" onclick="removeCheckedRowsUsedAJAX()">선택상품 삭제하기</button></td>
										<td style="text-align: right"><a href="bucketDeleteAll.jsp"><button type="button"
										class="btn btn-danger" style="margin-right: -10px"
										>장바구니 비우기</button></a></td>
									</tr>
								</table>
								<div class="row">
									<div class="col-8 mr-3"></div>
									<div class="col-3"><small>적립포인트는 전체구매금액의 1%입니다.</small></div>
								</div>
								<div class="row">
									<div class="col-3">
										<table class="table">
											<tr>
											</tr>
										</table>
									</div>
									<div class="col-7"></div>
								</div>
								<table class="table">
									<tbody>
										<tr>
											<th width="33.3%">전체상품합계</th>
											<th width="33.3%">선택상품합계</th>
											<th width="33.3%">적립예정포인트<th>
										</tr>
										<tr>
											<td id="allPrice" width="33.3%"></td>
											<td id="selectedPrice" width="33.3%">0 원</td>
											<td id="expectedpoint"><td>
										</tr>
									</tbody>
								</table>
								<table class="table">
									<tr id="hover1">
										<td><button type="button" class="btn btn-primary" onclick="orderAll()">전체상품주문</button></td>
										<td><button type="button" class="btn btn-primary" onclick="orderchecked(event)">선택상품주문</button></td>
										<td><a href="../home.jsp"><button type="button" class="btn btn-info">쇼핑계속하기</button></a></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
    			</div>
    		</div>
    	</div>
    	<% 
    		}
    	%>
    	<div class="row"> 
    		<div class="col-12">
    			<div class="footer text-center">
    			</div>
    		</div>
    	</div>
    </div>
  </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript">
	function hover() {
		var hover1 = document.querySelector("#hover td:nth-of-type(2)");
		hover1.style.backgroundColor = "gray";
	}
	
	function leave() {
		var leave1 = document.querySelector("#hover td:nth-of-type(2)");
		leave1.style.backgroundColor = "white";
	}
	
	// 행에서 바로 삭제하기
	var body = document.querySelector("#contact-table tbody");
	
	//전달받은 번호에 해당하는 행을 삭제한다.
	function removeRow(no) {
		// 지정된 아이디의 tr을 조회한다.
		var row = document.querySelector("#contact-" + no);
		// tbody의 자식엘리먼트 중에서 해당 tr을 삭제한다.
		body.removeChild(row);
		
		
	}
	
	// 제목줄의 전체체크박스의 체크상태가 변경될때마다
	// 연락처행의 체크박스를 전체선택/전체해제한다.
	function toggleChecked() {
		// 제목행의 체크박스를 조회한다.
		var checkbox = document.querySelector("input[name=checkall]");
		// 제목행의 체크박스 체크상태를 조회한다.
		var checkedStatus = checkbox.checked;
		// 제품행의 모든 체크박스를 조회한다.
		var checkboxs = document.querySelectorAll("input[name=items]");
		// 제품행의 모든 checked상태를 제목행의 체크상태와 일치시킨다.
		for (var i=0; i<checkboxs.length; i++) {
			checkboxs[i].checked = checkedStatus;
		}
		
		this.selectedprice();

	}
	
	// 체크박스를 선택/해제할 때마다 제목줄의 전체체크박스의 상태를 변경한다.
	function changeAllCheckbox() {
		var checkboxs = document.querySelectorAll("input[name=items]");
		
		var totalCheckboxCount = checkboxs.length;	// 전체 체크박스 갯수
		var checkedCount = 0;						// 체크된 체크박스 갯수
		for(var i=0; i<checkboxs.length; i++) {
			if(checkboxs[i].checked) {				// 체크박스가 체크된 상태
				checkedCount++;						// 체크된 체크박스 갯수를 1증가시킨다.
			}
		}
		// 연락처행의 체크박스 갯수와 체크된 체크박스 갯수가 동일하면
		// 모두 체크된 경우고, 그 외는 하나이상 체크되지 않은 상황이다.
		var checkbox = document.querySelector("input[name=checkall]");
		if (totalCheckboxCount == checkedCount) {
			checkbox.checked = true;
		} else {
			checkbox.checked = false;
		}
	}
	
	
	// AJAX를 이용해서 DB행 하나만 지우기
	function removeRowUsedAJAX(event) {
		var bucketNumber = event.target.getAttribute("name");
		
		var xhr = new XMLHttpRequest();
	
		xhr.open("GET", "bucketDelete.jsp?bucketno=" + bucketNumber);
		
		xhr.send();
		
		location.reload(true);
	}	
	
	
	// AJAX를 이용해서 checked된 열 삭제하기 
	function removeCheckedRowsUsedAJAX() {
		var checkboxs = document.querySelectorAll("input[name=items]");
		
		for (var i=0; i<checkboxs.length; i++) {
			
			if (checkboxs[i].checked) {
				var bucketNumber = checkboxs[i].value;
				
				var xhr = new XMLHttpRequest();
				
				xhr.open("GET", "bucketDelete.jsp?bucketno=" + bucketNumber);
				
				xhr.send();
				
				this.removeRow(bucketNumber);
				
	
			}
		}
		
		location.reload(true);
	}
	
	// 체크된 제품의 금액과 수량을 합하여 계산
	function displayTotalAmount() {
		var checkStatus = document.querySelectorAll("input[name=items]")
		
		var checkValues = [];
		
		for (var i=0; i<checkStatus.length; i++) {
			if(checkStatus[i].checked) {
				checkValues[i] = checkStatus[i].value;
			}
		}
		
		
	}
	
	// 
	function pointCheck() {
		var inputPoint = document.querySelector("input[name=pointcheck]").value;
		
		var userPoint = document.querySelector("#userPoint").textContent;
		
		if (parseInt(userPoint) < parseInt(inputPoint)) {
			alert("올바른 포인트를 입력해주세요");
			document.querySelector("input[name=pointcheck]").value = "";
			return;
		}
		
		
		
	}
	
	function checkStock() {
		var inputStock = document.querySelectorAll("#stock");
		var findStock = document.querySelectorAll("#stockquantity");
		
		for (var i=0; i<inputStock.length; i++) {
			
			if (parseInt(inputStock[i].value) > parseInt(findStock[i].getAttribute('title'))) {
				
				alert("주문하신 수량보다 재고가 부족합니다. 다시 입력해주세요");
				event.target.value = 1;
				document.querySelectorAll("#accumulatepoint")[i].textContent = "";
				document.querySelectorAll("#totalprice")[i].textContent = "";
				if (document.querySelector("#allPrice").textContent == "NaN 원") {
					document.querySelector("#allPrice").textContent = "";
				}
				this.dontdisplayNaN();
				return;
			} else if (!inputStock[i].value) {
				alert("올바른 수량을 입력해주세요");
				inputStock[i].value = 1;
				return;
			}
		}

	}
	
	function qntcheck() {
		var check = document.querySelectorAll("input[name=amount]");
		var stock = document.querySelectorAll("#stockquantity")
		
		for (var i=0; i<check.length; i++) {
			if (parseInt(check[i].value) < 0 || parseInt(check[i].value) > parseInt(stock[i].getAttribute("title"))) {
				alert("올바른 값을 입력해주세요");
				check[i].value = 1;
				return;
			}
		}
	}
	
	function buyitnow(event) {
		
		var product = document.querySelectorAll("input[name=productNo]");
		
		var checkboxNo = document.querySelectorAll("input[name=items]");
		var bucketNo = event.target.value;
		
		var productNo = "";		
		for (var i=0; i<checkboxNo.length; i++) {
			if (checkboxNo[i].value == bucketNo) {
				checkboxNo[i].checked = true;
				productNo = product[i].value;
			}
		}
		
		var url = 'order.jsp?buynow=true&productNo=' + productNo

		var form = document.querySelector("#my-form");
		form.setAttribute("action", url);
		form.submit();

		
	}
	
	function orderAll() {
		
		var inputamount = document.querySelectorAll("input[name=amount]");
		
		for (var i=0; i<inputamount.length; i++) {
			if (inputamount[i].value == 0) {
				alert("올바른 수량을 입력해주세요");
				inputamount[i].value.focus();
				return;
			}
		}
		
		var items = document.querySelectorAll("input[name=items]");
		
		for (var i=0; i<items.length; i++) {
			items[i].checked = true;
		}
		
		var url = 'order.jsp?buyAll=all'
		var form = document.querySelector("#my-form");
		
		form.setAttribute("action", url);
		form.submit();
	}
	
	function orderchecked(event) {
		
		var items = document.querySelectorAll("input[name=items]");
		var checkControl = document.querySelectorAll(".parent")
		
		var trueOrFalseCheck = false;
		
		for (var i=0; i<items.length; i++) {
			if (items[i].checked) {
				trueOrFalseCheck = true;
			}
		}
		
		if (!trueOrFalseCheck) {
			alert("구매하실 제품을 체크해주세요");
			return;
		
		} else if (trueOrFalseCheck) {
			for (var i=0; i<items.length; i++) {
				
				/*
				if (!items[i].checked) {
					checkControl[i].innerHTML = "";	
				}
				*/
			}
			
			var url = 'order.jsp?buyAll=all'
			var form = document.querySelector("#my-form");
			
			var checked = document.querySelectorAll("input[name=amount]");
			
			for (var i=0; i<checked.length; i++) {
				if (checked[i].value == 0) {
					alert("수량을 확인해주세요")
					return;
				}
			}		
			
			form.setAttribute("action", url);
			form.submit();
		}
	}
	

	
	function changepointandtotalprice() {
		
		var inputStock = document.querySelectorAll("#stock")
		var productPoint = document.querySelectorAll("#pPoint")
		var accuPoint = document.querySelectorAll("#accumulatepoint")
		var productPrice = document.querySelectorAll("#pPrice")
		var totalPrice = document.querySelectorAll("#totalprice")
		
		this.dontdisplayNaN();
		
		for(var i=0; i<inputStock.length; i++) {
			totalPrice[i].textContent = numberformatcomma(parseInt(inputStock[i].value) * parseInt(productPrice[i].getAttribute("title")));
			accuPoint[i].textContent = numberformatcomma(parseInt(removecomma(totalPrice[i].textContent)) * 0.01);
			totalPrice[i].innerHTML += "<span>원</span>"
			this.dontdisplayNaN();
		}
		
		var checked = document.querySelectorAll("input[name=items]");
		
		for (var i=0; i<checked.length; i++) {
			
			if (checked[i].checked) {
				this.selectedprice();
			} else if (!checked[i].checked) {
				this.totalprice();
			}
		}
	}
	
	function dontdisplayNaN() {
		
		var accuPoint = document.querySelectorAll("#accumulatepoint")
		var totalPrice = document.querySelectorAll("#totalprice")
		var allPrice = document.querySelector("#allPrice")
		
		for (var i=0; i<accuPoint.length; i++) {
			if("NaN" == accuPoint[i].textContent && "NaN원" == totalPrice[i].textContent) {
				accuPoint[i].textContent = "";
				totalPrice[i].textContent = "";
			} 
		}
	}
	
	function totalprice() {
		
		var oneRowTotalPrice = document.querySelectorAll("#totalprice");
		
		var totalPrice = 0;
		
		for (var i=0; i<oneRowTotalPrice.length; i++) {
			totalPrice += parseInt(removecomma(oneRowTotalPrice[i].textContent));
		}
		
		document.querySelector("#allPrice").textContent = numberformatcomma(totalPrice);
		document.querySelector("#allPrice").innerHTML += "<span> 원</span>"
		
		document.querySelector("#expectedpoint").textContent = numberformatcomma(parseInt(removecomma(document.querySelector("#allPrice").textContent))*0.01);
		
		var checkboxs = document.querySelectorAll("input[name=items]");
		
		var checked = false
		
		for (var i=0; i<checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				checked = true;
			}
		}
		
		var selectedPrice = document.querySelector("#selectedPrice").textContent
		selectedPriceWithComma = selectedPrice.substring(0, 7);
		numberformatcomma(parseInt((removecomma(selectedPriceWithComma))) * 0.01);
		
		if (checked) {
			document.querySelector("#expectedpoint").textContent = numberformatcomma(parseInt((removecomma(selectedPriceWithComma))) * 0.01);
		} else {
			document.querySelector("#expectedpoint").textContent = numberformatcomma(parseInt(removecomma(document.querySelector("#allPrice").textContent))*0.01);
		}
		
	
		
	}
	
	function selectedprice() {
		
		var checkboxs = document.querySelectorAll("input[name=items]");
		var oneRowTotalPrice = document.querySelectorAll("#totalprice");
		
		var checkedPrice = 0;
		for (var i=0; i<checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				
				checkedPrice += parseInt(removecomma(oneRowTotalPrice[i].textContent));
			}
		}
		
		document.querySelector("#selectedPrice").textContent = numberformatcomma(checkedPrice);
		document.querySelector("#selectedPrice").innerHTML += "<span> 원</span>"
		
		this.totalprice();
	}
	

	
	
	function numberformatcomma(number) {
		    if(number==0) return 0;
		 
		    var reg = /(^[+-]?\d+)(\d{3})/;
		    var n = (number + '');
		 
		    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
		 
		    return n;
	}
	
	function removecomma(str)

	{
		n = parseInt(str.replace(/,/g,""));
		return n;
	}
	
	/*
	function submitCheck() {
		var checked = document.querySelectorAll("input[name=items]");
		
		for (var i=0; i<checked.length; i++) {a
			if (!checked[i].checked) {
				checked[i].checked = true;
			}
			return true;
		}
	}
	*/
	
</script>
</body>
</html>