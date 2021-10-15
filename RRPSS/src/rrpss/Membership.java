package rrpss;

public class Membership {

    private int MembershipID;
    private double discountRate;
    private String membershipType;
    private boolean isValid;

    public Membership(int membershipID, double discountRate, String membershipType, boolean isValid) {
        MembershipID = membershipID;
        this.discountRate = discountRate;
        this.membershipType = membershipType;
        this.isValid = isValid;
    }

    public int getMembershipID() {
        return MembershipID;
    }

    public void setMembershipID(int membershipID) {
        MembershipID = membershipID;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
