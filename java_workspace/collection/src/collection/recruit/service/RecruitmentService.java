package collection.recruit.service;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();
	
	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		// 구직신청객체에 전달받은 이력서 객체 저장
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직신청번호를 반환받는다.
		// 구직신청번호를 출력한다.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		int no = repo.addRecuitment(recruitment);
		System.out.println("채용신청번호: " + no);
	}
	
	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		Recruitment newRepo = repo.getRecruitmentByNo(recruitmentNo);
		if(newRepo == null) {
			System.out.println("정보가 없습니다.");
			return;
		} 
		
		newRepo.addCareer(career);
	
	}
	
	
	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		
		Recruitment findrecruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(findrecruitment == null) {
			System.out.println("정보가 없습니다.");
		} else {
			System.out.println("-------------구직신청내용-------------");
			System.out.println("구직신청번호 : " + findrecruitment.getNo());
			System.out.println("이름 : " + findrecruitment.getResume().getName());
			System.out.println("전화번호 : " + findrecruitment.getResume().getTel());
			System.out.println("지원부서 : " + findrecruitment.getResume().getDept());
			System.out.println("합격여부 : " + findrecruitment.isPassed());

			for(Career c : findrecruitment.getCareers()) {
				System.out.println("근무했던 회사 : " + c.getCompanyName());
				System.out.println("근무했던 부사 : " + c.getDept());
				System.out.println("최종 직급 : " + c.getPosition());
				System.out.println("근무기간 : " + c.getYear());
				System.out.println();
			}

		}
	}
	
	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		Recruitment updateRepo = repo.getRecruitmentByNo(recruitmentNo);
		updateRepo.setResume(resume);
	}
	
	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		repo.deleteRecruitmentByNo(recruitmentNo);
	}
	
	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
	}
	
	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 합격/불합격여부를 결정한다.
	}
}