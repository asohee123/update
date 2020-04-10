package bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileOutputStream fos = new FileOutputStream("c:/files/sample.txt");
		
		fos.write('h');
		fos.write('e');
		fos.write('l');
		fos.write('l');
		fos.write('o');
		fos.write(',');
		fos.write(' ');
		fos.write('w');
		fos.write('o');
		fos.write('r');
		fos.write('l');
		fos.write('d');
		
		fos.close();
	}
}
