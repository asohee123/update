package BankingEx;

public class Banking {

	static final double RATE_OF_INTEREST = 0.021;
	String name;	//이름
	String no;		//계좌번호
	int password;	//비밀번호
	long balance;	//잔액
	int period;		//가입기간
	
	//	입금기능은 입금액을 전달받아서 잔액을 증가시킨다.
	void deposit(long inputMoney) {
		balance += inputMoney;
		System.out.println(inputMoney + "원 입급되었습니다.");
		System.out.println("총 잔고금액 : " + balance);
	}
	
	//	출금기능은 출금액과 비밀번호를 전달받아서 비밀번호가 일치하는 경우
	//	잔액을 출금액 만큼 감소키기고, 출금액에서 수수료(1300원)를 뺀 금액을 반환한다.
	long outputMoney(long inputMoney, long pwd) {
		return 0;
		
	}
	
	//	조회기능은 소유주, 계좌번호, 현재잔액을 화면에 출력한다.
	void display() {
		
	}
	
	//	비밀번호 변경기능은 이전비밀번호와 새비밀번호를 전달받아서
	//	이전 비밀번호가 일치하는 경우에만 비밀번호를새 비밀번호로 바꾼다.
	void changePassword(int oldPwd, int newPwd) {
		
	}
	
	//	해지기능은 비밀번호를 전달받아서 비밀번호가 일치하는 경우에만
	//	계좌를 해지하고, 금리를 적용한 총 해지금액을 반환한다.
	long close(int pwd) {
		return 0;
	}
	
}
