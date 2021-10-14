package rrpss;

public class Customer {

    private int customerID;
    private boolean isMember;
    private String phoneNum;
    private String emailAddress;

    public Customer(int customerID, boolean isMember, String phoneNum, String emailAddress) {
        this.customerID = customerID;
        this.isMember = isMember;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
    }

    public Customer(int customerID, boolean isMember) {
        this.customerID = customerID;
        this.isMember = isMember;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void deleteCustomer(int customerID){

    }

}
