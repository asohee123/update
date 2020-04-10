package array;

import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		
		/*
		 * 숫자를 10개 입력받아서 인접한 두 수의 차이가 가장 많이 나느 숫자를 각각 출력하기
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		//배열 생성하기
		int[] number = new int[10];
		
		//숫자 10개를 입력받아서 배열에 담기
		for(int i = 0; i <10; i++) {
			System.out.print("숫자를 입력하세요 : ");
			int selcetNumber = scanner.nextInt();
			
			number[i] = selcetNumber;
		}
		//출력할 값을 담는 변수 만들기
		int prev = 0;
		int next = 0;
		int gap = 0;
		
		for(int i= 0; i<number.length-1; i++) {
			int tempPrev = number[i];
			int tempNext = number[i+1];
			int currentGap = Math.abs(tempPrev - tempNext);
			
			
			if(currentGap>gap) {
				gap = currentGap;
				prev = tempPrev;
				next = tempNext;
			} 
		} 
		
		//인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그 차이를 구하기
		System.out.println("숫자 1 : "+ prev +"\t" +  "숫자 2 : " + next +"\t" + "차이 :	" + gap);
		
	}
}
