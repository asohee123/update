package oop4;

public class BookDemo {

	public static void main(String[] args) {
		
		Book book1 = new Book();					//첫번째 생성자 메소드 이용
		book1.title = "자바의 정석";
		book1.writer = "남 궁 섬";
		book1.price = 30000;
		book1.genre = "기술/컴퓨터";
		book1.printBookInfo();
		
		Book book2 = new Book("처음 만나는 머신러닝", "오다카 토모히로",18000, "기술/컴퓨터");					
		//두번째 생성자 메소드 이용
		book2.printBookInfo();
		
		Book book3 = new Book("파이썬 실전 프로그래밍", "최지식", "좋은 땅", 25600, "기술/컴퓨터");
		book3.printBookInfo();
	}
}
