package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Robot;

import oracle.net.aso.q;
import semi.dto.OrderDto;
import semi.dto.OrderListDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Order;
import semi.vo.OrderProduct;

public class OrderDao {
	
	public int getSeq() throws SQLException {
		
		int seq = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getSeq"));
				
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			seq = rs.getInt(1);
		}		
		//		order.getSeq		
		return seq;
	}
	
	public void insertOrder(Order order) throws SQLException {
		
		//order.insertOrder
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.insertOrder"));
				
		pstmt.setInt(1, order.getOrderNo());
		pstmt.setString(2, order.getUserId());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getPoint());
		pstmt.setInt(5, order.getTotalPrice());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}

	public void insertOrderProduct(OrderProduct item) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.insertOrderProduct"));
				
		pstmt.setInt(1, item.getOrderNo());
		pstmt.setInt(2, item.getItemNo());
		pstmt.setInt(3, item.getOrderedAmount());
		pstmt.setInt(4, item.getOrderedPrice());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Order getOrderByNO(int orderNo) throws SQLException {
		
		Order order = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderByNo"));
		
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			order = new Order();
			order.setOrderNo(rs.getInt(1));
			order.setUserId(rs.getString(2));
			order.setPrice(rs.getInt(3));
			order.setPoint(rs.getInt(4));
			order.setTotalPrice(rs.getInt(5));
			order.setOrderDate(rs.getDate(6));
			order.setDeliveryYn(rs.getString(7));				
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return order;
		
	}
	
	public List<OrderListDto> getOrderList(String userid) throws SQLException {
		
		List<OrderListDto> lists = new ArrayList<OrderListDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderListUser"));
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			OrderListDto orderList = new OrderListDto();
			orderList.setImg(rs.getString(1));
			orderList.setProductName(rs.getString(2));
			orderList.setSzie(rs.getString(3));
			orderList.setColor(rs.getString(4));
			orderList.setOrderNo(rs.getInt(5));
			orderList.setOrderDate(rs.getDate(6));
			orderList.setOrderPrice(rs.getInt(7));
			orderList.setStock(rs.getInt(8));
			orderList.setDelivery_yn(rs.getString(9));
			
			lists.add(orderList);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return lists;
	}
	
	public List<OrderListDto> getOrdersByOrderNo(int orderNo) throws SQLException {
		
		List<OrderListDto> lists = new ArrayList<OrderListDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrdersByOrderNo"));
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			OrderListDto orderList = new OrderListDto();
			orderList.setOrderDate(rs.getDate("order_date"));
			orderList.setImg(rs.getString("product_img"));
			orderList.setProductName(rs.getString("product_name"));
			orderList.setStock(rs.getInt("ordered_amount"));
			orderList.setOrderPrice(rs.getInt("product_discount_price"));
			orderList.setDelivery_yn(rs.getString("delivery_yn"));
			
			lists.add(orderList);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		
		return lists;
	}
	
	public OrderDto findOrderBeforeDeliveryCountByloginedId(String userId) throws SQLException {
		OrderDto orderDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.findOrderBeforeDeliveryCountByloginedId"));
		pstmt.setString(1,userId);
		pstmt.setString(2, "N");
		pstmt.setString(3, "N");
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			orderDto = new OrderDto();
			
			orderDto.setCount(rs.getInt("cnt"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orderDto;
	}
	
	public OrderDto findOrderDeliveryCompleteCountByloginedId(String userId) throws SQLException {
		
		OrderDto orderDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.findOrderDeliveryCompleteCountByloginedId"));
		pstmt.setString(1,userId);
		pstmt.setString(2, "Y");
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			orderDto = new OrderDto();
			
			orderDto.setCount(rs.getInt("cnt"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orderDto;
	}
	
	public OrderDto findRefundByloginedId(String userId) throws SQLException {
		
		OrderDto orderDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.findRefundByloginedId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			orderDto = new OrderDto();
			
			orderDto.setCount(rs.getInt("cnt"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orderDto;
		
	}
	
	public OrderDto getInfoForCancelUseOrderedProductNo(int orderedProductNo) throws SQLException {
		
		OrderDto orderDto = new OrderDto();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getInfoForCancelUseOrderedProductNo"));
		pstmt.setInt(1, orderedProductNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			orderDto.setOrderNo(rs.getInt("order_no"));
			orderDto.setOrderedProductNo(rs.getInt("ordered_product_no"));
			orderDto.setOrderedAmount(rs.getInt("ordered_amount"));
			orderDto.setOrderedPrice(rs.getInt("ordered_price"));
			orderDto.setItemNo(rs.getInt("item_no"));
			orderDto.setUsedPoint(rs.getInt("order_point_use"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orderDto;
	}
	
	public OrderProduct getOrderProductByOrderedProductNo(int orderedProductNo) throws SQLException {
		OrderProduct orderProduct = new OrderProduct();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderProductByOrderedProductNo"));
		pstmt.setInt(1, orderedProductNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			orderProduct.setOrderNo(rs.getInt("order_no"));
			orderProduct.setOrderProductNo(rs.getInt("ordered_product_no"));
			orderProduct.setItemNo(rs.getInt("item_no"));
			orderProduct.setOrderedAmount(rs.getInt("ordered_amount"));
			orderProduct.setOrderedPrice(rs.getInt("ordered_price"));
			orderProduct.setCancelYN(rs.getString("cancel_YN"));
		}
		
		return orderProduct;
		
	}
	
	public void updateOrderStateCheckCancel(Order order) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.updateOrderStateCheckCancel"));
		pstmt.setInt(1, order.getPrice());
		pstmt.setInt(2, order.getPoint());
		pstmt.setInt(3, order.getTotalPrice());
		pstmt.setInt(4, order.getOrderNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateOrderedStateCheckCancel(OrderProduct orderProduct) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.updateOrderedStateCheckCancel"));
		pstmt.setInt(1, orderProduct.getOrderedAmount());
		pstmt.setInt(2, orderProduct.getOrderedPrice());
		pstmt.setString(3, orderProduct.getCancelYN());
		pstmt.setInt(4, orderProduct.getOrderProductNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
}
