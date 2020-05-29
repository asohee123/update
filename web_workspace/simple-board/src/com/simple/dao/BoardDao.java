package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.QueryUtil;
import com.simple.util.connectionUtil;
import com.simple.vo.Board;

public class BoardDao {

	public List<Board> getBoardByUserId(String id) throws SQLException {
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoardByUserId"));
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setHit(rs.getInt("board_hit"));
			board.setReply_cnt(rs.getInt("board_reply_cnt"));
			board.setDel_yn(rs.getString("board_del_yn"));
			board.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<Board> getAllBoard() throws SQLException{
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoard"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setReply_cnt(rs.getInt("board_reply_cnt"));
			board.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(board);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
		
	}
}
