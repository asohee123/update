package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://imgnews.naver.net/image/311/2013/03/28/1364467257187_59_20130328194501.jpg");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/hansunsu.jpg");
		
		IOUtils.copy(is, fos);
		
		
	}
}
