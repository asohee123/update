package characterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo1 {

	public static void main(String[] args) throws IOException{
		
		//txt파일을 읽으려할때는 무조건 이것을 써야한다
		FileReader fr = new FileReader("c:/files/데이터.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int totalOrder = 0;
		String text = null;
		while((text = br.readLine()) != null) {
			if(!text.isEmpty()) {
				String[] items = text.split(",");
				System.out.println(items[4]);
				int price = Integer.parseInt(items[4]); // "28000" -> 28000
				//parseInt => 문자열을 숫자로 바꿔주는 문장
				totalOrder += price;
				
			}
		}
		System.out.println("총 금액 : " + totalOrder);
		br.close();
	}
}