package oop3;

public class ArgSample {

	//기본 자료형 타입의 값을 매게변수를 전달받는 경우
	void changeValue(int num) {
		
		System.out.println("changeValue()에서의 before num ---> " + num);
		num = 150;
		System.out.println("changeValue()에서의 after num -----> " + num);
	
	}
	
	//참조형 타입의 값을 매개변수로 전달받는 경우
	void changeDataValue(Data data) {
		System.out.println("changeValue()에서의 before data.num ---> " + data.num);
		data.num = 300;
		System.out.println("changeValue()에서의 after data.num -----> " + data.num);
	}
}
