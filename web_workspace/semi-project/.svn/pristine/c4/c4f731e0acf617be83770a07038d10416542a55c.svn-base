package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.OrderProduct;

public class OrderedDao {
	
	public void updateOrderedStateCheckCancel(OrderProduct orderProduct) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.updateOrderedStateCheckCancel"));
		pstmt.setInt(1, orderProduct.getOrderedAmount());
		pstmt.setInt(2, orderProduct.getOrderedPrice());
		pstmt.setString(3, orderProduct.getCancelYN());
		pstmt.setInt(4, orderProduct.getOrderProductNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public List<OrderProduct> getOrderStateByCancelOrRefund(String userId) throws SQLException {
		
		List<OrderProduct> products = new ArrayList<OrderProduct>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrderStateByCancelOrRefund"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			OrderProduct orderProduct = new OrderProduct();
			
			orderProduct.setCancelYN(rs.getString("cancel_yn"));
			
			products.add(orderProduct);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}

}
