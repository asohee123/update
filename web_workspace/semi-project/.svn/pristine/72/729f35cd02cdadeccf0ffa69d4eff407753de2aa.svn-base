package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.BucketDto;
import semi.dto.ProductDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Bucket;

public class BucketDao {

	public List<BucketDto> getAllbucket() throws SQLException {
		List<BucketDto> buckets = new ArrayList<BucketDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.getAllbucket"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BucketDto bucketDto = new BucketDto();
			
			bucketDto.setBucketNo(rs.getInt("bucket_no"));
			bucketDto.setProductImage(rs.getString("product_img"));
			bucketDto.setProductName(rs.getString("product_name"));
			bucketDto.setProductPrice(rs.getInt("product_price"));
			bucketDto.setProductColor(rs.getString("product_color"));
			bucketDto.setProductSize(rs.getString("product_size"));
			bucketDto.setProductAmount(rs.getInt("product_amount"));
			bucketDto.setProductPoint(rs.getInt("product_point"));
			bucketDto.setProductStock(rs.getInt("product_stock"));
			
			buckets.add(bucketDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return buckets;
	}

	public void deleteBucketbyBucketNo(int bucketNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.deleteBucketbyBucketNo"));
		pstmt.setInt(1, bucketNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<BucketDto> displayBucketListByUserId(String userId) throws SQLException {
		
		List<BucketDto> buckets = new ArrayList<BucketDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.displayBucketListByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {
			BucketDto bucketDto = new BucketDto();
			
			bucketDto.setBucketNo(rs.getInt("bucket_no"));
			bucketDto.setProductImage(rs.getString("product_img"));
			bucketDto.setProductName(rs.getString("product_name"));
			bucketDto.setProductPrice(rs.getInt("product_discount_price"));
			bucketDto.setProductColor(rs.getString("product_color"));
			bucketDto.setProductSize(rs.getString("product_size"));
			bucketDto.setProductAmount(rs.getInt("product_amount"));
			bucketDto.setProductPoint(rs.getInt("product_point"));
			bucketDto.setProductStock(rs.getInt("product_stock"));
			bucketDto.setProductNo(rs.getInt("product_no"));
			
			buckets.add(bucketDto);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return buckets;
	}
	
	public void addBucket(Bucket bucket) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.addBucket"));
		
		pstmt.setString(1, bucket.getUserId());
		pstmt.setInt(2, bucket.getItemNo());
		pstmt.setInt(3, bucket.getProductAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void deleteAutoBucket() throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.deleteAutoBucket"));
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();		
	}

	public BucketDto getProductStockBybucketNo(int bucketNo) throws SQLException {
		
		BucketDto bucketDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.getProductStockBybucketNo"));
		pstmt.setInt(1, bucketNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			bucketDto = new BucketDto();
			
			bucketDto.setBucketNo(rs.getInt("bucket_no"));
			bucketDto.setItemNo(rs.getInt("item_no"));
			bucketDto.setProductAmount(rs.getInt("product_amount"));
			bucketDto.setProductSize(rs.getString("product_size"));
			bucketDto.setProductStock(rs.getInt("product_stock"));
			
		}
		
		return bucketDto;
	}
	
	public void deleteAll(String userId) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.deleteAll"));
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public BucketDto findbucketCountByloginedId(String userId) throws SQLException {
		
		BucketDto bucketDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.findbucketCountByloginedId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			bucketDto = new BucketDto();
			
			bucketDto.setConut(rs.getInt("cnt"));

		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return bucketDto;
	}
	
	public void deleteBucketbyBucketNos(String userId, int[] bucketNo) throws SQLException {
		
		for (int i=0; i<bucketNo.length; i++) {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("bucket.deleteBucketbyBucketNos"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, bucketNo[i]);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
		}
		
	}

}

