package rrpss;

public class Food extends MenuItem {

	public enum CourseType {MAIN_COURSE, DESSERT, DRINK, APPETISER};
	public enum Temp {HOT, COLD};
	
	private CourseType type;
	private Temp temp;

	public Food(String menuName, String desc, double price, CourseType type, Temp temp) {
		super(menuName, desc, price);
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