package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.DeliveryDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;

public class DeliverDao {
	public List<DeliveryDto> getDeliveryByOrderNo(int orderNo) throws SQLException {
		List<DeliveryDto> deliveries = new ArrayList<DeliveryDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("delivery.getDeliveryByOrderNo"));
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			DeliveryDto delivery = new DeliveryDto();
			delivery.setUserId(rs.getString(1));
			delivery.setOrderDate(rs.getDate(2));
			delivery.setProductNo(rs.getInt(3));
			delivery.setProductImg(rs.getString(4));
			delivery.setProductName(rs.getString(5));
			delivery.setAmount(rs.getInt(6));
			delivery.setPrice(rs.getInt(7));
			
			deliveries.add(delivery);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return deliveries;
	}
	
	public List<Integer> getAllOrderNo() throws SQLException {
		List<Integer> orders = new ArrayList<Integer>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("delivery.getAllOrderNo"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			orders.add(rs.getInt(1));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orders;
	}
	
	public void delivered(int orderNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("delivery.delivered"));
		pstmt.setInt(1, orderNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
