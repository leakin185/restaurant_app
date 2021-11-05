package rrpss;

public class Member {
	private String name;
	private String phone;
	private String memberType;
	private double discount;
	
	public Member(String name, String phone, String memberType, double discount) {
		this.name = name;
		this.phone = phone;
		this.memberType = memberType;
		this.discount = discount;
		
	}
	
	public String getMemberName(){
		return name;
	}
	
	public String getMemberPhone(){
		return phone;
	}
	
	public String getMemberType(){
		return memberType;
	}
	
	public double getMemberDiscount(){
		return discount;
	}
}
