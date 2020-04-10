package control;

public class Ex01 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i = 1; i<=100; i++) {
			sum += i;
			System.out.print("["+i+"][" + sum + "] --->");
			System.out.println(sum);
		}
		System.out.println(sum);
	}
}
