package controller;
import database.RestaurantDB;
import rrpss.Reservation;
import rrpss.Table;

import java.util.*;

/**
 *
 * @author guangshin
 *
 */

public class ReservationController {

    private static Scanner scanner = new Scanner(System.in);
    /**
     * reservation from reservations in main DB
     */
    private static ArrayList<Reservation> reservations = RestaurantDB.reservations;
    /**
     * reservation from completed reservations in main DB
     */
    private static ArrayList<Reservation> completedReservation = RestaurantDB.completedReservations;
    /**
     * idCounter for reservations
     */
    private static int idCounter;

    ReservationController(){
        this.idCounter = 0;
    }
    /**
     * Method for creating a reservation
     * @param table
     * @param dateTime
     * @param paxSize
     * @param customerContact
     * @param customerName
     * @return status of the reservation if it is completed sucessfully
     */
    public static int createReservation(Table table, Calendar dateTime, int paxSize, int customerContact, String customerName){
        int reservationID = idCounter++;

        Reservation reservation = new Reservation(reservationID,table,dateTime,paxSize,customerContact,customerName);

        reservations.add(reservation);

        return reservationID;

    }
    /**
     * Method for view a reservation
     * @param reservationID
     * @return reservation that is queried
     */
    public Reservation viewReservation(int reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID() == reservationID){
                return reservation;
            }
        }
        return null; //cannot find reservation
    }
    /**
     * Method for remove a reservation
     * @param reservationID
     * @return status of the reservation if removed successfully
     */
    public static int removeReservation(int reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID() == reservationID){
                reservations.remove(reservation); //remove from active reservation list
                return reservationID;
            }
        }
        return -1; //fail to find reservation with input reservationID
    }
    /**
     * Method for completing reservation
     * @param reservationID
     * @return reservationID of the completed reservation
     */
    public static int completeReservation(int reservationID){
    	if(reservations.size() != 0 ){
	        for (Reservation reservation : reservations){
	            if (reservation.getReservationID() == reservationID){
	                completedReservation.add(reservation); //add to completed reservation list
	                reservations.remove(reservation);
	                return reservationID;
	            }
	        }
        }
        return -1; //fail to find reservation with input reservationID
    }
    /**
     * Method for checking reservation expiry
     * @param reservation
     * @return status of the reservation if expired
     */
    public static int checkReservationExpiry(Reservation reservation){
        Calendar expiredDateTime = Calendar.getInstance();
        expiredDateTime.add(Calendar.MINUTE, -15);
        if(reservation.getDateTime().before(expiredDateTime)){
            return -1;
        }
        return 1; 
    }
    public static void removeExpiredReservations(ArrayList<Reservation> reservations){

        List<Reservation> removed = new ArrayList<Reservation>();

        if(reservations.size() != 0 ){
	        for (Reservation reservation : reservations){
	            if(checkReservationExpiry(reservation) == -1){
	            	completedReservation.add(reservation); //add to completed reservation list
                    removed.add(reservation);
	            	//completeReservation(reservation.getReservationID());
	            }
	        }
            reservations.removeAll(removed);

        }
    }
}
