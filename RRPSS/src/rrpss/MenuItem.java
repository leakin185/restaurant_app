package rrpss;

/**
 * Represents a menu item as appear on the food menu.
 * Any menu item on a food menu has a menu name, 
 * description and price.
 * @author WangYi
 * @version 1.0
 * @since 2021-11-12
 */
public abstract class MenuItem{
	
	/**
	 * Menu name of the menu item.
	 */
	private String menuName;
	/**
	 * Description of the menu item.
	 */
	private String desc;
	/**
	 * Price of the menu item.
	 */
	private double price;
	/**
	 * Item ID of the menu item.
	 */
	private int itemId; 
	
	/**
	 * Creates a new menu item with a menu name, description, price and itemID
	 * @param menuName Menu name of the menu item
	 * @param desc Description of the menu item
	 * @param price Price of the menu item
	 * @param itemID itemID of the menu item
	 */
	public MenuItem(String menuName, String desc, double price, int itemId){
		this.menuName = menuName;
		this.desc = desc;
		this.price = price;
		this.itemId = itemId;
	}
	
	/**
	 * Changes the menu name of the menu item
	 * @param menuName Desired menu name
	 */
	public void setMenuName(String menuName){ 
		this.menuName = menuName; 
	}
	
	/**
	 * Changes the description of the menu item
	 * @param desc Desired description
	 */
	public void setDesc(String desc){ 
		this.desc = desc; 
	}
	
	/**
	 * Changes the price of the menu item
	 * @param price Desired price
	 */
	public void setPrice(double price){ 
		this.price = price; 
	}
	
	/**
	 * Changes the itemID of the menu item
	 * @param id Desired itemID
	 */
	public void setItemId(int id) {
		this.itemId = id;
	}
	
	/**
	 * Gets the menu name of the menu item
	 */
	public String getMenuName(){ 
		return this.menuName; 
	}
	
	/**
	 * Gets the description of the menu item
	 */
	public String getDesc(){ 
		return this.desc; 
	}
	
	/**
	 * Gets the price of the menu item
	 */
	public double getPrice(){ 
		return this.price; 
	}
	
	/**
	 * Gets the itemID of the menu item
	 */
	public int getItemId(){
		return this.itemId;
	}

}