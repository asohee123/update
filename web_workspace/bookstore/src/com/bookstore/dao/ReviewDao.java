package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import com.bookstore.dto.ReviewDto;
import com.bookstore.util.QueryUtil;
import com.bookstore.util.connectionUtil;
import com.bookstore.vo.Review;

public class ReviewDao {

	public List<ReviewDto> getReviewsByBookNo(int bookNo) throws SQLException{
		List<ReviewDto> reviews = new ArrayList<ReviewDto>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByBookNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			ReviewDto reviewDto = new ReviewDto();
			reviewDto.setNo(rs.getInt("review_no"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setPoint(rs.getInt("review_point"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
			
			reviews.add(reviewDto);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviews;
	}
	
	public void insertReview(Review review) throws SQLException {
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.insertReview"));
		
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getPoint());
		pstmt.setInt(3, review.getBookNo());
		pstmt.setString(4, review.getUserId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public ReviewDto searchReview(String userId, int bookNo) throws SQLException {
		
		ReviewDto reviewDto = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.searchReview"));
		pstmt.setString(1, userId);
		pstmt.setInt(2, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			reviewDto = new ReviewDto();
			reviewDto.setReview_yn(rs.getString("review_yn"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviewDto;
	}
}
	
//	public ReviewDto getReviewByBookNo(int bookNo) throws SQLException{
//		
//		ReviewDto reviewDto = null;
//		
//		Connection connection = connectionUtil.getConnection();
//		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByBookNo"));
//		pstmt.setInt(1, bookNo);
//		ResultSet rs = pstmt.executeQuery();
//		
//		if(rs.next()) {
//			
//			reviewDto = new ReviewDto();
//			reviewDto.setNo(rs.getInt("review_no"));
//			reviewDto.setUserName(rs.getString("user_name"));
//			reviewDto.setPoint(rs.getInt("review_point"));
//			reviewDto.setContent(rs.getString("review_content"));
//			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
//			
//		}
//		
//		connection.close();
//		pstmt.close();
//		rs.close();
//		
//		return reviewDto;
//		
//	}
//}
