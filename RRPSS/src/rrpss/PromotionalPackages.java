package rrpss;

import java.util.Arrays;

public class PromotionalPackages {
    private int packageID, quantity;
    private double promotionPrice;
    private String description;
    private MenuItem[] packageItems = new MenuItem[];
    private boolean removed;

    
    public PromotionalPackages(int packageID, MenuItem[] packageItems, /*int quantity,*/ double promotionPrice, String description) {
        this.packageID = packageID;
        this.packageItems = packageItems;
        //this.quantity = quantity;
        this.promotionPrice = promotionPrice;
        this.description = description;
    }


    public void createPromotion(int packageID, MenuItem[] packageItems, /*int quantity,*/ double promotionPrice, String description) {
        this.packageID = packageID;
        //this.quantity = quantity;
        this.packageItems = packageItems;
        this.promotionPrice = promotionPrice;
        this.description = description;
    }

    public void updatePromotion(Object o, MenuItem[] packageItems, double promotionPrice, String description) {
        if (o.getClass() == this.getClass()) {
            if (o.packageID == this.packageID) {
                this.packageItems = packageItems;
                //this.quantity = quantity;
                this.promotionPrice = promotionPrice;
                this.description = description;
            }
        }
    }

    public void removePromotion(Object o) {
        if (o.getClass() == this.getClass()) {
            if (o.packageID == this.packageID) {
                
            }
        }
    }

    public void addMenu() {

    }
}
