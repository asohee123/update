package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.PointHistory;

public class PointHistoryDao {

	public void insertHistory(PointHistory history) throws SQLException{
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("pointHistory.insertHistory"));
		
		pstmt.setString(1, history.getUserId());
		pstmt.setString(2, history.getReason());
		pstmt.setInt(3, history.getChange());
		pstmt.setInt(4, history.getOrderNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public int getLastSeqNumOfOrderNo() throws SQLException {
		
		PointHistory pointHistory = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("pointHistory.getLastSeqNumOfOrderNo"));
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			
			pointHistory = new PointHistory();
			
			pointHistory.setOrderNo(rs.getInt("order_no"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return pointHistory.getOrderNo();
	}
	
	public List<PointHistory> getPointHistoryByLoginedId(String userId) throws SQLException {
		
		List<PointHistory> historys = new ArrayList<PointHistory>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("pointHistory.getPointHistoryByLoginedId"));
		pstmt.setString(1, userId);
		ResultSet rs= pstmt.executeQuery();
		
		while (rs.next()) {
			
			PointHistory pointHistory = new PointHistory();
			
			pointHistory.setReason(rs.getString("history_reason"));
			pointHistory.setChange(rs.getInt("history_change"));
			pointHistory.setOrderNo(rs.getInt("order_no"));
			
			historys.add(pointHistory);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return historys;
	}
	
	public int getTotalHistoryPointListByUserId(String userId) throws SQLException {
		
		int totalRows = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("pointHistory.getTotalPointHistoryByLoginedId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		return totalRows;
		
	}
	
	public List<PointHistory> getPointHistoryByLoginedIdWithPaging(String userId, int beginIndex, int endIndex) throws SQLException {
		
		List<PointHistory> historys = new ArrayList<PointHistory>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt  = connection.prepareStatement(QueryUtil.getSQL("pointHistory.getPointHistoryByLoginedIdWithPaging"));
		pstmt.setString(1, userId);
		pstmt.setInt(2, beginIndex);
		pstmt.setInt(3, endIndex);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PointHistory pointHistory = new PointHistory();
			
			pointHistory.setReason(rs.getString("history_reason"));
			pointHistory.setChange(rs.getInt("history_change"));
			pointHistory.setOrderNo(rs.getInt("order_no"));
			
			historys.add(pointHistory);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		
		return historys;
		
	}
	
	public int getPointHistoryByLoginedIdAndOrderNoAndHistoryReason(PointHistory pointHistory) throws SQLException {
		
		PointHistory findPointHistory = new PointHistory();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("pointHistory.getPointHistoryByLoginedIdAndOrderNoAndHistoryReason"));
		pstmt.setString(1, pointHistory.getUserId());
		pstmt.setInt(2, pointHistory.getOrderNo());
		String Y = "적립";
		pstmt.setString(3, Y);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			findPointHistory.setHistoryNo(rs.getInt("history_no"));
			findPointHistory.setUserId(rs.getString("user_id"));
			findPointHistory.setReason(rs.getString("history_reason"));
			findPointHistory.setChange(rs.getInt("history_change"));
			findPointHistory.setHistoryDate(rs.getDate("history_date"));
			findPointHistory.setOrderNo(rs.getInt("order_no"));
		}
		
			rs.close();
			pstmt.close();
			connection.close();
			
			return findPointHistory.getChange();
		
	}
}
