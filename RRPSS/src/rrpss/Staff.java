package rrpss;

import java.lang.Math;

enum Gender
{
	male, female;
}

enum JobTitle
{
	manager, waiter, kitchenStaff;
}

public class Staff {
	
	//attributes
	private static int staffID = 1;
	private Gender gender;
	private String name;
	private JobTitle jobTitle; 
	
	//constructor
	public Staff(Gender gender, String name, JobTitle jobTitle) {
		this.staffID = staffID++;
		this.gender = gender;
		this.name = name;
		this.jobTitle = jobTitle;
	}
	
	//remove staff, returns the index of the staff in the arraylist, delete from caller class
	public int removeStaff(Staff[] staffs, int staffID) {
		for(int i = 0; i<staffs.length; i++) {
			if(staffs[i].staffID == staffID)
				return i;
		}
		return 0;
	}
	
	public int getID() {
		return staffID;
	}
	
	public String getGender() {
		return gender.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public String getJobTitle() {
		return jobTitle.toString();
	}
	
}
