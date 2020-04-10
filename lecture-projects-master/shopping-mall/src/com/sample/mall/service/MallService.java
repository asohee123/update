package com.sample.mall.service;

import com.sample.mall.repository.OrderRepository;
import com.sample.mall.repository.ProductRepository;
import com.sample.mall.repository.UserRepository;
import com.sample.mall.vo.Item;
import com.sample.mall.vo.Order;
import com.sample.mall.vo.Product;
import com.sample.mall.vo.User;

public class MallService {

	private OrderRepository orderRepo = new OrderRepository();
	private ProductRepository productRepo = new ProductRepository();
	private UserRepository userRepo = new UserRepository();
	
	/**
	 * 모든 상품정보를 화면에 표시한다.<br/>
	 * 출력내용 :: 상품번호, 상품명, 가격, 할인가격 정보를 표시한다.
	 */
	public void displayAllProducts() {
		Product[] products = productRepo.getAllProducts();
		
		System.out.println("=================================================================================");
		for (Product product : products) {
			System.out.println("상품번호: " + product.getNo());
			System.out.println("상품이름: " + product.getName());
			System.out.println("상품가격: " + product.getPrice());
			System.out.println("할인가격: " + product.getDiscountPrice());
			System.out.println("상품재고: " + product.getStock());
			System.out.println("판매지수: " + product.getScore());
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * 상품번호를 전달받아서 그 상품번호에 해당하는 상품의 상세정보를 화면에 표시한다.<br/>
	 * 출력내용 :: 상품번호, 상품명, 가격, 할인가격, 재고, 판매지수 정보를 표시한다.
	 * 
	 * @param productNo 상세정보를 조회할 상품번호
	 */
	public void displayProductDetail(int productNo) {
		Product product = productRepo.getProductByNo(productNo);
		if (product == null) {
			System.out.println("!! 상품정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("=================================================================================");
		System.out.println("상품번호: " + product.getNo());
		System.out.println("상품이름: " + product.getName());
		System.out.println("상품가격: " + product.getPrice());
		System.out.println("할인가격: " + product.getDiscountPrice());
		System.out.println("상품재고: " + product.getStock());
		System.out.println("판매지수: " + product.getScore());
		System.out.println("=================================================================================");
	}
	
	/**
	 * 사용자 아이디와 상품번호를 전달받아서 해당 사용자의 장바구니에 상품정보를 저장한다.<br/>
	 * 사용자의 장바구니에 동일한 상품이 존재하는 경우는 장바구니에 추가되지 않는다.<br/>
	 * 상품의 재고가 0개인 경우는 장바구니에 추가되지 않는다.
	 * 
	 * @param userId 사용자 아이디
	 * @param productNo 장바구니에 추가할 상품번호
	 */
	public void addCartItem(String userId, int productNo) {
		User user = userRepo.getUserById(userId);
		if (user == null) {
			System.out.println("!! 사용자 정보가 존재하지 않습니다.");
			return;
		}
		Product product = productRepo.getProductByNo(productNo);
		if (product == null) {
			System.out.println("!! 상품정보가 존재하지 않습니다.");
			return;
		}
		if (product.getStock() == 0) {
			System.out.println("!! 재고가 없습니다.");
			return;
		}
		boolean isExist = false;
		Item[] myCartItems = user.getItems();
		for (Item item : myCartItems) {
			if (item.getProductNo() == productNo) {
				isExist = true;
			}
		}
		if (isExist) {
			System.out.println("!! 장바구니에 동일한 상품이 이미 저장되어 있습니다.");
			return;
		}
		
		Item item = new Item();
		item.setProductNo(productNo);
		item.setProductName(product.getName());
		item.setOrderPrice(product.getDiscountPrice());
		
		user.addItem(item);
		product.setStock(product.getStock() - 1);
		System.out.println("## 장바구니에 상품이 저장되었습니다.");
	}
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 장바구니에 저장된 모든 상품정보를 화면에 출력한다.<br />
	 * 표시내용 :: 아이템번호, 상품번호, 상품명, 구매가격 정보를 표시한다.
	 * 
	 * @param userId 장바구니에 저장될 상품 정보를 조회할 사용자 아이디
	 */
	public void displayMyCart(String userId) {
		
		User user = userRepo.getUserById(userId);
		if (user == null) {
			System.out.println("!! 상품정보가 존재하지 않습니다.");
			return;
		}
		
		Item[] myCartItems = user.getItems();
		if (myCartItems.length == 0) {
			System.out.println("!! 장바구니에 저장된 상품이 없습니다.");
			return;
		}
		
		System.out.println("=================================================================================");
		System.out.println("번호	상품번호	상품이름	구매가격");
		System.out.println("=================================================================================");
		for (Item item : myCartItems) {
			System.out.print(item.getNo() + "\t");
			System.out.print(item.getProductNo() + "\t");
			System.out.print(item.getProductName() + "\t");
			System.out.println(item.getOrderPrice() + "\t");
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 장바구니에 저장된 모든 상품을 주문한다.
	 * 
	 * @param userId 장바구니에 저장된 모든 상품정보를 주문하고 싶어하는 사용자 아이디
	 */
	public void cartToOrder(String userId) {
		User user = userRepo.getUserById(userId);
		if (user == null) {
			System.out.println("!! 사용자 정보가 존재하지 않습니다.");
			return;
		}
		Item[] myCartItems = user.getItems();
		if (myCartItems.length == 0) {
			System.out.println("!! 장바구니에 저장된 상품이 없습니다.");
			return;
		}
		
		Order order = new Order();
		order.setUserId(userId);
		for (Item item : myCartItems) {
			Product product = productRepo.getProductByNo(item.getProductNo());
			product.setScore(product.getScore() + 1);
			order.addItem(item);
		}
		
		orderRepo.insertOrder(order);
		user.clearItems();
		System.out.println("## 구매가 완료되었습니다.");
	}
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 모든 주문내역을 화면에 출력한다.
	 * 
	 * @param userId 주문내역을 조회할 사용자 아이디
	 */
	public void displayMyOrders(String userId) {
		Order[] orders = orderRepo.getOrderByUserId(userId);
		if (orders == null) {
			System.out.println("!! 주문내역이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("=================================================================================");
		for (Order order : orders) {
			System.out.println("주문번호: " + order.getNo());
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("번호	상품번호	상품이름	구매가격");
			System.out.println("---------------------------------------------------------------------------------");
			Item[] items = order.getItems();
			for (Item item : items) {
				System.out.print(item.getNo() + "\t");
				System.out.print(item.getProductNo() + "\t");
				System.out.print(item.getProductName() + "\t");
				System.out.println(item.getOrderPrice() + "\t");
			}
			System.out.println();
		}
		System.out.println("=================================================================================");
	}
}
