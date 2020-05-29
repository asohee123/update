package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.util.QueryUtil;
import com.bookstore.util.connectionUtil;
import com.bookstore.vo.Board;

public class BoardDao {

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
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			board.setDel_yn(rs.getString("board_del_yn"));
			
			boards.add(board);
			
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
		
	}
	
	public void insertBoard(Board board) throws SQLException{
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setInt(3, board.getPassword());
		pstmt.setString(4, board.getContent());
		
		pstmt.executeUpdate();
	    
	    pstmt.close();
	    connection.close();
		
	}
	
	public Board getByBoardNo(int boardNo) throws SQLException {
		
		Board board = new Board();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
		board.setNo(rs.getInt("board_no"));
		board.setTitle(rs.getString("board_title"));
		board.setWriter(rs.getString("board_writer"));
		board.setRegisteredDate(rs.getDate("board_registered_date"));
		board.setHit(rs.getInt("board_hit"));
		board.setContent(rs.getString("board_content"));
		
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return board;
	}
	
	public List<Board> getByBoardTitle(String title) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getByBoardTitle"));
		pstmt.setString(1, title);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
		
	}
	
	public List<Board> getByBoardWriter(String writer) throws SQLException {
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getByBoardWriter"));
		pstmt.setString(1, writer);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}

	public List<Board> getByBoardContent(String content) throws SQLException {

		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getByBoardContent"));
		pstmt.setString(1, content);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public void DelBoardNo(int boardNo) throws SQLException {
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.DelBoardNo"));
		
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
	    
	    pstmt.close();
	    connection.close();
	}
}
