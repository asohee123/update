package control;

public class IfDemo1 {

	public static void main(String[] args) {
		
		/*
		 *  If문
		 *  	-제시된 조건식에 연산결과에 따라서 특정 수행문의 실행여부를 결정한다.
		 *  	-if (조건식) {
		 *  					조건식의 연산결과가 true로 판정 될 떄 실행될 수행문
		 * 						조건식의 연산결과가 true로 판정 될 떄 실행될 수행문
		 * 						조건식의 연산결과가 true로 판정 될 떄 실행될 수행문 
		 *  		}
		 *  
		 *  if ~ else 문
		 *  	-if(조건식) {
		 *  					조건식의 연산결과가 true로 판정 될 떄 실행될 수행문
		 *  					조건식의 연산결과가 true로 판정 될 떄 실행될 수행문
		 *  					조건식의 연산결과가 true로 판정 될 떄 실행될 수행문
		 *  		} else {
		 *  					조건식의 연산결과가 false로 판정 될 떄 실행될 수행문
		 *  					조건식의 연산결과가 false로 판정 될 떄 실행될 수행문
		 *  					조건식의 연산결과가 false로 판정 될 떄 실행될 수행문
		 *  		}
		 */			
		
		
		
		
//		int score = 96;
//		
//		if(score > 70) {
//			
//			System.out.println("합격");
//			
//		} else {
//			System.out.println("불합격");
//		}
//		
//		System.out.println("감사합니다");
//		
		//시험성적 60점 이상만 합격이라고 표시하기;
		int stuA = 61;
		
		if ( stuA >= 60 ) {
			
			System.out.println("합격!");
			
		}
		
		
		//사용자의 접근권한이 관리자인 경우 " 접근허용 " 그 외는 "접근거부"라고 표시하기
		String userRole = "관리자";
		
		if (userRole.equals("관리자")) {
			
			System.out.println("접근허용");
			
		} else {
			
			System.out.println("접근거부");
			
		}
		
	}
	
}
