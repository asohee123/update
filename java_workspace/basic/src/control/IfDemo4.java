package control;

import java.util.Scanner;

public class IfDemo4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.print("총 구매금액 : ");
		int totalOderPrice = sc.nextInt();
		
		System.out.print("고객의 등급을 입력하세요. : ");
		String grade = sc.next();
		
		int discountPrice = 0; //할인금액
		int payTotalPrice = 0; //지불금액
		int depositPoint = 0; //적립금액
		
		if (grade.equals("플래티넘")) {
			discountPrice = (int)(totalOderPrice * 0.1);
		} else if (grade.equals("로얄")) {
			discountPrice = (int)(totalOderPrice * 0.03);
		} else if (grade.equals("로얄")) {
			discountPrice = (int)(totalOderPrice * 0.01);
		}
		
		payTotalPrice = (totalOderPrice - discountPrice);
		depositPoint = (int)(payTotalPrice*0.03);
		
		
		System.out.println();
		System.out.println("++++++++영수 증표++++++++");
		System.out.println("총 구매금액 : " + totalOderPrice);
		System.out.println("고객등급 : " + grade);
		System.out.println("할인된 금액 : " + discountPrice);
		System.out.println("결제할 금액 : " + payTotalPrice);
		System.out.println("적립된 포인트 : " + depositPoint);
		System.out.println("++++++++++++++++++++++++");
		
	}
	
}
