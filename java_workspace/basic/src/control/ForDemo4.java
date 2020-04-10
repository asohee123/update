package control;

public class ForDemo4 {

	public static void main(String[] args) {
		
	
	/*
	 * 1~100까지의 숫자중에서 3의 배수에 해당하는 숫자의 합계를 계산하기
	 */
		
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {		
		if(i%3==0) {
			sum += i;
			}
		}
		System.out.println("3의 배수 합 : " + sum);
	}
}
