package rrpss;

//import rrpss.Food;
//import rrpss.MenuItem;

import java.util.*;
/**
 * Represents a Promotional Package. A promotional package can consist of more than 1 Menu Item
 * @author tyf
 *
 */
public class PromotionalPackages extends MenuItem {
	/**
	 * An ArrayList of Food items that makes up the Promotion Set
	 */
    private ArrayList<Food> promotionSet;
    
    /**
     * Constructor of the object
     * @param menuName
     * @param desc
     * @param price
     * @param itemId
     */
    public PromotionalPackages(String menuName, String desc, double price, int itemId) {
        super(menuName, desc, price, itemId);
        this.promotionSet = new ArrayList<Food>();
    }

    /**
     * Returns the Promotion Set
     * @return
     */
    public ArrayList<Food> getPromotionSet() {
        return promotionSet;
    }
    
    /**
     * Adding Food item into a promotion set
     * @param food
     */
    public void addToPromotionSet(Food food) {
        promotionSet.add(food);
    }
    
    /**
     * Adding food items selected from menu to be added to Promotion Set
     * @param menu
     */
    public void addToPromotionSet(ArrayList<MenuItem> menu) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Select food to be added to the Promotion Package: ");
        /**
         * Printing out all Food items included in menu
         */
        for (MenuItem menuItem : menu) {
            if (menuItem instanceof Food) {
                System.out.println(i+1 + ": " + menuItem.getMenuName());
                i++;
            }
        }



        /**
         * Get user input on what food to add, and add food to Promotion Set
         */
        int selection = sc.nextInt();

        MenuItem foundMenuItem = null;
        try {
            if (true) {

                int k = 0 ;
                for (MenuItem menuItem : menu) {
                    if (menuItem instanceof Food) {

                        if(k == selection-1){
                foundMenuItem = menuItem;
                            break;
                        }
                        k++;

                    }
                }


                System.out.println(foundMenuItem.getMenuName());
                this.promotionSet.add((Food)foundMenuItem);
                System.out.println(foundMenuItem.getMenuName() + " added to Promotional Package.");
            }
            else {
                System.out.println("Selection is invalid.");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Failed to add to promotion set. Invalid item.");
        }
    }
    
    /**
     * Remove Food item from a Promotion Set
     * @param food
     */
    public void removeFromPromotionSet(Food food) {
        promotionSet.remove(food);
    }
    
    /**
     * Remove food items selected from the Promotion Set
     */
    public void removeFromPromotionSet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select food to be removed from Promotion Package: ");
        int i = 1;
        /**
         * Print out all the Food Items in Promotion Set
         */
        for (Food foood : promotionSet) {
            System.out.println(i + ": " + foood.getMenuName());
            i++;
        }
        /**
         *  Get user input on what food to remove, and remove from Promotion Set
         */
        int selection = sc.nextInt();
        try {
            String removeSelection = promotionSet.get(selection).getMenuName();
            promotionSet.remove(selection);
            System.out.println(removeSelection + " removed from Promotion Package.");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Failed to remove from promotion set. Item is invalid.");
        }
    }
}
