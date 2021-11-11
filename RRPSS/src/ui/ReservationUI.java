package ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import database.RestaurantDB;
import rrpss.*;
import java.util.Calendar;
import controller.ReservationController;

import controller.TableController;
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
            System.out.println("4) Back to main menu");
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
                case 4:
                    return;
                default:
                    showMainMenu();
                    break;
            }
        }
        while (selection < 4);

    }

    public static void createReservationUI() {
    	ArrayList<Reservation> reservations = RestaurantDB.reservations;
    	ReservationController.removeExpiredReservations(reservations);
        Scanner sc = new Scanner(System.in);
        Table table;
        int paxSize = 0;
        Calendar dateTime;
        int customerContact = 0;
        String customerName;
        String data = "";
        boolean paxSizeIntCheck = false;
        boolean contactIntCheck = false;
        boolean eightDigitCheck = false;

        System.out.println("Enter Customer Name ");
        customerName = sc.nextLine();

        do{
            System.out.println("Enter Pax Size");
            data = sc.nextLine();
            try {
                paxSize = Integer.parseInt(data);
                paxSizeIntCheck = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Integer Number");
                continue;
            }
        }
        while(!paxSizeIntCheck);

        dateTime = inputValidDateTime();

        do{
            System.out.println("Enter Customer Phone Number:");
            data = sc.nextLine();

            try {
                customerContact = Integer.parseInt(data);
                contactIntCheck = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Integer Number");
                continue;
            }

            if(data.length() == 8){
                eightDigitCheck = true;
            } else{
                System.out.println("Invalid Phone Number (Please Enter 8 Digits Only)");
                continue;
            }
        }
        while(!contactIntCheck || !eightDigitCheck);

        if(TableController.getAvailableTable(dateTime,paxSize) == null){
            System.out.println("No Table is available");
        }
        else{
            table = TableController.getAvailableTable(dateTime,paxSize);
            ReservationController.createReservation(table, dateTime,paxSize, customerContact,customerName);
            System.out.println("Reservation is successfully made!");
            System.out.println("Customer Name " + customerName);
            System.out.println("Customer Contact " + customerContact);
            System.out.println("Date Time " + dateTime.getTime());
            System.out.println("Pax Size " + paxSize);
            System.out.println("Table "+table.getTableNo());
        }
    }

    public static void showReservation() {
        ArrayList<Reservation> reservations = RestaurantDB.reservations;
        ReservationController.removeExpiredReservations(reservations);
        int i = 1;
        if(reservations.size() == 0 ){
            System.out.println("No reservations have been made yet!");
        }
        for (Reservation reservation : reservations) {
            System.out.println(i + ") Reservation ID:  " + reservation.getReservationID());
            System.out.println("Customer Name " + reservation.getCustomerName());
            System.out.println("Contact Number: "+ reservation.getCustomerContact());
            System.out.println("Reservation Time:"+ reservation.getDateTime().getTime());
            System.out.println("Pax Size " + reservation.getPaxSize());
            System.out.println("Table "+reservation.getTable().getTableNo());
            i++;
            System.out.println("\n");
        }
    }

    public static void removeReservation() {
        ArrayList<Reservation> reservations = RestaurantDB.reservations;
        ReservationController.removeExpiredReservations(reservations);
        int i = 1;
        boolean validIndexCheck = false;

        for (Reservation reservation : reservations) {
            System.out.println(i + ") Reservation ID:  " + reservation.getReservationID());
            System.out.println("Customer Name " + reservation.getCustomerName());
            System.out.println("Contact Number: "+ reservation.getCustomerContact());
            System.out.println("Reservation Time:"+ reservation.getDateTime().getTime());
            System.out.println("Pax Size " + reservation.getPaxSize());
            System.out.println("Table "+reservation.getTable().getTableNo());
            System.out.println("\n");
            i++;
        }

        do{
            System.out.println("Enter the reservationID of the reservation to be removed");
            int selection = scanner.nextInt();

            if(selection < i){
                ReservationController.removeReservation(reservations.get(selection).getReservationID());
                validIndexCheck = true;
            } else {
                System.out.println("Invalid reservationID!");
                continue;
            }
        }
        while(!validIndexCheck);
    }

    public static Calendar inputValidDateTime(){
        Scanner scanner = new Scanner(System.in);
        String date = "";
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        Calendar arrivalTime = Calendar.getInstance();
        Calendar currentTime = new GregorianCalendar();
        boolean expiredDate = true;


        do{
            System.out.print("Enter reservation datetime (dd/mm/yyyy hh:mm): ");
            date  = scanner.nextLine();
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            try {
                parsedDate = dateFormat.parse(date);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Please re-enter datetime in the correct format (dd/mm/yyyy hh:mm): ");
                continue;
            }

            arrivalTime.setTime(parsedDate);

            if(arrivalTime.compareTo(currentTime) <= 0){
                System.out.println("Please re-enter datetime with a valid date in the future (dd/mm/yyyy hh:mm): ");
                continue;
            }
            else{
                expiredDate = false;
            }

        } while(!validDate || expiredDate);

        return arrivalTime;
    }
}
