package oop2;

import java.util.Scanner;

public class StudentExDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Studentex[] studentse = new Studentex[100];
		int savePosition = 0;
		
		while (true) {
			System.out.println();
			System.out.println("학생정보 관리 프로그램");
			System.out.println("1.조회 2.검색 3.입력 0.종료");
			
			System.out.print("메뉴 선택 : ");
			int number = scanner.nextInt();
			
			if(number == 1) {
				System.out.println("학생정보 조회");
				System.out.println("이름	반	번호	국어	영어	수학	총점	평균");
				System.out.println();
				
				
				for(int i = 0; i<savePosition; i++) {
					Studentex studentex = studentse[i];
					studentex.displayStudentInForRow();
				}
			}else if(number == 2) {
				System.out.println("학생정보 검색");
				
				System.out.print("이름 : ");
				String searchName =scanner.next();
				
				boolean isFound = false;
				for(int i = 0; i<savePosition; i++) {
					if(searchName.equals(studentse[i].name)) {
						System.out.println("검색결과");
						System.out.println("학생이름\t반\t국어점수\t영어점수\t수학점수\t총점\t평균\t");
						studentse[i].dispalyStudentInfo();
						isFound = true;
					}
				}
			}else if(number == 3) {
				System.out.println("학생정보를 입력");
				System.out.print("학생이름 : ");
				String name = scanner.next();
				System.out.print("반 : ");
				int ban = scanner.nextInt();
				System.out.print("번호 : ");
				int no = scanner.nextInt();
				System.out.print("국어점수 : ");
				int kor = scanner.nextInt();
				System.out.print("영어점수 : ");
				int eng = scanner.nextInt();
				System.out.print("수학점수 : ");
				int math = scanner.nextInt();
				
				Studentex studentse = new Studentex();
				studentse.name = name;
				studentse.ban = ban;
				studentse.no = no;
				studentse.kor = kor;
				studentse.eng = eng;
				studentse.math = math;
				
				studentex[savePosition] = studentse;
				savePosition++;
				
			}else if(number == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
