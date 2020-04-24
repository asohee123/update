package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.util.connectionUtil;
import com.sample.bookstore.vo.User;

public class UserDAO {

	public void addUser(User user) throws SQLException {
	
//		String sql = "select * "
//					+ "(user_id, user_name, user_password, user_email, user_point, user_registered_date) "
//					+ "values "
//					+ "(?, ?, ?, ?, ?, sysdate)";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.addUser"));
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
					
	}
	
	public User getUserById(String userId) throws SQLException {
		
//		String sql = "selcet * "
//					+ "from sample_book_users "
//					+ "where user_id = ?";
		
		User user = null;
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			
		}
		
		connection.close();
		pstmt.close();
		rs.close();
		
		return user;
	}
	
	public void updateUser(User user) throws Exception{
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.updateUser"));
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getEmail());
		pstmt.setInt(3, user.getPoint());
		pstmt.setString(4, user.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
}
