package semi.vo;

public class OrderProduct {
	
	private int orderProductNo;
	private int orderNo;
	private int itemNo;
	private int orderedAmount;
	private int orderedPrice;
	
	public OrderProduct() {}

	public int getOrderProductNo() {
		return orderProductNo;
	}

	public void setOrderProductNo(int orderProductNo) {
		this.orderProductNo = orderProductNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getOrderedAmount() {
		return orderedAmount;
	}

	public void setOrderedAmount(int orderedAmount) {
		this.orderedAmount = orderedAmount;
	}

	public int getOrderedPrice() {
		return orderedPrice;
	}

	public void setOrderedPrice(int orderedPrice) {
		this.orderedPrice = orderedPrice;
	}
	
	
}
