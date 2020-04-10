package data.app;

import java.util.Scanner;

import data.service.DataService;

public class DataApp {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		DataService service = new DataService();
		
		while(true) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.전체조회 2.지역별조회 3.날짜별조회 4.통계 5.종료");
			System.out.println("--------------------------------------------------");
			
			System.out.print("메뉴 선택 : ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				
				System.out.println("[전체조회 메뉴]");
				service.printAllDataCount();
				
			} else if(menuNo == 2) {
				
				System.out.println("[지역별조회 메뉴]");
				System.out.print("지역을 입력하세요 : ");			
				String sido = sc.next();
	
				service.printDataBysido(sido);
				
			} else if(menuNo == 3) {
				
				System.out.println("[날짜별조회 메뉴]");
				System.out.print("날짜를 입력하세요(MM-dd) : ");
				String day = sc.next();
				
				service.printDataByDay(day);
				
			} else if(menuNo == 4) {
				
				System.out.println("[통계보기]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.지역별 2.월별 3.요일별 4.위반내용별 5.요약 6.나가기");
				System.out.println("-------------------------------------------------");
				System.out.print("메뉴 선택 : ");
				int subMenuNo = sc.nextInt();
				
				if(subMenuNo == 1) {
					
					System.out.println("[지역별 메뉴]");
					System.out.print("지역을 입력하세요 : ");
					String sido = sc.next();
					
					service.printDataStatBySido(sido);
					
				} else if(subMenuNo == 2) {
					System.out.println("[월별별 메뉴]");
					
					service.printDataStatByMonth();
				} else if(subMenuNo == 3) {
					System.out.println("[요일 메뉴]");
					service.printDataStatByDayOfWeek();
				} else if(subMenuNo == 4) {
					System.out.println("[위반내용별 메뉴]");
					service.printDataStatByViolation();
					
				} else if(subMenuNo == 5) {
					System.out.println("[요약 메뉴]");
					service.printDataStat();
				}
					
			} else if(menuNo == 5) {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}
}
