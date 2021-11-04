package rrpss;

import database.RestaurantDB;
import rrpss.Food.CourseType;
import rrpss.Food.Temp;

import java.util.*;
import java.time.LocalDateTime;
import controller.StaffController;
import controller.TableController;
import controller.TableOrderInvoiceController;
import ui.FoodMenuUI;
import ui.ReservationUI;

public class RRPSS {

    private static ArrayList<Table> tables = RestaurantDB.tables;
    private ArrayList<Staff> Staffs = RestaurantDB.staffs;
    private static ArrayList<MenuItem> menu = RestaurantDB.menu;


    RRPSS() {
    	createStaffs(); //initialize arraylist for satffs
        createTables();
        initFoodMenu();
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
                        FoodMenuUI.menuShowFoodMenuOptions();
                        break;
                    case 3:
                    	tableOption();
                        break;
                    case 4:
                        staffsOption();
                        break;
                    case 5:
                        ReservationUI.showMainMenu();
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
    	RestaurantDB.staffs = SC.initStaffs();
    }
    
    //ui for staffs option
    public void staffsOption() {
    	 StaffController SC= new StaffController();
    	 SC.displayStaffs();
    	
    }
    
    //ui for table options
    public void tableOption() {
    	int tableID, choice, staffID;
    	Scanner sc = new Scanner(System.in);
    	StaffController SC = new StaffController();
    	TableOrderInvoiceController TOIC = new TableOrderInvoiceController();
    	//show available tables for walk in customer
    	//to-do validate entered table id
    	System.out.println("Enter table number: ");
    	tableID = sc.nextInt();
    	while(true) {
    		System.out.println("Enter staff ID: ");
        	staffID = sc.nextInt();
        	if(SC.checkStaff(staffID)) break;
        	System.out.println("invalid staff ID!");
    	};
    	
    	System.out.println("1. place order/add order for table " + tableID + ": ");
    	System.out.println("2. print receipt for table " + tableID + ": ");
    	System.out.println("3. print order for table " + tableID + ": ");
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
    			Invoice invoice = TOIC.setInvoiceToTable(discount, tableID);
    			
    			if(invoice == null ) break;
    			TableController.getTableFromTableNo(tableID).getinvoice().print();
    			TableOrderInvoiceController.insertTransactionForTableOrder(invoice);

    			
    			break;
    		
    		case 3: 
    			if(TableController.getTableFromTableNo(tableID).getOrder()==null) {
    				System.out.println("No order yet!");
    				break;
    			}
    			System.out.println(" ");
    			TOIC.printCurrentOrderForTable(tableID);
    			System.out.println(" ");
    			
    		case 0: 
    			break;
    			
    		default:
    			System.out.println("Invlaid choice!");
    			System.out.println(" ");
    			break;
    		}
    		System.out.println("1. place order for table " + tableID + ": ");
        	System.out.println("2. print receipt for table " + tableID + ": ");
        	System.out.println("3. print order for table " + tableID + ": ");
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
    
    public static void initFoodMenu(){
		
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
