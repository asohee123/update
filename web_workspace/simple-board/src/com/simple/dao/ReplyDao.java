package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.QueryUtil;
import com.simple.util.connectionUtil;
import com.simple.vo.Reply;

public class ReplyDao {

	public List<Reply> getReplyByUserId(String id) throws SQLException{
		
		List<Reply> replys = new ArrayList<Reply>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getReplyByUserId"));
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Reply reply = new Reply();
			
			reply.setNo(rs.getInt("reply_no"));
			reply.setContent(rs.getString("reply_content"));
			reply.setDel_yn(rs.getString("reply_del_yn"));
			reply.setCreateDate(rs.getDate("reply_create_date"));
			
			replys.add(reply);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return replys;
	}
}
