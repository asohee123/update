package array;

import java.util.Scanner;

public class ArrayDemo9 {

	public static void main(String[] args) {
		
		/*
		 * 숫자를 10개 입력받아서 그 중에 짝수 들의 합계만 구해서 출력하기
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] number = new int[10];
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자를 입력하세요 : ");
			int selcetNumber = sc.nextInt();
			
			number[i] = selcetNumber;
			
		}
		int total = 0;
		for(int x:number) {
				if(x%2 == 0) {
					total += x;
				}	
			}
		System.out.println(total);
	}
}
