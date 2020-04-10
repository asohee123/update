package oop1;

public class NumberDemo1 {

	public static void main(String[] args) {
		
		double num1 = 0.1;
		double num2 = 0.2;
		
		//실수를 계산할때 정수로 만들고 하는게 좋다.
		//실수끼리의 연산 결과는 정확한 값이 나오지 않을 수 있다.
		System.out.println(num1 + num2);				//0.30000000000000004
		//실수끼리의 연산은 적절한 10^n 값을 곱해서 연산한 후 10^n값으로 나눈다.
		System.out.println((num1*10 + num2*10)/10);		
	}
}
