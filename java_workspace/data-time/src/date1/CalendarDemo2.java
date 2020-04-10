package date1;

import java.util.Calendar;

public class CalendarDemo2 {

	public static void main(String[] args) {
		
		//특정날짜의 캘린더 객체 만들기
		Calendar date1 = Calendar.getInstance();
		//2019년 4월 11일
		date1.set(2019, 3, 11);
		System.out.println(toString(date1));
	
		//3일전 날짜 구하기
		Calendar date2 = Calendar.getInstance();
		date2.add(Calendar.DATE, -3);
		System.out.println(toString(date2));
		//7일전 날짜 구하기
		Calendar date3 = Calendar.getInstance();
		date3.add(Calendar.DATE, -7);
		System.out.println(toString(date3));
		
		Calendar date4 = Calendar.getInstance();
		date4.add(Calendar.MONTH, -3);
		System.out.println(toString(date4));
		
	}
	
	
	
	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 "
				+ (date.get(Calendar.MONTH) + 1) + "월"
				+ date.get(Calendar.DAY_OF_MONTH) + "일";
		
//		Date 
//				
//		주요생성자
//			new Date()			현재날짜와 시간정보를 포함하는 객체 생성
//			new Date(long)		전달받은 유닉스타임에 해당하는 날짜/시간정보를 포함하는 객체 생성
//			
//		주요 메소드
//		long getTime()			유닉스타임으로 반환
//		boolean before(Date when)		when으로 전달받은 날짜보다 이전날짜이면 true반환
//		boolean affer(Date when)		when으로 전달받은 날짜보다 이후 날짜이면 true반환
//		
//		SimpleDateFormat
//			날짜를 지정된 형식의 텍스트로 변환
//			String format(Date day)
//		
//			지정된 형식의 텍스트를 날짜로 변환
//			Date pares(String text)
//		
//		DecimalFormat	
//			숫자를 지정한 형식의 텍스트로 변환
//			String format(double number)
//			String format(long number)
//		
//			지정된 형식의 텍스트를 숫자로 변환		
//			number format(String text)
//		
//		
//		
	}
	
}
