package rrpss;

import database.RestaurantDB;

import java.util.*;

public class RRPSS {

	private static ArrayList<Table> tables = RestaurantDB.tables;


	RRPSS() {
		createTables();
//		displayTables();
		System.out.println("Restaurant Reservation and Point of Sale System");
		
		displayOptions();
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
	
	//create array list for staffs
	public void createStaff() {
		
	}
	
	//remove staff
	public void removeStaff() {
			
	}

	public void displayOptions() {
		System.out.println("Select an option to begin: ");
		System.out.println("1. Show Menu interface");
		System.out.println("2. Show Promotion interface");
		System.out.println("3. Show Order interface");
		System.out.println("4. Show Order interface");
		System.out.println("5. Show Reservation interface");
		System.out.println("6. Show Revenue Report interface");

	}

}
