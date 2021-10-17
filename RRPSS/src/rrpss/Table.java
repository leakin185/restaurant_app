package rrpss;

import java.util.ArrayList;

public class Table {
	private static int id = 1;
	private int tableNo;
	private int tableCapacity;
	private boolean isAvailable = true;
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	private Invoice invoice;
	private Order order;

	Table(int capacity) {
		tableCapacity = capacity;
		tableNo = id++;
	}

	public void setOrder(Order order) {

		this.order = order;

	}

	public void setOrder(Invoice invoice) {

		this.invoice = invoice;

	}

	public void addReservation(Reservation reservation) {

		this.reservations.add(reservation);

	}

	public void removeReservation(int reservationId) {

		for (int i = 0; i < reservations.size(); i++) {

			if (reservations.get(i).getReservationID() == id) {
				reservations.remove(i);
				System.out.println("Reservation removed successfully!");
				return;
			}
		}

		System.out.println("No reservation found!");

	}

	public void showReservations() {

		System.out.println("Reservations for the table:");

		for (int i = 0; i < reservations.size(); i++) {

			System.out.println(String.format("Reservation ID #%d, Pax Size: %d", reservations.get(i).getReservationID(),
					reservations.get(i).getPaxSize()));

		}

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

	public int getTableCapacity() {
		return tableCapacity;
	}

}
