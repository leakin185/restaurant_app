package rrpss;

import java.lang.Math;
import controller.StaffController;
/**
 * Represent a staff working in employed in the restaurant
 * @author Chew Poshi
 *
 */
public class Staff {
	/**
	 * Gender of the staff: male or female
	 */
	public enum Gender
	{
		male, female;
	}
	/**
	 * Job title of the staff: manager, waiter, kitchenStaff
	 */
	public enum JobTitle
	{
		manager, waiter, kitchenStaff;
	}
	//attributes
	/**
	 * index used to generate incrementing ID
	 */
	private static int index = 1;
	/**
	 * staffID for staff
	 */
	private int staffID = 1;
	/**
	 * gender for staff
	 */
	private Gender gender;
	/**
	 * name of staff
	 */
	private String name;
	/**
	 * job title of staff
	 */
	private JobTitle jobTitle; 
	
	//constructor
	/**
	 * Constructor of Staff object
	 * @param gender
	 * @param name
	 * @param jobTitle
	 */
	public Staff(Gender gender, String name, JobTitle jobTitle) {
		this.staffID = index++;
		this.gender = gender;
		this.name = name;
		this.jobTitle = jobTitle;
	}
	

	//remove staff, returns the index of the staff in the arraylist, delete from caller class
	/**
	 * function to remove a staff from the data base
	 * @param staffs
	 * @param staffID
	 * @return index of the staff's psotion in the array
	 */
	public int removeStaff(Staff[] staffs, int staffID) {
		for(int i = 0; i<staffs.length; i++) {
			if(staffs[i].staffID == staffID)
				return i;
		}
		return 0;
	}
	/**
	 * return staffID of staff
	 * @return staffID of staff
	 */
	public int getID() {
		return staffID;
	}
	/**
	 * return gender of staff
	 * @return gender of staff
	 */
	public String getGender() {
		return gender.toString();
	}
	/**
	 * return name of staff
	 * @return name of staff
	 */
	public String getName() {
		return name;
	}
	/**
	 * return job title of staff
	 * @return job title of staff
	 */
	public String getJobTitle() {
		return jobTitle.toString();
	}
	
}
