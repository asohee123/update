package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import semi.util.ConnectionUtil;
import semi.util.QueryUtil;

public class TagDao {
	public void insertTag(List<String> tags, int productNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		for(String tag : tags) {
			if(tag != null) {
				PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("tag.insertTag"));
				pstmt.setString(1, tag);
				pstmt.setInt(2, productNo);
				pstmt.executeUpdate();
				
				pstmt.close();
			}
		}
		
		connection.close();
	}
	
	public void deleteTag(int productNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("tag.deleteTag"));
		pstmt.setInt(1, productNo);
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
}
