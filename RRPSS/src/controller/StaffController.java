package controller;
import rrpss.Staff;
import java.util.ArrayList;


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
}
