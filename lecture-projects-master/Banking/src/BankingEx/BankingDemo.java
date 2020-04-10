package BankingEx;

import java.util.Scanner;

public class BankingDemo {
	
		
		/*
		BankingDemo2클래스에서는 Banking클래스를 이용해서 신규계좌개설, 입금하기, 출금하기, 비번변경하기, 해지하기를 서비스하기
    	BankingDemo2는 계좌정보에 대한 아래의 메뉴를 제공하시오
      	=======================================================
      	1.신규  2.조회  3.입금  4.출금  5.비번변경  6.해지  0.종료
      	=======================================================
    	BankingDemo2에서 신규메뉴를 선택하면
      	이름, 계좌번호, 비밀번호, 잔액, 가입기간을 입력받아서 Bankig에 담고, 배열에 저장하시오
    	BankingDemo2에서 조회를 선택하면
      	계좌번호를 입력받아서 배열에 저장된 계좌중에서 계좌번호가 일치하는 Banking을 찾아서 정보를 표시하시오
    	BankingDemo2에서 입금을 선택하면
      	계좌번호, 입금액을 입력받아서 배열에 저장된 계좌중에서 계좌번호가 일치하는 Banking을 찾아서 입금처리 하시오.
    	BankingDemo2에서 출금을 선택하면
      	계좌번호, 출금액, 비밀번호를 입력받아서 배열에 저장된 계좌중에서 계좌번호가 일치하는 Banking을 찾아서 출금처리 하시오.
    	BankingDemo2에서 비번변경을 선택하면
      	계좌번호, 이전비밀번호, 새 비밀번호를 입력받아서 배열에 저장된 계좌중에서 계좌번호가 일치하는 Banking을 찾아서 변경처리 하시오.
    	BankingDemo2에서 해지를 선택하면
      	계좌번호, 비밀번호를 입력받아서 배열에 저장된 계좌중에서 계좌번호가 일치하는 Banking을 찾아서 출금처리 하시오.
	 	*/
	
		public static void main(String[] args) {
			
			BankingService service = new BankingService();
			int savePosition = 0;
			
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
			
				System.out.println("은행 프로그램");
				System.out.println("=======================================================");
				System.out.println("1.신규  2.조회  3.입금  4.출금  5.비번변경  6.해지  0.종료");
				System.out.println("=======================================================");
				
				System.out.print("메뉴 선택 : ");
				int selcetNumber = scanner.nextInt();
				
				if(selcetNumber == 1) {
					System.out.println();
					System.out.println("신규회원 가입 메뉴입니다.");
				
					
				} else if(selcetNumber == 2 ) {
					System.out.println();
					System.out.println("조회서비스 메뉴입니다.");
					System.out.println();
					System.out.print("비밀번호를 입력하세요 : ");
					int no = scanner.nextInt();
					
					service.printAllBanking(no);
					
				} else if(selcetNumber == 3) {
					System.out.println();
					System.out.println("입급서비스 메뉴입니다.");
					
				} else if(selcetNumber == 4) {
					System.out.println();
					System.out.println("출금서비스 메뉴입니다.");

				} else if(selcetNumber == 5) {
					System.out.println("비밀번호 변경 메뉴입니다.");
					System.out.println();

				} else if(selcetNumber == 6) {
					System.out.println();
					System.out.println("은행해지 메뉴입니다.");

				} else if(selcetNumber == 0) {
					System.out.println("시스템 종료");
					break;
				}
			}
		}
}
