package opperator;

public class OpDemo5 {

	public static void main(String[] args) {
		
		//비교연산자(이항 연산자)
		// > < >= <= !=
		//비교연산자 조건문과 반복문의 조건식으로 사용된다.
		// 비교 연산자의 연산 결과는 항상 true/false 중 하나다.
		// ==연산자
		//		기본자료형일 때는 변수에 저장된 값을 비교한다.
		//		참조자료형일 때는 변수에 저장된 주소값을 비교한다.
		//		*참조자려형일 때 == 연산자는 쓸모없음.
		int num1 = 20;
		int num2 = 30;

		boolean result1 = num1 > num2;
		boolean result2 = num1 < num2;
		boolean result3 = num1 >= num2;
		boolean result4 = num1 <= num2;
		boolean result5 = num1 == num2;
		boolean result6 = num1 != num2;
		
//		boolean result5 = num1 == num2;  연산자의 우선수위에 대한 가독성이 좋지않다.
//		boolean result6 = (num1 != num2);  연산자의 우선수위에 대한 가독성이 좋다.
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println("두수가 동일한가? : " + result5);
		System.out.println("두수가 동일하지않는가? : " + result6);
		
	}
	
}
