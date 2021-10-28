package rrpss;

import database.RestaurantDB;

import java.util.*;
import controller.StaffController;

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

        this.tables = new ArrayList<Table>();

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

    //create array list for staffs
    public void createStaffs(){
    	StaffController SC = new StaffController();
    	this.Staffs = SC.initStaffs();
    }
    
    //ui for staffs option
    public void staffsOption(ArrayList<Staff> Staffs) {
    	 StaffController SC= new StaffController();
    	 SC.displayStaffs(Staffs);
    	
    }
    

    public void displayOptions() {
        System.out.println("Select an option to begin: ");
        System.out.println("1. Show Menu interface");
        System.out.println("2. Show Promotion interface");
        System.out.println("3. Show Order interface");
        System.out.println("4. Show Staff Options");
        System.out.println("5. Show Reservation interface");
        System.out.println("6. Show Revenue Report interface");

    }


}
