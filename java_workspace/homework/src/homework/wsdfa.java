package homework;

import java.util.Scanner;

public class wsdfa {

	 public boolean solution(String s) {
		
		char tmp;
		boolean output = true;
		
		for(int i=0; i<s.length(); i++) {
			
			tmp = s.charAt(i);
			
			if(Character.isDigit(tmp) == false) {
				
				output = false;
				
			} 
			
		}
		return output;
		
	}
}
