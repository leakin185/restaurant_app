package rrpss;

import database.RestaurantDB;
import rrpss.Food.CourseType;
import rrpss.Food.Temp;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import controller.StaffController;
import controller.TableController;
import controller.TableOrderInvoiceController;
import ui.FoodMenuUI;
import ui.ReportUI;
import ui.ReservationUI;

import javax.sound.sampled.*;

/**
 * Represents the main driver class.
 * Populates restaurant related data.
 * A restaurant can have many tables.
 * A restaurant can have many staffs.
 * A restaurant can have many menu items.
 * A restaurant can have many members.
 *
 * @author Tjandy Putra
 * @version 1.0
 * @since 2021-10-30
 */
public class RRPSS {

    private  ArrayList<Table> tables = RestaurantDB.tables;
    private ArrayList<Staff> Staffs = RestaurantDB.staffs;
    private  ArrayList<MenuItem> menu = RestaurantDB.menu;
    private ArrayList<Member> members = RestaurantDB.members;




	/**
	 * Creates a new RRPSS object.
	 * Handles the initialization calls of Table, Staff, MenuItem and Member.
	 * */
    RRPSS() {
    	createStaffs(); //initialize arraylist for satffs
        createTables();
        initFoodMenu();
        initMemberList();
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
                        FoodMenuUI.menuShowFoodMenuOptions();
                        break;
                    case 2:
                        // call appropriate ui method
                    	tableOption();
                        break;
                    case 3:
                    	staffsOption();
                        break;
                    case 4:
                    	ReservationUI.showMainMenu();
                        break;
                    case 5:
                    	ReportUI.showReportOptions();
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
    /**
     * Initialize an arraylist of Member objects with dummy data
     */
    private void initMemberList() {
		// TODO Auto-generated method stub
    	ArrayList<Member> members = new ArrayList<Member>();
    	members.add(new Member(1, "Alice", 11111111, "silver", 0.9));
    	members.add(new Member(2, "Bob", 22222222, "gold", 0.8));
    	members.add(new Member(3, "Chad", 33333333, "Platinum", 0.7));
    	members.add(new Member(4, "Dick", 44444444, "Platinum", 0.7));
    	members.add(new Member(5, "Li Fang", 97777777, "Platinum", 0.7));
    	
    	RestaurantDB.members = members;
		
	}
	/**
	 * Initialize an arraylist of Table objects with dummy data
	 */
	private void createTables() {

  

        for (int i = 0; i < 50; i++) {

            Random r = new Random();

            int random = r.nextInt(5) + 1;
            random = (random * 2);

            this.tables.add(new Table(random));
        }


	}

	/**
	 * Display all tables
	 */
    private void displayTables() {
        System.out.println("List of Tables");

        for (int i = 0; i < tables.size(); i++) {

            System.out.println(String.format("Table #%d, Capacity: %d", tables.get(i).getTableNo(), tables.get(i).getTableCapacity()));

        }

    }

    /**
     * Initialize an arraylist of staff objects with dummy data
     */
    private void createStaffs(){
    	RestaurantDB.staffs = StaffController.initStaffs();
    }
    
    //ui for staffs option
    /**
     * user interface with option to display the list of staff information
     */
    private void staffsOption() {
    	 StaffController.displayStaffs();
    	
    }
    
    /**
     * user interface for table options: 1. place order/add/edit order for table 2. print receipt for table 3. print order for table
     */
	private void tableOption() {
    	int tableID, choice, staffID, walkIn, walkInPax;
		tableID = 0;
    	Calendar now;
    	Scanner sc = new Scanner(System.in);
    	StaffController SC = new StaffController();
    	
    	System.out.println("1. New walk-in customer\n2. Customer with reservation\n3. Occupied Table Options\n4. Show Occupied Tables\n");
    	walkIn = sc.nextInt();
    	if(walkIn==1) {
    		now = Calendar.getInstance();
    		Table table;
    		while(true) {
    			System.out.println("Enter pax");
        		walkInPax = sc.nextInt();
        		if(walkInPax>0) break;
        		System.out.println("pax must be more than 0.");
    		}
    		
    		System.out.println("Finding avaliable table...\n");
    		table = TableController.getAvailableTable(now, walkInPax);
    		if(table==null) {
    			System.out.println("Sorry no available table right now\n");
    			return;
    		}
    		else {
    			tableID = table.getTableNo();
    			System.out.println("Found available table, assigning table: \n"+tableID);
    			table.setUnavailable();

    		}
    	}

		else if(walkIn == 2){
			// check against list of reervations

			System.out.println("Please enter the reservation id:");
			if(!sc.hasNextInt()){
				System.out.println("Please enter a valid reservation id!");
				return;
			}

			int rid = sc.nextInt();

			boolean found = false;
			for(int i =0;  i< RestaurantDB.reservations.size();i++){

				if(RestaurantDB.reservations.get(i).getReservationID() == rid){
					System.out.println("Reservation found!");
					found = !found;
					tableID= RestaurantDB.reservations.get(i).getTable().getTableNo();
					RestaurantDB.reservations.get(i).getTable().setUnavailable();
				}
			}
			if(!found){
				System.out.println("No reservation found!");
return;
			}

		}
    	else if(walkIn==3){
    		System.out.println("Enter table number: \n");
        	tableID = sc.nextInt();
        	if(TableController.getTableFromTableNo(tableID).getTableAvailability()) {
        		System.out.println("This table is not assigned yet, returning \n");
        		return;
        	}

    	}
else if(walkIn==4){
	TableController.showOccupiedTable();
	return;
		}
		else{
			System.out.println("Invalid option entered!");
			return;
		}


		while(true) {
			System.out.println("Enter staff ID: ");
			staffID = sc.nextInt();
			if(SC.checkStaff(staffID)) break;
			System.out.println("invalid staff ID!\n");
			return;
		}
    	System.out.println("1. place order/add/edit order for table " + tableID + ": ");
    	System.out.println("2. print receipt for table " + tableID + ": ");
    	System.out.println("3. print order for table " + tableID + ": ");
    	System.out.println("Enter 0 to return");
    	choice = sc.nextInt();
    	while(choice != 0) {
    		switch(choice) {
    		case 1: 
    			TableOrderInvoiceController.setOrderToTable(staffID,tableID);
    			break;
    			
    		case 2:
    			double discount = 1;
    			int c;
    			if(TableController.getTableFromTableNo(tableID).getOrder() == null) {
    				System.out.println("No order yet!\n");
    				break;
    			}
    			System.out.println("Is customer a member?\n1: yes\nOther numeric keys: no\n");
    			c = sc.nextInt();
    			if(c == 1) {
    				int ID = -1;
    				int phone = -1;
    				Scanner m = new Scanner(System.in);
    				int found = 0;
    				System.out.println("Enter member ID: ");
    				ID = m.nextInt();
    				System.out.println("Enter member phone: ");
    				phone = m.nextInt();
    				for(Member member : RestaurantDB.members) {
    					if(member.getMemberID() == ID && member.getMemberPhone() == phone) {
    						System.out.println("Member found: member type: "+member.getMemberType() + "member discount: " + (100-(member.getMemberDiscount()*100))+"% off");
    						found =1;
    						discount = member.getMemberDiscount();
    						break;
    					}
    				}
    				if (found == 0) System.out.println("Cannot find this member, proceeding without discount.");
    				
    			}
    			Invoice invoice = TableOrderInvoiceController.setInvoiceToTable(discount, tableID);
    			
    			if(invoice == null ) break;
    			TableController.getTableFromTableNo(tableID).getinvoice().print();
    			TableOrderInvoiceController.insertTransactionForTableOrder(invoice);
    			//reset table
    			TableController.getTableFromTableNo(tableID).setAvailable();
    			TableController.getTableFromTableNo(tableID).setInvoiceToNull();
    			TableController.getTableFromTableNo(tableID).setOrderToNull();
    			System.out.println("Clearing table...\nTable is available now.\n");
    			return;
    			
    			

    		
    		case 3: 
    			if(TableController.getTableFromTableNo(tableID).getOrder()==null) {
    				System.out.println("No order yet!\n");
    				break;
    			}
    			System.out.println(" ");
    			TableOrderInvoiceController.printCurrentOrderForTable(tableID);
    			System.out.println(" ");
    			
    		case 0: 
    			break;
    			
    		default:
    			System.out.println("Invlaid choice!");
    			System.out.println(" ");
    			break;
    		}
    		System.out.println("1. place order/edit for table " + tableID + ": ");
        	System.out.println("2. print receipt for table " + tableID + ": ");
        	System.out.println("3. print order for table " + tableID + ": ");
        	System.out.println("Enter 0 to return");
        	choice = sc.nextInt();
    	}
    	return;
    	
   	
   }

	/**
	 * Display a list of options for user to interact with different UIs.
	 */
	private void displayOptions() {
        System.out.println("Select an option to begin: ");
        System.out.println("1. Show Menu/Promotion interface");
        System.out.println("2. Show Table options");
        System.out.println("3. Show Staff options");
        System.out.println("4. Show Reservation interface");
        System.out.println("5. Show Revenue Report interface");

    }
	/**
	 * initialize the menu with dummy menu items
	 */
	private static void initFoodMenu(){
		
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		Food food1 = new Food("Burger", "Juicy American burger", 3.50, 1, CourseType.MAIN_COURSE, Temp.HOT);
		Food food2 = new Food("Nuggets", "Nuggets - halal", 1.00, 2, CourseType.MAIN_COURSE, Temp.HOT);
		Food food3 = new Food("Oreo McFlurry", "Ice cream dessert filled with crushed oreos", 3.85, 3, CourseType.DESSERT, Temp.COLD);
		Food food4 = new Food("Apple Ice Cream", "Apple flavoured ice cream dessert", 8.00, 4, CourseType.DESSERT, Temp.COLD);
		Food food5 = new Food("Ice Lemon Tea", "Homemade Ice Lemon Tea", 1.50, 5, CourseType.DRINK, Temp.COLD);
		Food food6 = new Food("Plain Water", "On the house", 0.00, 6, CourseType.DRINK, Temp.COLD);
		Food food7 = new Food("Healthy Fruit Juice", "Mixed fruit juice", 2.00, 7, CourseType.DRINK, Temp.COLD);
		
		PromotionalPackages promo1 = new PromotionalPackages("McNugget Meal", "6pc nuggets in 1", 3.00, 8);
		promo1.addToPromotionSet(food2);
		promo1.addToPromotionSet(food2);
		promo1.addToPromotionSet(food2);
		promo1.addToPromotionSet(food2);
		promo1.addToPromotionSet(food2);
		promo1.addToPromotionSet(food2);

		PromotionalPackages promo2 = new PromotionalPackages("Burger set meal", "Burger set at cheaper price", 5.00,9);
		promo2.addToPromotionSet(food1);
		promo2.addToPromotionSet(food2);
		promo2.addToPromotionSet(food7);

		PromotionalPackages promo3 = new PromotionalPackages("Healthy set meal", "Very healthy meal", 2.00,10);
		promo3.addToPromotionSet(food7);
		promo3.addToPromotionSet(food6);
		promo3.addToPromotionSet(food4);

		menuItems.add((MenuItem) food1);
		menuItems.add((MenuItem) food2);
		menuItems.add((MenuItem) food3);
		menuItems.add((MenuItem) food4);
		menuItems.add((MenuItem) food5);
		menuItems.add((MenuItem) food6);
		menuItems.add((MenuItem) food7);
		menuItems.add((MenuItem) promo1);
		menuItems.add((MenuItem) promo2);
		menuItems.add((MenuItem) promo3);
		
		RestaurantDB.menu = menuItems;
		
	}



}
