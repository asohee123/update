package array;

import java.util.Arrays;

public class ArrayDemo15 {

	public static void main(String[] args) {
		
		int[] numbers = {10, 29, 1, 5, 23, 75, 31};
		
		//배열의 값을 오름차순으로 정렬하기
		Arrays.sort(numbers);			//오름차순으로 정리해주는 것
		//배열의 값을 문자열로 변환해서 제공하기
		String text = Arrays.toString(numbers); //==> 텍스트 형식으로 출력하게 해주는것
		
		System.out.println(text);
		
		String[] names = {"이순신", "김유신", "장쥐환", "박종우", "엄씨"};
		Arrays.parallelSort(names);
		System.out.println(Arrays.toString(names));
		
		//배열을 복사 할때 쓰는 것들
//		Arrays.copyOf(original, newLength)		//원본배열, 복사할 값의 갯수 
//		Arrays.copyOfRange(original, from, to)			//원본배열, 복사시작위치, 복사끝위치
		
		numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		int[] arr1 = Arrays.copyOf(numbers, 10);
		int[] arr2 = Arrays.copyOf(numbers, 5);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
		int[] arr3 = Arrays.copyOfRange(numbers, 0, 3);		//range면 0,1,2 만 가져온다. 3번 앞까지 복사한다는 뜻
		int[] arr4 = Arrays.copyOfRange(numbers, 3, 7);
		int[] arr5 = Arrays.copyOfRange(numbers, 0, numbers.length);
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
	}
}
