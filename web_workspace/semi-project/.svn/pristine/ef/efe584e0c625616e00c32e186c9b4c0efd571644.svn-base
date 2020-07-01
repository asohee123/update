package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Category;

public class CategoryDao {

	public List<Category> getAllCategorys() throws SQLException {
		
		List<Category> categorys = new ArrayList<Category>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("category.getAllCategorys"));
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {			
			Category category = new Category();
			category.setCategoryNo(rs.getInt("category_no"));
			category.setCategoryName(rs.getString("category_name"));
			
			categorys.add(category);			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return categorys;
	}
	
}
