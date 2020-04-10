package array;

import java.util.Scanner;

public class ArrayDemo7 {

	public static void main(String[] args) {
		//숫자를 5번 입력받아서 입력받은 숫자의 총합을 계산하기
		
		//키보드 입력받기
		Scanner scanner = new Scanner(System.in);
		
		//숫자 5개를 입력받는 배열 생성하기
		int[] number = new int[5];					
				
		//숫자 5번 입력받기
		for(int i = 0; i<5; i++) {				//i를 0~4까지 변경하면서 반복하기
			System.out.print("숫자를 입력하세요 : ");
			//입력받은 숫자를 변수에 저장하기
			int selcetNumber = scanner.nextInt();
			
			//변수에 저장된 값을 배열에 담기
			number[i] = selcetNumber;			//입력받은 값을 배열의 i번째에 담기
			
		}
		
		//입력받은 숫자들의 총합 계산하기
		int total = 0;
		for(int totals : number) {//=> enhanced-for문 //numbers배열의 값을 하나씩 순서대로 num에 담기
			//total에 숫자 누적시키기		//배열안에 있는 것들을 모두 꺼낼때 쓴다.
			total += totals;
		}
		
		System.out.println("총합 : " + total);
				
	}
}
