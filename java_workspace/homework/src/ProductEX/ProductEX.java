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
			System.out.println("=====================================================");
			System.out.println("1.전체조회 2.검색 3.등록 4.종료");
			System.out.println("=====================================================");
			
			System.out.print("메뉴선택 : ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				System.out.println("=====================================================");
				System.out.println("전체조회 메뉴");
				System.out.println("=====================================================");
				
			} else if(menuNo == 2) {
				System.out.println("=====================================================");
				System.out.println("검색 메뉴");
				System.out.println("=====================================================");
				
			} else if(menuNo == 3) {
				System.out.println("=====================================================");
				System.out.println("등록 메뉴");
				System.out.println("=====================================================");
				
			} else if(menuNo == 4) {
				System.out.println("종료합니다.");
				break;
			}
			
		}
	}
}
