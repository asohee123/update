package opperator;

import java.util.Scanner;

public class ScannerDemo2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 학생이름, 국어점수, 영어점수, 수학점수를 입력받는다.
		 * 출력내용
		 * 			학생이름, 국어점수, 영어점수, 수학점수, 총점, 평균, 합격여부, 장학금지급여부
		 * 			*합격여부는 평균이 60점 이상인 경우만 "예"로 출력 그 외는 "아니오" 출력
		 * 			*장학금지급여부는 평균이 96점 이상인 경우만 "예"로 출력 그 외는 "아니오" 출력
		 */
		
		System.out.print("이름이 무엇입니까? : ");
		String name = scanner.next();
		
		System.out.print("국어점수를 입력하세요. : ");
		int kor = scanner.nextInt();
		
		System.out.print("영어점수를 입력하세요. : ");
		int eng = scanner.nextInt();
		
		System.out.print("수학점수를 입력하세요. : ");
		int math = scanner.nextInt();
		
		int totalScore = kor + eng + math;
		int average = totalScore/3;
		
		String result = average >= 60? "예" : "아니오";
		String scholarShip = average >= 90? "예" : "아니오";
		//일자로 나오게 하는 방법
		System.out.println();
		System.out.println("-------- 시험 점수 --------");
		System.out.println("학생이름 : " + name);
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + average);
		System.out.println("합격여부 : " + result);
		System.out.println("장학금지급여부 : " + scholarShip);

		//옆으로 나오게 하는 방법
//		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학금지급여부");
//		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+totalScore+"\t"+average+"\t"+result+"\t"+scholarShip);
		
		
	}
	
}
