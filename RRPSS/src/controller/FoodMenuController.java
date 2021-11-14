package controller;

import rrpss.*;
import database.*;
import java.util.*;
import rrpss.Food.CourseType;
import rrpss.Food.Temp;

/**
 * 
 * @author tyf
 *
 */
public class FoodMenuController {
	private static ArrayList<MenuItem> menu = RestaurantDB.menu;
	private static Scanner sc = new Scanner(System.in);
	/**
	 * Method for creating a Food Object
	 * @param foodName
	 * @param foodDesc
	 * @param foodPrice
	 * @param foodId
	 * @param foodCourseType
	 * @param foodTemp
	 */
	public static void createFood(String foodName, String foodDesc, double foodPrice, int foodId,
			CourseType foodCourseType, Temp foodTemp) {
		/**
		 * Validate price
		 */
		if (foodPrice <= 0) {
			System.out.println("Invalid Price. Please input positive price.");
			return;
		}
		/**
		 * Validate MenuID availability
		 */
		for (MenuItem item : menu) {
			if (item.getItemId() == foodId) {
				System.out.println("Error!! Menu ID in use.");
				return;
			}
		}
		Food newFood;
		newFood = new Food(foodName, foodDesc, foodPrice, foodId, foodCourseType, foodTemp);
		menu.add(newFood);
		System.out.println(foodName + " has been added to the menu.");
	}
	
	/**
	 * Method for creating a Promotional Package object
	 * @param menuName
	 * @param desc
	 * @param price
	 * @param itemId
	 */
	public static void createNewPromotionPackage(String menuName, String desc, double price, int itemId) {

		PromotionalPackages newPromo;
		/**
		 * Validate price
		 */
		if (price <= 0) {
			System.out.println("Invalid Price. Please input positive price.");
			return;
		}
		/**
		 * Validate MenuID availability
		 */
		for (MenuItem item : menu) {
			if (item.getItemId() == itemId) {
				System.out.println("Error!! Menu ID in use.");
				return;
			}
		}
		
		newPromo = new PromotionalPackages(menuName, desc, price, itemId);
		String input = "";

		boolean done = false;

		while (!done) {
			newPromo.addToPromotionSet(menu);
			System.out.println("Add more items to package? (Y/N): ");
			
			input = sc.nextLine().toLowerCase();
			
			if (input.equals("n")) {
				done = true;
			}
		}
		menu.add((PromotionalPackages) newPromo);

	}
	
	/**
	 * Method for removing a Menu Item from the menu
	 * @param selection
	 */
	public static void removeMenuItem(int selection) {
		try {
			String removeSelection = menu.get(selection).getMenuName();
			menu.remove(selection);
			System.out.println(removeSelection + " removed from Menu.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Remove Menu Item failed. Invalid item.");
		}
	}

	/**
	 * Method for updating the MenuItem name
	 * @param MenuItem
	 * @param name
	 */
	public static void updateMenuItemName(MenuItem MenuItem, String name) {
		try {
			String oldName = MenuItem.getMenuName();
			MenuItem.setMenuName(name);
			System.out.println("'" + oldName + "'" + " has been updated to " + "'" + name + "'");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Update Menu Item Name Failed. Invalid Item.");
		}
	}

	/**
	 * Method for updating the Menu Item Description
	 * @param MenuItem
	 * @param desc
	 */
	public static void updateMenuItemDesc(MenuItem MenuItem, String desc) {
		try {
			String oldDesc = MenuItem.getMenuName();
			MenuItem.setDesc(desc);
			System.out.println("'" + oldDesc + "'" + " has been updated to " + "'" + desc + "'");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Update Menu Item Description failed. Invalid Item.");
		}
	}

	/**
	 * Method for updating the Menu Item Price
	 * @param menuItem
	 * @param price
	 */
	public static void updateMenuItemPrice(MenuItem menuItem, double price) {
		double oldPrice;
		String name;

		try {
			oldPrice = menuItem.getPrice();
			name = menuItem.getMenuName();
			menuItem.setPrice(price);
			System.out.println("Price of " + name + " updated from $" + oldPrice + " to $" + price);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Price update failed. Invalid item.");
		}
	}

	/**
	 * Method for printing out Promotional Package details
	 * @param promotionalPackages
	 */
	public static void printPromotionPackage(PromotionalPackages promotionalPackages) {
		System.out.println();
		System.out.println("Promotion Package Name: " + promotionalPackages.getMenuName());
		System.out.println("Promotion Package Description: " + promotionalPackages.getDesc());
		System.out.println("Promotion Package Price: " + promotionalPackages.getPrice());

		ArrayList<Food> promotionSet = promotionalPackages.getPromotionSet();
		System.out.println("\nThis Promotion Package includes: ");
		int i = 0;
		for (Food food : promotionSet)
			System.out.println("(" + i + ") " + food.getMenuName());
		i++;
	}

	/**
	 * Return Menu that contains all Menu Items
	 * @return
	 */
	public static ArrayList<MenuItem> getRestaurantFoodMenu() {
		return menu;
	}

	/**
	 * Print details of food
	 * 
	 * @param food Food to print
	 */
	public static void printFood(Food food) {
		System.out.println();
		System.out.println("Food Name: " + food.getMenuName());
		System.out.println("Food Description: " + food.getDesc());
		System.out.println("Food Price: " + food.getPrice());
		System.out.println("Course Type: " + food.getType());
		System.out.println("Food Temp: " + food.getTemp());
	}

	/**
	 * Method for updating Food COurse Type
	 * @param menuItem
	 * @param foodCourseType
	 */
	public static void updateFoodCourseType(MenuItem menuItem, CourseType foodCourseType) {

		Food food = (Food) menuItem;
		String menuName = food.getMenuName();
		CourseType prevCourseType = food.getType();

		food.setType(foodCourseType);
		System.out.println(
				"\nCourse Type of " + menuName + " has been updated from " + prevCourseType + " to " + foodCourseType);
	}

	/**
	 * Method for updating Food Temperature
	 * @param menuItem
	 * @param foodTemp
	 */
	public static void updateFoodTemp(MenuItem menuItem, Temp foodTemp) {

		Food food = (Food) menuItem;
		String menuName = food.getMenuName();
		Temp prevTemp = food.getTemp();

		food.setTemp(foodTemp);
		System.out.println("\nTemp of " + menuName + " has been updated from " + prevTemp + " to " + foodTemp);
	}

}
