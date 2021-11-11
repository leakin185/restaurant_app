package rrpss;
/**
 * 
 * Represents a Alacarte Menu Item
 * @author tyf
 *
 */
public class Alacarte extends Food {
	/**
	 * Constructor for the object
	 * @param menuName
	 * @param desc
	 * @param price
	 * @param itemId
	 * @param type
	 * @param temp
	 */
    public Alacarte (String menuName, String desc, double price, int itemId, CourseType type, Temp temp) {
        super(menuName, desc, price, itemId, type, temp);
    }
}
