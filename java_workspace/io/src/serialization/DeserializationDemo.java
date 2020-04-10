package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		FileInputStream fts = new FileInputStream("c:/files/user.sav");
		ObjectInputStream ois = new ObjectInputStream(fts);
		
		
		//스트림으로 읽어온 직렬화된 객체의 정보를 바탕으로 User객체를 복원한다.
		User user = (User)ois.readObject();
		System.out.println("번호 : " + user.getNo());
		System.out.println("아이디 : " + user.getUserId());
		System.out.println("전화번호 : " + user.getTel());
		System.out.println("패스워드 : " + user.getPassword());
		System.out.println("이메일 : " + user.getEmail());
		
		ois.close();
	}
}
