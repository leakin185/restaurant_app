package rrpss;


public class Food extends MenuItem {
	
	private CourseType type;
	private Temp temp;
	public enum CourseType {MAIN_COURSE, DESSERT, DRINK, APPETISER};
	public enum Temp {HOT, COLD};

	public Food(String menuName, String desc, double price, int itemId, CourseType type, Temp temp) {
		super(menuName, desc, price, itemId);
		this.type = type;
		if (type != CourseType.DRINK) {
			this.temp = Temp.HOT;
		}
		else {
			this.temp = temp;
		}
	}
	
	public CourseType getType() { 
		return this.type; 
	}
	
	public void setType(CourseType type) { 
		this.type = type; 
	}
	
	public Temp getTemp() { 
		return this.temp; 
	}
	
	public void setTemp(Temp temp) { 
		if (type != CourseType.DRINK) {
			this.temp = Temp.HOT;
		}
		else {
			this.temp = temp;
		}
	}

}