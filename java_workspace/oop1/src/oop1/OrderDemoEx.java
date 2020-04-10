package oop1;

import java.util.Scanner;

public class OrderDemoEx {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			
			System.out.println("상품권 관리 프로그램");
			System.out.println("=================================");
			System.out.println("1.조회	2.검색	3.입력	4.종료");
			System.out.println("=================================");
			System.out.print("메뉴 선택 : ");
			int selcetNumber = scanner.nextInt();
			
			if(selcetNumber == 1) {
				
				System.out.println();
				System.out.println("고객 정보조회");
				
				if(savePosition == 0) {
					System.out.println("고객정보가 없습니다.");
				} else {
					System.out.println("고객정보 출력");
					System.out.println("고객명\t고객등급\t구매금액\t적립포인트\t사은품\t");
					
					for(int i = 0; i<savePosition; i++) {
						Order order = orders[i];
						System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t");
						System.out.print(order.point + "\t");
						System.out.println(order.gift);
						
					}
				}
				
			} else if(selcetNumber == 2) {
				
				System.out.println();
				System.out.println("고객정보 검색");
				
			} else if(selcetNumber == 3) {
				System.out.println();
				System.out.println("고객 주문내용 입력");
				System.out.print("고객명 : ");
				String name = scanner.next();
				System.out.print("고객 등급 : ");
				String grade= scanner.next();
				System.out.print("총 구매금액 : ");
				int price = scanner.nextInt();
				System.out.println("========================================");
				
				Order order = new Order();
				
				order.name = name;
				order.grade = grade;
				order.price = price;
				
				if(grade.equals("프리미어")) {
					order.point = (int)(order.price*0.05);
				} else if(grade.equals("에이스")) {
					order.point = (int)(order.price*0.03);
				} else if(grade.equals("베스트")) {
					order.point = (int)(order.price*0.02);
				} else if(grade.equals("클래식")) {
					order.point = (int)(order.price*0.01);
				}
				
				if(order.price >= 5000000) {
					order.gift = "1등";
				} else if(order.price >= 4000000) {
					order.gift = "2등";
				} else if(order.price >= 3000000) {
					order.gift = "3등";
				} else if(order.price >= 2000000) {
					order.gift = "4등";
				}
				
				orders[savePosition] = order;
				savePosition++;
				
			} else if(selcetNumber == 4) {
				System.out.println("종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
