package control;

import java.util.Scanner;

public class IfDemo2Ex {

	public static void main(String[] args) {
		
		
		//숫자를 입력받아서 짝수인 경우 "짝수", 아닌 경우는 "홀수" 라고 표시하기
				//짝수는 2의 배수다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요. : ");
		int number = sc.nextInt();
		
		if(number%2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
	}
	
}
