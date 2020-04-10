package com.sample.mall.vo;

import java.util.Arrays;

public class Order {

	private int no;
	private String userId;
	private Item[] items = new Item[20];
	private int position = 0;
	
	public Order() {}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 주문정보에 Item을 추가한다.
	 * @param item 구매 Item객체
	 */
	public void addItem(Item item) {
		items[position++] = item;
	}
	
	/**
	 * 사용자의 주문 Item배열을 반환한다.
	 * @return Item 배열
	 */
	public Item[] getItems() {
		return Arrays.copyOfRange(items, 0, position);
	}
}
