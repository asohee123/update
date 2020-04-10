package opperator;

public class OpDemo1 {
	
	public static void main(String[] args) {
		
		// 증감 연산자(단항 연산자).
		// ++ --
		// ++피연산자의 값을 1 증가시킨다.
		// --피연산자의 값을 1 감소시킨다.
		
		int a = 10;
		a++;
		System.out.println(a);
		
		a++;
		System.out.println(a);
		
		int b = 20;
		++b;
		System.out.println(b);
		++b;
		System.out.println(b);
		
		
		int c = 10;
		c--;
		System.out.println(c);
		c--;
		System.out.println(c);
		
		int d = 20;
		--d;
		System.out.println(d);
		--d;
		System.out.println(d);
		
		// 리터널로 표시된 값은 상수값이기 때문에 증감연산자로 변경시킬 수 없다.
		//System.out.println(6++);		문법오류
		

		
	}

}
