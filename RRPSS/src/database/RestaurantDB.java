package database;

import java.util.*;

import rrpss.Reservation;
import rrpss.Table;
import rrpss.Transaction;
import rrpss.Staff;
import rrpss.MenuItem;
import rrpss.PromotionalPackages;
import rrpss.Member;
/**
 * this class contains acts as a database for the restaurant, contains lists of objects, like Reservation, Staff, Members, etc.
 * @author everyone
 *
 */
public class RestaurantDB {
	/**
	 * ArrayList of reservations that are active
	 */
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    /**
     * ArrayList of completed reservations
     */
    public static ArrayList<Reservation> completedReservations = new ArrayList<Reservation>();
    /**
     * ArrayList of transactions that are made in the restaurant
     */
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    /**
     * ArrayList of tables that exist in the restaurant
     */
    public static ArrayList<Table> tables = new ArrayList<Table>();
    /**
     * ArrayList of staffs who work in the restaurant
     */
    public static ArrayList<Staff> staffs = new ArrayList<Staff>();
    /**
     * ArrayList of menu items that are in the restaurant's menu
     */
    public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    /**
     * ArrayList of registered members
     */
    public static ArrayList<Member> members = new ArrayList<Member>();


}
