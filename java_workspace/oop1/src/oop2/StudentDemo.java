package oop2;

import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
	
		Student[] student = new Student[100];
		
		Scanner scanner = new Scanner(System.in);
		
		int savePosition = 0;
		
		while(true) {
			System.out.println("==============================");
			System.out.println("1.조회	2.검색	3.입력	0.종료");
			System.out.println("==============================");
			
			System.out.print("메뉴 선택 : ");
			int selcetNumber = scanner.nextInt();
			
			if(selcetNumber == 1) {
				for(int i=0; i<savePosition; i++) {
					Student students = student[i];
					students.display();
				}
			
				System.out.println();
				System.out.println("학생정보 조회");
				
				
			} else if(selcetNumber == 2) {
				Student students = new Student();
				System.out.println("학생정보 검색");
				
				System.out.print("검색할 학생 이름 : ");
				String searchName = scanner.next();
				

				for(int i = 0; i<savePosition; i++) {
					if(searchName.equals(student[i].studentName)) {
						
						students = student[i];
						students.display();
						break;
						
					}else {
						System.out.println("실패");
					}
					
				}
				
			} else if(selcetNumber == 3) {
				System.out.println("학생정보를 입력");
				System.out.print("학생이름 : ");
				String name = scanner.next();
				System.out.print("반 : ");
				int classs = scanner.nextInt();
				System.out.print("번호 : ");
				int num = scanner.nextInt();
				System.out.print("국어점수 : ");
				int kor = scanner.nextInt();
				System.out.print("영어점수 : ");
				int eng = scanner.nextInt();
				System.out.print("수학점수 : ");
				int math = scanner.nextInt();
				
				Student students = new Student();
				students.studentName = name;
				students.studentClass = classs;
				students.studentNumber = num;
				students.kor = kor;
				students.eng = eng;
				students.math = math;
				
				
				student[savePosition] = students;
				savePosition++;
			} else if(selcetNumber == 0) {
				break;
			}
		}
		System.out.println("시스템을 종료합니다.");

	}
}
