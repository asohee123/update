package control;

import java.util.Scanner;

public class BreakDemo1 {

	public static void main(String[] args) {
		
		/*
		 * break문
		 * 	반복문을 탈출한다. for문, while문 안에서 사용된다.
		 */
		Scanner scanner = new Scanner(System.in);
		
		//내가 입력한 주사위 숫자와 동일한 숫자가 나오면 탈출.
		for(;;) {
			System.out.print("숫자를 입력하세요.(1~6 사용) : ");
			int number = scanner.nextInt();
			
			int randomNumber = (int)(Math.random()*6+1);
			//break; -> 반복문 안에 break문 쓰면 한번만 실행하고 빠져나가게 됨으로 조건문과 같이 써주는것이 좋다.
			System.out.println("["+ number +", " + randomNumber +"]");
			
			if (number == randomNumber) {
				System.out.println("숫자가 같습니다.");
				break;
			}
		}
		
	}
	
}
