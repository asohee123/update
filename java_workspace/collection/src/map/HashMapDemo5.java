package map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo5 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("서울", 25);
		result.put("대구", 4);
		result.put("울산", 19);
		result.put("부산", 20);
		result.put("인천", 16);
		result.put("경남", 27);
		result.put("경북", 2);
		
		//HashMap의 모든 key를 조회하기
		Set<String> keys = result.keySet();
		for(String key : keys) {
			int count = result.get(key);
			System.out.println("["+key+"]" + count);
			
		}
		System.out.println();
		
		//HashMap의 모든 Entry를 조회하기
		Set<Entry<String, Integer>> entries = result.entrySet();
		for(Entry<String, Integer> entry:entries) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("["+key+"]" + value);
		}
		
	}
}
