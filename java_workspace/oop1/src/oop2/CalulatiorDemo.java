package oop2;

public class CalulatiorDemo {

	public static void main(String[] args) {
	
		Calculator calculator = new Calculator();
	
	
	
	int result1 = calculator.plus(6, 8);
	double result2 = calculator.plus(6.9, 8.1);
	long result3 = calculator.plus(60000L, 800000);
	int result4 = calculator.plus(6,7,8);
	
	}
}
