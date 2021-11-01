package rrpss;
import java.util.Calendar;


public class Reservation {

    private int reservationID;
    private Table table;
    private Calendar dateTime;
    private int paxSize;
    private int customerContact;
    private String customerName;


    public Reservation(int reservationID,Table table, Calendar dateTime, int paxSize, int customerContact, String customerName) {
        this.reservationID = reservationID;
        this.table = table;
        this.dateTime = dateTime;
        this.paxSize = paxSize;
        this.customerContact = customerContact;
        this.customerName = customerName;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Table getTable() {
        return table;
    }

    public Table setTableNo(Table table) {
        return this. table = table;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public int getPaxSize() {
        return paxSize;
    }

    public void setPaxSize(int paxSize) {
        this.paxSize = paxSize;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
