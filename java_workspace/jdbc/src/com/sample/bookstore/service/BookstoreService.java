package com.sample.bookstore.service; //업무로직 담당


import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;
/**
 * 회원가입, 책검색, 책 상세정보 조회, 주문하기, 내 주문조회, 주문 상세정보보기 등의 
 * 기능을 제공하는 객체다.
 * @author JHTA
 *
 */
public class BookstoreService {

	private UserDAO userDao = new UserDAO();
	private OrderDAO orderDao = new OrderDAO();
	private BookDAO bookDao = new BookDAO();
	
	/**
	 * 신규 사용자 정보를 등록한다.
	 * @param user 신규 사용자 정보
	 * @return 회원가입이 성공하면 true를 반환한다.
	 * @throws Exception
	 */
	public boolean 회원가입(User user) throws Exception {
		
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			return false;
		}
		// 비밀번호 암호화하기
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		userDao.addUser(user);
		return true;
		
	}
	
	/**
	 * 지정된 키워드가 제목에 포함된 책정보를 반환한다.
	 * @param title 검색 키워드
	 * @return 검색된 책들
	 * @throws Exception 
	 */
	public List<Book> 도서검색(String title) throws Exception {
		return bookDao.getBooksByTitle(title);
	}
	
	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책번호
	 * @return 책정보 유효한 번호가 아닌 경우 null이 반환된다.
	 * @throws Exception 
	 */
	public Book 도서상세정보(int bookNo) throws Exception {
		return bookDao.getBookByNo(bookNo);
	}
	/**
	 * 주문요청을 처리합니다
	 * @param userId 주문자 아이디
	 * @param bookNo 주문할 책번호
	 * @param amount 주문 수량
	 * @return 
	 * @return 주문 성공시 true를 반환한다.
	 * @throws Exception 
	 */
	public boolean 주문하기(int bookNo, int amount, String userId) throws Exception {
		User user = userDao.getUserById(userId);
		if(user == null) {
			return false;
		}
		Book book = bookDao.getBookByNo(bookNo);
		if(book == null) {
			return false;
		}
		
		if(book.getStock() < amount) {	// 재고가 부족함
			return false;
		}
		
		Order order = new Order();
		order.setUser(user);
		order.setBook(book);
		order.setAmount(amount);
		order.setPrice(book.getDiscountPrice());
		
		// 주문정보 저장
		orderDao.addOrder(order);

		book.setStock(book.getStock()- amount); //조회된 책 재고에서 주문수량 만큼 뺀다.
		bookDao.updateBook(book); // 빼고 남은 수량을 넣는다.
		
		// 사용자 포인트 변경
		int depositPoint = (int)(book.getDiscountPrice()*0.03);
		user.setPoint(user.getPoint()+depositPoint);
		userDao.updateUser(user);
		
		return true;
	}
	
	/**
	 * 지정된 사용자아이디의 모든 주문내역을 반환한다.
	 * @param userId	주문내역을 조회할 사용자 아이디
	 * @return			주문내역, 주문내역이 없는 경우 empty List가 반환된다.
	 * @throws Exception 
	 */
	public List<Order> 내주문조회(String userId) throws Exception{
		
		return orderDao.getUserById(userId);
	
	}
	
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다.
	 * @param orderNo	orderNo 주문정보를 조회할 주문번호
	 * @return			주문정보 상세내역, 주문번호가 틀린 경우 null이 반한된다.
	 * @throws Exception 
	 */
	public Order 주문상세정보(int orderNo) throws Exception {
		
		
		return orderDao.getOrderByNo(orderNo);
	}

	boolean 문의등록(Question question){
		
		return true;
	}
	
	List<Question> 문의글전체조회(){
		
		return null;
	}
	
	Question 문의글조회(int questionNo){
		
		return null;
	}
	
	void 문의글삭제(int questionNo, String userId){
		
		
	}
	
}
