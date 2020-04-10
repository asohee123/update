package control;

import java.util.Scanner;

public class IfDemo5Ex {
	
	public static void main(String[] args) {
		
		/*
		 * 고객의 등급(일반, 로얄, 플래티넘 중 하나)과 총 구매금액을 입력받는다.
		 * 고개의 등급이	플래티넘인 경우 구매금액의 10%를 할인한다.
		 * 				로얄인 경우 구매금액의 3%를 할인한다.
		 * 				일반인 경우 구매금액의 1%를 할인한다.
		 * 결제금액은 총구매금액에서 할인된 금액만큼 차감한 금액이다.
		 * 적립포인트는 결재금액의 3%를 적립한다.
		 * 
		 * 출력내용은
		 * 			총구매금액, 고객등급, 할인된 금액, 결제할 금액, 적립된 포인트
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("등급을 말하세요. : ");
		String grade = sc.next();
		
		System.out.println("구매금액을 말하세요 : ");
		int buyMoney = sc.nextInt();
		
		
		
		
	}

}
