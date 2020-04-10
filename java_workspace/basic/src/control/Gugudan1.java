package control;

import java.util.Scanner;

public class Gugudan1 {

	public static void main(String[] args) {
		
		/*
		 * 숫자를 입력받아서 해당 숫자에 대한 구구단을 출력한다.
		 */
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("몇단? : ");
		int selectNumber = scanner.nextInt();
		
		for (int i = 1; i < 10; i++) {
			System.out.println(selectNumber + " * " + i + " = " + selectNumber*i);
		}
	}
}
