package rrpss;

public class orderItem {
	private int orderItemID;
	private MenuItem item;
	private int quantity;
	
	public orderItem(MenuItem item, int quantity) {
		this.orderItemID = (int) (Math.random() *1000);
		this.item = item;
		this.quantity = quantity;
	}
	
	public MenuItem getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getItemID() {
		return orderItemID;
	}
}
