package rrpss;

public class Appetisers {
	private int appetiserId;
	private double appetiserPrice; 
	
	// Constructor for class
    public Appetisers(int appetiser_id) {
        this.appetiserId = appetiser_id;
    }
    
    public void setPrice(int appetiserId, double price) {
        if (this.appetiserId == appetiserId) {
        	this.appetiserPrice = price;
        }
    }
    public double getAppetiserPrice() {
        return appetiserPrice;
    }

    public double getAppetiserId() {
        return appetiserId;
    }
}
