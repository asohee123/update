package semi.dto;

import java.util.Date;

public class OrderListDto {

	private String img;
	private String productName;
	private String szie;
	private String color;
	private int orderNo;
	private Date orderDate;
	private int orderPrice;
	private int stock;
	private String Delivery_yn;
	
	public OrderListDto() {}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSzie() {
		return szie;
	}

	public void setSzie(String szie) {
		this.szie = szie;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDelivery_yn() {
		return Delivery_yn;
	}

	public void setDelivery_yn(String delivery_yn) {
		Delivery_yn = delivery_yn;
	}
	
	
	
	
}
