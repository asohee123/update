package com.sample.mall.vo;

import java.util.Arrays;

public class User {

	private String id;
	private String name;
	private int point;
	private Item[] items = new Item[20];
	private int position = 0;
	private int sequence = 200;
	
	public User() {}
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public User(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	/**
	 * 사용자의 장바구니에 Item을 추가한다.
	 * @param item 장바구니 Item객체
	 */
	public void addItem(Item item) {
		item.setNo(sequence++);
		items[position++] = item;
	}
	
	/**
	 * 사용자의 장바구니에 저장된 Item배열을 반환한다.
	 * @return Item 배열
	 */
	public Item[] getItems() {
		return Arrays.copyOfRange(items, 0, position);
	}
	
	/**
	 * 사용자의 장바구니를 비운다.
	 */
	public void clearItems() {
		Arrays.fill(items, null);
		position = 0;
	}
}
