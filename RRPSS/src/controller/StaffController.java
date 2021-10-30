package controller;
import rrpss.Staff;
import java.util.ArrayList;
import java.util.Scanner;
import database.RestaurantDB;


public class StaffController {
	//method to add staff
	public StaffController() {
		
	}
	
	public ArrayList<Staff> initStaffs() {
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
	
	public void displayStaffs() {
		Scanner sc = new Scanner(System.in);
    	System.out.println("Press 1 to display staff information: ");
    	System.out.println("Press other keys to quit: ");
    	int so = sc.nextInt();
    	if(so == 1) {
    		for(Staff s : RestaurantDB.staffs) {
    			 System.out.println("\t" + s.getID()+" "+s.getName()+" "+s.getGender()+" "+s.getJobTitle());
    		}
    	}
    	else return;
	
	}
	
	public boolean checkStaff(int ID) {
		for(Staff staff : RestaurantDB.staffs) {
			if(staff.getID() == ID) return true;
		}
		return false;
	}
	
}
