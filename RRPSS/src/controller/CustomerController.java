package controller;
import database.RestaurantDB;
import java.util.*;
import rrpss.Customer;
import rrpss.Membership;
import rrpss.Reservation;

import java.util.*;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Customer> customers = RestaurantDB.customers;
    private int idCounter;

    CustomerController(){
        idCounter = 0;
    }

    public int createCustomerWithMembership(int customerID, String customerName, double discountRate, String membershipType, String phoneNum, String emailAddress){
        int id = this.idCounter++;
        Membership membership = createCustomerMembership(discountRate,membershipType);
        Customer customer = new Customer(id,customerName,membership,phoneNum,emailAddress);
        customers.add(customer);
        return id;
    }

    public int createCustomerWithoutMembership(String customerName, String phoneNum, String emailAddress){
        int customerID = this.idCounter++;
        Customer customer = new Customer(customerID,customerName,phoneNum,emailAddress);
        customers.add(customer);
        return customerID;
    }

    public Customer viewCustomer(int customerID){
         for (Customer customer: customers){
             if (customer.getCustomerID() == customerID){
                 return customer;
             }
         }
         return null;
    }

    public Membership createCustomerMembership(double discountRate, String membershipType){
        Membership membership = new Membership(discountRate,membershipType);
        return membership;
    }

}
