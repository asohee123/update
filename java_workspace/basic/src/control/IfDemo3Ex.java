package control;

import java.util.Scanner;

public class IfDemo3Ex {
	public static void main(String[] args) {
		
		/*
		 * 구매금액이	500만원 이상인 경우 10만원 상품권 지급
		 * 			100만원 이상인 경우 1만원 상품권 지급
		 * 			50만원 이상인 경우 커피쿠폰 지급
		 * 			그 외는 주차할인권 지급
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("구매금액 입력 : ");
		int buyMoney = sc.nextInt();
		
		if (buyMoney >= 5000000) {
			System.out.println("10만원 상품권 지급");
		} else if (buyMoney >= 1000000) {
			System.out.println("1만원 상품권 지급");
		} else if(buyMoney >= 500000) {
			System.out.println("커피쿠폰 지급");
		} else {
			System.out.println("주차할인권 지급");
		}
		
	}
}
