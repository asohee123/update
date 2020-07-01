package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.BucketDto;
import semi.dto.ProductDto;
import semi.dto.ProductImgDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Product;
import semi.vo.Tag;

public class ProductDao {
		
	public List<ProductDto> getAllProducts(int categoryNo, int begin, int end) throws SQLException {
		List<ProductDto> products = new ArrayList<ProductDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt;
		if(categoryNo == 0) {
			pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getAllProducts"));
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
		} else {
			pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getAllProductsByCategory"));
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
		}

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductDto product = new ProductDto();
			product.setImg(rs.getString(1));
			product.setpName(rs.getString(2));
			product.setPrice(rs.getInt(3));
			product.setDiscountPrice(rs.getInt(4));
			product.setDescription(rs.getString(5));
			product.setCategory(rs.getInt(6));
			product.setProductNo(rs.getInt(7));
			
			products.add(product);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}

	public ProductImgDto getProductByNo(int productNo) throws SQLException {
		
		ProductImgDto product = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getProductByNo"));
		pstmt.setInt(1, productNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			product = new ProductImgDto();
			product.setProductNo(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setPrice(rs.getInt(3));
			product.setDiscountPrice(rs.getInt(4));
			product.setPoint(rs.getInt(5));
			product.setDescription(rs.getString(6));
			product.setCategoryNo(rs.getInt(7));
			product.setImg(rs.getString(8));			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return product;
		
	}
	
	public int getTotalRows(int categoryNo) throws SQLException {
		int totalRows = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt;
		if(categoryNo == 0) 
			pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getTotalRows"));
		else {
			pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getTotalRowsByCategory"));
			pstmt.setInt(1, categoryNo);
		}
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		return totalRows;
	}
	
	public List<ProductDto> getSearchProduct(int categoryNo, String searchPname, int minMoney, int maxMoney, int orderBy, int begin, int end) throws SQLException {
		
			List<ProductDto> searchProducts = new ArrayList<ProductDto>();
			
			boolean category = false;
			boolean pName = false;
			boolean money = false;
			boolean sort = false;
			
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt;
			
			String sql = null;
			
			if(categoryNo == 0 && "".equals(searchPname) && minMoney == 0 && maxMoney == 0 && orderBy == 0) {
				
				sql = "SELECT product_img, product_name, product_price, product_discount_price, product_description, category_no, product_no, rn "
						+ "from (select c.product_img, b.product_name, b.product_price, b.product_discount_price, b.product_description, a.category_no, b.product_no, "
						+ "row_number() over(order by b.product_no desc) rn "
						+ "from semi_category a, semi_product b, semi_product_image c "
						+ "where a.category_no = b.category_no "
						+ "and b.product_no = c.product_no) "
						+ "where rn >= ? and rn <= ? ";
			} else {
			
				sql = "SELECT product_img, product_name, product_price, product_discount_price, product_description, category_no, product_no, rn "
						+ "from (select c.product_img, b.product_name, b.product_price, b.product_discount_price, b.product_description, a.category_no, b.product_no ";
				
				if(orderBy == 1) {
					sort = true;
					sql += ", row_number() over(order by b.product_no desc) rn ";
							
					
				} else if(orderBy == 2) {
					sort = true;
					sql += ", row_number() over(order by b.product_name asc) rn ";
					
				} else if(orderBy == 3) {
					sort = true;
					sql += ", row_number() over(order by b.product_discount_price asc) rn ";
					
				} else if(orderBy == 4) {
					sort = true;
					sql += ", row_number() over(order by b.product_discount_price desc) rn ";
					
				}
				if(!sort) {
					sql += ", row_number() over(order by b.product_no desc) rn ";
				}
				
				sql += "from semi_category a, semi_product b, semi_product_image c "
						+ "where a.category_no = b.category_no "
						+ "and b.product_no = c.product_no ";
				
				 if(categoryNo != 0) {
					 sql += "and a.category_no = ? ";
					 category = true;
				 }
					 
				 if(!"".equals(searchPname)) {
					 
					 sql += "and b.product_name like ? ";
					 pName = true;
	
				 }
				 
				 if(minMoney != 0 && maxMoney != 0) {
					 
					 sql += "and b.product_discount_price BETWEEN ? and ?";
					 money = true;	
					 
				 }	
				 
				 sql += ") where rn >= ? and rn <= ? ";
			}
			
			int count = 1;
			pstmt= connection.prepareStatement(sql);
			
			
			if(category) {

				pstmt.setInt(count, categoryNo);		
				++count;
			}
			
			if(pName) {

				String sName = "";
				sName += "%";
				sName += searchPname;
				sName += "%";
				pstmt.setString(count, sName);
				++count;
			}
			
			if(money) {
				pstmt.setInt(count, minMoney);
				++count;
				pstmt.setInt(count, maxMoney);
				++count;
			}
			
		
			pstmt.setInt(count, begin);
			++count;
			pstmt.setInt(count, end);

			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				ProductDto productDto = new ProductDto();
				
				productDto.setImg(rs.getString("product_img"));
				productDto.setpName(rs.getString("product_name"));
				productDto.setPrice(rs.getInt("product_price"));
				productDto.setDiscountPrice(rs.getInt("product_discount_price"));
				productDto.setDescription(rs.getString("product_description"));
				productDto.setCategory(rs.getInt("category_no"));
				productDto.setProductNo(rs.getInt("product_no"));
				
				searchProducts.add(productDto);
			}
			
			rs.close();
			pstmt.close();
			connection.close();
			
			return searchProducts;
	}
	
	public int getSearchRows(int categoryNo, String searchPname, int minMoney, int maxMoney, int orderBy) throws SQLException {
		
		int totalRows = 0;
		int count = 1;
		
		boolean category = false;
		boolean pName = false;
		boolean money = false;
	
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt;
		
		String sql = null;
		
		if(categoryNo == 0 && "".equals(searchPname) && minMoney == 0 && maxMoney == 0 && orderBy == 0) {
			sql = "select count(*) cnt "
					+ "from semi_category a, semi_product b "
					+ "where b.category_no = a.category_no ";
				
		} else {
			sql = "select count(*) cnt " 
					+ "from semi_category a, semi_product b " 
					+ "where b.category_no = a.category_no ";
			
			if(categoryNo != 0) {
				sql += "and a.category_no = ? ";
				category = true;
			}
			
			if(!"".equals(searchPname)) {
				sql += "and b.product_name like ? ";
				pName = true;
			}
			
			if(minMoney != 0 && maxMoney != 0) {
				sql += "and b.product_discount_price BETWEEN ? and ?  ";
				money = true;
			}
			
			if(orderBy == 1) {
				sql += "order by b.product_no desc ";
				
			} else if(orderBy == 2) {
				sql += "order by b.product_name asc ";
				
			} else if(orderBy == 3) {
				sql += "order by b.product_discount_price asc ";
				
			} else if(orderBy == 4) {
				sql += "order by b.product_discount_price desc ";
				
			}
			
		}
		
		pstmt = connection.prepareStatement(sql);
		
		
		if(category) {

			pstmt.setInt(count, categoryNo);		
			++count;
			
		}
		if(pName) {
			
			String sName = "";
			sName += "%";
			sName += searchPname;
			sName += "%";
			pstmt.setString(count, sName);
			++count;
			
		}
		
		if(money) {
			pstmt.setInt(count, minMoney);		
			++count;
			pstmt.setInt(count, maxMoney);
		}
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalRows;
		
	}
	
	/***
	 * �대�� 移댄��怨�由ъ�� 理�洹� ��怨��� ����踰��� ���� 3媛� 諛��� 
	 * ���� 媛��� �������ㅻ㈃ product.getNewProductNos�� rownum ������怨� ������ newProductNos �ш린�� ����
	 * @param categoryNo
	 * @return
	 * @throws SQLException
	 */
	public int[] getNewProductNos(int categoryNo) throws SQLException {
		
		// 移댄��怨�由щ�濡� ������ 3媛���
		int[] newProductNos = new int[3];
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getNewProductNos"));
		
		pstmt.setInt(1, categoryNo);		
		ResultSet rs = pstmt.executeQuery();
		
		int i = 0;
		while (rs.next()) {			
			newProductNos[i] = rs.getInt(1);
			i++;			
		}
		
		rs.close();
		pstmt.close();
		connection.close();		
		
		return newProductNos;
		
	}
	
	public void insertProduct(Product product) throws SQLException { 
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.insertProduct"));
		pstmt.setString(1, product.getProductName());
		pstmt.setInt(2, product.getPrice());
		pstmt.setInt(3, product.getDiscountPrice());
		pstmt.setInt(4, product.getPoint());
		pstmt.setString(5, product.getDescription());
		pstmt.setInt(6, product.getCategoryNo());
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public void insertImage(String productImg, int productNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.insertImage"));
		pstmt.setInt(1, productNo);
		pstmt.setString(2, productImg);
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}

	public List<String> getTagsByProductNo(int productNo) throws SQLException {
		
		List<String> tags = new ArrayList<String>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getTagsByProductNo"));
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {			
			tags.add(rs.getString("tag_name"));		
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return tags;
	}
	
	public int getLastProductNo() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getLastProductNo"));
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int productNo = rs.getInt(1);
		
		return productNo;
	}
	
	public List<ProductImgDto> getproductFormOfArray(int[] productNosNum) throws SQLException {
		
		List<ProductImgDto> productImgDtos = new ArrayList<ProductImgDto>();
		
		for (int i=0; i<productNosNum.length; i++) {
			ProductImgDto productImgDto = new ProductImgDto();
			
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getProductByNo"));
			pstmt.setInt(1, productNosNum[i]);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				productImgDto.setProductNo(rs.getInt("product_no"));
				productImgDto.setProductName(rs.getString("product_name"));
				productImgDto.setPrice(rs.getInt("product_price"));
				productImgDto.setDiscountPrice(rs.getInt("product_discount_price"));
				productImgDto.setPoint(rs.getInt("product_point"));
				productImgDto.setDescription(rs.getString("product_description"));
				productImgDto.setCategoryNo(rs.getInt("category_no"));
				productImgDto.setImg(rs.getString("product_img"));
				
				productImgDtos.add(productImgDto);
			}
			rs.close();
			pstmt.close();
			connection.close();
		}
		
		return productImgDtos;
	}	
	
	
	public int[] getHotProductNos() throws SQLException {
				
		int[] hotProductNos = new int[5];
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getHotProductNos"));
				
		ResultSet rs = pstmt.executeQuery();
		
		int i = 0;
		while (rs.next()) {			
			hotProductNos[i] = rs.getInt(1);
			i++;			
		}
		
		rs.close();
		pstmt.close();
		connection.close();		
		
		return hotProductNos;
		
	}
	
	
	public void updateProduct(Product product, int productNo) throws SQLException { 
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.updateProduct"));
		pstmt.setString(1, product.getProductName());
		pstmt.setInt(2, product.getPrice());
		pstmt.setInt(3, product.getDiscountPrice());
		pstmt.setString(4, product.getDescription());
		pstmt.setInt(5, productNo);
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public List<ProductDto> getRadProducts() throws SQLException {
		List<ProductDto> products = new ArrayList<ProductDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getRadProducts"));
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductDto product = new ProductDto();
			product.setImg(rs.getString(1));
			product.setpName(rs.getString(2));
			product.setPrice(rs.getInt(3));
			product.setDiscountPrice(rs.getInt(4));
			product.setDescription(rs.getString(5));
			product.setCategory(rs.getInt(6));
			product.setProductNo(rs.getInt(7));
			
			products.add(product);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	public void insertRecentView(int productNo, String userId) throws SQLException {
		if("비회원".equals(userId))
			return;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.insertRecentView"));
		System.out.println("userId : " + userId);
		pstmt.setInt(1, productNo);
		pstmt.setString(2, userId);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Integer> getRecentView(String userId) throws SQLException {
		List<Integer> views = new ArrayList<Integer>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getRecentView"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			views.add(rs.getInt(1));
		}
		
		return views;
	}
	
	public int getLastView() throws SQLException {
		int last = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.getLastView"));
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			last = rs.getInt(1);
		
		
		return last;
	}
	
	public void deleteRecentView(String userId) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.deleteRecentView"));
		pstmt.setString(1, userId);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
		return;
	}
	
	public void deleteImg(int productNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.deleteImg"));
		pstmt.setInt(1, productNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void deleteProduct(int productNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("product.deleteProduct"));
		pstmt.setInt(1, productNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}


























