package array;

public class ArrayDemo1 {

	public static void main(String[] args) {
		
		/*
		 * 	배열 - 같은 타입의 값을 여러 개 저장할 수 있는 변수의 묶음이다.
		 * 	배열의 생성 - 정수 5개를 저장하는 배열 생성해서 참조변수에 담기
		 * 				int[] numbers = new int[5];
		 * 					-> 생성된 배열 => [0, 0, 0, 0, 0]
		 * 				int[] number = {10, 40, 20, 70, 40}; ->배열 리터럴 이라 부른다.
		 * 					-> 생성된 배열 => [10, 40, 20, 70, 40]
		 * 				int[] number = new int[]{10, 20, 30, 40, 50};
		 * 					-> 생성된 배열 => [10, 20, 30, 40, 50]
		 * 
		 * -배열을 생성할 때 배열의 길이만 지정해서 배열을 생성하면 
		 * 	배열의 각 요소는 해당 데이터타입의 기본값으로 초기화되어 있다.
		 * 		*기본 데이터 타입별 기본값
		 * 			-정수 (byte, short, int, long) -> 0
		 * 			-실수 (float, double) -> 0.0
		 * 			-문자 (char) -> \n0000
		 * 			-논리(boolean) -> false
		 * 
		 * 		*참조 데이터타입 기본값
		 * 			-기본 데이터타입을 제외한 모든 데이터타입의 기본값은 null이다.
		 * 				모든 참조타입의 변수에 null값을 대입할 수 있다.
		 * 				null은 참조변수가 객체를 더 이상 참조하지 못하게  하는 값이다.
		 * 
		 */
		
		//정수형 배열
		int[] numbers1 = new int[3];
		System.out.println("0번째 정수 : " + numbers1[0]);
		System.out.println("1번째 정수 : " + numbers1[1]);
		System.out.println("2번째 정수 : " + numbers1[2]);
		
		//실수형 배열
		double[] numbers2 = new double[3];
		System.out.println("0번째 실수 : " + numbers2[0]);
		System.out.println("1번째 실수 : " + numbers2[1]);
		System.out.println("2번째 실수 : " + numbers2[2]);
		
		//String형 배열
		String[] words = new String[3];
		System.out.println("0번째 문자열 : " + words[0]);
		System.out.println("1번째 문자열 : " + words[1]);
		System.out.println("2번째 문자열 : " + words[2]);
		
		
		
		//정수형 배열
		int[] scores = {10, 40, 100};
		System.out.println("0번째 정수 : " + scores[0]);
		System.out.println("1번째 정수 : " + scores[1]);
		System.out.println("2번째 정수 : " + scores[2]);
		
		//실수형 배열
		double[] rates = {0.05, 0.001, 0.005};
		System.out.println("0번째 실수 : " + rates[0]);
		System.out.println("1번째 실수 : " + rates[1]);
		System.out.println("2번째 실수 : " + rates[2]);
		
		
		//String형 배열
		String[] str = {"홍길동", "김유신", "주몽"};
		System.out.println("0번째 문자열 : " + str[0]);
		System.out.println("1번째 문자열 : " + str[1]);
		System.out.println("2번째 문자열 : " + str[2]);
	}
}
