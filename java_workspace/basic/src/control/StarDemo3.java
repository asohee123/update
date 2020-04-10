package control;

public class StarDemo3 {

	public static void main(String[] args) {
		
		/*
				  **  i=1 공백 8 별 2
				****  i=2 공백 6 별 4
			  ******  i=3 공백 4 별 6
			********  i=4 공백 2 별 8
		  **********  i=5 공백 0 별 10
		 */
		
		for(int i=1; i<=5; i++) {
			//공백출력
			for(int j=1; j<=10-i*2; j++) {
				
				System.out.print(" ");
			}
			
			//별출력
			for(int k=1; k<=i*2; k++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
	
}
