package oop2;

public class Calculator {

	int plus(int x, int y) {
		System.out.println("int + int + int의 합계");
		int result1 = x+y;
		return result1;
	}
	
	int plus(int x, int y, int z) {
		System.out.println("double + double의 합계");
		int result2 = x+y+z;
		return result2;
	}
	
	double plus(double x, double y){
		System.out.println("double + double의 합계");
		double result3 = x + y;
	return  result3;
	
	}
	
	long plus(long x, long y) {
		System.out.println("long + long의 합계");
		long result4 = x + y;
		return result4;
		
	}
		

	/*
	 *	메소드 중복정의 규칙 위반
	long plus(long b, long a) {
		long result = x + y;
		return result;
	*/
}
