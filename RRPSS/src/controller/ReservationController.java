package controller;
import database.RestaurantDB;
import rrpss.Reservation;
import rrpss.Customer;
import rrpss.Table;
import java.util.Calendar;
import java.util.*;

public class ReservationController {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Reservation> reservations = RestaurantDB.reservations;
    private static ArrayList<Reservation> completedReservation = RestaurantDB.completedReservations;

    private int idCounter;

    ReservationController(){
        this.idCounter = 0;
    }

    public int createReservation(Table table, Calendar dateTime, int paxSize, Customer customer){
        Calendar currentTime = new GregorianCalendar();
        int reservationID = this.idCounter++;
        //need to wait for table controller to complete to initialise table controller

        if(dateTime.compareTo(currentTime) <= 0){
            return -1; //handle error as reservation cannot have date in the past
        }

        Reservation reservation = new Reservation(reservationID,null,dateTime,paxSize,customer);

        reservations.add(reservation);

        return reservationID;

    }

    public Reservation viewReservation(int reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID() == reservationID){
                return reservation;
            }
        }
        return null; //cannot find reservation
    }

    public int removeReservation(int reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID() == reservationID){
                reservations.remove(reservation); //remove from active reservation list
                return reservationID;
            }
        }
        return -1; //fail to find reservation with input reservationID
    }

    public int completeReservation(int reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID() == reservationID){
                completedReservation.add(reservation); //add to completed reservation list
                reservations.remove(reservation);
                return reservationID;
            }
        }
        return -1; //fail to find reservation with input reservationID
    }

    public int checkReservationExpiry(Reservation reservation){
        Calendar currentTime = Calendar.getInstance();
        if(reservation.getDateTime().before(currentTime)){
            return -1;
        }
        return 1;
    }

    public void removeExpiredReservations(ArrayList<Reservation> reservations){
        for (Reservation reservation : reservations){
            if(checkReservationExpiry(reservation) == -1){
                completeReservation(reservation.getReservationID());
            }
        }
    }

}
