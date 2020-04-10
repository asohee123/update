package oop1;

public class StringDemo1 {

	public static void main(String[] args) {
		
//		String replace(CharSequence old, CharSequence nw) :
//		String replaceAll(String regexp, String replacement) :
//		원본에 있는 글자를 찾아 바꾼다. 원본이 바뀌진않는다.
		String str5 = "중앙HTA학원과 새중앙HTA학원은 별도의 법인이다.";
		String s5 = str5.replace("중앙", "현대");

		System.out.println("원본 문자열 : " + str5);
		System.out.println("중앙이 현대로 바뀐 새문자열 : " + s5);

		String str6 = "010-1111-2222, 010-2222-3333";
		String s6 = str6.replaceAll("\\d{3}", "***");
		System.out.println("숫자를 *로 바꾼 새문자열 : " + s6);
		System.out.println();

		//String[] split(String regexp) : 문자열을 지정된 표현식(혹은 구분문자)으로 자른 새로운 배열을 반환한다.
		String str7 = "S0001,전자공학과,회로이론실습,홍길동,3";
		String[] items = str7.split(",");
		System.out.println("과목코드 : " + items[0]);
		System.out.println("학    과 : " + items[1]);
		System.out.println("과 목 명 : " + items[2]);
		System.out.println("담당교수 : " + items[3]);
		System.out.println("학   점 : " + items[4]);
		System.out.println();

		//boolean contains(CharSequence s) : 문자열에 지정된 문자열이 포함되어 있으면 true를 반환한다.
		//int indexOf(String str) : 문자열에 지정된 문자열이 있으면 그 위치를 반환한다. 없으면 -1을 반환한다. 왼쪽에서 오른쪽으로
		//int lastIndexOf(String str) : 문자열에 지정된 문자열이 마지막으로 등장하는 위치를 반환한다. 없으면 -1을 반환한다. 오른쪽에서 왼쪽으로
		String str8 = "홍길동은 오늘 병원에 갔다. 병원에서 주사를 맞았다.";
		boolean b3 = str8.contains("주사");
		int pos1 = str8.indexOf("병원");
		int pos2 = str8.lastIndexOf("병원");
		System.out.println("문자열에 '주사'를 포함하고 있나? : " + b3);
		System.out.println("문자열에서 '병원'이 처음으로 등장하는 위치 : " + pos1);
		System.out.println("문자열에서 '병원이 마지막으로 등장하는 위치 : " + pos2);
		System.out.println();

		//조건문에서 많이 쓰임
		//boolean isEmpty() : 문자열의 길이가  0이면 true를 반환한다.
		boolean b4 = "안녕하세요".isEmpty();
		boolean b5 = "  ".isEmpty();
		boolean b6 = "			".isEmpty();
		System.out.println("빈 문자열인가요? : " + b4);
		System.out.println("빈 문자열인가요? : " + b5);
		System.out.println("빈 문자열인가요? : " + b6);
		System.out.println();

		//boolean starsWith(String prefix) : 문자열이 지정된 문자열로 시작하면 true를 반환한다.
		//boolean endsWith(String suffix) : 문자열이 지정된 문자열로 끝나면 true로 반환한다.
		boolean b7 = "휴가신청서_홍길동.docx".startsWith("휴가신청서");
		boolean b8 = "휴가신청서_홍길동.docx".startsWith("docx");
		System.out.println("파일명이 휴가신청서로 시작되는가? : " + b7);
		System.out.println("ms워드 파일인가? : " + b8);
		
		//내림차순 오름차순을 정렬할때 사용
		//int compareTo(String other) : 다른 문자열과 사전순서를 기준으로 비교했을떄, 같으면 0, 빠르면 음수, 늦으면 양수를 반환한다.
		int n1 = "이순신".compareTo("김유신");
		int n2 = "이순신".compareTo("이순신");
		int n3 = "이순신".compareTo("허균");
		System.out.println("이순신과 김유신을 비교 : " + n1);
		System.out.println("이순신과 이순신을 비교 :" + n2);
		System.out.println("이순신과 허준을 비교 :" + n3);
		
		//String trim() : 문자열에서 불필요한 좌우공백을 제거한 새로운 문자열을 반환한다.
		String str9 = "           안녕 나는 로봇이야	   ";
		String s7 = str9.trim();
		System.out.println("공백제거 전 : [" + str9 + "]");
		System.out.println("공백제거 후 : [" + s7 + "]");
		
		//String String.valueOf(다양한 값) : 전달받은 값을 문자열로 변환해서 반환한다.
		int num1 = 123456;
		int num2 = 789;
		String b9 =String.valueOf(num1);
		String b10 =String.valueOf(num2);
		System.out.println(num1 + num2);
		System.out.println(b8 + b9);
	}
}
