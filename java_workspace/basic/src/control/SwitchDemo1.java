package control;

import java.util.Scanner;

public class SwitchDemo1 {

	public static void main(String[] args) {
		
		/*
		 * switch문
		 * 			조건식과 일치하는 다양한 경우를 간결한 표현으로 처리할 수있다.
		 * shitch(비교값){
		 * 		case 값1:
		 * 				비교값이 값1와 일치하는 경우 실행되는 실행문;
		 * 		case 값2:	
		 * 				비교값이 값2와 일치하는 경우 실행되는 실행문;
		 * 		default:
		 * 				비교값이 제시된ㄱ ㅏㅄ과 일치하는 것이 없을 때 실행되는 수행문;
		 * 		}
		 * 	비교값으로 사용하는 값은 정수, 문자, 문자열만 가능하다.
		 * 	case에 제시된 값 상수 혹은 리터럴 값이어야한다,
		 * 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("등급을 말하세요. : ");
		String grade = sc.next();		
		switch (grade) {
			case "vvip":
		
					System.out.println("vvip 고객님 방문을 환영합니다.");
					System.out.println("오늘은 10분 한정 프리미엄 포도주 증정이 있습니다,.");
						break;
			case "vip":
				System.out.println("vip 고객님 방문을 환영합니다.");	
				System.out.println("오늘은 30분 한정 프리미엄 식기 세트 증정이 있습니다,.");
						break;
			case "classic":
						System.out.println("classic 고객님 방문을 환영합니다.");
						System.out.println("오늘은 10분 한정 프리미엄 포도주 증정이 있습니다,.");
						break;
			default:
				System.out.println("방문 환영");
				System.out.println(" 100분 한정 주차권할인");
						
		}	if (grade.equals("vvip")) {
				System.out.println("vvip 고객님 안형히 가세요");
		} else if (grade.equals("vip")) {
				System.out.println("vip 고객님 안형히 가세요");
		} else if(grade.equals("classic"))  {
				System.out.println("vvip 고객님 안형히 가세요");
		} else { System.out.println("손님 안녕히 가세요.");
		
		}
	}
}


