package control;

public class WhileDemo5 {

	public static void main(String[] args) {
		
		//1+(-2)+3+(-4)+5+(-6)+7+(-8)+... 몇까지 더해야 총합이 100 이상이 되는지 구하세요
		
		
		int sum = 0;
		
		int num = 1;
		while(true) {
			
			if(num%2==0) {
				sum += num *-1;
			} else {
				sum += num;
			} 
			if(sum>=100) {
				break;
			}
			num++;
		} 
		System.out.println(num);
	}
}
