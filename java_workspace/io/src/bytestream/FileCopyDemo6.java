package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		FileInputStream fis = new FileInputStream("c:/files/network.hwp");
		FileOutputStream fos = new FileOutputStream("c:/files/network_copy2.hwp");
		
		IOUtils.copy(fis, fos);
		
	}
}
