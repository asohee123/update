package sort;

public class Contact implements Comparable<Contact>{
		
	private int no;
	private String name;
	private String tel;
	private String email;
	
	public Contact() {}

	public Contact(int no, String name, String tel, String email) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	/*
//	 * 이 객체와 다른 Contact를 비교하는  메소드를 재정의 한다.
//	 * 		번호(no)를 기준으로 비교하는 경우
//	 * 			이 객체의 번호가 다른 객체의 번호보다 크면 0보다 큰 값을 반환하자
//	 * 			이 객체의 번호와 다른 객체의 번호가 같으면 0을 반환하자
//	 * 			이 객체의 번호가 다른 객체의 번호보다 작으면 0보다 작은 값을 반환하자
	
//				번호는 정수값이다. 이 객체의 번호와 다른 Contact객체의 번호를 빼기 연산하면 된다.
//	 */
	
//	@Override
//	public int compareTo(Contact other) {
//		// TODO Auto-generated method stub
//		return this.no - other.no;
//	}  -> 번호를 기준으로 만드는 것
	
	/*
	 * 객체와 다른 Contact를 비교하는 메소드를 재정의한다.
	 * 		이름(name)을 기준으로 비교하는 경우
	 * 
	 * 		이름은 문자열이다. 
	 * 		String에는 다른 String과 비교하는 compareTo(String o)가 이미 구현되어 있다.
	 *		String에 구현된 compareTo(String o)를 사용해서
	 *		이 객체의 이름과 다른 Contact 객체의 이름을 비교하면 된다. 
	 */
	@Override
	public int compareTo(Contact other) {
		// TODO Auto-generated method stub
		return this.name.compareTo(other.name);
	}
}

