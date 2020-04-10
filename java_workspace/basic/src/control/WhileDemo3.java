package control;

import java.util.Scanner;

public class WhileDemo3 {

	public static void main(String[] args) {
		//1~100까지 임의의 정수를 하나 생성한다.
		//사용자가 입력한 숫자와 임의의 정수를 비교해서 up/down을 표시한다.
		//사용자가 입력한 숫자와 임의의 정수가 일치하면
		//몇번만에 맞췄는지 화면에 표시한다.
		
		Scanner scanner = new Scanner(System.in);
		//1~100 임의의 정수를 생성해서 secretNumber에 저장한다.
		int secretNumber = (int)(Math.random()*100+1);
		
		//사용자가 정답을 맞추기 위해서 숫자를 입력한 횟수.
		int inputCount = 0;
		
		
		while(true) {
			System.out.print("정수를 입력하세요, : ");
			int selectNumber = scanner.nextInt();
			
			inputCount++;
			if(secretNumber == selectNumber) {
				System.out.println("정답입니다.");
				break;
			} else if (secretNumber < selectNumber) {
				System.out.println(selectNumber + "보다 작습니다");
			} else if (secretNumber > selectNumber) {
				System.out.println(selectNumber + "보다 큽니다");
			}
			
		}
		System.out.println("정답 : " + secretNumber + " 입력횟수 : " + inputCount);
	}
}
