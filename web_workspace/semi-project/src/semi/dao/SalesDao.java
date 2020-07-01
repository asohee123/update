package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.CategorySalesDto;
import semi.dto.DaySales;
import semi.dto.ProductSalesDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;

public class SalesDao {

	// 판매량 
	public List<CategorySalesDto> getSalesByCategory() throws SQLException {
		
		List<CategorySalesDto> sales = new ArrayList<CategorySalesDto>();	
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getSalesByCategory"));
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CategorySalesDto sale = new CategorySalesDto();	
			sale.setCategoryNo(rs.getInt(1));
			sale.setSales(rs.getInt(2));
			sale.setCategoryName(rs.getString(3));
			
			sales.add(sale);			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return sales;
	}
	
	// 매출액
	
	public int getTotalSalesByCategoryNo(int categoryNo) throws SQLException {
				
		int totalSales = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalSalesByCategoryNo"));
		pstmt.setInt(1, categoryNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			totalSales = rs.getInt(2);	
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalSales;
		
	}
	
	public int getTotalSales() throws SQLException{
		int result = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalSales"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
			
		}
		
		return result;
	}
	
	public int getTotalUserCount() throws SQLException{
		int result = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalUserCount"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		return result;
	}
	
	public int getTotalStockCount() throws SQLException{
		int result = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalStockCount"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		return result;
	}
	
	public int getTotalProductCount() throws SQLException{
		int result = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalProductCount"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		return result;
	}
	
	
	// 카테고리내 상품 순위	
	public List<ProductSalesDto> getAllProductSalesByCategoryNo(int categoryNo) throws SQLException {
	//sales.getAllProductSalesByCategoryNo
		
		List<ProductSalesDto> sales = new ArrayList<ProductSalesDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getAllProductSalesByCategoryNo"));
		
		pstmt.setInt(1, categoryNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ProductSalesDto sale = new ProductSalesDto();
			sale.setProductNo(rs.getInt(1));
			sale.setTotalSales(rs.getInt(2));
			
			sales.add(sale);			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return sales;
	}
	
	public List<DaySales> getRecentWeekSales() throws SQLException {
		
		//sales.getRecentWeekSales
		List<DaySales> sales = new ArrayList<DaySales>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getRecentWeekSales"));
				
		ResultSet rs = pstmt.executeQuery();
	
		while (rs.next()) {
			DaySales sale = new DaySales();
			sale.setDay(rs.getString(1));
			sale.setDaySales(rs.getInt(2));
			sales.add(sale);
		}		
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return sales;
	}
	
	public int getTodaySales() throws SQLException {
		
		//sales.getTodaySales
		int result = 0;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTodaySales"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return result;
	}
	
	public int getTodayNewUserCount() throws SQLException {
		//sales.getTodayNewUserCount
		int result = -1;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTodayNewUserCount"));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return result;
	}
	
	// 모든 상품 매출 순위
	//sales.getTotalProductSales
	
	public List<ProductSalesDto> getTotalProductSales() throws SQLException {
		
		List<ProductSalesDto> sales = new ArrayList<ProductSalesDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("sales.getTotalProductSales"));
		
		ResultSet rs = pstmt.executeQuery();
				
		while(rs.next()) {
			ProductSalesDto sale = new ProductSalesDto();
			
			sale.setProductNo(rs.getInt(1));
			sale.setTotalSales(rs.getInt(2));			
			sales.add(sale);			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return sales;		
	}
}


































