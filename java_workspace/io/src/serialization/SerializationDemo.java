package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		User user = new User();
		user.setNo(100);
		user.setUserId("hong");
		user.setPassword("123456789");
		user.setTel("010-7520-0636");
		user.setEmail("asohee123@naver.com");
		
		UserGrade userGreade = new UserGrade();
		userGreade.setGrade("VIP");
		userGreade.setPoint(24000);

		user.setGrade(userGreade);
		
		FileOutputStream fos = new FileOutputStream("c:/files/user.sav");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// user참조변수가 참조하는 객체를 스트림으로 전송가능한 상태로 만들어서
		// 연결된 FileOutputStream으로 보낸다.
		// FileOutputStream은 user.sav 파일로 출력한다.
		oos.writeObject(user);
		
		oos.close();
		
	}
}
