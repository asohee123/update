package semi.util;

import java.text.DecimalFormat;

public class NumberUtil {

	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	
	public static Double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
	
	public static Long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	/**
	 * 정수를 ,가 포함된 통화표현식 문자열로 변환해서 반환한다.
	 * @param number 정수
	 * @return ","가 포함된 문자열
	 */
	public static String numberWithComma(int number) {
		return currencyFormat.format(number);
	}
}
