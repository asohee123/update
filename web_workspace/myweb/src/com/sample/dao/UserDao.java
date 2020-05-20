package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.util.connectionUtil;
import com.sample.vo.User;

public class UserDao {

	public void insertUser(User user) throws SQLException {
	String sql = "insert into sample_book_users "
			+ " (user_id, user_name, user_password,"
			+ "  user_email) "
			+ " values "
			+ " (?, ?, ?, ?) ";
	
	Connection connection = connectionUtil.getConnection();
	PreparedStatement pstmt = connection.prepareStatement(sql);
	pstmt.setString(1, user.getId());
	pstmt.setString(2, user.getName());
	pstmt.setString(3, user.getPassword());
	pstmt.setString(4, user.getEmail());
	
	pstmt.executeUpdate();
	
	pstmt.close();
	connection.close();
	
	}

	public List<User> getAllUser() throws SQLException{
		
		List<User> users = new ArrayList<User>();

		
		String sql = "select * from sample_book_users ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
		
			users.add(user);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return users;
	}
}
