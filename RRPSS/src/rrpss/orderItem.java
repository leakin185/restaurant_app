package rrpss;

public class orderItem {
	private static int orderItemID = 1;
	private MenuItem item;
	private int quantity;
	private boolean isPromotion; 
	
	public orderItem(MenuItem item, int quantity, boolean isPromotion) {
		this.orderItemID = orderItemID++;
		this.item = item;
		this.quantity = quantity;
		this.isPromotion = isPromotion;
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
	
	public boolean getIsPromotion() {
		return isPromotion;
	}
	
	public void setQuantity(int newQuant) {
		this.quantity = newQuant;
	}
}
