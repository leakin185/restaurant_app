package ui;

import java.util.ArrayList;
import java.util.Scanner;

import rrpss.Food;
import rrpss.MenuItem;
import rrpss.PromotionalPackages;
import rrpss.Food.CourseType;
import rrpss.Food.Temp;
import controller.FoodMenuController;
import lib.ScannerExt;

/**
 * Represents the UI displayed to the user when changing the food menu.
 * 
 * @author WangYi
 * @version 1.0
 * @since 2021-10-30
 */
public class FoodMenuUI {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Display options user can perform on restaurant food menu. User can Add new
	 * food, new promotion package or remove menu item from menu
	 */
	public static void menuShowFoodMenuOptions() {

		int choice;

		do {
			System.out.println("\nSelect a choice: ");
			System.out.println("(1) Add new food to food menu");
			System.out.println("(2) Add new promotion package to food menu");
			System.out.println("(3) Update menu item in food menu");
			System.out.println("(4) Remove a menu item from food menu");
			System.out.println("(5) View menu item");
			System.out.println("(6) Back");
			System.out.println("Enter the number of your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				createNewFoodUI();
				break;
			case 2:
				createNewPromotionPackageUI();
				break;
			case 3:
				updateMenuItemUI();
				break;
			case 4:
				removeMenuItemUI();
				break;
			case 5:
				viewMenuItemUI();
				break;
			case 6:
			}
		} while (choice < 6);

	}

	/**
	 * Show a UI that prompts user for menu item to be viewed.
	 */
	private static void viewMenuItemUI() {

		int choice;
		ArrayList<MenuItem> foodMenu = FoodMenuController.getRestaurantFoodMenu();

		int index = 1;
		System.out.println("\nList of Menu Items:");
		System.out.println("\nALACARTE MENU");
		for (MenuItem menuItem : foodMenu)
			if (menuItem instanceof Food) {
				System.out.println("(" + index++ + ") " + menuItem.getMenuName());
			}
			else {
				index++;
			}
		System.out.println("-------------------------------------");
		System.out.println("\nPROMOTION MENU");
		index = 1;
		for (MenuItem menuItem : foodMenu)
			if (menuItem instanceof PromotionalPackages) {
				System.out.println("(" + index++ + ") " + menuItem.getMenuName());
			}
			else {
				index++;
			}
		
		System.out.println("(-1) Go Back");
		choice = ScannerExt.nextInt("\n    Enter the number of your choice: ", -1, index - 1);

		if (choice == -1) {
			return;
		}

		MenuItem viewMenuItem = foodMenu.get(choice-1);
		if (viewMenuItem instanceof Food)
			FoodMenuController.printFood((Food) viewMenuItem);
		else if (viewMenuItem instanceof PromotionalPackages)
			FoodMenuController.printPromotionPackage((PromotionalPackages) viewMenuItem);
		else
			System.out.println("Invalid number!");
	}

	/**
	 * Show a UI that prompts user for menu item to be removed.
	 */
	private static void removeMenuItemUI() {

		int choice;
		ArrayList<MenuItem> foodMenu = FoodMenuController.getRestaurantFoodMenu();

		int index = 0;
		System.out.println("\nSelect the menu item to remove from the food menu:");
		for (MenuItem menuItem : foodMenu)
			System.out.println("(" + index++ + ") " + menuItem.getMenuName());
		choice = ScannerExt.nextInt("    Enter the number of your choice: ");

		FoodMenuController.removeMenuItem(choice);

	}

	/**
	 * Show a UI that prompts user for details of the promotion package to be
	 * created.
	 */
	private static void createNewPromotionPackageUI() {

		String menuName;
		String menuDesc;
		double menuPrice;
		int menuID;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter menu name of promotion package: ");

		menuName = sc.nextLine();
		System.out.print("Enter menu description of promotion package: ");

		menuDesc = sc.nextLine();
		menuPrice = ScannerExt.nextDouble("Enter price of promotion package: ");
		menuID = ScannerExt.nextInt("Enter menuID of promotion package: ");

		FoodMenuController.createNewPromotionPackage(menuName, menuDesc, menuPrice, menuID);

	}

	/**
	 * Show a UI that prompts user for details of the food to be created.
	 */
	private static void createNewFoodUI() {

		Scanner sc = new Scanner(System.in);

		CourseType foodCourseType = null;
		Temp foodTemp = null;

		System.out.println("Enter menu name of food: ");

		String foodName = sc.nextLine();
		System.out.println("Enter menu description of food: ");

		String foodDesc = sc.nextLine();
		double foodPrice = ScannerExt.nextDouble("Enter price of food: ");
		int foodID = ScannerExt.nextInt("Enter ID of food: ");
		foodCourseType = selectFoodCourseTypeUI("\nSelect course type of your food.");
		foodTemp = selectFoodTempUI("\nSelect temperature of your food.");
		FoodMenuController.createFood(foodName, foodDesc, foodPrice, foodID, foodCourseType, foodTemp);

	}

	/**
	 * Show a UI that prompts user for menu item to be updated.
	 */
	private static void updateMenuItemUI() {

		int choice;
		MenuItem menuItemToUpdate;
		ArrayList<MenuItem> foodMenu = FoodMenuController.getRestaurantFoodMenu();

		if (foodMenu.size() <= 0) {
			System.out.println("There are no menu items in food menu.");
			return;
		}

		int index = 0;
		System.out.println("\nSelect the menu item to update in the food menu:");
		for (MenuItem menuItem : foodMenu)
			System.out.println("(" + index++ + ") " + menuItem.getMenuName());

		choice = ScannerExt.nextInt("\n    Enter the number of your choice: ", 0, index - 1);
		menuItemToUpdate = foodMenu.get(choice);

		if (menuItemToUpdate instanceof Food)
			updateFood(menuItemToUpdate);
		else if (menuItemToUpdate instanceof PromotionalPackages)
			updatePromotionPackage(menuItemToUpdate);
		else
			System.out.println("Invalid number!");
	}

	/**
	 * Update menu item name, description or price from restaurant food menu.
	 * 
	 * @param menuItem Menu item to be updated
	 */
	private static void updateFood(MenuItem menuItem) {

		int choice;

		try {

			do {
				System.out.println("\nWhat would you like to update?");
				System.out.println("(1) Food Name");
				System.out.println("(2) Food Description");
				System.out.println("(3) Food Price");
				System.out.println("(4) Food Course Type");
				System.out.println("(5) Food Temperature Type");
				System.out.println("(6) Back");
				choice = ScannerExt.nextInt("\n    Enter the number of your choice: ", 1, 6);

				switch (choice) {
				case 1:
					updateMenuItemName(menuItem);
					break;
				case 2:
					updateMenuItemDesc(menuItem);
					break;
				case 3:
					updateMenuItemPrice(menuItem);
					break;
				case 4:
					FoodMenuController.updateFoodCourseType(menuItem,
							selectFoodCourseTypeUI("Select food course type."));
					break;
				case 5:
					FoodMenuController.updateFoodTemp(menuItem,
							selectFoodTempUI("Select food temp type."));
					break;
				case 6:
				}

			} while (choice != 6);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Update menu item in food menu failed! (Invalid index provided");
		}

	}

	/**
	 * Update promotion package name, description or price from restaurant food
	 * menu.
	 * 
	 * @param menuItem Menu item to be updated
	 */
	private static void updatePromotionPackage(MenuItem menuItem) {
		int choice;

		do {
			System.out.println("\nWhat would you like to update?");
			System.out.println("(1) Promotion Package Name");
			System.out.println("(2) Promotion Package Description");
			System.out.println("(3) Promotion Package Price");
			System.out.println("(4) Promotion Package Food");
			System.out.println("(5) Back");
			choice = ScannerExt.nextInt("\n    Enter the number of your choice: ", 1, 5);

			switch (choice) {
			case 1:
				updateMenuItemName(menuItem);
				break;
			case 2:
				updateMenuItemDesc(menuItem);
				break;
			case 3:
				updateMenuItemPrice(menuItem);
				break;
			case 4:
				updatePromotionPackageFoodUI(menuItem);
				break;
			case 5:
			}

		} while (choice != 5);

	}

	/**
	 * Edit food contained in promotion package
	 * 
	 * @param menuItem Promotion Package menu item to be edited
	 */
	public static void updatePromotionPackageFoodUI(MenuItem menuItem) {

		int choice;
		PromotionalPackages pp = (PromotionalPackages) menuItem;

		do {

			System.out.println("\nWould you like to add or delete food from Promotion Package?");
			System.out.println("(1) Add food");
			System.out.println("(2) Remove food");
			System.out.println("(3) Back");
			choice = ScannerExt.nextInt("\n    Enter the number of your choice: ", 1, 3);

			switch (choice) {
			case 1:
				System.out.println();
				pp.addToPromotionSet(FoodMenuController.getRestaurantFoodMenu());
				break;
			case 2:
				System.out.println();
				pp.removeFromPromotionSet();
				break;
			case 3:
			}
		} while (choice != 3);

	}

	/**
	 * Prompt user for menu item name to be updated
	 * 
	 * @param menuItem Menu Item to be updated
	 */
	public static void updateMenuItemName(MenuItem menuItem) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Updated Menu Name : ");

		if (sc.hasNextLine()) {

			FoodMenuController.updateMenuItemName(menuItem, sc.nextLine());

		}

	}

	/**
	 * Prompt user for menu item description to be updated
	 * 
	 * @param menuItem Menu Item to be updated
	 */
	public static void updateMenuItemDesc(MenuItem menuItem) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Updated Menu Description : ");

		if (sc.hasNextLine()) {
			String menuDesc = sc.nextLine();

			FoodMenuController.updateMenuItemDesc(menuItem, menuDesc);

		}

	}

	/**
	 * Prompt user for menu item price to be updated
	 * 
	 * @param menuItem Menu Item to be updated
	 */
	public static void updateMenuItemPrice(MenuItem menuItem) {

		double menuPrice = ScannerExt.nextDouble("\nEnter Updated Menu Price : ");
		FoodMenuController.updateMenuItemPrice(menuItem, menuPrice);

	}

	/**
	 * Prompt user for a food course type
	 * 
	 * @param promptMsg Message to ask user before prompting a selection
	 */
	public static CourseType selectFoodCourseTypeUI(String promptMsg) {

		CourseType foodCourseType;

		System.out.println(promptMsg);
		int index = 0;
		for (CourseType courseType : CourseType.values())
			System.out.println("(" + index++ + ")" + " " + courseType);
		int choice = ScannerExt.nextInt("    Enter the number of your choice: ", 0, CourseType.values().length - 1);
		foodCourseType = Food.CourseType.values()[choice];

		return foodCourseType;

	}

	/**
	 * Prompt user for a food temperature type
	 * 
	 * @param promptMsg Message to ask user before prompting a selection
	 */
	public static Temp selectFoodTempUI(String promptMsg) {

		Temp foodTemp;

		System.out.println(promptMsg);
		int index = 0;
		for (Temp temp : Temp.values())
			System.out.println("(" + index++ + ")" + " " + temp);
		int choice = ScannerExt.nextInt("    Enter the number of your choice: ", 0, Temp.values().length - 1);

		foodTemp = Food.Temp.values()[choice];

		return foodTemp;

	}

}
