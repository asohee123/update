package collection.recruit.vo;
/**
 * 경력사항 정보를 담는 객체용 설계도.
 * @author JHTA
 *
 */
public class Career {

	private String companyName; // 근무했던 회사이름
	private String dept; 		// 근무했던 부서
	private String position;	// 최종 직급(사원, 대리, 과장, 차장, 부장, 이상)
	private int year;			// 근무기간(년 단위)
	
	public Career() {
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
