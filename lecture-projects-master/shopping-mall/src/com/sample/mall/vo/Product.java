package com.sample.mall.vo;

public class Product {

	private int no;
	private String name;
	private int price;
	private int discountPrice;
	private int stock;
	private int score;
	
	public Product() {}
	
	public Product(String name, int price, int discountPrice, int stock, int score) {
		this.name = name;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.score = score;
	}

	public Product(int no, String name, int price, int discountPrice, int stock, int score) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
