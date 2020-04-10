package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo4 {

	public static void main(String[] args) {
		
		try { 
			URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/PSG-Shakhter15_%2812%29.jpg/200px-PSG-Shakhter15_%2812%29.jpg");
			InputStream in = url.openStream();
			
			FileOutputStream out = new FileOutputStream("c:/fis/star.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len=in.read(buf)) != -1) {
				out.write(buf, 0, len);
			
			}
			out.close();
			
		} catch (MalformedURLException e) {
			//e.printStackTrace();
//			String errorMessage = e.getMessage();
//			System.out.println("에러 메세지 : " + errorMessage);

		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : " + errorMessage);
			
		} catch (IOException e) {
			//e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : " + errorMessage);
			
		}
	}
}
