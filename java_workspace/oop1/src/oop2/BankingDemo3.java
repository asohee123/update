package oop2;

import java.util.Scanner;

public class BankingDemo3 {	//사용자와 서버 사이의 브릿지 역활	
							// UI - User Ineterface.

	public static void main(String[] args) {
		
		BankingService service = new BankingService();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		while(true) {
			System.out.println();
			System.out.println("계좌 괸리 프로그램");
			System.out.println("======================================================");
			System.out.println("1.조회	2.검색	3.신규	4.입금	5.출금	6. 해지	0.종료");
			System.out.println("======================================================");
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1 ) {
				service.printAllBanking();
				
			
			} else if(menuNo == 2 ) {
				System.out.print("조회할 계좌번호 : ");
				String bankingNo = scanner.next();
				
				service.printBankingByNo(bankingNo);
				
				
			} else if(menuNo == 3 ) {
				System.out.println("신규 계좌개설에 필요한 정보 입력 : ");
				System.out.print("고객명을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("비밀번호을 입력하세요 : ");
				int pwd = scanner.nextInt();
				System.out.print("첫 입금액을 입력하세요 : ");
				long money = scanner.nextLong();
				
				service.addNewBanking(name, pwd, money);
				
				
			} else if(menuNo == 4 ) {
				System.out.print("계좌번호를 입력하세요 :");
				String no = scanner.next();
				System.out.print("얼마 입금하시겠습니까 : ");
				long money = scanner.nextLong();
				
				
				service.depositeBanking(no, money);
			
			} else if(menuNo == 5 ) {
				
				System.out.println("계좌번호와 비밀번호, 출금액을 입력하세요. ");
				System.out.print("계좌번호를 입력하세요 : ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int pwd = scanner.nextInt();
				System.out.print("출금할 금액을 적으세요 : ");
				long money = scanner.nextLong();
				
				
				long withdrawMoney = service.withdrawFromBanking(no, pwd, money);
				System.out.println("고객님 ["+ withdrawMoney + "]원 나옵니다.");
				
				
			} else if(menuNo == 6 ) {
				System.out.print("계좌번호를 입력하세요 : ");
				String bankingNo = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int pwd = scanner.nextInt();
				
				long money = service.closeBanking(bankingNo, pwd);
				System.out.println("고객님 총 해지금액 [" + money + "]원 입니다.");
				
			} else if(menuNo == 0 ) {
				System.out.println("프로그램을 종료합니다.");
				break;
				
			}


		}
	}
}
