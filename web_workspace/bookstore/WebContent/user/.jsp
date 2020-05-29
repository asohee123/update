<%@page import="com.bookstore.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.UserDao"%>
<%@page import="com.bookstore.dto.UserDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
	<div class="wrapper">
	
		<div class="navi">
			<%
				String userId = request.getParameter("userid");
				String position = "user";
			
				UserDao userDao = new UserDao();
				User user = userDao.getUserById(userId);
				List<UserDetailDto> userDetailDto = userDao.getOrderByUserid(userId);
			%>	
			<%@ include file="../common/navibar.jsp" %>
		</div>
		
		<div class="header">
		
			<h1>고객 주문내역</h1>
			
		</div>
		<div class="body">
			<div>
				<h3>책의 상세정보</h3>
				<p><strong>누적포인트 : </strong><%=user.getPoint() %></p>
				<table class="table bordered">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>제목</th>
							<th>가격</th>
							<th>수량</th>
							<th>결재금액</th>
							<th>주문날짜</th>
							<td></td>
						</tr>
					</thead>
					<%
						for(UserDetailDto users : userDetailDto) {
					%>
					<tbody>
						<tr>
							<td><%=users.getNo() %></td>
							<td><a href="../book/detail.jsp?bookno=<%=users.getBookNo() %>"><%=users.getTitle() %></a></td>
							<td><%=users.getPrice() %></td>
							<td><%=users.getAmount() %></td>
							<td><%=users.getOrderPrice() %></td>
							<td><%=users.getRegisteredDate() %></td>
							<td><a href="../review/form.jsp?userid=<%=userId %>&bookno=<%=users.getBookNo() %>">리뷰작성</a></td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>

</body>
</html>