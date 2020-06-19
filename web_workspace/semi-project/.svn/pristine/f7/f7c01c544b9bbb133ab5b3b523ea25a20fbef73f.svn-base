package semi.dto;

import java.util.Date;

public class ReviewDto {
	private int reviewNo;
	private String content;
	private String userName;
	private Date registeredDate;
	
	public ReviewDto () {}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public String getHiddenName() {
		if (userName == null) {
			return "";
		}
		return userName.substring(0, 1) + "****";
		
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}
