package datatype;

public class DataTypeDemo4 {

	public static void main(String[] args) {
		
		//리터널 : 코드에 직접 값을 표시하는 것
		// 값의 종류에 따라서 표기법이 정해져 있다.

		//논리값 리터널 true   false
		//정수값 리터널 1 10 0 -3 1_000__000 20000000000L
		//실수값 리터널 3.14 3.0 3. -5.04 3.14F 3.14f
		//문자 리터널 'A', '1', '잉', '\n', '\b', '\t', '\u0042' -> 유니코드를 표시한것
		//문자열 리터널 "안녕하세요",  "서울특별시 종로수 \n디아망빌딩 \n401호 \nL2강의실" 
		
		
/*		자바의 기본자료형
 		
 		논리값 타입 bloon false
 		정수값 타입 byte short long int
 		실수값 타입 double float
 		문자   타입 char
 		
 		문자열 전용 String -> 기본자료형 아님
 */
		
		//각 리너털별 변수 사용하기
		//논리값 다루기   true 와 false 는 참/거짓 논리값을 나타내는 자바의 예약어.
		boolean soldOut = true;
		boolean passed = false;
		System.out.println(soldOut);
		System.out.println(passed);
		System.out.println("true"); // 논리값이 아닌 문자열값
		
		//정수값 다루기
		byte num1 = 100;
		short num2 = 30000;
		int num3 = 1000000;
		long num4 = 10000000;
//		byte num5 = 232;				byte값의 범위를 초과하기 때문에 오류
//		int num6 = 3000000000;			int값의 범위를 초과하기 때문에 오류
//		long num7 = 3000000000;			int값의 범위를 초과하는 값을 long에 대입할 떄 리터널에 L을 붙인다.
//		대표적인 정수값은 int이기 때문에 long을 쓸 때에는 뒤에 L을 붙혀준다.
		long num7 = 3000000000L;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num7);
		
		int num8 = 012;			//8진수12가 저장된다
		int num9 = 0x12;		//16진수 12가 저장된다
		int num10 = 0xA4;
		System.out.println(num8);
		System.out.println(num9);
		System.out.println(num10);
		
		//실수값 다루기
		float value1 = 3.14F; //실수 리터널은 double타입으로 정의해야한다. float타입으로 나태내고 싶으면 f를 붙이면 된다.
		double value2 = 3.14;
		
		System.out.println(value1);
		System.out.println(value2);
		
		
		//문  자 다루기
		char ch1 = 'A';				//문자 A를 대입한다.
		char ch2 = '\u0041';		//유니코드표에서 0041코드에 해당하는 문자를 대입한다.
		char ch3 = 65;				//아스키코드표에서 65번에 해당하는 문자를 대입한다.
		System.out.println(ch1); 
		System.out.println(ch2);
		System.out.println(ch3);
		
		//문자열 다루기
		//문자열은 0개 이상의 문자들이 나열되어 있는 것
		String str1 = "A";
		String str2 = "네모링~";
		String str3 = "말대꾸하지마!!";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
		/*
		  자료형
		  
		  기본형 primitive type
		  
		  boolean, byte, short, long, int, float, double, chaer			8가지
		  
		  
		  참조형+ referene type
		  객체의 주소를 저장, 기본형 8가지를 제외한 나머지 타입.
		  
		  클래스이름과 상수는 대문자로 시작한다.
		
		  순서가 있는건 list
		  		없는건 set
		 */
		
		
		
	}
	
}
