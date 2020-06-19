package semi.util;

public class StringUtil {

	/**
	 * 문자열 값이 null이면 지정된 defaultValue값을 반환한다
	 * @param str null인지 체크할 문자열
	 * @param defaultValue null일때 반환할 기본값
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if(str == null) {
			return defaultValue;
		}
		return str;
	}
	
	/**
	 * 문자열 값이 null이면 ""을 반환한다.
	 * @param str null인지 체크할 문자열
	 * @return
	 */
	public static String nullToBlank(String str) {		
		return nullToValue(str, "");
	}
	
	 
	/**
	 * 문자열의 줄바꿈문자를 &lt:br&gr;로 변환해서 반환한다.
	 * @param text
	 * @return
	 */
	public static String strWithBr(String text) {
		if(text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
}
