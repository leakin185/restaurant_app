package ui;
import java.util.*;

import database.RestaurantDB;
import rrpss.*;
import java.util.Calendar;
import controller.CustomerController;
import controller.ReservationController;
import ui.CustomerUI;
//need to import table controller

public class ReservationUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        int selection;

        do {
            System.out.println("Enter your choice:");
            System.out.println("1) Create Reservation");
            System.out.println("2) Remove reservation");
            System.out.println("3) Show reservations");
            selection = scanner.nextInt();

            switch(selection){
                case 1:
                    createReservationUI();
                    break;
                case 2:
                    removeReservation();
                    break;
                case 3:
                    showReservation();
                    break;
                default:
                    showMainMenu();
                    break;
            }
        }
        while (selection < 7);

    }

    public static void createReservationUI() {
        Table table; //TODO : need to get Table Class before being able to implement Table Parsing
        int paxSize;
        Calendar dateTime;
        Customer customer;
        customer = ui.CustomerUI.showMainMenu(); //Customer UI will handle this function
        System.out.println("Enter Pax Size \n");
        paxSize = scanner.nextInt();
        System.out.println("Enter Date Time\n"); //TODO : need to create a function to handle datetime
//        dateTime = scanner.next();

//        ReservationController.createReservation(table, dateTime,paxSize, customer);
    }

    public static void showReservation() {
        ArrayList<Reservation> reservations = RestaurantDB.reservations;
        ReservationController.removeExpiredReservations(reservations);
        int i = 1;
        for (Reservation reservation : reservations) {
            i++;
            System.out.println(i + ") " + reservation);
        }
    }

    public static void removeReservation() {
        ArrayList<Reservation> reservations = RestaurantDB.reservations;
        ReservationController.removeExpiredReservations(reservations);
        int i = 0;
        for (Reservation reservation : reservations) {
            i++;
            System.out.println(i + ") " + reservation);
        }
        System.out.println("Enter the index of reservation to be removed");
        int selection = scanner.nextInt();

        if (selection < i) {
            ReservationController.removeReservation(reservations.get(i).getReservationID());
            System.out.println("Reservation successfully removed");
        }
    }
}
