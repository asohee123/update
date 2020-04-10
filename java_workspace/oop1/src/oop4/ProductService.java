package oop4;

public class ProductService {

	Product[] db = new Product[20];
	int savePosition = 0;
	
	//	배열에 저장된 모든 상품정보를 출력한다.
	void printAllProducts() {
		
		System.out.println("----------------------------------------------");
		System.out.println("책이름	제조사	카데고리	가격	할인율	제고	절판");
		System.out.println("----------------------------------------------");
		
		for(int i = 0; i<savePosition; i++) {
			Product product = db[i];
			product.display();
			
//			System.out.print(product.name + "\t");
//			System.out.print(product.maker + "\t");
//			System.out.print(product.category + "\t");
//			System.out.print(product.price + "\t");
//			System.out.print(product.discountRate + "\t");
//			System.out.print(product.stock + "\t");
//			System.out.print(product.isSoldOut + "\t");
					
		}
	}
	//	상품객체(새 상품, 이월상품)를 전달받아서 배열에 저장한다.
	void insertProduct(Product product) {
		db[savePosition] = product;
		savePosition++;
	}
	//	상품명과 입고량을 전달받아서 이미 배열에 저장된 상품의 재고량을 증가시킨다.
	void addProductScock(String name, int amount) {
		Product result = null;
		for(int i = 0; i<savePosition; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				product.stock += amount;
			}
		}
	}
	//	상품명과 출고량을 전달받아서 배열에서 해당 상품을 찾아서 재고량을 감소시킨다.
	//	단, 재고량보다 출고량이 많은 경우 오류 메시지를 표현한다.
	//	, 재고량이 0이되면 해상상품의 절반여부를 true로 설정한다.
	void exportProduct(String name, int amount) {
		
		
	}
	//	상품명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void exportProductByName(String name) {
		Product result = null;
		for(int i = 0; i<savePosition; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				
			}
		}
	}
	//	제조사명을 전달받아서 배열에서 제조사명이 일치하는 상품정보를 출력한다.
	void exportProductByMaker(String maker) {
		
	}
	//	카테고리명을 전달받아서 배열에서 카데고리명이 일치하는 상품정보를 출력한다.
	void exportProductByCategory(String category) {
	
}
	//	최저가격과 최고가격을을 전달받아서 배열에서 해당 가격범위에 속하는 상품정보를 출력한다.
	void printProductsByPrice(int minPrice, int maxPrice) {
		
	}
}
