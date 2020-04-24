package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class Bookstore {

	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.회원가입 2.검색 3.상세정보 4.주문 5.내주문 6.주문정보 7.종료");
			System.out.println("-------------------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[회원가입]");
				
				System.out.print("아이디를 입력하세요 : ");
				String id = KeyboardUtil.nextString();
				
				System.out.print("비밀번호를 입력하세요 : ");
				String password = KeyboardUtil.nextString();
				
				System.out.print("이름을 입력하세요 : ");
				String name = KeyboardUtil.nextString();
				
				System.out.print("이메일을 입력하세요 : ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				
				boolean risSuccess = service.회원가입(user);
				if(risSuccess) {
					System.out.println("회원가입이 완료되었습니다.");
				} else {
					System.out.println("중복된 아이디가 있습니다.");
				}

			} else if(menuNo == 2){
				System.out.println("[책정보 검색하기]");
				
				System.out.print("키워드를 입력하세요 : ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.도서검색(keyword);
				if(books.isEmpty()) {
					System.out.println("검색결과가 존재하지않습니다.");
				} else {
					System.out.println(books.size() + "권의 책이 조회되었습니다.");
					System.out.println("번호\t제목\t저자\t출판사\t가격");
					System.out.println("-------------------------------------------------------------");
					for(Book book : books) {
						System.out.print(book.getNo() + "\t");
						System.out.print(book.getTitle() + "\t");
						System.out.print(book.getWriter() + "\t");
						System.out.print(book.getPublisher() + "\t");
						System.out.println(book.getPrice());
					}
					System.out.println("-------------------------------------------------------------");
				}
				
			} else if(menuNo == 3){
				System.out.println("[책정보 상세보기]");
				System.out.print("조회할 책번호를 입력하세요 : ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.도서상세정보(bookNo);
				
				if(book == null) {
					System.out.println("조회한 책정보가 없습니다.");
				} else {
					System.out.println("-------------------------------------------------------------");
					System.out.println("번호 : " + book.getNo());
					System.out.println("제목 : " + book.getTitle());
					System.out.println("저자 : " + book.getWriter());
					System.out.println("장르 : " + book.getGenre());
					System.out.println("출판사 : " + book.getPublisher());
					System.out.println("가격 :  " + book.getPrice());
					System.out.println("할인가격 : " + book.getDiscountPrice());
					System.out.println("재고 : " + book.getStock());
					System.out.println("등록일 : " + book.getRegisteredDate());
					System.out.println("-------------------------------------------------------------");
				}
			} else if(menuNo == 4){
				System.out.println("[책 주문]");
				
				System.out.print("주문할 책 번호를 입력하세요 : ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("주문수량을 입력하세요 : ");
				int amount = KeyboardUtil.nextInt();
				System.out.print("주문자 아이디를 입력하세요 : ");
				String userId = KeyboardUtil.nextString();
				
				boolean isSuccess = service.주문하기(bookNo, amount, userId);
				if(isSuccess) {
					System.out.println("주문이 완료되었습니다.");
				} else {
					System.out.println("주문이 실패하였습니다.");
				}
			} else if(menuNo == 5){
				System.out.println("[내 주문 보기]");
			} else if(menuNo == 6){
				System.out.println("[주문 정보]");
			} else if(menuNo == 7){
				KeyboardUtil.close();
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
	}
}
