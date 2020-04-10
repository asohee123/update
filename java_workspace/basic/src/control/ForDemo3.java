package control;

import java.util.Scanner;

public class ForDemo3 {

	public static void main(String[] args) {
		//정수 2개를 입력받아서 두 정수 사이의 숫자를 더한 값을 구하기
		// 예)	10 13
		//	  	10 + 11 + 12 + 13 --->
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번쨰 숫자를 입력하세요");
		int firstNumber = sc.nextInt();
		
		System.out.print("두번째 숫자를 입력하세요");
		int secondNumber = sc.nextInt();
		
		int sum = 0;
		for(int i = firstNumber; i<=secondNumber; i++) {
			sum += i;
		}
		System.out.println(firstNumber + " ~ " +  secondNumber + "의 합계 : " + sum);
	}
	
}
