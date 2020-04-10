package control;

public class StarDemo5 {

	public static void main(String[] args) {
		
		/*              									공백갯수	Math.abs(5-i) -> 절대값으로 나오게 하는 방법
		 				**        i=1 공백=4 별=2				5-1	=  4
				 	   ****       i=2 공백=3 별=4				5-2	=  3
				   	  ******      i=3 공백=2 별=6				5-3	=  2
				     ********     i=4 공백=1 별=8				5-4	=  1
			        **********    i=5 공백=0 별=10			5-5	=  0
			         ********     i=6 공백=1 별=8				5-6	= -1
			          ******      i=7 공백=2 별=6				5-7	= -2
			           ****       i=8 공백=3 별=4				5-8	= -3
			        	**        i=9 공백=4 별=2				5-9	= -4
		*/       
		for(int i=1; i<=9; i++) {
			int space = Math.abs(5-i);
			int star = 10 - space *2;
			
			for(int j=1; j<=space; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=star; k++) {
				System.out.print("*");
			}
			System.out.println();
		
		
		
		
//		for(int i=1; i<=9; i++) {
//			int space = (5-i)>=0 ? (5-i) : (5-i)* -1;
//			int star = 10 - space *2;
//			
//			for(int j=1; j<=space; j++) {
//				System.out.print(" ");
//			}
//			for(int k=1; k<=star; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		
			
			
			
		
//		for(int i=1; i<=9; i++) {
//			int space = 0;
//			if(i<=5) {
//				space = 5-i;
//			} else {
//				space = (5-i) * -1;
//			}
//			int star = 10 - space *2;
//			for(int j=1; j<=space; j++) {
//				System.out.print(" ");
//			}
//			for(int k=1; k<=star; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
		}
	}
}
