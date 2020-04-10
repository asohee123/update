package collection.recruit;

import java.util.Scanner;

import collection.recruit.service.RecruitmentService;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RecruitmentService service = new RecruitmentService();
		
		while (true) {
			System.out.println("=========================================");
			System.out.println("1.구직자  2.인사담당자  0.종료");
			System.out.println("=========================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if (menuNo == 1) {
				System.out.println("==========================================================================");
				System.out.println("1.이력서등록 2.경력사항등록 3.채용상태확인 4.이력서수정 5.구직신청 삭제");
				System.out.println("==========================================================================");
				
				System.out.print("구직자 메뉴를 선택하세요 : ");
				int empMenuNo = scanner.nextInt();
				
				if (empMenuNo == 1) {
					// 이름, 전화번호, 지원부서를 입력받는다.
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("전화번호 : ");
					String tel = scanner.next();
					System.out.print("지원부서 : ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.addNewResume(resume);
					
				} else if (empMenuNo == 2) {
					// 구직신청번호, 재직회사명, 근무부서, 직위, 근무년수를 입력받는다.
					System.out.print("구직신청번호를 입력하세요 : ");
					int no = scanner.nextInt();
					System.out.print("재직했던 회사명을 입력하세요 : ");
					String companyName = scanner.next();
					System.out.print("근무했던 부서명을 입력하세요 : ");
					String dept = scanner.next();
					System.out.print("직위를 입력하세요 : ");
					String position = scanner.next();
					System.out.print("근무년수를 입력하세요 : ");
					int year = scanner.nextInt();
					
					Career career = new Career();
					
					career.setCompanyName(companyName);
					career.setDept(dept);
					career.setPosition(position);
					career.setYear(year);
					
					
					service.addCareer(no, career);
					
				} else if (empMenuNo == 3) {
					// 구직신청번호를 입력받는다.
					System.out.print("구직신청번호를 입력하세요 :");
					int no = scanner.nextInt();
					
					service.printRecruitmentDetail(no);
					
				} else if (empMenuNo == 4) {
					// 구직신청번호, 이름, 전화번호, 지원부서를 입력받는다.
					System.out.print("구직신청번호 : ");
					int no = scanner.nextInt();
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("전화번호 : ");
					String tel = scanner.next();
					System.out.print("지원부서 : ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.updateResume(no, resume);
					
				} else if (empMenuNo == 5) {
					// 구직신청번호를 입력받는다.
					System.out.print("구직신청번호 : ");
					int no = scanner.nextInt();
					
					service.deleteRecruitment(no);
				} 
				
			} else if (menuNo == 2) {
				System.out.println("==========================================================================");
				System.out.println("1.채용신청서 조회  2.채용신청서 상세조회  3.채용신청서 심사");
				System.out.println("==========================================================================");
				
				System.out.print("구직자 메뉴를 선택하세요");
				int empMenuNo = scanner.nextInt();
				
				if (empMenuNo == 1) {
					// 입력값 없음
					service.printAllRecruitment();
					
				} else if (empMenuNo == 2) {
					// 구직신청번호를 입력받는다.
					System.out.print("구직신청번호 : ");
					int no = scanner.nextInt();
					
				} else if (empMenuNo == 3) {
					// 구직신청번호와 합격불합격여부를 Y/N으로 입력받는다.
				} 
				
			} else if (menuNo == 0) {
				System.out.println("### 프로그램을 종료합니다.");
				break;
			}
			System.out.println();
		}
		scanner.close();
	}
}