package opperator;

import java.util.Scanner;

public class ScannerDemo3 {

	public static void main(String[] args) {
		
		/*
		 * 	고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 * 	출력내용
		 * 			고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결제금액, 적립포인트
		 * 			*사용포인트는 고객이 이미 적립한 포인트가 있다고 가정하고, 임의의 값을 입력받는다.
		 * 			*결재금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 * 			*적립포인트는 실결재금액의 3%다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("고객명을 입력하세요. : ");
		String name = scanner.next();
		
		System.out.print("상품명을 입력하세요. : ");
		String product = scanner.next();
		
		System.out.print("가격을 입력하세요. : ");
		int price = scanner.nextInt();
		
		System.out.print("구매수량을 입력하세요. : ");
		int quantity = scanner.nextInt();
		
		System.out.print("사용포인트 : ");
		int point = scanner.nextInt();
		
		int orderTotal = price*quantity;
		int useMoney = (orderTotal-point);
		int savePoint = (int)(orderTotal*0.03);
		
		System.out.println();
		System.out.println("++++++++결제 금액++++++++");
		
		System.out.println("고객명 : " + name);
		System.out.println("상품명 : " + product);
		System.out.println("가격 : " + price + "원");
		System.out.println("구매수량 : " + quantity + "개");
		System.out.println("구매가격 : " + orderTotal + "원");
		System.out.println("사용포인트 : " + point + "점");
		System.out.println("결제금액 : " + useMoney + "원");
		System.out.println("적립포인트 : " + savePoint + "점");
		
		
	}
	
}
