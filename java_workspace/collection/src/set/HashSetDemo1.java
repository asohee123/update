package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {

	public static void main(String[] args) {
		
		HashSet<String> names = new HashSet<String>();
		names.add("홍길동");
		names.add("홍길동");  //오류 x, 하지만 객체의 중복을 허용하지않기 떄문에 실행 x
		names.add("홍길동");  //오류 x, 하지만 객체의 중복을 허용하지않기 떄문에 실행 x
		names.add("김유신");
		names.add("박혁거세");
		names.add("세종");
		names.add("정조");
		names.add("태조");

		//꺼내기
		//Enhanced-for문
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		Iterator<String> name = names.iterator();
		while(name.hasNext()) {
			String data = name.next();
			System.out.println(data);
		}
		System.out.println();
		
		//저장된 객체의 갯수 조회
		int size = names.size();
		System.out.println("저장된 객체의 갯수 : " + size);
		System.out.println();
		
		//전부 지우는것
		names.clear();
		System.out.println("객체 삭제 완료" + names);
		
		//비어있는지 확인
		boolean empty = names.isEmpty();
		System.out.println("비어있는가? : " + empty);
		
		System.out.println();
		
		System.out.println(names);
	}
}
