package rrpss;

//import rrpss.Food;
//import rrpss.MenuItem;

import java.util.*;
public class PromotionalPackages extends MenuItem {

    private ArrayList<Food> promotionSet;
    
    public PromotionalPackages(String menuName, String desc, double price, int itemId) {
        super(menuName, desc, price, itemId);
        this.promotionSet = new ArrayList<Food>();
    }

    public ArrayList<Food> getPromotionSet() {
        return promotionSet;
    }

    public void addToPromotionSet(Food food) {
        promotionSet.add(food);
    }

    public void addToPromotionSet(ArrayList<MenuItem> menu) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Select food to be added to the Promotion Package: ");
        for (MenuItem menuItem : menu) {
            if (menuItem instanceof Food) {
                System.out.println(i+1 + ": " + menuItem.getMenuName());
                i++;
            }
        }
        
        int selection = sc.nextInt();
        try { 
            if (menu.get(selection-1) instanceof Food) {
                Food foodSelection = (Food) menu.get(selection-1);
                this.promotionSet.add(foodSelection);
                System.out.println(foodSelection.getMenuName() + "added to Promotional Package.");
            }
            else {
                System.out.println("Selection is invalid.");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Failed to add to promotion set. Invalid item.");
        }
    }

    public void removeFromPromotionSet(Food food) {
        promotionSet.remove(food);
    }

    public void removeFromPromotionSet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select food to be removed from Promotion Package: ");
        int i = 1;
        for (Food foood : promotionSet) {
            System.out.println(i + ": " + foood.getMenuName());
            i++;
        }
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
