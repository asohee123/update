package ex2;

public class HTAException extends RuntimeException{
	
	public HTAException() {		//기본생성자
			
	}
	
	public HTAException(String message) {
		super(message);
	}
	
	public HTAException (Throwable cause) {
		super(cause);
	}
	
	public HTAException(String message, Throwable cause) {
		super(message, cause);
	}
}
