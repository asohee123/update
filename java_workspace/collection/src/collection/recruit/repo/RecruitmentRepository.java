package collection.recruit.repo;

import java.util.ArrayList;

import collection.recruit.vo.Recruitment;

public class RecruitmentRepository {

	private ArrayList<Recruitment> db = new ArrayList<Recruitment>();
	private int sequence = 100;
	
	// 구직신청 등록하기
	public int addRecuitment(Recruitment recruitment) {
		recruitment.setNo(sequence++);
		db.add(recruitment);
		return sequence - 1;		//구직신청번호 제공
	}
	
	// 나의 구직신청 현황 조회하기
	public Recruitment getRecruitmentByNo(int recruitmentNo) {
		Recruitment result = null;
		for(Recruitment repo : db) {
			if(recruitmentNo == repo.getNo()) {
				result = repo;
				break;
			}
		}
		return result;
	}
	
	// 나의 구직신청 삭제하기
	public void deleteRecruitmentByNo(int recruitmentNo) {
		Recruitment result = getRecruitmentByNo(recruitmentNo);
		
		db.remove(result);
	}
	
	// 전체 구직현황 조회하기
	public ArrayList<Recruitment> getAllRecruitments() {
		return db;
	}
}