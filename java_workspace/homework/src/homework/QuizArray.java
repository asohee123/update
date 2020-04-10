package homework;

import java.util.Scanner;

public class QuizArray {

	public static void main(String[] args) {
		
		String[] OXQuiz = new String[10];
		
		Scanner scanner = new Scanner(System.in);
		
		int userScore = 0;
		int sum = 0;
		
		while(true) {
			
			for(int i = 0; i<OXQuiz.length; i++) {
				System.out.print("O,X 중 하나를 입력하세요 : ");
				String userSelcet = scanner.next();
			
				int comSelcetInt = (int)(Math.random()*2+1);
				String comSelcet = null;
			
				if(comSelcetInt == 1) {
					System.out.println("O 입니다.");
					comSelcet = "O";
				} else if(comSelcetInt == 2) {
					System.out.println("X 입니다.");
					comSelcet = "X";
				}
			
				if(userSelcet.equals(comSelcet)) {
					System.out.println("정답입니다.");
					userScore++;
					sum += userScore;
				} else {
					System.out.println("틀렸습니다.");
					userScore = 0;
				}
			
			System.out.println("점수 : " + userScore);
			
			}
			System.out.println("합계 : " + sum);
			break;
		}
	}
	
}
