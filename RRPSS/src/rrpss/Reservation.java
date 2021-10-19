package rrpss;
import java.util.Calendar;

public class Reservation {

    private int reservationID;
    private Table table;
    private Calendar dateTime;
    private int paxSize;
    private Customer customer;

    public Reservation(int reservationID,Table table, Calendar dateTime, int paxSize, Customer customer) {
        this.reservationID = reservationID;
        this.table = table;
        this.dateTime = dateTime;
        this.paxSize = paxSize;
        this.customer = customer;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Table getTableNo() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
