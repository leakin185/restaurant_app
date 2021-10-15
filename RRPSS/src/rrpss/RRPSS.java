package rrpss;

import java.util.*;

public class RRPSS {

	private ArrayList<Table> tables;

	RRPSS() {
		createTables();
//		displayTables();
		System.out.println("Restaurant Reservation and Point of Sale System");
	}

	public void createTables() {

		this.tables = new ArrayList<Table>();

		for (int i = 0; i < 50; i++) {

			Random r = new Random();

			int random = r.nextInt(5)+1;
			random = (random * 2);

			this.tables.add(new Table(random));
		}
	}

	public void displayTables() {
		System.out.println("List of Tables");

		for (int i = 0; i < tables.size(); i++) {
				
			System.out.println(String.format("Table #%d, Capacity: %d", tables.get(i).getTableNo(),tables.get(i).getTableCapacity()));

		}

	}

	public void displayOptions() {

	}

}
