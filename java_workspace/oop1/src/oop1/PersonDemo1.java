package oop1;

public class PersonDemo1 {

	public static void main(String[] args) {
		
		//person 객체 만들기
		//person p1 = Person 설계도로 생성된 객체의 주소값을 담는 p1변수를 생성함
		
		//new Person() = Person 설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을 반환함
		
		//Person p1 = new Person();	=	Person 설계도로 메모리에 객체를 생성하고, 
		//								생성된 객체의 주소값을 Person타입의 변수 p1에 대입한다.
		
		Person p1 = new Person(); // new => 객체 생성 , 생성된 객체의 주소값을 변수에 대입
		Person p2 = new Person();
		Person p3 = new Person();
		
		//p1이 참조하는 객체의 속성을 변경하기
		p1.name = "장쥐환";
		p1.tel = "010-1234-5678";
		p1.email = "asohee123@naver.com";
		p1.gender = "남자";
		p1.age = 28;
		
		p2.name = "박종우";
		p2.tel = "010-9876-5432";
		p2.email = "konapa@naver.com";
		p2.gender = "남자";
		p2.age = 27;
		
		p3.name = "엄준식";
		p3.tel = "010-9876-5432";
		p3.email = "konapa123@naver.com";
		p3.gender = "남자";
		p3.age = 29;
		
		
		
		
		
		
	}
	
}
