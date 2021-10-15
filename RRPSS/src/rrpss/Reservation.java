package rrpss;

public class Reservation {

    private int reservationID;
    private int tableNo;
    private String dateTime;
    private int paxSize;

    public Reservation(int reservationID, int tableNo, String dateTime, int paxSize) {
        this.reservationID = reservationID;
        this.tableNo = tableNo;
        this.dateTime = dateTime;
        this.paxSize = paxSize;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getPaxSize() {
        return paxSize;
    }

    public void setPaxSize(int paxSize) {
        this.paxSize = paxSize;
    }
}
