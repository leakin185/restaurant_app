package controller;

import database.RestaurantDB;
import rrpss.Reservation;
import rrpss.Table;

import java.util.ArrayList;
import java.util.Calendar;

public class TableController {


    private static ArrayList<Reservation> reservations = RestaurantDB.reservations;
    private static ArrayList<Table> tables = RestaurantDB.tables;


    public static void showReservationsForTableNo(Table table) {

        System.out.println("Reservations for table #" + table);

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == table.getTableNo()) {
                System.out.println(String.format("Reservation ID #%d, Pax Size: %d", reservations.get(i).getReservationID(),
                        reservations.get(i).getPaxSize()));
            }

        }

    }

    // returns null if no table with tableNo found
    public static Table getTableFromTableNo(int tableNo) {

        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getTableNo() == tableNo) {
                return tables.get(i);
            }

        }

        return null;

    }



    public static void showAvailableTable(Calendar dateTime, int noOfPax) {

        System.out.println("Available tables of size " + noOfPax + " on " + dateTime);

        for (int i = 0; i < tables.size(); i++) {

            boolean isValid = true; // table is available for datetime


            if (tables.get(i).getTableCapacity() == noOfPax) {


                for (int j = 0; j < reservations.size(); j++) {
                    if (reservations.get(j).getTable().getTableNo() == tables.get(i).getTableNo() && reservations.get(j).getDateTime() == dateTime) {
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

    public static Table getAvailableTable(Calendar dateTime, int noOfPax) {

        for (int i = 0; i < tables.size(); i++) {

            boolean isValid = true;

            if (tables.get(i).getTableCapacity() == noOfPax) {
                for (int j = 0; j < reservations.size(); j++) {
                    if (reservations.get(j).getTable().getTableNo() == tables.get(i).getTableNo() && reservations.get(j).getDateTime() == dateTime) {
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
