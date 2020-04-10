package array;

public class ArrayDemo5 {

	public static void main(String[] args) {
		
		//2차원 배열
		int[][] scores = new int[2][3]; //2행 3열
		//0번행은 이순신의 국,영,수 점수
		scores[0][0] = 60;
		scores[0][1] = 70;
		scores[0][2] = 80;
		//1번행은 김유신의 국,영,수 점수
		scores[1][0] = 50;
		scores[1][1] = 40;
		scores[1][2] = 30;
		
		System.out.println("scores.length : " + scores.length);
		System.out.println("scores.length : " + scores[0].length);
		System.out.println("scores.length : " + scores[1].length);
		
		int total = 0;
		for(int i = 0; i<scores.length; i++) {
			for(int j = 0; j<scores[i].length; j++) {
				System.out.println(i + "," + j + "----->" + scores[i][j]);

			}
		}
		System.out.println("합계 : " + total);
		
		//이순신의 총점
		int total1 = 0;
		for(int i = 0; i<3; i++) {
			System.out.println(scores[0][i]);
			total1 += scores[0][i];
		}
		System.out.println("이순신의 총점 : " + total1);
		
		//김유신의 총점
		int total2 = 0;
		for(int i = 0; i <3; i++) {
			System.out.println(scores[1][i]);
			total2 += scores[1][i];
		}
		System.out.println("김유신의 총점 : " + total2);
		
		
		
		
	}
}
