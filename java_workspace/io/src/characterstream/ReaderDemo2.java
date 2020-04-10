package characterstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.READER;

public class ReaderDemo2 {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		//	data.txt의 도서 정보 읽어서 Book객체에 담고, ArrayList에 Book객체 저장하기.
		List<Book> books = new ArrayList<Book>();
		
		FileInputStream fis = new FileInputStream("c:/files/데이터.txt");
		InputStreamReader isr = new InputStreamReader(fis, "ms949");
		BufferedReader br = new BufferedReader(isr);
		
		String text = null;
		while((text=br.readLine()) != null) {
			if(!text.isEmpty()) {
				String[] items = text.split(",");
				
				int no = Integer.parseInt(items[0]);
				String title = items[1];
				String writer = items[2];
				String publiser = items[3];
				int price = Integer.parseInt(items[4]);
				
				Book book = new Book();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setPubliser(publiser);
				book.setPrice(price);
				
				books.add(book);
				
			}
		}
		while(true) {
			System.out.println("===========================");
			System.out.println("1.도서내역 2.상세조회 3.종료");
			System.out.println("===========================");
			
			System.out.print("메뉴 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				
				System.out.println("[도서 목록]");
				System.out.printf("%-3s %-20s %-15s %-7s\n", "번호", "제목", "저자", "가격");
				for(Book book : books) {
				
					int no = book.getNo();
					String title = book.getTitle();
					String writer = book.getWriter();
					int price = book.getPrice();
					
					System.out.printf("%-3d %-20s %-15s %-7d\n", no, title, writer, price);
				}
				
			} else if(menuNo == 2) {
				
				System.out.println("[도서정보 보기]");
				System.out.print("책번호를 입력하세요 : ");
				int bookNo = scanner.nextInt();

				for(Book book : books) {
				
					if(book.getNo() == bookNo) {
					
						System.out.println("번호 : " + book.getNo());
						System.out.println("제목 : " + book.getTitle());
						System.out.println("저자 : " + book.getWriter());
						System.out.println("출판사 : " + book.getPubliser());
						System.out.println("가격 : " + book.getPrice());
						
					}
				}
				
 			} else if(menuNo == 3) {
				
				System.out.println("시스템을 종료합니다.");
				break;
			
			}
		}
		
		scanner.close();
		br.close();
	}
}
