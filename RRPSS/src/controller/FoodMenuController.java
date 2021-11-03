package controller;

import rrpss.*;
import database.*;
import java.util.*;
import rrpss.Food.CourseType;
import rrpss.Food.Temp;

public class FoodMenuController {
    private static ArrayList<MenuItem> menu = RestaurantDB.menu;
	private static Scanner sc = new Scanner(System.in);


    public static void createFood(String foodName, String foodDesc, double foodPrice, int foodId, CourseType foodCourseType, Temp foodTemp) {
        Food newFood;
        newFood = new Food(foodName, foodDesc, foodPrice, foodId, foodCourseType, foodTemp);
        menu.add((MenuItem) newFood);
        System.out.println(foodName + " has been added to the menu.");
    }

    public static void createNewPromotionPackage(String menuName, String desc, double price, int itemId) {

        PromotionalPackages newPromo;
        newPromo = new PromotionalPackages(menuName, desc, price, itemId);
        String input = "";

        boolean done = false;

        while(!done) {
            newPromo.addToPromotionSet(menu);
            System.out.println("Add more items to package? (Y/N): ");
            input = sc.nextLine();
            if (input == "N") {
                done = true;
            }
        }
        menu.add((PromotionalPackages) newPromo);

    }

    public static void removeMenuItem(int selection) {
        try {
            String removeSelection = menu.get(selection).getMenuName();
            menu.remove(selection);
            System.out.println(removeSelection + " removed from Menu.");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Remove Menu Item failed. Invalid item.");
        }
    }

    public static void updateMenuItemName(MenuItem MenuItem, String name) {
        try {
            String oldName = MenuItem.getMenuName();
            MenuItem.setMenuName(name);
            System.out.println("'"+oldName+"'" + " has been updated to " + "'"+name+"'");
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("Update Menu Item Name Failed. Invalid Item.");
        }
    }

    public static void updateMenuItemDesc(MenuItem MenuItem, String desc) {
        try {
            String oldDesc = MenuItem.getMenuName();
            MenuItem.setDesc(desc);
            System.out.println("'"+oldDesc+"'" + " has been updated to " + "'"+desc+"'");
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("Update Menu Item Description failed. Invalid Item.");
        }
    }

    public static void updateMenuItemPrice(MenuItem menuItem, double price) {
        double oldPrice;
        String name;

        try {
            oldPrice = menuItem.getPrice();
            name = menuItem.getMenuName();
            menuItem.setPrice(price);
            System.out.println("Price of " + name + " updated from $" + oldPrice + " to $" + price);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Price update failed. Invalid item.");
        }
    }

    public static void printPromotionPackage(PromotionalPackages promotionalPackages) {
		System.out.println();
		System.out.println("Promotion Package Name: " + promotionalPackages.getMenuName());
		System.out.println("Promotion Package Description: " + promotionalPackages.getDesc());
		System.out.println("Promotion Package Price: " + promotionalPackages.getPrice());
		
		ArrayList<Food> promotionSet = promotionalPackages.getPromotionSet();
		System.out.println("\nThis Promotion Package includes: ");
		int i = 0;
		for(Food food: promotionSet)
			System.out.println("(" + i + ") " + food.getMenuName());
            i++;
	}
    
    public static ArrayList<MenuItem> getRestaurantFoodMenu(){ return menu; }
    
    /**
	 * Print details of food
	 * @param food Food to print
	 */
	public static void printFood(MenuItem food) {
		System.out.println();
		System.out.println("Food Name: " + food.getMenuName());
		System.out.println("Food Description: " + food.getDesc());
		System.out.println("Food Price: " + food.getPrice());
	}
	
	public static void updateFoodCourseType(MenuItem menuItem, CourseType foodCourseType){
		
		Food food = (Food) menuItem;
		String menuName = food.getMenuName();
		CourseType prevCourseType = food.getType();
		
		food.setType(foodCourseType);
		System.out.println("\nCourse Type of " + menuName + " has been updated from " + prevCourseType + " to " + foodCourseType);
	}
	
	public static void updateFoodTemp(MenuItem menuItem, Temp foodTemp){
		
		Food food = (Food) menuItem;
		String menuName = food.getMenuName();
		Temp prevTemp = food.getTemp();
		
		food.setTemp(foodTemp);
		System.out.println("\nTemp of " + menuName + " has been updated from " + prevTemp + " to " + foodTemp);
	}

	
}
