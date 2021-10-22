package rrpss;

import java.util.*;

import rrpss.Food;

public class PromotionalPackages extends Food {

    private ArrayList<Food> promotionSet;

    public PromotionalPackages(String menuName, String desc, double price, int itemId, CourseType type, Temp temp) {
        super(menuName, desc, price, itemId, type, temp);
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
        int i = 1;
        System.out.println("Select food to be added to the Promotion Package: ");
        for (MenuItem menuItem : menu) {
            if (menuItem instanceof Food) {
                System.out.println(i + ": " + menuItem.getMenuName());
                i++;
            }
        }
        
        int selection = sc.nextInt();
        try {
            if (menu.get(selection) instanceof Food) {
                Food foodSelection = menu.get(selection);
                this.promotionSet.add(foodSelection);
                System.out.println(foodSelection.getMenuName() + "added to Promotional Package.");
            }
            else {
                System.out.println("Selection is invalid.");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Selection does not exist.");
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
            System.out.println("Selection is invalid.");
        }
    }

    


}
