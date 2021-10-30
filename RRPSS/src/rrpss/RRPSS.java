package rrpss;

import database.RestaurantDB;

import java.util.*;
import controller.StaffController;
import controller.TableController;
import controller.TableOrderInvoiceController;

public class RRPSS {

    private static ArrayList<Table> tables = RestaurantDB.tables;
    private ArrayList<Staff> Staffs;


    RRPSS() {
    	createStaffs(); //initialize arraylist for satffs
        createTables();
//		displayTables();
        System.out.println("Restaurant Reservation and Point of Sale System");

        int input = 0;
        while (true) {
        	
            displayOptions();
            
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                input = sc.nextInt();


                switch (input) {
                    case 1:
                        // call appropriate ui method
                        break;
                    case 2:
                        // call appropriate ui method
                        break;
                    case 3:
                        // call appropriate ui method
                        break;
                    case 4:
                        staffsOption(Staffs);
                        break;
                    case 5:
                        // call appropriate ui method
                        break;
                    case 6:
                        // call appropriate ui method
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;

                }
            } else {
                System.out.println("Invalid input!");
            }
        }


    }

    public void createTables() {

  

        for (int i = 0; i < 50; i++) {

            Random r = new Random();

            int random = r.nextInt(5) + 1;
            random = (random * 2);

            this.tables.add(new Table(random));
        }
    }

    public void displayTables() {
        System.out.println("List of Tables");

        for (int i = 0; i < tables.size(); i++) {

            System.out.println(String.format("Table #%d, Capacity: %d", tables.get(i).getTableNo(), tables.get(i).getTableCapacity()));

        }

    }

    //Initialise Staffs
    public void createStaffs(){
    	StaffController SC = new StaffController();
    	this.Staffs = SC.initStaffs();
    }
    
    //ui for staffs option
    public void staffsOption(ArrayList<Staff> Staffs) {
    	 StaffController SC= new StaffController();
    	 SC.displayStaffs(Staffs);
    	
    }
    
    //ui for table options
    public void tableOption(ArrayList<Staff> Staffs) {
    	int tableID, choice, staffID;
    	Scanner sc = new Scanner(System.in);
    	StaffController SC = new StaffController();
    	TableController TC = new TableController();
    	TableOrderInvoiceController TOIC = new TableOrderInvoiceController();
    	
    	System.out.println("Enter table number: ");
    	tableID = sc.nextInt();
    	while(true) {
    		System.out.println("Enter staff ID: ");
        	staffID = sc.nextInt();
        	if(SC.checkStaff(Staffs, staffID)) break;
        	System.out.println("invalid staff ID!");
    	};
    	
    	System.out.println("1. place order/add order for table " + tableID + ": ");
    	System.out.println("2. print receipt for table " + tableID + ": ");
    	System.out.println("Enter 0 to return");
    	choice = sc.nextInt();
    	while(choice != 0) {
    		switch(choice) {
    		case 1: 
    			TOIC.setOrderToTable(staffID,tableID);
    			break;
    			
    		case 2:
    			boolean discount = false;
    			String c;
    			System.out.println("Is customer a member? Y/N");
    			//add logic to get membership 
    			c = sc.next();
    			if(c == "Y") discount = true;
    			TOIC.setInvoiceToTable(discount, tableID);
    			//method to print receipt
    			break;
    			
    		case 0: 
    			break;
    			
    		default:
    			break;
    		}
    		System.out.println("1. place order for table " + tableID + ": ");
        	System.out.println("2. print receipt for table " + tableID + ": ");
        	System.out.println("Enter 0 to return");
        	choice = sc.nextInt();
    	}
    	return;
    	
   	
   }

    public void displayOptions() {
        System.out.println("Select an option to begin: ");
        System.out.println("1. Show Menu interface");
        System.out.println("2. Show Promotion interface");
        System.out.println("3. Show Table options");
        System.out.println("4. Show Staff options");
        System.out.println("5. Show Reservation interface");
        System.out.println("6. Show Revenue Report interface");

    }


}
