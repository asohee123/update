package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookStoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookstoreApp {

	public static void main(String[] args) {
		
		BookStoreService service = new BookStoreService();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("--------------도서 프로그램--------------");
			System.out.println("1.회원관리 2.도서관리 3.대여관리 4.종료");
			System.out.println("---------------------------------------");
			System.out.print("메뉴를 선택하세요. : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println();
				System.out.println("--------------회원관리--------------");
				System.out.println("1.등록 2.조회 3.변경 4.대여조회 5.전체조회 6.탈퇴");
				System.out.println("-----------------------------------");
				
				System.out.print("회원관리 메뉴를 선택하세요. : ");
				int userMenuNo = scanner.nextInt();
				
				if(userMenuNo == 1) {
					System.out.println("[회원 등록]");
					
					System.out.print("이름을 입력하세요 : ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요 : ");
					String tel = scanner.next();
					
					service.addNewUser(name, tel);   // -> BookStoreService 상속, 
					System.out.println("### 회원등록이 완료되었습니다.");
					
					
				} else if(userMenuNo == 2) {
				
					System.out.println("[회원 조회]");
					
					System.out.print("회원번호 입력하세요 : ");
					int userNo = scanner.nextInt();
					
					service.retrieveUserInfo(userNo);
					System.out.println("### 회원조회가 완료되었습니다.");
				
				
				} else if(userMenuNo == 3) {
					
					System.out.println("[회원정보 수정]");
					
					System.out.print("회원번호을 입력하세요 : ");
					int no = scanner.nextInt();
					System.out.print("이름을 입력하세요 : ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요 : ");
					String tel = scanner.next();
					
					User user = new User(no, name, tel, 100, false);
					service.modifyUserInfo(user);
					System.out.println("### 정보수정이 완료되었습니다.");
				
				
				} else if (userMenuNo == 4) {
					
					System.out.println("[나의 대여정보]");
					
					System.out.print("이름을 입력하세요 :");
					String name = scanner.next();
					
					System.out.println("### 대여정보확인 완료되었습니다.");
				} else if(userMenuNo == 5) {
					
					User user = new User();
					
					System.out.println("[전체 정보조회]");
					
				
					service.retrieveAllUsers();
					System.out.println("### 전체 정보조회를 완료되었습니다.");
					
				} else if(userMenuNo == 6) {
					
					System.out.println("[회원정보 탈퇴]");
					
					System.out.print("회원번호를 입력하세요 : ");
					int no = scanner.nextInt();
					
					
					
					service.disabledUser(no);
					System.out.println("### 회원탈퇴가 완료되었습니다.");
				}
				
				
			} else if (menuNo == 2) {
				
				System.out.println();
				System.out.println("--------------도서관리--------------");
				System.out.println("1.검색 2.등록 3.수정");
				System.out.println("-----------------------------------");
				
				System.out.print("도서관리 메뉴를 선택하세요. : ");
				int bookMenuNo = scanner.nextInt();
				
				if(bookMenuNo == 1) {
					System.out.println("[도서정보 검색]");
					
					System.out.print("책 제목을 입력하세요 : ");
					String title = scanner.next();
				
					service.searchBooks(title);
					
				
				} else if(bookMenuNo == 2) {
					
					System.out.println("[도서정보 수정]");
					
					System.out.print("책 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("저자 를 입력하세요 : ");
					String wirter = scanner.next();
					System.out.print("가격 를 입력하세요 : ");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, wirter, price);
					
				
				} else if(bookMenuNo == 3) {
					
					System.out.println("[도서정보 수정]");
					
					System.out.print("책 번호을 입력하세요 : ");
					int no = scanner.nextInt();
					System.out.print("책 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("저자 를 입력하세요 : ");
					String wirter = scanner.next();
					System.out.print("가격 를 입력하세요 : ");
					int price = scanner.nextInt();
					
					Book book = new Book(no, title, wirter, price, 0);
					service.modifyBook(book);
					
				}
				
				
				
			} else if (menuNo == 3) {
				
				System.out.println();
				System.out.println("--------------대여관리--------------");
				System.out.println("1.대여 2.반납 3.대여현황조회");
				System.out.println("-----------------------------------");
				
				System.out.print("메뉴를 선탹하세요 : ");
				int userNameNo = scanner.nextInt();
				
				if(userNameNo == 1) {
					
					System.out.println("대여");
					
					System.out.print("사용자번호 를 입력하세요 : ");
					int userNo = scanner.nextInt();
					System.out.print("책번호 를 입력하세요 : ");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					
				} else if(userNameNo == 2) {
					
					System.out.println("반납메뉴입니다. ");
					
					System.out.print("대여번호를 입력하세요. : ");
					int rentalNo = scanner.nextInt();
					
					service.returnBook(rentalNo);
					
				} else if(userNameNo == 3) {
					
					
					
				}
				
				
			} else if (menuNo == 4) {
			
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
