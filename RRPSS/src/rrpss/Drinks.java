package rrpss;

public class Drinks {
	private int drinkId;
	private double drinkPrice; 
	
	// Constructor for class
    public Drinks(int drink_id) {
        this.drinkId = drink_id; 
    }
    
    public void setPrice(int drinksId, double price) {
        if (this.drinkId == drinksId) {
        	this.drinkPrice = price;
        }
    }
    public double getDrinkPrice() {
        return drinkPrice;
    }

    public double getDrinkId() {
        return drinkId;
    }
}
