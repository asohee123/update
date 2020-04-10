package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo6 {

	public static void main(String[] args) {
		try {
			ExceptionDemo6.savImage("https://i.ytimg.com/vi/4TwbWwv_kgQ/maxresdefault.jpg");
		} catch (Exception e) {
			System.out.println((e.getMessage()));
		}
	}
		
	
	public static void savImage(String path) throws Exception {
		try {
			URL url = new URL(path);
		
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream("c:/files/van-de-sar.jpg");
		
			byte[] buf = new byte[1024];
			int len = 0;
			while((in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.close();
		
		} catch (FileNotFoundException e) {
			Exception ex = new Exception("파일을 찾을 수 없습니다.");
			//예외 강제 발생시키기, 예외의 변환
			//	예외강제 발생 : throw 키워드 다음에 발생시킬 예외객체를 적는다.
			//	예외의 반환 : 발생된 예외를 가로채고, 다른 예외를 발생시킨다.
			throw ex;

		} catch (MalformedURLException e) {
			Exception ex = new Exception("URL이 올바른 형식이 아닙니다.");
			throw ex;
			
		} catch (IOException e) {
			Exception ex = new Exception("I/O작업 중 오류가 발생하였습니다.");
			throw ex;
			
		}	
	}
}
