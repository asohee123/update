package control;

public class ContinueDemo1 {

	public static void main(String[] args) {
		
		/*	continue문
		 *	반복문안에 있는 수행문을 실행하다가 continue가 실행되면 남아있는 
		 *	수행문의 실행을 취소하고 증감식으로 이동해서 다음 번 반복을 하러 간다.
		 */

//		for (int i = 1; i <= 10; i++) {
//			if (i%3 == 0) {
//			System.out.println(i);
//			}
//			//반대로 3,6,9만 나오게하고 싶을때 이렇게
			
			
		for (int i = 1; i <= 10; i++) {
			if (i%3 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
}
