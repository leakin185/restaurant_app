package database;

import java.util.*;

import rrpss.Reservation;
import rrpss.Customer;
import rrpss.Table;
import rrpss.Transaction;
import rrpss.Staff;
import rrpss.MenuItem;
import rrpss.Food;

public class RestaurantDB {
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    public static ArrayList<Reservation> completedReservations = new ArrayList<Reservation>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public static ArrayList<Table> tables = new ArrayList<Table>();
    public static ArrayList<Staff> staffs = new ArrayList<Staff>();
    public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();


}
