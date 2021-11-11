package rrpss;
import java.util.Calendar;
/**
 *
 * @author guangshin
 *
 */

public class Reservation {
    /**
     * ID of a reservation
     */
    private int reservationID;
    /**
     * Table of a reservation
     */
    private Table table;
    /**
     * dateTime of a reservation
     */
    private Calendar dateTime;
    /**
     * paxSize of a reservation
     */
    private int paxSize;
    /**
     * customerContact of a reservation
     */
    private int customerContact;
    /**
     * customerName of a reservation
     */
    private String customerName;

    /**
     * Method for constructor of reservation
     * @param reservationID
     * @param table
     * @param dateTime
     * @param paxSize
     * @param customerContact
     * @param customerName
     */
    public Reservation(int reservationID,Table table, Calendar dateTime, int paxSize, int customerContact, String customerName) {
        this.reservationID = reservationID;
        this.table = table;
        this.dateTime = dateTime;
        this.paxSize = paxSize;
        this.customerContact = customerContact;
        this.customerName = customerName;
    }
    /**
     * Method to get reservation ID
     * @return return reservationID
     */
    public int getReservationID() {
        return reservationID;
    }
    /**
     * Method to set reservation ID
     * @param reservationID
     */
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
    /**
     * Method to get table
     * @return return Table
     */
    public Table getTable() {
        return table;
    }
    /**
     * Method to set tableNo
     * @param table
     */
    public Table setTableNo(Table table) {
        return this. table = table;
    }
    /**
     * Method to get dateTime
     * @return return dateTime
     */
    public Calendar getDateTime() {
        return dateTime;
    }
    /**
     * Method to set dateTime
     * @param dateTime
     */
    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }
    /**
     * Method to get paxSize
     * @return return paxSize
     */
    public int getPaxSize() {
        return paxSize;
    }
    /**
     * Method to set paxSize
     * @param paxSize
     */
    public void setPaxSize(int paxSize) {
        this.paxSize = paxSize;
    }
    /**
     * Method to set table
     * @param table
     */
    public void setTable(Table table) {
        this.table = table;
    }
    /**
     * Method to get customerContact
     * @return return customerContact
     */
    public int getCustomerContact() {
        return customerContact;
    }
    /**
     * Method to set customerContact
     * @param customerContact
     */
    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }
    /**
     * Method to get customerName
     * @return return customerName
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Method to set customerName
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
