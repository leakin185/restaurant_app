package rrpss;

public class Table {
	private static int id = 0;
	private int tableNo;
	private int tableCapacity;
	private boolean isReserved = false;
//	private Reservation reservedBy;

	Table(int capacity){
		tableCapacity = capacity;
		tableNo = id++;
	}
	public void addReservation(/* Reservation reservation */) {
		isReserved = true;
//		reservedBy = reservation;
	}

	public void removeReservation() {
		isReserved = false;
//		reservedBy = null;
	}

	public int getTableNo() {
		return tableNo;
	}
	

	public int getTableCapacity() {
		return tableCapacity;
	}

}
