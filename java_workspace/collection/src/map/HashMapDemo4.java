package map;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo4 {

	public static void main(String[] args) {
		
		ArrayList<String> adderesses = new ArrayList<String>();
		adderesses.add("서울특별시 종로구 봉익동");
		adderesses.add("경기도 수원시 장안구");
		adderesses.add("경기도 수원시 천천구");
		adderesses.add("경기도 수원시 영통구");
		adderesses.add("경기도 수원시 권선구");
		adderesses.add("경상북도 구미시");
		adderesses.add("경상남도 김해시");
		adderesses.add("경상남도 창원시");
		adderesses.add("경상남도 진주시");
		adderesses.add("경상남도 영주시");
		adderesses.add("경상남도 포항시");
		adderesses.add("인천직할시 부평구");
		adderesses.add("경기도 성남시");
		//				key		value
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for(String addr : adderesses) {
			int endPoint = addr.indexOf(" ");
			String sido = addr.substring(0, endPoint);
			
			if(result.containsKey(sido)) {
				int count = result.get(sido);
				result.put(sido, count+1);
			} else {
				result.put(sido, 1);
			}
			System.out.println(result);
		}
	}
}
