package date1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {

	public static void main(String[] args) {
		/*
		 * Date를 지정된 형식의 문자열로 변환하기
		 */
		Date today = new Date();
		
		SimpleDateFormat df =  new SimpleDateFormat("M");
		String formatedDateText = df.format(today);
		
		System.out.println(formatedDateText);
	
	}
/*
 * 패턴							출력내용						
 * ---------------------------------------------------------------------------------
 * yyyy							2020(년)				
 * MM							04(월)				1~9까지 01, 02, 03, .... ,09 로 표현
 * M							4
 * dd							06
 * d							6
 * yyyy-MM-dd					2020-04-06
 * yyyy-M-d						2020-4-6
 * yyyy년M월d일					2020년 4월 6일			
 * E							월
 * EEEE							월요일
 * a							오전/오후
 * HH							24(시간 0부터 23시까지 표현)
 * H
 * hh							12(시간 1부터 12까지 표현)
 * h
 * mm							0~59분
 * m
 * ss							0~59초
 * s
 * 
 * 
 */
	
}



