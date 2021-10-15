package rrpss;

public class Dessert {
    private double dessertPrice;
    private int dessertId;

    // Constructor for class
    public Dessert(int dessert_id) {
        dessertId = dessert_id;
    }

    public void setPrice(int dessertId, double price) {
        if (this.dessertId == dessertId) {
            dessertPrice = price;
        }
        
    }

    public double getDessertPrice() {
        return dessertPrice;
    }

    public double getDessertId() {
        return dessertId;
    }
}
