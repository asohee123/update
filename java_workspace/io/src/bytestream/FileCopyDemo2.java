package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		FileInputStream fis = new FileInputStream("c:/files/sample.txt");
		FileOutputStream fos = new FileOutputStream("c:/files/sampl4.txt");
		
		int value = 0;
		while((value = fis.read()) != -1) {
			fos.write(value);
		}
		fis.close();
		fos.close();
		
	}
}
