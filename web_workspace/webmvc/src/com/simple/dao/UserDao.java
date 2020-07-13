package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.QueryUtil;
import com.simple.util.connectionUtil;
import com.simple.vo.User;

public class UserDao {

	public User getUserById(String userId) throws SQLException{
		User user = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
	         user = new User();
	         user.setId(rs.getString("user_id"));
	         user.setPassword(rs.getString("user_password"));
	         user.setName(rs.getString("user_name"));
	         user.setEmail(rs.getString("user_email"));
	         user.setPoint(rs.getInt("user_point"));
	         user.setRegisteredDate(rs.getDate("user_registered_date"));
	     }
		return user;
	}
}
