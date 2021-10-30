package controller;

import rrpss.*;
import database.*;
import java.util.*;

public class FoodMenuController {
    private static ArrayList<MenuItem> menu = RestaurantDB.menu;
	private static Scanner sc = new Scanner(System.in);

    public static ArrayList<MenuItem> getRestaurantDBMenu(){ 
        return menu; 
    }

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
        menu.add((MenuItem) newPromo);

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
}
