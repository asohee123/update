package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.ReviewDto;
import semi.vo.Review;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;

public class ReviewDao {
	public List<ReviewDto> getReviewsByProdNo(int productNo) throws SQLException {
		List<ReviewDto> reviews = new ArrayList<ReviewDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewsByProdNo"));
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ReviewDto reviewDto = new ReviewDto();
			reviewDto.setReviewNo(rs.getInt("review_no"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
				
			reviews.add(reviewDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviews;
	}
	
	public void insertReview(Review review) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.insertReview"));
		pstmt.setString(1, review.getUserId());
		pstmt.setInt(2, review.getProductNo());
		pstmt.setString(3, review.getReviewContent());
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
}
