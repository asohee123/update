package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		//오류 : 타입파라미터<E>에는 클래스명,인터페이스 명이 정의되어야 한다.
		//		int, long, double는 자바의 키워드다. 클래스명이 아니다.
		//ArrayList<int> number = new ArrayList<int>(); 
		//ArrayList<long> number = new ArrayList<long>(); 
		//ArrayList<double> number = new ArrayList<double>(); 
		
		//기본자료형에 대응되는 wrapper 클래스를 타입파리미터로 지정한다.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
		
		
		//정수가 한개만 담기는 일은 거의 없다.
		numbers.add(new Integer(10));
		//오토박싱
		numbers.add(10);				//실제로 실행되는 코드 : numbers.add(new Integer(10));		
		
		currencies.add(new Long(10000000000L));
		//오토박싱
		currencies.add(10000000000L);	//실제로 실행되는 코드 : currencies.add(new Long(10000000000L));
		
		scores.add(new Double(4.2));
		//오토박싱
		scores.add(4.2);				//실제로 실행되는 코드 : scores.add(new Double(4.2));
		
		for(Integer num : numbers) {
			System.out.println(num);
		}
		System.out.println();
		for(int num : numbers) {		// 반복될 떄 마다 Integer 객체가 꺼내진다 -> 언박싱되어서 숫자만 num에 대입
			System.out.println(num);
		}
		
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		System.out.println();
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();		// itr.next() -> Long 객체 변환 -> 언박싱되어서 숫자만 curr에 대입
			System.out.println(curr);
		}
		
		
		
		
		//*오톡박싱* - wrapper클래스에 한에서 사용
		//기본자료형값을 변수에 대입하거나, 매개변수로 전달할 때
		//변수의 타입이 int이면 정수값이 전달된다.
		//변수의 타입이 Integer 혹은 Object라면 그 정수값을 담은 Integer객체가 자동으로 생성된다.
		//
		//	void m1(int no){ ... }			m1(10);
		//	void m2(Integer no){ ... }		m2(10); -> me(new Integer(10))
		//
		//	double d1 = 3.14;
		//	Double d2 = 3.14;		->		Double d2 = new Double(3.14);
		//
		//	ArrayList<Long> currency = new ArrayList<Long>();
		//	currency.add(10000000L);	-> currency.add(new Long(10000000L));
		
		/*	오토 언박싱(Auto-Unboxing) -> 값을 꺼낼때 사용
		 *		Wrapper객체를 변수에 대입하거나, 매개변수로 전달할 때
		 *		변수의 타입이 기본자료형타입이면 자동으로 wrapoer객체에 저장된 기본자료형값만 대입된다.
		 *
		 *	Double x = new Double(3.14);		//오토-언박싱 지원으로 실제 실행되는 코드
		 * 	double y = x					->	double y = x.doubleValue();
		 * 
		 *  Integer x = new Integer(100);	//오토-언박싱 지원으로 실제 실행되는 코드
		 *  int y = x;					->	int y = x.intValue();
		 *  
		 *  Long x = new Long(10000000L);	//오토-언박싱 지원으로 실제 실행되는 코드
		 *  long y = x;					->	long y = x.longValue();
		 *  
		 *  ArrayList<Integer> scores = new ArrayList<Integer>();
		 *  scores.add(new Integer(100));
		 *  scores.add(98);
		 *  scores.add(68);
		 *  
		 *  						<-	둘다 써도 됨	->
		 *  for(Integer s : scores) {				for(int s : scores){
		 *  																
		 *  }										}
		 */
	}
}
