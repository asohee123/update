'package array;

public class HOLY {

	public static void main(String[] args) {

		//	핸드폰번호 가리기
			      String answer = "01012345678";
			      
			      String[] phone = answer.split("");
				     answer = "";
				     for(int i = 0; i<phone.length-4; i++) {
				    	 phone[i] = "*";
				     }
				     for(int i = 0; i<phone.length; i++) {
				    	 answer += phone[i];
				     }
				     
			      
				     System.out.println(answer);
				     
				    
	}
}
