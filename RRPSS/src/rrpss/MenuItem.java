package rrpss;

public abstract class MenuItem{
	
	private String menuName;
	private String desc;
	private double price;
	private int itemId; 
	
	public MenuItem(String menuName, String desc, double price, int itemId){
		this.menuName = menuName;
		this.desc = desc;
		this.price = price;
		this.itemId = itemId;
	}
	
	public void setMenuName(String menuName){ 
		this.menuName = menuName; 
	}
	
	public void setDesc(String desc){ 
		this.desc = desc; 
	}
	
	public void setPrice(double price){ 
		this.price = price; 
	}
	
	public void setItemId(int id) {
		this.itemId = id;
	}
	
	public String getMenuName(){ 
		return this.menuName; 
	}
	
	public String getDesc(){ 
		return this.desc; 
	}
	
	public double getPrice(){ 
		return this.price; 
	}
	
	public int getItemId(){
		return this.itemId;
	}

}