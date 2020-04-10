package oop2;
/**
 * 
 * @author JHTA
 *
 */
public class Student {

	String studentName;
	int studentClass;
	int studentNumber;
	int kor;
	int eng;
	int math;
	
	
	/**
	 * 객체의 국어,영어,수학점수를 모두 더해서 총점을 반환해라.
	 */
	int totalScore() {
		int total = kor + eng + math;

		return total;
	}
	
	
	/**
	 * 총점을 과목수로 나눈 평균을 반환하는 메소드
	 */
	int average() {
		int average = totalScore()/3;
		
		return average;
	}
	
	/**
	 * 학생이름, 반, 번호, 국어점수, 영어점수, 수학점수, 총점, 평균을 
	 * 화면에 출력하는 메소드
	 */
	void display() {
		System.out.println("===============학생 정보==========");
		System.out.println("학생이름 : " + studentName);
		System.out.println("학생 반 : " + studentClass);
		System.out.println("학생 번호 : " + studentNumber);
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총	점 : " + totalScore());
		System.out.println("평	균 : " + average());
		System.out.println("================================");
	}
	
}
