package rrpss;

import java.util.ArrayList;

import database.RestaurantDB;

/**
 * Represents Table in the restaurant.
 * A restaurant can have many tables.
 *
 * @author Tjandy Putra
 * @version 1.0
 * @since 2021-10-30
 */
public class Table {

    /**
     * The unique id static counter whose value will be used as tableNo.
     */
    private static int id = 1;
    /**
     * The table number of this table, based on id.
     */
    private int tableNo;
    /**
     * The capacity of this table.
     * */
    private int tableCapacity;
    /**
     * The status of availability of this table.
     * */
    private boolean isAvailable = true;
    /**
     * The Invoice object of this table.
     *
     * */
    private Invoice invoice;
    /**
     * The Order object of this table.
     * */
    private Order order;

    /**
     * Creates a new Table object with the given capacity.
     * @param capacity This Table's capacity.
     * */
    Table(int capacity) {
        tableCapacity = capacity;
        tableNo = id++;
    }
    /**
     * Changes the Order object reference of this table.
     * @param order This table's new Order reference.
     * */
    public void setOrder(Order order) {
        setUnavailable();
        this.order = order;
    }

    /**
     * Changes the Order object reference of this table to null.
     * */
    public void setOrderToNull() {
        this.order = null;

    }

    /**
     * Changes the Invoice object reference of this table.
     * @param invoice This table's new Invoice reference.
     * */
    public void setInvoice(Invoice invoice) {

        this.invoice = invoice;

    }

    /**
     * Changes the Invoice object reference of this table to null.
     * */
    public void setInvoiceToNull() {
        this.invoice = null;

    }

    /**
     * Changes the status of availability of this table to unavailable.
     * */
    public void setUnavailable() {

        isAvailable = false;
    }

    /**
     * Changes the status of availability of this table to available.
     * */
    public void setAvailable() {

        isAvailable = true;
    }

    /**
     * Gets the table number.
     * @return this table's number.
     * */
    public int getTableNo() {
        return tableNo;
    }

    /**
     * Gets the table availability status.
     * @return this table's availability.
     * */
    public boolean getTableAvailability() {
        return isAvailable;
    }

    /**
     * Gets the table capacity.
     * @return this table's capacity.
     * */
    public int getTableCapacity() {
        return tableCapacity;
    }

    /**
     * Gets the table order reference.
     * @return this table's order reference.
     * */
    public Order getOrder() {
    	return order;
    }
    /**
     * Gets the table invoice reference.
     * @return this table's invoice reference.
     * */
    public Invoice getinvoice() {
    	return invoice;
    }
}
