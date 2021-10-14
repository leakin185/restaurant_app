package rrpss;

public class MainCourse {
	private int mainCourseId;
	private double mainCoursePrice; 
	
	// Constructor for class
    public MainCourse(int mainCourse_id) {
        this.mainCourseId = mainCourse_id;
    }
    
    public void setPrice(int mainCourseId, double price) {
        if (this.mainCourseId == mainCourseId) {
        	this.mainCoursePrice = price;
        }
    }
    public double getMainCoursePrice() {
        return mainCoursePrice;
    }

    public double getMainCourseId() {
        return mainCourseId;
    }
}
