package date1;

import java.util.Calendar;

public class CalendarDemo1 {

	public static void main(String[] args) {
		
		Calendar cal  = Calendar.getInstance();
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		int yoil = cal.get(Calendar.DAY_OF_WEEK);//1~7 1: 이료일
		System.out.println("년 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + day);
		System.out.println("시 : " + hour);
		System.out.println("분 : " +  minute );
		System.out.println("초 : " + second);
		System.out.println("요일 : " + yoil);
		
		
	}
}
