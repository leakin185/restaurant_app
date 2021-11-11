package controller;
import rrpss.Staff;
import java.util.ArrayList;
import java.util.Scanner;
import database.RestaurantDB;


public class StaffController {
	//method to add staff
	public StaffController() {
		
	}
	
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
	
	public static boolean checkStaff(int ID) {
		for(Staff staff : RestaurantDB.staffs) {
			if(staff.getID() == ID) return true;
		}
		return false;
	}
	
}
