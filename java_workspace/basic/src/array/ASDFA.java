package array;

public class ASDFA {

	public static void main(String[] args) {
		
		String answer = "01075200636";
		
		StringBuilder builder = new StringBuilder(answer);
		
		for(int i = 0; i < builder.length()-4; i++) {
			
			builder.setCharAt(i, '*');
			
		}
		
		answer = builder.toString();
		
		System.out.println(answer);
		
	}
}
