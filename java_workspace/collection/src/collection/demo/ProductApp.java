package collection.demo;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Product;

public class ProductApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//상품정보를 저장하는 ArrayList객체 생성
		ArrayList<Product> db = new ArrayList<Product>();
		
		ProductRepository repo = new ProductRepository();
		
		while(true) {
			try {
				
				System.out.println("=====================================================");
				System.out.println("1.전체조회 2.검색 3.등록 4.종료");
				System.out.println("=====================================================");
				
				System.out.print("메뉴선택 : ");
				int menuNo = sc.nextInt();
				
				if(menuNo == 1) {
					System.out.println("=====================================================");
					System.out.println("전체조회 메뉴");
					System.out.println("=====================================================");
					
					ArrayList<Product> productList = repo.getAllProducts();
					
					if(productList.isEmpty()) {  //결과값이 없을때 쓰는 것
						System.out.println("조회되지않습니다.");
					} else {
						System.out.println("상품번호\t상품가격\t가격");
						for(Product product : productList) {
							System.out.print(product.getNo()+"\t");
							System.out.print(product.getName()+"\t");
							System.out.println(product.getPrice()+"\t");
						}
					}
					
				} else if(menuNo == 2) {
					System.out.println("=====================================================");
					System.out.println("검색 메뉴");
					System.out.println("=====================================================");
					
					System.out.print("제목명을 입력하세요 : ");
					String bookName = sc.next();
					
					ArrayList<Product> productList = repo.searchProducts(bookName);
					if(productList .isEmpty()) {
						
						System.out.println("전체 [" + bookName +"] 검색어에 해당하는 상품을 찾을 수 없습니다.");
						
					} else {
						
						System.out.println("전체 [" + productList .size() + "]건이 조회되었습니다.");
						System.out.println("상품번호\t상품가격\t가격");
						
						for(Product product : productList) {
							
							System.out.print(product.getNo()+"\t");
							System.out.print(product.getName()+"\t");
							System.out.println(product.getPrice()+"\t");
							
						}
					}
					
				} else if(menuNo == 3) {
					System.out.println("=====================================================");
					System.out.println("등록 메뉴");
					System.out.println("=====================================================");
					
					System.out.print("제목을 입력하세요 : ");
					String bookName = sc.next();
					System.out.print("제조사을 입력하세요 : ");
					String bookMaker = sc.next();
					System.out.print("가격을 입력하세요 : ");
					int bookPrice = sc.nextInt();
					
					Product product = new Product();
					product.setName(bookName);
					product.setMaker(bookMaker);
					product.setPrice(bookPrice);
					
					repo.insertProduct(product);
					System.out.println("### 신규상품이 등록되었습니다.");
					
				} else if(menuNo == 4) {
					System.out.println("종료합니다.");
					break;
				}
				
			
				} catch (Exception e) {
					System.out.println("메인메뉴로 돌아갑니다.");
			}

			
		}
		
	}
}
