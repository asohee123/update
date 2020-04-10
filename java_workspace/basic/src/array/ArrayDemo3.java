package array;

public class ArrayDemo3 {

	//배열의 길이 조회하기
	//		배열이름.length 로 조회만 할 수 있다.
	//		*배열의 길이는 불변이다. 배열의 길이을 변경할 수 없다.
	public static void main(String[] args) {
		
		String[] names = {"이순신", "김유신", "박혁거세"};
		
		//배열의 길이 -> 항상 정수값으로 표현된다.
		int len = names.length;
		System.out.println("배열의 길이 : " + names.length);
		System.out.println("배열의 길이 : " + len);
		
		//배열의 길이를 활용해서 배열의 각 요소값 조회하기
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		
		for(int i = 0; i< names.length; i++) {
		System.out.println(names[i]);	
		}
		
		int[] scores= {80, 50, 67, 52, 77,45,78,21,02,60,8,4,6,49, 87};
		int totalScroe = 0;
		for (int i = 0; i<scores.length; i++){
			System.out.println("점수 : " + scores[i]);
			totalScroe += scores[i];
		}
		System.out.println("총점 : " + totalScroe);
	}
}
