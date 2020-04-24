package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.util.connectionUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

public class OrderDAO {

	public void addOrder(Order order) throws Exception{
				
//		String sql = "select * "
//					+ "(order_no, user_id, book_no, order_price, order_amount, order_registered_date) "
//					+ "values "
//					+ "(sample_order_seq.nextval, ?, ?, ?, ?, sysdate) ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.addOrder"));
		pstmt.setString(1, order.getUser().getId());
		pstmt.setInt(2, order.getBook().getNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
		
	}
	
	public List<Order> getUserById(String userId) throws Exception{
		
		List<Order> orders = new ArrayList<Order>();
		
//		String sql = "select * "
//				+ "from sample_book_orders "
//				+ "where user_id = ? "
//				+ "order by order_no desc ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrdersByUserId"));
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Order order = new Order();
			order.setNo(rs.getInt("order_no"));
			order.setPrice(rs.getInt("order_price"));
			order.setAmount(rs.getInt("order_amount"));
			order.setRegisteredDate(rs.getDate("order_registered_date"));
			
			User user = new User();
			user.setName(rs.getNString("user_name"));
			
			Book book = new Book();
			book.setTitle(rs.getString("book_title"));
			book.setPrice(rs.getInt("book_price"));
			
			order.setUser(user);
			order.setBook(book);
			
			orders.add(order);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orders;
	}
	
	public Order getOrderByNo(int orderNo) throws Exception {
		
		Order order = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderByNo"));
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			order = new Order();
			order.setNo(rs.getInt("order_no"));
			order.setPrice(rs.getInt("order_price"));
			order.setAmount(rs.getInt("order_amount"));
			order.setRegisteredDate(rs.getDate("order_registered_date"));
			
			User user = new User();
			user.setName(rs.getNString("user_name"));
			
			Book book = new Book();
			book.setTitle(rs.getString("book_title"));
			book.setPrice(rs.getInt("book_price"));
			
			order.setUser(user);
			order.setBook(book);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return order;
	}
	


}
