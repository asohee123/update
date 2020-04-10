package datatype;

public class DataTypeDemo8 {
	
	public static void main(String[] args) {
		
		/*
		 * 반지름의 길이가 5, 10, 20인 원들이 있다.
		 * 각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
		 * 넓이는 3.14 * 반지름 * 반지름 둘레길이는 2 * 3.14 * 반지름
		 */
		
		int radius1 = 5;
		int radius2 = 10;
		int radius3 = 20;
		
		double total1 = Math.PI * radius1 * radius1;
		double total2 = 2 * Math.PI * radius1;
		
		System.out.println("5 넓이 : " +total1);
		System.out.println("5 둘레 : " +total2);
		
		double total3 = Math.PI * radius2 * radius2;
		double total4 = 2 * Math.PI * radius2;
		
		System.out.println("10 넓이 : " +total3);
		System.out.println("10 둘레 : " +total4);
		
		double total5 = Math.PI * radius3 * radius3;
		double total6 = 2 * Math.PI * radius3;
		
		System.out.println("20 넓이 : " +total5);
		System.out.println("20 둘레 : " +total6);
		
		
		
	}

}
