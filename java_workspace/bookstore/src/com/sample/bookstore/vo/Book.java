package com.sample.bookstore.vo;

public class Book {
	//클래스 정의
	
	public int no;
	
	public String title;
	public String wirter;
	
	public int price;
	public int stock;
	
	public Book() {} //기본 생성자
	
	public Book(int no, String title, String wirter, int price, int stock) {
		super();
		this.no = no;
		this.title = title;
		this.wirter = wirter;
		this.price = price;
		this.stock = stock;
	}
	
	
	
}
