package controller;
import rrpss.Staff;
import java.util.ArrayList;
import java.util.Scanner;
import database.RestaurantDB;

/**
 * controller class to handle instruction on the Staff class
 * @author Chew Poshi
 *
 */
public class StaffController {
	/**
	 * Constructor for the class
	 */
	public StaffController() {
		
	}
	/**
	 * function to initialize the list of Staffs with dummy data
	 * @return list of Staff items
	 */
	public static ArrayList<Staff> initStaffs() {
		ArrayList<Staff> temp = new ArrayList<Staff>();
		Staff J = new Staff(Staff.Gender.male, "Ben", Staff.JobTitle.manager);
		temp.add(J);
		J = new Staff(Staff.Gender.female, "Kate", Staff.JobTitle.waiter);
		temp.add(J);
		J = new Staff(Staff.Gender.male, "Simon", Staff.JobTitle.waiter);
		temp.add(J);
		J = new Staff(Staff.Gender.female, "Dave", Staff.JobTitle.kitchenStaff);
		temp.add(J);
		J = new Staff(Staff.Gender.female, "Chris", Staff.JobTitle.kitchenStaff);
		temp.add(J);
		
		return temp;
	
	}
	/**
	 * function to display all staff information
	 */
	public static void displayStaffs() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
    	System.out.println("Press 1 to display staff information: ");
    	System.out.println("Press other keys to quit: \n");
    	int so = sc.nextInt();
    	if(so == 1) {
    		System.out.println("staff ID:\tname:\tgender\tjob title:");
    		for(Staff s : RestaurantDB.staffs) {
    			
    			 System.out.println(s.getID()+"\t\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getJobTitle());
    		}
    		System.out.println();
    	}
    	else return;
	
	}
	/**
	 * function with check whether a staff ID is valid
	 * @param ID represents staffID
	 * @return whether a staff ID is valid
	 */
	public static boolean checkStaff(int ID) {
		for(Staff staff : RestaurantDB.staffs) {
			if(staff.getID() == ID) return true;
		}
		return false;
	}
	
}
