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
 * @author user
 *
 */
public class RestaurantDB {
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    public static ArrayList<Reservation> completedReservations = new ArrayList<Reservation>();
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public static ArrayList<Table> tables = new ArrayList<Table>();
    public static ArrayList<Staff> staffs = new ArrayList<Staff>();
    public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    public static ArrayList<Member> members = new ArrayList<Member>();


}
