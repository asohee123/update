package datatype;

public class DataTypeDemo7 {

			public static void main(String[] args) {
				
				/*변수 활용하기
				 * 
				 * 본인의 이름, 전화번호, 이메일, 나이, 키, 몸무게, 혈액형, 결혼여부을
				 * 저장하는 변수를 선언하고 해당값을 각 변수에 저장하기
				 * 
				 * 각 변수에 저장된 값을 출력하기
				 */
				
				String name = "박재형";
				String tel = "010 - 7520 - 0636";
				String mail = "asohee123@naver.com";
				int age = 28;
				double height = 180.3;
				double weight = 180.3;
				char blood = 'A';
				String married = "NO";
				
				System.out.println("이름 : " +name);
				System.out.println("전화번호 : " +tel);
				System.out.println("이메일 : " +mail);
				
				System.out.println("나이 : " +age);
				if (age >= 25) {
					System.out.println("20대 후반입니다.");
				} else {
					if(age < 25) {
						System.out.println("20대 초반입니다.");
					}
				}
				
				System.out.println("키 : " + height);
				System.out.println("몸무게 : " + weight);
				System.out.println("혈액형 : " + blood);
				System.out.println("결혼여부 : " + married);
				
				
			}
}
