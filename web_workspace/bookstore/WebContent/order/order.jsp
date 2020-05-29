<%@page import="com.bookstore.dao.OrderDao"%>
<%@page import="com.bookstore.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%

	// 책번호, 구매가격, 구매수량, 사용자 아이디 조회하기 
	int bookNo = Integer.parseInt(request.getParameter("bookno"));
	int price = Integer.parseInt(request.getParameter("price"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	// String userId = request.getParameter("userid"); 
	
	// Order 객체를 생성해서 위에서 획득한 정보 저장하기
	Order order = new Order();
	
	order.setUserId(loginedUserId);
	order.setBookNo(bookNo);
	order.setPrice(price);
	order.setAmount(amount);
	
	// OrderDao의 insertOrder(Order order) 실행하기  
	OrderDao orderDao = new OrderDao();
	orderDao.insertOrder(order);
	
	// 주문완료페이지를 재요청하는 응답을 클라이언트로 보내기  
	response.sendRedirect("completed.jsp?userid=" + loginedUserId);
%>