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
<body>
<%@ include file="../common/navibar.jsp" %>
<div class="container">  
			<%
				UserDao userDao = new UserDao();
				User user = userDao.getUserById(userName);
				
			%>
			
			<div class="text-center">
				<div class="row">
					<div class="col-7"><strong><%=user.getName() %></strong>님은 현재 <strong>일반회원</strong> 입니다.</div>
					<div class="col-5"><%=user.getPoint() %> 점</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-1"><button type="button" class="btn" onclick="location.href='../board/notice.jsp'">Notice</button></div>
				<div class="col-1"><button type="button" class="btn" onclick="location.href='../user/profile.jsp'">Profile</button></div>
			</div>
			<div class="text-center">
				<p> Order List</p>
			</div>
			<div>
				<div class="col-2">
					<form>
						<div>
						  <select name="delivery-option" class="custom-select" onchange="changedelivery(event)">
						    <option value="all" onchange="changedelivery(event)">전체 주문처리상태</option>
						    <option value="beforedelivery" onchange="changedelivery(event)">배송전</option>
						    <option value="affterdelivery" onchange="changedelivery(event)">배송완료</option>
						  </select>
						</div>
					</form>
				</div>
				<div class="col-12">
					<table class="table" id="delivery-Select">
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
				%>
						
						<tbody>
						<%
							for(OrderListDto list : lists){
								if("N".equals(list.getDelivery_yn())){
								
						%>
							<tr data-type="beforedelivery">
								<td><%=list.getOrderDate() %></td>
								<td><img src="../resources/<%=list.getImg() %>" width="130" height="130"></td>
								<td><%=list.getProductName() %></td>
								<td><%=list.getStock() %></td>
								<td><%=list.getOrderPrice() %> won</td>
								<td>배송전</td>
								<td></td>
						<%
								} else if("Y".equals(list.getDelivery_yn())){
						%>
							<tr data-type="affterdelivery">
								<td><%=list.getOrderDate() %></td>
								<td><img src="../resources/<%=list.getImg() %>" width="130" height="130"></td>
								<td><%=list.getProductName() %></td>
								<td><%=list.getStock() %></td>
								<td><%=list.getOrderPrice() %> won</td>
								<td>배송완료</td>
								<td></td>
						<% 			
								}
							}
						%>
							</tr>
						</tbody>
					</table>
				</div>
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

</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>