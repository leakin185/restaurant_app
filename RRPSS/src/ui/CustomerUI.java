package ui;
import java.util.Scanner;
import database.RestaurantDB;
import java.util.*;
import rrpss.Customer;
import rrpss.Membership;
import rrpss.Reservation;
import controller.CustomerController;

public class CustomerUI {
    private static Scanner scanner = new Scanner(System.in);

    public static Customer showMainMenu(){
        int selection;
        Customer customer = null;
        do{
            System.out.println("Enter your choice:");
            System.out.println("1) Create New Customer with Membership");
            System.out.println("2) Create New Customer without Membership");
            System.out.println("3) View Existing Customer");
            selection = scanner.nextInt();

            switch(selection){
                case 1:
                    customer = createNewCustomerWithMembershipUI();
                    break;
                case 2:
                    customer = createNewCustomerWithoutMembershipUI();
                    break;
                case 3:
                    customer = viewExistingCustomer();
                    break;
                default:
                    showMainMenu();
                    break;
            }
        }
        while(selection < 4);

        return customer;
    }

    public static Customer createNewCustomerWithMembershipUI(){
        String customerName;
        double discountRate;
        String membershipType;
        String phoneNum;
        String emailAddress;
        Customer customer;

        System.out.println("Enter Customer Name \n");
        customerName = scanner.nextLine();
        System.out.println("Enter discount rate \n");
        discountRate = scanner.nextDouble();
        System.out.println("Enter Membership Type \n");
        membershipType = scanner.nextLine();
        System.out.println("Enter phone number \n");
        phoneNum = scanner.nextLine();
        System.out.println("Enter email address \n");
        emailAddress = scanner.nextLine();

        customer = CustomerController.createCustomerWithMembership(customerName,discountRate,membershipType,phoneNum,emailAddress);

        System.out.println("You have successfully created a new customer with membership! \n");
        System.out.println("New customer details: \n");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Email Address: " + emailAddress);

        return customer;
    }

    public static Customer createNewCustomerWithoutMembershipUI(){
        String customerName;
        String phoneNum;
        String emailAddress;
        Customer customer;

        System.out.println("Enter Customer Name \n");
        customerName = scanner.nextLine();
        System.out.println("Enter phone number \n");
        phoneNum = scanner.nextLine();
        System.out.println("Enter email address \n");
        emailAddress = scanner.nextLine();

        customer = CustomerController.createCustomerWithoutMembership(customerName,phoneNum,emailAddress);

        System.out.println("You have successfully created a new customer with membership! \n");
        System.out.println("New customer details: \n");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Email Address: " + emailAddress);

        return customer;
    }

    public static Customer viewExistingCustomer(){
        int customerIDLookup;
        Customer customerLookup;

        System.out.println("Enter Customer ID \n");
        customerIDLookup = scanner.nextInt();
        customerLookup = CustomerController.viewCustomer(customerIDLookup);

        if(customerLookup == null){
            System.out.println("Customer not found in restaurant database! \n");
            System.out.println("Do you wish to create a new customer profile? \n");
            System.out.println("Enter 1 to create a new customer profile \n");
            System.out.println("Enter 0 to exit to main menu \n");
            int choice = scanner.nextInt();

            if(choice == 0){
                return null;
            }
            else if (choice == 1){
                System.out.println("Do you wish to create a new customer profile with membership or without membership? \n");
                System.out.println("Enter 1 to create a new customer profile with membership \n");
                System.out.println("Enter 0 to create a new customer profile without membership \n");
                int choice2 = scanner.nextInt();
                if(choice2 == 0){
                    createNewCustomerWithMembershipUI();
                }
                else if (choice2 == 1){
                    createNewCustomerWithoutMembershipUI();
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            else{
                System.out.println("Invalid input");
            }
        }
        else{
            System.out.println("Customer Details with ID " +customerIDLookup +"\n");
            System.out.println("Customer Name: " + customerLookup.getCustomerName());
            System.out.println("Phone Number: " + customerLookup.getPhoneNum());
            System.out.println("Email Address: " + customerLookup.getEmailAddress());
        }
        return customerLookup;
    }
}
