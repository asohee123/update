package map;

import java.util.HashMap;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		HashMap<String, String> contacts = new HashMap<String, String>();
		
		//HashMap객체에 key/value쌍으로 저장하기
		contacts.put("lee", "리");	//닉네임, 실제데이터
		contacts.put("jae", "재");	//닉네임, 실제데이터
		contacts.put("su", "수");	//닉네임, 실제데이터
		contacts.put("ji", "지");	//닉네임, 실제데이터
		contacts.put("park", "박");	//닉네임, 실제데이터
		
		
		//HashMap 객체에 저장된 값 조회하기
		String value = contacts.get("jae");
		System.out.println("키[hong]으로 조회한 값 : " + value);
		
		
		//HashMap객체에 key가 이미 존재하는지 확인하기
		boolean exist = contacts.containsKey("ji");
		
		System.out.println("키[ji]가 존재하는가?" + exist);
		
		//HashMap 객체에 ㅓ장된 entry(키/값의 쌍)의 갯수 조회하기
		int size = contacts.size();
		System.out.println("HashMap객체에 저장된 Entry의 총 갯수 : " + size);
		
		//HashMap 객체에 저장된 betry 삭제하기
		 contacts.remove("ji");
		 
		 System.out.println(contacts);
		 
		 //HashMap에 저장된 모든 Entry 삭제하기
		 contacts.clear();
		 
		 System.out.println(contacts);
	}
}
