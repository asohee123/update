package control;

import java.util.Scanner;

public class WhileDemo4 {

	public static void main(String[] args) {
		
		//10000 ~ 99999사이의 임의의 정수를 입력하세요.
		//예) 입력값 : 12132 ----> 출력값 1 + 2 + 1 + 3 + 2 -- 9
		
		
		// inputNumber		last		sum		inputNumber
		//		123			3			3			12
		//		12			2			5			1
		//		1			1			6			0
		Scanner scanner = new Scanner(System.in);
		System.out.print("임의의 5자리 숫자를 입력하세요.(10000~99999) : ");
		int inputNumber = scanner.nextInt();
		
		int sum = 0;
		
		while (inputNumber != 0) {
			int lastNumber = inputNumber%10;
			sum += lastNumber;
			
			inputNumber = inputNumber/10;
		}
		System.out.println("합계 : " + sum);		
	}
}
