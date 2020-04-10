package control;

import java.util.Scanner;

public class Lotto2 {

	public static void main(String[] args) {
	
		/*
		 * 금액을 입력받는다.
		 * 금액는 1000원 단위의 값만 입력받는다.
		 * 로또번호를 입력된 금액만큼 발행한다.
		 * 1000원당 1세트씩 발행한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액('천원 단위')을 입력하세요. : ");
		int priec = sc.nextInt();
		
		int set = priec/1000;
		
		for(int i = 1; i<=set*6; i++) {
			int number = (int)(Math.random()*45+1);
			System.out.print(number + " ");
			if(i%6==0) {
				System.out.println();
			}
		}
		
	}
	
}
