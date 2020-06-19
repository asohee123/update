package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Item;

public class ItemDao {
	
	public Item getItemBySizeAndColor(int productNo, String color, String size) throws SQLException {
		
		Item item = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("item.getItemBySizeAndColor"));
		pstmt.setInt(1, productNo);
		pstmt.setString(2, color);
		pstmt.setString(3, size);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			item = new Item();
			item.setNo(rs.getInt(1));
			item.setProductNo(rs.getInt(2));
			item.setSize(rs.getString(3));
			item.setColor(rs.getString(4));
			item.setStock(rs.getInt(5));
		}
		
		rs.close();
		pstmt.close();
		connection.close();		
		return item;		
	}
	
	public Item getItemByNo(int itemNo) throws SQLException {
		
		Item item = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("item.getItemByNo"));
		pstmt.setInt(1, itemNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			item = new Item();
			item.setNo(rs.getInt(1));
			item.setProductNo(rs.getInt(2));
			item.setSize(rs.getString(3));
			item.setColor(rs.getString(4));
			item.setStock(rs.getInt(5));
		}
		
		rs.close();
		pstmt.close();
		connection.close();		
		return item;		
	}
	
	
	
	public void updateStock(Item item) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("item.updateStock"));
		pstmt.setInt(1, item.getStock());
		pstmt.setInt(2, item.getNo());
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public void insertStock(int[] stock, int productNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt1 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock1"));
		PreparedStatement pstmt2 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock2"));
		PreparedStatement pstmt3 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock3"));
		PreparedStatement pstmt4 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock4"));
		PreparedStatement pstmt5 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock5"));
		PreparedStatement pstmt6 = connection.prepareStatement(QueryUtil.getSQL("item.insertStock6"));
		
		pstmt1.setInt(1, productNo);
		pstmt1.setInt(2, stock[0]);
		
		pstmt2.setInt(1, productNo);
		pstmt2.setInt(2, stock[1]);
		
		pstmt3.setInt(1, productNo);
		pstmt3.setInt(2, stock[2]);
		
		pstmt4.setInt(1, productNo);
		pstmt4.setInt(2, stock[3]);
		
		pstmt5.setInt(1, productNo);
		pstmt5.setInt(2, stock[4]);
		
		pstmt6.setInt(1, productNo);
		pstmt6.setInt(2, stock[5]);
		
		pstmt1.executeUpdate();
		pstmt2.executeUpdate();
		pstmt3.executeUpdate();
		pstmt4.executeUpdate();
		pstmt5.executeUpdate();
		pstmt6.executeUpdate();
		
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		pstmt4.close();
		pstmt5.close();
		pstmt6.close();
		
		connection.close();
	}
}
