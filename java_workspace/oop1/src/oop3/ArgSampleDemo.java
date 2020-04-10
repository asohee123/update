package oop3;

public class ArgSampleDemo {
	public static void main(String[] args) {
		
		ArgSample sample = new ArgSample();
		
		int num = 100;
		
		//기본자료형 변수가 가지고 있는 값을 메소드 호출 시 전달하는 경우
		System.out.println("main()에서 changeValue() 수행 전 num -----> " +  num);
		sample.changeValue(num);		//<---num변수가 가지고 있는 값을 전달
		System.out.println("main()에서 changeValue() 수행 전 num -----> " +  num);
		
		
		//참조형 변수가 가지고 있는 주소값을 메소드 호출시 전달한 경우
		Data data = new Data();
		data.num = 200;
		
		System.out.println("main()에서 changeDataValue() 수행 전 num -----> " +  data.num);
		sample.changeDataValue(data);		//<----data변수가 가지고 있는 주소값을 전달
		System.out.println("main()에서 changeDataValue() 수행 전 num -----> " +  data.num);
	}
}
