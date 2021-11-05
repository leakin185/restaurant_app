package rrpss;

public class Member {
	private int ID;
	private String name;
	private int phone;
	private String memberType;
	private double discount;
	
	public Member(int ID, String name, int phone, String memberType, double discount) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.memberType = memberType;
		this.discount = discount;
		
	}
	
	public int getMemberID(){
		return ID;
	}
	
	public String getMemberName(){
		return name;
	}
	
	public int getMemberPhone(){
		return phone;
	}
	
	public String getMemberType(){
		return memberType;
	}
	
	public double getMemberDiscount(){
		return discount;
	}
}
