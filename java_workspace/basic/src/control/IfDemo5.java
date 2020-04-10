package control;

import java.util.Scanner;

public class IfDemo5 {

	public static void main(String[] args) {
		
		// 중첩 if문
		// if문의 블록내에 다른 if문을 포함시키는 것
		
		/*
		 * 성적표 출력하기
		 * 		60점 이상인 경우 합격 그외는 불합격
		 * 		단, 합격자 중에서 성적이 100점 이상인 경우 장학금 지급.
		 * 					    성적이 96점 이상인 경우 반액 장학금 지급.
		 * 		단, 성적이 40점 이하인 경우 다음 회차 응시기회를 박탈.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요. : ");
		int score = sc.nextInt();
		
		if (score >= 60) {
			System.out.println("합격");
			if (score >= 100) {
				System.out.println("전액 장학금 지급 대상");
			} else if (score >= 96) {
				System.out.println("반액 장학급 지급 대상");
			}
		} else {
			System.out.println("불합격");
			if (score <= 40) {
				System.out.println("다음 시험 응시자격 박탈");
			}
		}
		
	}
	
}
