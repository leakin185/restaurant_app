package rrpss;

import java.util.ArrayList;

import database.RestaurantDB;


public class Table {
    private static int id = 1;
    private int tableNo;
    private int tableCapacity;
    private boolean isAvailable = true;

    private Invoice invoice;
    private Order order;

    Table(int capacity) {
        tableCapacity = capacity;
        tableNo = id++;
    }

    public void setOrder(Order order) {

        this.order = order;

    }

    public void setInvoice(Invoice invoice) {

        this.invoice = invoice;

    }


    public void setUnavailable() {

        isAvailable = false;
    }

    public void setAvailable() {

        isAvailable = true;
    }

    public int getTableNo() {
        return tableNo;
    }

    public boolean getTableAvailability() {
        return isAvailable;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

}
