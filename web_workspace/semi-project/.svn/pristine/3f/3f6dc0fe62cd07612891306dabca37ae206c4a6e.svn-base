<%@page import="semi.dao.PointHistoryDao"%>
<%@page import="semi.vo.PointHistory"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="semi.dao.OrderedDao"%>
<%@page import="semi.vo.OrderProduct"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.vo.Order"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="semi.dao.OrderDao"%>
<%@page import="semi.dto.OrderDto"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int orderedProductNo = NumberUtil.stringToInt(request.getParameter("orderedProductNo"));
	String reason = request.getParameter("reason");
	
	System.out.println(reason);
	System.out.println(orderedProductNo);
	
	UserDao userDao = new UserDao();
	OrderDao orderDao = new OrderDao();
	ItemDao itemDao = new ItemDao();
	PointHistoryDao pointHistoryDao = new PointHistoryDao();
	
	//orderedProductNo를 이용해서 주문이 완료된 항목에대한 정보를 가져온다.
	OrderDto orderDto = orderDao.getInfoForCancelUseOrderedProductNo(orderedProductNo);
	
	// 로그인된 아이디
	String userId = (String)session.getAttribute("아이디");
	// 주문완료된 항목에 대한 orderNo
	int DtoOrderNo = orderDto.getOrderNo();
	// 주문완료된 항목에 대한 주문수량
	int DtoOrderedAmount = orderDto.getOrderedAmount();
	// 주문완료된 항목에 대한 주문금액
	int DtoOrderPrice = orderDto.getOrderedPrice();
	// 주문완료된 항목에 대한 아이템번호
	int DtoItemNo = orderDto.getItemNo();
	// 주문완료된 항목에 대한 사용된 포인트
	int DtoUsedPoint = orderDto.getUsedPoint();
	
	/*
	System.out.println("#########userId :" + userId);
	System.out.println("#########DtoOrderNo : " + DtoOrderNo);
	System.out.println("#########DtoOrderedAmount : " + DtoOrderedAmount);
	System.out.println("#########DtoOrderPrice : " + DtoOrderPrice);
	System.out.println("#########DtoItemNo : " + DtoItemNo);
	System.out.println("#########DtoUsedPoint :" + DtoUsedPoint);
	*/
	
	
	// 로그인된 아이디로 유저찾기
	User findUser = userDao.getUserById(userId);
	// 주문완료된 항목의 오더넘버에 대한 오더찾기
	Order order = orderDao.getOrderByNO(DtoOrderNo);
	// 주문완료된 항목의 아이템번호로 아이템찾기
	Item item = itemDao.getItemByNo(DtoItemNo);
	// 주문완료된 항목 찾기
	OrderProduct orderProduct = orderDao.getOrderProductByOrderedProductNo(orderedProductNo);
	
	
	if ("cancel".equals(reason)) {
		// 사용자의 총 주문금액에서 주문취소한 금액만큼 차감하기
		int totalOrderPrice = findUser.getTotalOrderPrice() - DtoOrderPrice;
		// 사용자가 주문에 대해서 사용한 포인트만큼 더해주기
		int userPoint = findUser.getPoint() + DtoUsedPoint;
		
		/*
		System.out.println("findUser.getTotalOrderPrice() : " + findUser.getTotalOrderPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("totalOrderPrice : " + totalOrderPrice);
		
		System.out.println("fineUser.getPoint() : " + findUser.getPoint());
		System.out.println("DtoUsedPoint : " + DtoUsedPoint);
		System.out.println("userPoint : " + userPoint);
		*/
		
		
		User user = new User();
		
		user.setUserId(userId);
		user.setTotalOrderPrice(totalOrderPrice);
		user.setPoint(userPoint);
		
		userDao.updatePoint(user);
		userDao.updateTotalOrderPrice(user);
		
		// 포인트를 사용한 주문 총 금액에서 취소한 항목에 대한 금액 + 사용한 포인트를 더해서 차감
		int orderPrice = order.getPrice() - (DtoOrderPrice - DtoUsedPoint);
		// 포인트를 사용하지않은 주문 총 금액에서 취소한 항목에 대한 금액 차감
		int orderTotalPrice = order.getTotalPrice() - DtoOrderPrice;
		// 주문포인트에서 사용된 주문포인트만큼 차감
		int orderPoint = order.getPoint() - DtoUsedPoint;
		
		/*
		System.out.println("order.getPrice() : " + order.getPrice());
		System.out.println("DtoOrderPrice : " +  DtoOrderPrice);
		System.out.println("orderPrice : " + orderPrice);
		
		System.out.println("order.getTotalPrice() : " + order.getTotalPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("orderTotalPrice : " + orderTotalPrice);
		
		System.out.println("order.getPoint() : " + order.getPoint());
		System.out.println("DtoUsedPoint : " + DtoUsedPoint);
		System.out.println("orderPoint : " + orderPoint);

		
		System.out.println(DtoOrderNo);
		*/
		
		Order newOrder = new Order();
		newOrder.setOrderNo(DtoOrderNo);
		newOrder.setPrice(orderPrice);
		newOrder.setTotalPrice(orderTotalPrice);
		newOrder.setPoint(orderPoint);
		
		orderDao.updateOrderStateCheckCancel(newOrder);
		
		// 아이템 재고에서 주문된 수량만큼 증가시켜준다.
		int stock = item.getStock() + DtoOrderedAmount;
		
		/*
		System.out.println("item.getStock() : " + item.getStock());
		System.out.println("DtoOrderedAmount : " + DtoOrderedAmount);
		System.out.println("Stock : " + stock);
		System.out.println("DtoItemNo : " + DtoItemNo);
		*/
		
		Item newItem = new Item();
		newItem.setStock(stock);
		newItem.setNo(DtoItemNo);
		
		itemDao.updateStockAboutOneItem(newItem);
		
		// 주문완료된 항목에 대한 구매금액 차감
		int orderedPrice = orderProduct.getOrderedPrice() - DtoOrderPrice;
		// 주문완료된 항목에 대한 구매수량 차감
		int orderedAmount = orderProduct.getOrderedAmount() - DtoOrderedAmount;
		// 구매완료된 항목의 오더넘버
		/*
		System.out.println("orderProduct.getOrderedPrice() : " + orderProduct.getOrderedPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("orderedPrice : " + orderedPrice);
		
		System.out.println("orderProduct.getOrderedAmount() : " + orderProduct.getOrderedAmount());
		System.out.println("DtoOrderedAmount : " + DtoOrderedAmount);
		System.out.println("orderedAmount : " + orderedAmount);
		*/
		
		System.out.println("orderedNo : " + orderedProductNo);
	
		
		String cancelYN = "Y";
		
		OrderProduct newOrderProduct = new OrderProduct();
		newOrderProduct.setOrderedPrice(orderedPrice);
		newOrderProduct.setOrderedAmount(orderedAmount);
		newOrderProduct.setOrderProductNo(orderedProductNo);
		newOrderProduct.setCancelYN(cancelYN);
		
		OrderedDao orderedDao = new OrderedDao();
		orderedDao.updateOrderedStateCheckCancel(newOrderProduct);
		
	 	Gson gson = new Gson();
	 	
		String success = "cancel";
	 	String jsonText = gson.toJson(success);
	 	
	 	out.write(jsonText);
		
		
	} 	else if ("refund".equals(reason)) {
		
		PointHistory pointHistory = new PointHistory();
		
		pointHistory.setOrderNo(order.getOrderNo());
		pointHistory.setUserId(findUser.getUserId());
		pointHistory.setReason("환불");
		/*
		System.out.println("order.getOrderNo() : " + order.getOrderNo());
		System.out.println("findUser.getUserId() : " + findUser.getUserId());
		*/
		
		int depositPoint = pointHistoryDao.getPointHistoryByLoginedIdAndOrderNoAndHistoryReason(pointHistory);
		pointHistory.setChange(-depositPoint);
		pointHistoryDao.insertHistory(pointHistory);
		
		// 사용자의 총 주문금액에서 주문취소한 금액만큼 차감하기-
		int totalOrderPrice = findUser.getTotalOrderPrice() - DtoOrderPrice;
		// 사용자가 주문에 대해서 사용한 포인트만큼 더해주고 적립된 포인트만큼 차감하기
		int userPoint = findUser.getPoint() + DtoUsedPoint - depositPoint;
		
		System.out.println("findUser.getUserid : " + findUser.getUserId());
		System.out.println("order.getOrderNo() : " + order.getOrderNo());
		/*
		System.out.println("findUser.getTotalOrderPrice() : " + findUser.getTotalOrderPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("totalOrderPrice : " + totalOrderPrice);
		
		System.out.println("fineUser.getPoint() : " + findUser.getPoint());
		System.out.println("DtoUsedPoint : " + DtoUsedPoint);
		System.out.println("userPoint : " + userPoint);
		System.out.println("depositPoint : " + depositPoint);
		*/
		
		User user = new User();
		
		user.setUserId(userId);
		user.setTotalOrderPrice(totalOrderPrice);
		user.setPoint(userPoint);
		
		userDao.updatePoint(user);
		userDao.updateTotalOrderPrice(user);
		
		// 주문중에서 취소한 항목에 대한 포인트를 사용한 금액을 포함한 구매총액 차감
		int orderPrice = order.getPrice() - (DtoOrderPrice + DtoUsedPoint);
		// 주문중에서 포인트를 사용하지 않고 구매한 총액차감
		int orderTotalPrice = order.getTotalPrice() - DtoOrderPrice;
		// 주문포인트에서 사용된 주문포인트만큼 차감
		int orderPoint = order.getPoint() - DtoUsedPoint;
		
		/*
		System.out.println("order.getPrice() : " + order.getPrice());
		System.out.println("DtoOrderPrice : " +  DtoOrderPrice);
		System.out.println("orderPrice : " + orderPrice);
		
		System.out.println("order.getTotalPrice() : " + order.getTotalPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("orderTotalPrice : " + orderTotalPrice);
		
		System.out.println("order.getPoint() : " + order.getPoint());
		System.out.println("DtoUsedPoint : " + DtoUsedPoint);
		System.out.println("orderPoint : " + orderPoint);
		*/
		
		System.out.println(DtoOrderNo);
		
		Order newOrder = new Order();
		newOrder.setOrderNo(DtoOrderNo);
		newOrder.setPrice(orderPrice);
		newOrder.setTotalPrice(orderTotalPrice);
		newOrder.setPoint(orderPoint);
		
		orderDao.updateOrderStateCheckCancel(newOrder);
		
		// 아이템 재고에서 주문된 수량만큼 증가시켜준다.
		int stock = item.getStock() + DtoOrderedAmount;
		
		/*
		System.out.println("item.getStock() : " + item.getStock());
		System.out.println("DtoOrderedAmount : " + DtoOrderedAmount);
		System.out.println("Stock : " + stock);
		System.out.println("DtoItemNo : " + DtoItemNo);
		*/
		
		Item newItem = new Item();
		newItem.setStock(stock);
		newItem.setNo(DtoItemNo);
		
		itemDao.updateStockAboutOneItem(newItem);
		
		// 주문완료된 항목에 대한 구매금액 차감
		int orderedPrice = orderProduct.getOrderedPrice() - DtoOrderPrice;
		// 주문완료된 항목에 대한 구매수량 차감
		int orderedAmount = orderProduct.getOrderedAmount() - DtoOrderedAmount;
		// 구매완료된 항목의 오더넘버
		int orderedNo = orderedProductNo;
		
		/*
		System.out.println("orderProduct.getOrderedPrice() : " + orderProduct.getOrderedPrice());
		System.out.println("DtoOrderPrice : " + DtoOrderPrice);
		System.out.println("orderedPrice : " + orderedPrice);
		
		System.out.println("orderProduct.getOrderedAmount() : " + orderProduct.getOrderedAmount());
		System.out.println("DtoOrderedAmount : " + DtoOrderedAmount);
		System.out.println("orderedAmount : " + orderedAmount);
		
		System.out.println("orderedNo : " + orderedProductNo);
		*/
		
		String cancelYN = "Y";
		
		OrderProduct newOrderProduct = new OrderProduct();
		newOrderProduct.setOrderedPrice(orderedPrice);
		newOrderProduct.setOrderedAmount(orderedAmount);
		newOrderProduct.setOrderProductNo(orderedProductNo);
		newOrderProduct.setCancelYN(cancelYN);
		
		OrderedDao orderedDao = new OrderedDao();
		orderedDao.updateOrderedStateCheckCancel(newOrderProduct);
		
	 	Gson gson = new Gson();
	 	
		String success = "refund";
	 	String jsonText = gson.toJson(success);
	 	
	 	out.write(jsonText);
		
	}
	

	
%>