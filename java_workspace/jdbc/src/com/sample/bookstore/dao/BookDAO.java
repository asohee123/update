package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sample.bookstore.app.BookstoreApp;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.util.connectionUtil;
import com.sample.bookstore.vo.Book;

/**
 * SAMPLE_BOOKS 테이블에 대한 데이터 엑세스 기능을 지원하는 클래스다.
 * @author JHTA
 *
 */

public class BookDAO {

	/**
	 * 전달받은 책정보를 데이터베이스에 저장한다.
	 * @param book 등록할 책정보를 포함하고 있는 Book 객체
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception {
		
		String sql = "insert into sample_books "
				+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_registered_date) "
				+ "values "
				+ "(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	/**
	 * 지정된 번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책번호
	 * @return 조회된 책정보가 없으면 null이 반환된다.
	 * @throws Exception
	 */
	public Book getBookByNo(int bookNo) throws Exception {
		String sql = "select * "
					+ "from sample_books "
					+ "where book_no = ? ";
		Book book = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bookNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = resultSetToBook(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return book;
	}
	
	/**
	 *  저장된 모든 책을 반환한다.
	 * @return 책정보를 포함하고 있는 List 객체
	 * @throws Exception
	 */
	public List<Book> getAllBooks() throws Exception {
		
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = connectionUtil.getConnection();
		
		String sql = "select * "
				+ "from sample_books "
				+ "order by book_no desc ";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
//			int no = rs.getInt("book_no");
//			String title = rs.getString("book_title");
//			String writer = rs.getString("book_writer");
//			String genre = rs.getString("book_genre");
//			String publisher = rs.getString("book_publisher");
//			int price = rs.getInt("book_price");
//			int discountPrice = rs.getInt("book_discount_price");
//			Date registeredDate = rs.getDate("book_registered_date");
	
//			Book book = new Book();
//			book.setNo(rs.getInt("book_no"));
//			book.setTitle(rs.getString("book_title"));
//			book.setWriter(rs.getString("book_writer"));
//			book.setGenre(rs.getString("book_genre"));
//			book.setPublisher(rs.getString("book_publisher"));
//			book.setPrice(rs.getInt("book_price"));
//			book.setPrice(rs.getInt("book_discount_price"));
//			book.setRegisteredDate(rs.getDate("book_registered_date"));
//			
//			books.add(book);
			
			books.add(resultSetToBook(rs));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
		
	}
	
	/**
	 * 지정된 제목을 포함하고 있는 모든 책 정보를 반환한다.
	 * @param title 검색할 책 제목
	 * @return 조회된 책정보가 없으면 빈 List객체가 반환된다. 절대 null이 나올 수 없다.
	 * @throws Exception
	 */
	public List<Book> getBooksByTitle(String title) throws Exception {
		List<Book> books = new ArrayList<Book>();
		
		String sql = "select * "
					+ "from sample_books "
					+ "where book_title like '%' || ? || '%' "
					+ "order by book_no desc ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, title);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			books.add(resultSetToBook(rs));

		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}
	
	/**
	 * 지정된 장르와 일치하는 모든 책 정보를 반환한다.
	 * @param genre 검색할 책 장르
	 * @return 조회된 책장르가 없으면 빈 List객체가 반환된다. 절대 null이 나올 수 없다.
	 * @throws Exception
	 */
	public List<Book> getBooksByGenre(String genre) throws Exception {
		List<Book> books = new ArrayList<Book>();
		
		String sql = "select * "
					+ "from sample_books "
					+ "where book_genre = ? "
					+ "order by book_no desc ";
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, genre);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			books.add(resultSetToBook(rs));
			
		}		
		rs.close();
		pstmt.close();
		connection.close();
		return books;
	}
	
	/** 
	 * 지정된 가격범위에 해당하는 모든 책 정보를 반환한다.
	 * @param minPrice 최저가격
	 * @param maxPrice 최대가격
	 * @return 조회된 책정보가 없으면 빈 List객체가 반환된다.
	 * @throws Exception
	 */
	public List<Book> getBooksByPriceRange(int minPrice, int maxPrice) throws Exception {		
		List<Book> books = new ArrayList<Book>();
		
		String sql = "select * "
					+ "from sample_books "
					+ "where book_price >= ? and book_price<= ? "
					+ "order by book_no desc ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, minPrice);
		pstmt.setInt(2, maxPrice);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			books.add(resultSetToBook(rs));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}
	
	/**
	 * ResultSet 객체에서 현재 커서가 위치한 행의 정보를 Book객체에 담아서 반환한다.
	 * @param bookNo
	 * @throws Exception
	 */
	public void removeBookByNo(int bookNo) throws Exception {
		
	}
	
	/**
	 * 지정된 책정보에 해당하는 책정보를 변경한다.
	 * @param book 변경할 책정보가 포함된 Book객체
	 * @throws Exception
	 */
	public void updateBook(Book book) throws Exception {
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.updateBook"));	
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getGenre());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.setInt(7, book.getStock());
		pstmt.setInt(8, book.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 *  ResultSet 객체에서 현재 커서가 위치한 행의 정보를 Book객체에 담아서 반환한다.
	 * @param rs ResultSet 객체
	 * @return 책정보가 포함된 Book 객체
	 * @throws SQLException
	 */
	public Book resultSetToBook(ResultSet rs) throws SQLException{
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		book.setTitle(rs.getString("book_title"));
		book.setWriter(rs.getString("book_writer"));
		book.setGenre(rs.getString("book_genre"));
		book.setPublisher(rs.getString("book_publisher"));
		book.setPrice(rs.getInt("book_price"));
		book.setDiscountPrice(rs.getInt("book_discount_price"));
		book.setRegisteredDate(rs.getDate("book_registered_date"));
		book.setStock(rs.getInt("book_stock"));
		
		return book;
	}
}
