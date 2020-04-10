package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		//sample.txt를 읽어오는 스트림
		FileInputStream fis = new FileInputStream("c:/files/sample.txt");
		//sample2.txt 파일에 기록하는 스트림
		FileOutputStream fos = new FileOutputStream("c:/files/sample2.txt");
		
		int value1 = fis.read();
		fos.write(value1);
		int value2 = fis.read();
		fos.write(value2);
		int value3 = fis.read();
		fos.write(value3);
		int value4 = fis.read();
		fos.write(value4);
		int value5 = fis.read();
		fos.write(value5);
		
		fis.close();
		fos.close();
	}
}
