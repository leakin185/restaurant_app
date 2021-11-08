package rrpss;
/**
 * Represent a member of the restaurant
 * @author Chew Poshi
 *
 */
public class Member {
	/**
	 * ID of a membership
	 */
	private int ID;
	/**
	 * name of a member
	 */
	private String name;
	/**
	 * phone number of the member
	 */
	private int phone;
	/**
	 * membership type of the member, silver, gold and platinum
	 */
	private String memberType;
	/**
	 * discount rate for the member
	 */
	private double discount;
	/**
	 * Constructor for the member object
	 * @param ID
	 * @param name
	 * @param phone
	 * @param memberType
	 * @param discount
	 */
	public Member(int ID, String name, int phone, String memberType, double discount) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.memberType = memberType;
		this.discount = discount;
		
	}
	/**
	 * return the ID of a member
	 * @return
	 */
	public int getMemberID(){
		return ID;
	}
	/**
	 * return the name of a member
	 * @return
	 */
	public String getMemberName(){
		return name;
	}
	/**
	 * return the phone number of a member
	 * @return
	 */
	public int getMemberPhone(){
		return phone;
	}
	/**
	 * return the membership type of a member
	 * @return
	 */
	public String getMemberType(){
		return memberType;
	}
	/**
	 * return the discount of a member
	 * @return
	 */
	public double getMemberDiscount(){
		return discount;
	}
}
