package hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo2 {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static String nextString() throws Exception {
		return reader.readLine();
	}

	private static int nextInt() throws Exception {
		return Integer.parseInt(reader.readLine());
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("책 등록하기");
		
		System.out.print("제목을 입력하세요 : ");
		String title = nextString();
		
		System.out.print("저자를 입력하세요 : ");
		String writer = nextString();
		
		System.out.print("장르를 입력하세요 : ");
		String genre = nextString();
		
		System.out.print("출판사를 입력하세요 : ");
		String publisher = nextString();
		
		System.out.print("가격을 입력하세요 : ");
		int price = nextInt();
		
		System.out.print("할인가격을 입력하세요 : ");
		int discountPrice = nextInt();
		
		// jdbc Driver 로딩
		Class.forName("oracle.jdbc.OracleDriver");
		
		// Connection 객체 획득
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// PreparedStatement -> 객체획득
		String sql = "insert into sample_books "
					+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_registered_date)"
					+ "values"
					+ "(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, genre);
		pstmt.setString(4, publisher);
		pstmt.setInt(5, price);
		pstmt.setInt(6, discountPrice);
		
		int count = pstmt.executeUpdate();
		System.out.println("["+count+"]개의 책이 등록되었습니다.");
		
		pstmt.close();
		connection.close();

		
	}
}
