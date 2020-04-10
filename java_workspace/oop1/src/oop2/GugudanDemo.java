package oop2;

public class GugudanDemo {

	public static void main(String[] args) {
		
		Gugudan gugudan = new Gugudan();
		
//		gugudan.print99dan();{
//		
//			System.out.println("===========2단부터 9단까지=============");
//			for(int i = 1; i<10; i++) {
//				for(int j = 2; j<10; j++) {
//					System.out.print(j	+	"*"	+	i	+	"="	+	(j*i)	+	"\t");
//				}
//				System.out.println();
//			}
//		}
		
		gugudan.print99danByNumber(4);
		
		
		
		
		gugudan.print99danByRange(2, 9);
	}
}
