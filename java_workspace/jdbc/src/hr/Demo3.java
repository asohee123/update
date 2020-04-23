package hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Demo3 {

private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static String nextString() throws Exception {
		return reader.readLine();
	}

	private static int nextInt() throws Exception {
		return Integer.parseInt(reader.readLine());
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("[도서 검색하기]");
		System.out.print("제목을 입력하세요 : ");
		String keyword = nextString();
		
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql = "select * "
					+ "from sample_books "
					+ "where book_title like '%' || ? || '%' "
					+ "order by book_no desc ";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, keyword);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int no = rs.getInt("book_no");
			String title = rs.getString("book_title");
			String writer = rs.getString("book_writer");
			String genre = rs.getString("book_genre");
			String publisher = rs.getString("book_publisher");
			int price = rs.getInt("book_price");
			int discountPrice = rs.getInt("book_discount_price");
			Date registeredDate = rs.getDate("book_registered_date");
			
			System.out.println(no + ", " + title + ", " + writer + ", " + genre + ", " + publisher + ", " + price + "원, " + discountPrice + "원, " + registeredDate);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
	}
}
