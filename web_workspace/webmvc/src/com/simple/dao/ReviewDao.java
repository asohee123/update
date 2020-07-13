package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.QueryUtil;
import com.simple.util.connectionUtil;
import com.simple.vo.Review;

public class ReviewDao {

	public List<Review> getReviewsByBookNo(int bookNo) throws SQLException {
		
		List<Review> reviews = new ArrayList<Review>();
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByBookNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Review review = new Review();
			review.setNo(rs.getInt("review_no"));
			review.setContent(rs.getString("review_content"));
			review.setPoint(rs.getInt("review_point"));
			review.setRegisteredDate(rs.getDate("review_registered_date"));
			review.setBookNo(rs.getInt("book_no"));
			review.setUserId(rs.getString("user_id"));
			
			reviews.add(review);
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
		pstmt.setInt(2, review.getBookNo());
		pstmt.setString(4, review.getUserId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public void deleteReview(int reviewNo) throws SQLException {
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.deleteReview"));
		pstmt.setInt(1, reviewNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public Review getReviewByNo(int reviewNo) throws SQLException {
		Review review = null;
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByNo"));
		
		pstmt.setInt(1, reviewNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			review = new Review();
			review.setNo(rs.getInt("review_no"));
			review.setContent(rs.getString("review_content"));
			review.setPoint(rs.getInt("review_point"));
			review.setRegisteredDate(rs.getDate("review_registered_date"));
			review.setBookNo(rs.getInt("book_no"));
			review.setUserId(rs.getString("user_id"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return review;
	}
	
}
