package ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import controller.TableController;
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
        ArrayList<Table> tables = RestaurantDB.tables;
        Table table;
        int paxSize;
        Calendar dateTime;
        Customer customer;
        customer = ui.CustomerUI.showMainMenu(); //Customer UI will handle this function
        System.out.println("Enter Pax Size \n");
        paxSize = scanner.nextInt();
        System.out.println("Enter Date Time\n");
        dateTime = inputValidDateTime();
        TableController.showAvailableTable(dateTime,paxSize);
        System.out.println("Enter Table No. to be reserved: ");
        int choice = scanner.nextInt();;
        if(tables.get(choice).getTableAvailability() == false){
            System.out.println("No Table is available");
        }
        else{
            table = tables.get(choice);
            ReservationController.createReservation(table, dateTime,paxSize, customer);
        }
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

    public static Calendar inputValidDateTime(){
        Scanner scanner = new Scanner(System.in);
        String date = "";
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        Calendar arrivalTime = Calendar.getInstance();

        do{
            System.out.print("Enter reservation datetime (dd/MM/yyyy HH:mm): ");
            date  = scanner.nextLine();
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("Please re-enter datetime in the correct format (dd/MM/yyyy HH:mm): ");
                continue;
            }

            arrivalTime.setTime(parsedDate);

        } while(!validDate);

        return arrivalTime;
    }
}
