package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		
		
		try {
		
			FileReader reader = new FileReader("c:/setup.lo`g");
			BufferedReader br = new BufferedReader(reader);
		
			String text = br.readLine();
			System.out.println("파일 내용 : "+text);
		
			} catch (FileNotFoundException e) {							// 자식  부모자식관계일 경우 부모를 밑으로 내려써야함
				System.out.println("파일이 존재하지 않습니다. 파일명을 다시 확인하세요.");				
			} catch (IOException e) {					//  부모  부모자식관계일 경우 부모를 밑으로 내려써야함															
				System.out.println("파일을 읽어오는 도중 오류가 발생하였습니다." );	
			} catch(Exception e) {
				System.out.println("예상하지 못한 오류가 발생하였습니다.");
			}
		
		/*
		 * 	catch() {} 블록을 여러 개 작성해야 하는 경우
		 * 	예외를 catch하는 순서가 중요하다. 부모 클래스가 아래쪽에 위치하게 작성해야 한다.
		 * 	맨 마지막 catch () {} 블록은 Exception 객체를 잡는다.
		 * 	catch () {} 블록에서 Exception을 지정해두면 예쌍하지 못한 예외도
		 * 	해당 catch () {} 에서 잡을 수 있기 때문에 프로그램의 갑작스러운 종료를 방지할 수 있다.
		 */
		
		
	}
}
