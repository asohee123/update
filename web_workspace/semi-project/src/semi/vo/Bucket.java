package semi.vo;

import java.util.Date;

public class Bucket {
	
	private int bucketNo;
	private String userId;
	private int itemNo;
	private Date createDate;
	private int productAmount;
	
	public Bucket() {}

	public int getBucketNo() {
		return bucketNo;
	}

	public void setBucketNo(int bucketNo) {
		this.bucketNo = bucketNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
	
	
	
}
