package array;

import java.util.Scanner;

public class ArrayDemo14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] frist = new int[3];		//
		int[] second = new int[3];		//랜덤
		int strike =0; 
		int ball = 0;
		int count = 0;

		for(int i=0; i<3; i++) {
			frist[i] = (int)(Math.random()*9+1);

		}
		
		while(true) {			
			
			for(int i = 0; i<3; i++) {
				System.out.print("숫자를 입력하세요. : ");
				second[i] = scanner.nextInt();
				System.out.println(second[i]);
				break;
			}
			
				for(int i = 0; i<3; i++) {
					if(frist[i] == second[i]) {
						strike++;
						
					} else if (frist[i] == second[i]) {
						ball++;
					} 
					count++;
				}
				if(strike == 3) {
					System.out.println("탈출");
					break;
				}else if (count == 10) {
					System.out.println("실패");
					break;	
				}
		}
	}
}
