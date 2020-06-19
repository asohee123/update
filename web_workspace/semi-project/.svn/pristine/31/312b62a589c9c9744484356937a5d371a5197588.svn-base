package semi.dto;

public class QuestionDto {

	private int questionNo;
	private int productNo;
	private String content;
	private String userName;
	
	public QuestionDto () {}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
	
	
}
