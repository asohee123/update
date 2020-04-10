package BankingEx;

public class BankingService {

	//모든 개설된 계좌정보를 저장하는 배열
		Banking[] db = null;
		int savePosition = 0;
		
			//기본생성자를 사용하는 경우 계좌정보 100개를 저장할 수 있는 배열을 생성함
			BankingService() {
			db = new Banking[100];
			}
			//이 생성자를 사용하는 경우 전달받은 size만큼 계좌정보를 저장할 수 있는 배열을 생성함.
			BankingService(int size) {
			db = new Banking[size];	
			}
			
			

			//등록된 전체 계좌정보를 출력하는 서비스
			void printAllBanking() {
				System.out.println("===============================");
				System.out.println("이름	계좌번호	잔고금액	기간");
				System.out.println("===============================");
				for(int i = 0; i<savePosition; i++) {
					System.out.println(db[i].name +"\t");
					System.out.println(db[i].no +"\t");
					System.out.println(db[i].balance +"\t");
					System.out.println(db[i].period +"\t");
				}
				System.out.println("===============================");
			}
			
			//신규계좌를 등록하는 서비스
			void addNewBanking(String name, int pwd, long money) {
				
			}
			
			//계좌조회 서비스
			//계좌번호에 해당하는 계좌정보를 조회(출력)하는 서비스
			void printBankingByNo(String bankingNo) {
				
			}
			
			//계좌번호, 입금액을 전달받아서 해당 계좌에 입금하는 서비스
			void depositeBanking(String bankingNo, long money) {
				
			}
			
			//계좌번호, 비밀번호, 출금액을 전달받아서 출금액만큼 반환하는 서비스
			long withdrawFromBanking(String bankingNo, int pwd, long money) {
				return 0;
			}
			
			//계좌번호, 비밀번호를 전달받아서 계좌를 해지하고, 해지금액 전체를 반환하는 서비스
			long closeBanking(String bankingNo, int pwd) {
				return 0;
			}
			
			// 서비스에 자주 사용되는 계좌번호에 해당하는 계좌정보를 찾아서 반환하는 기능
			Banking findBankingByNo(String bankingNo) {
				return 0;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
}
