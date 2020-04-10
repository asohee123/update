package sort;

import java.util.ArrayList;

import java.util.Collections;

public class SortDemo4 {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact(1, "류관순", "010-1111-2222", "si@naver.com"));
		contacts.add(new Contact(2, "이관순", "010-1234-2345", "jin@naver.com"));
		contacts.add(new Contact(3, "박관순", "010-6879-0987", "ping@naver.com"));
		contacts.add(new Contact(4, "김관순", "010-3333-7775", "bo@naver.com"));
		contacts.add(new Contact(5, "호관순", "010-1211-0636", "om@naver.com"));
		
		Collections.sort(contacts);
		
		for(Contact c : contacts) {
			System.out.println(c.getNo()+ c.getName()+ c.getTel() + c.getEmail());
		}
		
		
	}
}
