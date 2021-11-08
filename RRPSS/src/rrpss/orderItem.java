package rrpss;
/**
 * 
 * @author Chew Poshi
 *
 */
public class orderItem {
	/**
	 * used to increment the ID
	 */
	private static int index = 1;
	/**
	 * incrementing ID
	 */
	private int orderItemID = 1;
	/**
	 * MenuItem object that is contained in this orderItem
	 */
	private MenuItem item;
	/**
	 * quantity of the MenuItem ordered by the customer
	 */
	private int quantity;
	/**
	 * Whether this orderItem is a promotionalPackage or not
	 */
	private boolean isPromotion; 
	/*
	 * Constructor for the object
	 */
	public orderItem(MenuItem item, int quantity, boolean isPromotion) {
		this.orderItemID = index++;
		this.orderItemID = orderItemID++;
		this.item = item;
		this.quantity = quantity;
		this.isPromotion = isPromotion;
	}
	/**
	 * returns the MenuItem object that belongs to this orerItem
	 * @return the MenuItem object that belongs to this orerItem
	 */
	public MenuItem getItem() {
		return item;
	}
	/**
	 * returns the quantity of the Menuitem ordered
	 * @return the quantity of the Menuitem ordered
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * returns the ID of the orderitem
	 * @return the ID of the orderitem
	 */
	public int getItemID() {
		return orderItemID;
	}
	/**
	 * returns whether this orerItem is promotoinalpackage or not 
	 * @return whether this orerItem is promotoinalpackage or not
	 */
	public boolean getIsPromotion() {
		return isPromotion;
	}
	/**
	 * set the quantity of the MenuItem ordred for this orderItem
	 * @param newQuant
	 */
	public void setQuantity(int newQuant) {
		this.quantity = newQuant;
	}
}
