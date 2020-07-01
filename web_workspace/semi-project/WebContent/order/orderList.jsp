<%@page import="semi.vo.OrderProduct"%>
<%@page import="semi.dao.OrderedDao"%>
<%@page import="semi.vo.Order"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="semi.dao.OrderDao"%>
<%@page import="semi.dto.OrderListDto"%>
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
<%@ include file="../common/navibar.jsp" %>
<%@ include file="/common/fixedbar.jsp" %>
<% 
				UserDao userDao = new UserDao();
				User user = userDao.getUserById(userName);
				
				String loginedId = (String)session.getAttribute("아이디");
				
				String userGrade = null;
				if(user.getTotalOrderPrice() >= 500000) {
					userGrade = "골드등급";
				} else if(user.getTotalOrderPrice() >= 300000) {
					userGrade = "실버등급";
				} else if(user.getTotalOrderPrice() >= 100000) {
					userGrade = "브론즈등급";
				} else if(user.getTotalOrderPrice() < 100000) {
					userGrade = "일반등급";
				}
%>

<body>
<div class="container">  

    	<div class="row">
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
    										<strong><%=user.getName() %></strong>님은 현재 <strong><%=userGrade %></strong> 입니다.</strong>
    									</div>
    									<div class="col-6">
											<div class="row">
												<div class="col-12"><a class="text-dark" href="../user/pointHistory.jsp">
													<strong>보유포인트</strong>
												</a></div>
											</div>
											<div class="row">
												<div class="col-12">
													<%=user.getPoint() %>
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
			<div class="row justify-content-center">
			<div class="col-3"></div>
			<div class="col-6">
				<table class="table">
					<tr class="text-center h4">
						<th width="33.3%"><a style="color: black;" href="orderList.jsp">Order</a></th>
						<th width="33.3%"><a style="color: black;" href="../board/notice.jsp">notice</a></th>
						<th width="33.3%"><a style="color: black;" href="../user/profile.jsp">Profile</a></th>
				    </tr>
				</table>
			</div>	
			<div class="col-3"></div>
			</div>

			<div>
				<div class="col-6">
					
						<div>
						  <select name="delivery-option" style="width: 33%;"  class="custom-select" onchange="changedelivery(event)">
						    <option value="all" onchange="changedelivery(event)">전체 주문처리상태</option>
						    <option value="beforedelivery" onchange="changedelivery(event)">배송전</option>
						    <option value="affterdelivery" onchange="changedelivery(event)">배송완료</option>
						  </select>
						</div>
				</div>
				<form>
				<%
				%>
					<div class="col-12 mt-3">
						<table class="table text-center" id="delivery-Select">
							<thead>
								<tr>
									<th>order date</th>
									<th>image</th>
									<th>product name</th>
									<th>qty</th>
									<th>price</th>
									<th>order state</th>
									<th>order change</th>
								</tr>
							</thead>
					<%
							OrderDao dao = new OrderDao();
							List<OrderListDto> lists = dao.getOrderList(userName);
							
							OrderedDao orderedDao = new OrderedDao();
							List<OrderProduct> products = orderedDao.getOrderStateByCancelOrRefund(loginedId);
							
					%>
							<tbody>
							<%
								for(int i=0; i<lists.size(); i++) {
									if("N".equals(lists.get(i).getDelivery_yn())){
									
									System.out.println(products.get(i).getCancelYN());
										
							%>
								<tr data-type="beforedelivery" id="contact-<%=lists.get(i).getOrderNo()%>">
									<td><%=lists.get(i).getOrderDate() %></td>
									<td><img src="../resources/<%=lists.get(i).getImg() %>" width="130" height="130"></td>
									<td><%=lists.get(i).getProductName() %></td>
									<td><%=lists.get(i).getStock() %></td>
									<td><%=lists.get(i).getOrderPrice() %> won</td>
									<td id="deliveryState">배송전</td>
									<td><button type="button" data-type=<%=lists.get(i).getOrderNo()%> onclick="cancel(event, 'cancel'); removeRow(<%=lists.get(i).getOrderNo() %>)" class="btn btn-primary">취소</button></td>
								</tr>	
							<%
									} else if("Y".equals(lists.get(i).getDelivery_yn())){
							%>
								<tr data-type="beforedelivery" id="contact-<%=lists.get(i).getOrderNo()%>">
									<td><%=lists.get(i).getOrderDate() %></td>
									<td><img src="../resources/<%=lists.get(i).getImg() %>" width="130" height="130"></td>
									<td><%=lists.get(i).getProductName() %></td>
									<td><%=lists.get(i).getStock() %></td>
									<td><%=lists.get(i).getOrderPrice() %> won</td>
									<td id="deliveryState">배송완료</td>
									<td><button type="button" data-type=<%=lists.get(i).getOrderNo()%> onclick="cancel(event, 'refund'); removeRow(<%=lists.get(i).getOrderNo() %>)" class="btn btn-primary">환불</button></td>
								</tr>
							<% 			
									}
								}
							%>
							</tbody>
						</table>
					</div>
				</form>	
			</div>
			
</div>
<script type="text/javascript">

	function changedelivery(event) {
		
		var selectButton = event.target;
        var selectType = selectButton.value;
        
        hideAllCourse();
        showCourse(selectType);
	}
	
	function hideAllCourse() {
        var rows = document.querySelectorAll("#delivery-Select tbody tr");
        for(var i=0; i<rows.length; i++) {
           var row = rows[i];
           row.style.display = 'none';
        }
     }
	
	function showCourse(selectType){
        
        var rows = document.querySelectorAll("#delivery-Select tbody tr");
        
        for(var i = 0; i<rows.length; i++){
      	  	
           var row = rows[i];
           
           if(selectType == "all"){
          	 row.style.display = "";
           }
           
           var rowCourseType = row.getAttribute("data-type");
           
           if(selectType == rowCourseType){
              row.style.display = "";
           }
        }
     }
	
	function cancel(event, reason) {
		
		var orderedProductNo = event.target.getAttribute("data-type");
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				var text = xhr.responseText;
				var success = JSON.parse(text);
				
				if ("cancel" == success) {
					alert("주문이 취소되었습니다.");
					location.reload(true);
					return;
				} else if ("refund" == success) {
					alert("환불처리 예정입니다.");
					location.reload(true);
					return;
				}

			}
		}
		
		xhr.open("GET", "cancel.jsp?orderedProductNo=" + orderedProductNo + "&reason=" + reason);
		
		xhr.send();
	}
	
	function removeRow(no) {
				
		var body = document.querySelector("#delivery-Select tbody");
		
		var row = document.querySelector("#contact-" + no);
		
		body.removeChild(row);
	}
	
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>