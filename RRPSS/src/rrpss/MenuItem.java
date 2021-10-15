package rrpss;

public class MenuItem {
	private String name; 
	private String description; 
	private Double price; 
	private int itemId;
	
	// constructor for a menu item
	public MenuItem(int itemId, double price) {
		this.itemId = itemId; 
		this.price = price;
	}
	
	public void updateMenuItem(String description, int itemId, Double price) {
		if (this.itemId == itemId) {
		this.description = description;
		this.price = price; 
		}
	}
	
	public void removeMenuItem(int itemId) {
		if (this.itemId == itemId) {
			this.description = null;
			this.price = 0.0;
			this.name = null;
		}
	}
}
