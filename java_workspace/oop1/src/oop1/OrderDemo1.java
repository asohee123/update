package oop1;

import java.util.Scanner;

public class OrderDemo1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			
			System.out.println("상품권 관리 프로그램");
			System.out.println(" 메뉴 구성");
			System.out.println("1.조회 2.검색 3.입력 4.종료");
			System.out.println("====================================");
			
			System.out.print("메뉴 선택 : ");
			int menuNum = scanner.nextInt();
			
			
			
			if(menuNum == 1) {
				
				System.out.println();
				System.out.println("고객정보 조회");
				
				if(savePosition == 0) {
					System.out.println("고객 주문 내용이 존재하지 않습니다.");
				} else {
						System.out.println("고객명\t고객등급\t구매금액\t적립포인트\t사은품\t");
				
				
						for(int i = 0; i<savePosition; i++) {
							Order order = orders[i];
							System.out.print(order.name + "\t");
							System.out.print(order.grade + "\t");
							System.out.print(order.price + "\t");
							System.out.print(order.point + "\t");
							System.out.print(order.gift);
							System.out.println();
						}
				
				}
//				if(grade.equals("프리미어")) {
//					
//				} else if(grade.equals("에이스")) {
//					
//				} else if(grade.equals("베스트")) {
//					
//				} else if(grade.equals("클래식")) {
//					
//				}
//				
//				
//				if(price >= 5000000) {
//					String gift = "숙박권 지급";
//				} else if (price >= 1000000) {
//					String gift = "상품권 지급";
//				} else if(price >= 500000) {
//					String gift = "할인권 지급";
//				} else {
//					String gift = "주차권 지급";
//				}
//				
//				order.point = point;
//				order.gift = gift;
				
				
			} else if(menuNum == 2) {
				System.out.println();
				System.out.println("고객 주문내용 검색");
				System.out.print("검색조건을 입력하세요.(N=이름, G=사은품) : ");
				String option = scanner.next();
				
				System.out.print("검색내용을 입력하세요. : ");
				String text = scanner.next();
				
				System.out.println("고객명\t고객등급\t구매금액\t적립포인트\t사은품\t");
				System.out.println("==============================================================");
				
				for(int i = 0; i<savePosition; i++) {
					Order order = orders[i];
					
					
					boolean isFound = false;
					if(option.equals("N") && text.equals(order.name)) {
						isFound = true;
					} else if(option.equals("G") && text.equals(order.gift)) {
						isFound = true;
					}
					
					if(isFound) {
						System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t");
						System.out.print(order.point + "\t");
						System.out.print(order.gift);
						System.out.println();
					}
				}
				
//				Order foundScore = null;
//				for(int i = 0; i<savePosition; i++) {
//					Order order = orders[i];
//					if(customerName.equals(order.name)) {
//						foundScore = order;
//						break;
//					}
//				}
				
//				if(foundScore != null) {
//					
//					System.out.println("===========검색");
//					
//				}
				
			} else if(menuNum == 3) {
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
				
				order.name  = name;
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
					order.gift = "숙박권 지급";
				} else if (order.price >= 1000000) {
					order.gift = "상품권 지급";
				} else if(order.price >= 500000) {
					order.gift = "할인권 지급";
				} else {
					order.gift = "주차권 지급";
				}
				
			
				orders[savePosition] = order;
				savePosition++;
				
				

				
			} else if(menuNum == 4) {
				System.out.println("종료합니다.");
				break;
			}
		}
		
		scanner.close(); //스캐너 종료
		
	}

}
