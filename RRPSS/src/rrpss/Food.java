package rrpss;


public class Food extends MenuItem {
	
	/**
	 * Object representing food sold in the restaurant extending
	 * from the MenuItem class. Food sold must be a type of the CourseType
	 * @author WangYi 
	 * @version 1.0
	 * @since 2021-11-12
	 */
	
	private CourseType type;
	private Temp temp;
	/**
	 * Course type of the food. Uses CourseType enum
	 */
	public enum CourseType {MAIN_COURSE, DESSERT, DRINK, APPETISER};
	/**
	 * temperature of the food. Uses Temp enum
	 */
	public enum Temp {HOT, COLD};
	
	/**
	 * Create a new food having menu name, description, price temperature, and
	 * course type.
	 * @param menuName Name of the food as appear on the menu
	 * @param desc Description of the food
	 * @param itemId Item ID of the food
	 * @param price Price of the food
	 * @param type Course type of the food
	 * @param temp Temperature type of the food
	 */
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
	
	/**
	 * Get the course type of the food
	 * @return this food course type
	 */
	public CourseType getType() { 
		return this.type; 
	}
	
	/**
	 * Changes the course type of the food
	 * @param type Course type of the food.
	 */
	public void setType(CourseType type) { 
		this.type = type; 
	}
	
	/**
	 * Get the temperature type of the food
	 * @return this food temperature type
	 */
	public Temp getTemp() { 
		return this.temp; 
	}
	
	/**
	 * Changes the temperature type of the food
	 * @param temp temperature type of the food.
	 */
	public void setTemp(Temp temp) { 
		if (type != CourseType.DRINK) {
			this.temp = Temp.HOT;
		}
		else {
			this.temp = temp;
		}
	}

}