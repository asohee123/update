package control;

import java.util.Scanner;

public class IfDemo3 {

	public static void main(String[] args) {
		
		/*
		 * if ~ else if ~ else if ~ else 문
		 * 3개 이상의 경우의 수를 처리해야 할 떄 사용되는 조건문이다.
		 * 
		 * if (조건식1) {
		 * 				조건식1의 true로 판정 될 때 사용한다. 이후 문장은 실행되지 않는다.
		 * } else if (조건문2) {
		 * 				조건식2의 true로 판정 될 때 사용한다. 이후 문장은 실행되지 않는다.
		 * } else if (조건문3) {
		 * 				조건식3의 true로 판정 될 때 사용한다. 이후 문장은 실행되지 않는다.
		 * } else {
		 * 				조건식1,2,3이 모두 거짓으로 판정 될 떄 사용한다.
		 * }
		 * 
		 */
		
		/*
		 * 구매금액이	500만원 이상인 경우 10만원 상품권 지급
		 * 			100만원 이상인 경우 1만원 상품권 지급
		 * 			50만원 이상인 경우 커피쿠폰 지급
		 * 			그 외는 주차할인권 지급
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구입금액 : ");
		int price = sc.nextInt();
		
		if( price >= 5000000 ) {
			System.out.println("10만원 상품권 지급");
		} else if (price >=1000000 ) {
			System.out.println("1만원 상품권 지급");
		} else if (price >= 500000) {
			System.out.println("커피쿠폰 지급");
		} else {
			System.out.println("주차할인권 지급");
		}
		
	}
	
}
