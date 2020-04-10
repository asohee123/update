package com.sample.bookstore.service;

import java.security.Provider.Service;

import javax.swing.text.Position;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookStoreService {
	
	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// 회원등록 서비스
	// 이름, 전화번호를 전달받아서 회원등록 서비스를 제공한다.
	// 		- User객체를 생성해서 이름과 전화번호를 저장한다.
	//		- 회원등록시 100포인트를 지급한다.
	//		- UserService의 회원등록 기능을 실행한다.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
	
	// 회원조회 서비스
	// 회원번호를 전달받아서 회원번호에 대한 회원정보를 화면에 출력한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.
	public void retrieveUserInfo(int userNo) {
		
		User user = userService.findUserByNo(userNo);
		
		
		
		System.out.println("회원번호 : " + user.no);
		System.out.println("회원이름 : " + user.name);
		System.out.println("전화번호 : " + user.tel);
		System.out.println("포 인 트 : " + user.point);
		System.out.println("탈퇴여부 : " + user.isDisabled);
		
	}
	
	// 회원수정 서비스
	// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
	//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		User savedUser = userService.findUserByNo(user.no);
		userService.updateUser(user);
		
		savedUser.name = user.name;
		savedUser.tel = user.tel;
		
	}
	
	// 회원탈퇴 서비스
	// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
	//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User user = userService.findUserByNo(userNo);
		user.isDisabled = true;
		

	}
	
	// 전체 회원조회 서비스
	// 등록된 모든 회원정보 조회를 처리한다.
	// 		- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.(null체크)
	public void retrieveAllUsers() {
		User[] users = userService.getAllUsers();
		if(users.length == 0) {
			System.out.println("정보가 없습니다.");
			return;
		}
		

		System.out.println("회원번호\t회원이름\t전화번호\t\t포인트\t탈퇴여부");
		System.out.println("=======================================================");
		for(User user : users) {
			System.out.print(user.no + "\t");
			System.out.print(user.name + "\t");
			System.out.print(user.tel + "\t");
			System.out.print(user.point + "\t");
			System.out.println(user.isDisabled + "\t");
			
		}
		System.out.println("=======================================================");
		
	}
	
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	//		- Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	//		- 재고는 10000권으로 한다.
	// 		- BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String wirter, int price) {
		Book book = new Book();
		
		book.title = title;
		book.wirter = wirter;
		book.price = price;
		
		
		bookService.insertBook(book);
	}
	
	// 도서 검색 서비스
	// 제목를 전달받아서 도서 검색서비스를 처리한다.
	//		- BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
	//		- 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		Book[] book = bookService.findBookByTitle(title);
		
			for(int i=1; i < book.length; i++) {
				System.out.println("책 번호 : " + book[i].no);
				System.out.println("책 이름 : " + book[i].title);
				System.out.println("저 자 : " + book[i].wirter);
				System.out.println("가 격 : " + book[i].price);
				System.out.println("제고량 : " + book[i].stock);
			}
	}
	
	// 도서 정보 수정 서비스
	// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
	//		- BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}
	
	// 대여 서비스
	// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
	//		- Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
	//		- 대여여부는 대여중으로 설정한다.
	//		- 책재고 변경하기
	//			- BookService에서 책번호에 해당하는 책정보 조회기능 실행
	//			- 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		
		Rental rental = new Rental();
		
		Book book = bookService.findBookByNo(bookNo);
		User user = userService.findUserByNo(userNo);
		
		if(user != null && book != null) {
			rental.bookNo = bookNo;
			rental.userNo = userNo;
			rental.isRent = true;
			book.stock--;
			
			System.out.println("대여하셨습니다.");
			
		} else if(user == null){
			System.out.println("사용자번호를 잘못입력했습니다.");
			
		} else if(book == null) {
			System.out.println("책 번호를 잘못입력했습니다.");
		}
	}
	
	// 반납 서비스
	// 대여번호를 전달받아서 반납 서비스를 처리한다.
	//		- RentalService에서 대여번호에 해당하는 대여정보 조회 기능을 실행
	//		- 조회된 대여정보의 반납여부를 false로 설정한다.
	//		- 사용자포인트 증가, 책재고 변경하기
	//			- UserService에서 사용자번호로 사용자정보 조회하기 실행
	//			- BookService에서 책번호로 책정보 조회하기 실행
	//			- 조회된 사용자의 포인트를 책가격의 1%만큼 증가시키기
	//			- 조회된 책정보의 재고를 1증가시키기
	public void returnBook(int rentalNo) {
		Rental rental = rentalService.findRentalByNo(rentalNo);
		
		Book book = bookService.findBookByNo(rental.bookNo);
		User user = userService.findUserByNo(rental.no);
		if(rental != null) {
			int price = (int)(book.price * 0.01);
			user.point += price;
			book.stock++;
			rental.isRent = false;
			
		} 
	}

	
	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	//		- RentalService의 전체 대여정보조회 기능을 실행한다.
	//		- 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		Rental[] rental = rentalService.getAllRentals();
		
		
	}
}
