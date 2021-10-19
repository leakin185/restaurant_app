package rrpss;

public class Membership {

    private double discountRate;
    private String membershipType;

    public Membership(double discountRate, String membershipType) {

        this.discountRate = discountRate;
        this.membershipType = membershipType;
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

}
