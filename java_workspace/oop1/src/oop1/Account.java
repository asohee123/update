package oop1;

public class Account {

	//클래스 변수 - 상수
	static final double RATE_OF_INTEREST = 0.021; //-> 상수는 모든 글자를 대문자로 작성하고 합성어일 경우 _를 붙힌다.
	
	// 멤버 변수
	String owner;	//예금주
	String no;		//계좌번호
	String password;//비밀번호
	int balance;	//잔액
	int period;		//예금기간(개월단위)
}
