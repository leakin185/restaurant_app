package controller;

import database.RestaurantDB;
import rrpss.Reservation;
import rrpss.Table;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Represents Table Controller which will be used to operate Table related actions
 *
 * @author Tjandy Putra
 * @version 1.0
 * @since 2021-10-30
 */

public class TableController {

    private static ArrayList<Reservation> reservations = RestaurantDB.reservations;
    private static ArrayList<Table> tables = RestaurantDB.tables;

    /**
     * Retrieve all and print reservations for table.
     * @param table The table to retrieve reservations for.
     */
    public static void showReservationsForTableNo(Table table) {

        System.out.println("Reservations for table #" + table);

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == table.getTableNo()) {
                System.out.println(String.format("Reservation ID #%d, Pax Size: %d",
                        reservations.get(i).getReservationID(), reservations.get(i).getPaxSize()));
            }

        }

    }

    // returns null if no table with tableNo found
    /**
     * Retrieve table object reference given the table number.
     * @param tableNo The number to retrieve table object reference from.
     */
    public static Table getTableFromTableNo(int tableNo) {

        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getTableNo() == tableNo) {
                return tables.get(i);
            }

        }

        return null;

    }

    /**
     * Retrieve and print all currently occupied table.
     */
    public static void showOccupiedTable() {
        boolean anyOccupied = false;
        for (int i = 0; i < tables.size(); i++) {

if(tables.get(i).getTableAvailability() == false){
    System.out.println("Table #"+tables.get(i).getTableNo() + " is currently occupied");
  anyOccupied = true;
}



        }

        if(!anyOccupied){
            System.out.println("No tables are occupied at the moment");

        }


    }

    /**
     * Print all tables available for booking based on the specified date time and no. of pax.
     * @param dateTime The date time to search for.
     * @param noOfPax The number of people looking to get a table.
     */
        public static void showAvailableTable(Calendar dateTime, int noOfPax) {

        System.out.println("Available tables of size " + noOfPax + " on " + dateTime);

        for (int i = 0; i < tables.size(); i++) {

            boolean isValid = true; // table is available for datetime

            if (tables.get(i).getTableCapacity() == noOfPax) {

                for (int j = 0; j < reservations.size(); j++) {

                    Calendar tempCal = (Calendar) dateTime.clone();
                    tempCal.add(Calendar.MINUTE, -60);

                    if (reservations.get(j).getTable().getTableNo() == tables.get(i).getTableNo() &&
                            tempCal.getTime().before(reservations.get(j).getDateTime().getTime())
                    ) {
                        isValid = false;
                        break;
                    }

                }

                if (isValid) {
                    System.out.println("Table No. " + tables.get(i).getTableNo() + "is available for booking");

                }

            }

        }

    }


    /**
     * Retrieve the first available for booking based on the specified date time and no. of pax.
     * @param dateTime The date time to search by.
     * @param noOfPax The number of people looking to get a table.
     */

    public static Table getAvailableTable(Calendar dateTime, int noOfPax) {
        int numToSearch = (noOfPax % 2 == 0) ? noOfPax : (noOfPax + 1);

        for (int i = 0; i < tables.size(); i++) {

            boolean isValid = true;

            if (tables.get(i).getTableCapacity() == numToSearch && tables.get(i).getTableAvailability() == true) {

                for (int j = 0; j < reservations.size(); j++) {

                    Calendar tempCal = (Calendar) dateTime.clone();
                    tempCal.add(Calendar.MINUTE, -60);


                    if (reservations.get(j).getTable().getTableNo() == tables.get(i).getTableNo() &&
                            tempCal.getTime().before(reservations.get(j).getDateTime().getTime())
                    ) {

                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    return tables.get(i);
                }
            }

        }
        return null;
    }

}
