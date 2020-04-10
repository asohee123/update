package oop1;

public class PersonDemo2 {

	public static void main(String[] args) {
		
		/*
		 * Person 객체를 여러 개 담는 배열을 사용해보기
		 */
		
		//Person객체 3개를 담을 수 있는 배열에 생성해서 people에 대입하기.
		Person[] people = new Person[3];
		
		Person p1 = new Person(); // p1은 Person객체의 주소값을 가지고 있다.
		p1.name = "주몽";
		p1.email = "123@naver.com";
		p1.age = 60;
		
		Person p2 = new Person(); // p1은 Person객체의 주소값을 가지고 있다.
		p2.name = "이순신";
		p2.email = "456@naver.com";
		p2.age = 70;
		
		Person p3 = new Person(); // p1은 Person객체의 주소값을 가지고 있다.
		p3.name = "김유신";
		p3.email = "789@naver.com";
		p3.age = 80;
		
		
		//생성된 각각의 Person객체의 주소값을 배열에 저장하기
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;
		
		
		
		//people 배열에 저장된 모든 Person 객체의 속성 확인하기
		for(int i = 0; i<people.length; i++) {
			Person p = people[i];		// p에는 Person객체의 주소값이 순섲대로 대입된다.
			System.out.println(p.name + "\t" + p.email + "\t" + p.age);
			
			
			
		}
		
		
		
		
		
		
		
		
	}
}
