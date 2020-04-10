package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx1 {

	public static void main(String[] args) {
		
		HashSet<String> names = new HashSet<String>();
		
		names.add("박재형");
		names.add("박소정");
		names.add("박소희");
		
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
		
		int size = names.size();
		System.out.println(size);
		System.out.println();
		
		names.clear();
		System.out.println(names);
		System.out.println();
		
		boolean empty = names.isEmpty();
		
	}
}
