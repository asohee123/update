package control;

public class IfDemo1Ex {

	public static void main(String[] args) {
		
		//시험성적 60점 이상만 합격이라고 표시하기;
//		int score = 50;
//		
//		if(score >= 60) {
//			System.out.println("합격입니다.");
//		}else { 
//			System.out.println("불합격입니다.");
//		}
		
		//사용자의 접근권한이 관리자인 경우 " 접근허용 " 그 외는 "접근거부"라고 표시하기
		String name = "관리자";
		if (name == "관리자") {
			System.out.println("접근허용");
		} else {
			System.out.println("접근불가");
		}
		
	}
	
}
