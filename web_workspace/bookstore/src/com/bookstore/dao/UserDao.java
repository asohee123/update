package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.UserDetailDto;
import com.bookstore.util.QueryUtil;
import com.bookstore.util.connectionUtil;
import com.bookstore.vo.User;

public class UserDao {

	public List<User> getAllUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getNewUsers"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			//이름 아이디 이메일 가입일
			User user = new User();
			user.setName(rs.getString("user_name"));
			user.setId(rs.getString("user_id"));
			user.setEmail(rs.getString("user_email"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			
			users.add(user);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return users;	
	}
	
	public List<User> getAllUsers() throws SQLException {
		
		List<User> users = new ArrayList<User>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getAllUsers"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			// id, 이름,이메일, 포인트가입일
			User user = new User();
			user.setId(rs.getNString("user_id"));
			user.setName(rs.getNString("user_name"));
			user.setEmail(rs.getNString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			
			users.add(user);
			
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return users;
	}
	
	public List<UserDetailDto> getOrderByUserid(String userId) throws SQLException{
		
		List<UserDetailDto> users = new ArrayList<UserDetailDto>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getOrderByUserid"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			UserDetailDto userDetailDto = new UserDetailDto();
			userDetailDto.setNo(rs.getInt("order_no"));
			userDetailDto.setBookNo(rs.getInt("book_no"));
			userDetailDto.setTitle(rs.getString("book_title"));
			userDetailDto.setPrice(rs.getInt("book_price"));
			userDetailDto.setAmount(rs.getInt("order_amount"));
			userDetailDto.setOrderPrice(rs.getInt("order_price"));
			userDetailDto.setRegisteredDate(rs.getDate("order_registered_date"));
			
			users.add(userDetailDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return users;
	}
	
	public User getUserById(String userId) throws SQLException {
		User user = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			user = new User();
			user.setName(rs.getString("user_name"));
			user.setId(rs.getString("user_id"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			user.setPassword(rs.getString("user_password"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
}
