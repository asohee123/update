package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo3 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		FileInputStream fis = new FileInputStream("c:/files/star.png");
		FileOutputStream fos = new FileOutputStream("c:/files/star_copy.png");
		
		int value = 0;
		while((value = fis.read()) != -1) {
			fos.write(value);
		}
		
		
		fis.close();
		fos.close();
		
	}
}
