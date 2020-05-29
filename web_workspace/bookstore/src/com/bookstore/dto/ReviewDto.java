package com.bookstore.dto;

import java.util.Date;

public class ReviewDto {

	private int no;
	private String userName;
	private int point;
	private String content;
	private String review_yn;
	private Date registeredDate;
	
	public ReviewDto() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getReview_yn() {
		return review_yn;
	}

	public void setReview_yn(String review_yn) {
		this.review_yn = review_yn;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}
