package com.sample.mall.repository;

import java.util.Arrays;

import com.sample.mall.vo.Product;

public class ProductRepository {

	private Product[] db = new Product[20];
	private int position = 0;
	private int sequence = 10001;
	
	public ProductRepository() {
		db[position++] = new Product(sequence++, "아이패드", 1000000, 900000, 100, 0);
		db[position++] = new Product(sequence++, "갤럭시20", 1600000, 1400000, 100, 0);
		db[position++] = new Product(sequence++, "아이폰X", 1400000, 1300000, 100, 0);
		db[position++] = new Product(sequence++, "아이폰11", 1600000, 1500000, 100, 0);
		db[position++] = new Product(sequence++, "맥북프로", 2600000, 2300000, 100, 0);
		db[position++] = new Product(sequence++, "맥북에어", 1300000, 1100000, 100, 0);
		db[position++] = new Product(sequence++, "에어팟프로", 340000, 310000, 100, 0);
	}
	
	public Product[] getAllProducts() {
		return Arrays.copyOfRange(db, 0, position);
	}
	
	public Product getProductByNo(int productNo) {
		for (Product product : db) {
			if (product.getNo() == productNo) {
				return product;
			}
		}
		return null;
	}
	
}
