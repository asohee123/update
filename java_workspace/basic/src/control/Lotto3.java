package control;

public class Lotto3 {

	public static void main(String[] args) {
		
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		
		for (int i=1; i<=6; i++) {
			int num = (int)(Math.random()*45+1);
			
			if(num == n1 || num == n2 || num == n3 || num == n4 || num == n5 || num == n6) {
				i--;
				} else {
					if (i == 1) {
						n1 = num;
					} else if (i == 2){
						n2 = num;
					} else if (i == 3){
						n3 = num;
					} else if (i == 4){
						n4 = num;
					} else if (i == 5){
						n5 = num;
					} else if (i == 6){
						n6 = num;
					}
				}
			System.out.println(num + "====>" + n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5 + " " + n6);
		}
		System.out.println(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5 + " " + n6);
	}
}