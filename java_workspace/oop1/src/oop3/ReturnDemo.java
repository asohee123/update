package oop3;

import java.util.Arrays;

public class ReturnDemo {

	public static void main(String[] args) {
		
		int[] numbers = {1, 3, 6, 9, 4, 6, 8};
	
		int[] arr1 = multipleArray(numbers, 7);
		System.out.println(Arrays.toString(arr1));
	}
	
	//	전달받은 배열의 값을 n배로 만들어서 반환하는 메소드
	
	static int[] multipleArray(int[] src, int num){
		
		int[] result = new int[src.length];
		
		for(int i = 0; i<src.length; i++) {
			result[i] = src[i]*num;
		}
		
		return null;
	}
	 
}
