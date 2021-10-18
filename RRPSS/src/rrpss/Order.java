package rrpss;

import java.util.ArrayList; // import the ArrayList class
import java.lang.Math;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Order {
	private int orderID;
	private String dateCreated;
	private int handlingStaff;
	private boolean discount;
	private ArrayList<orderItem> orderList; 
	private double totalPrice;
	private int tableID;
	
	//constructor
	public Order(int staffID, int tableID) {
		this.orderID = (int) (Math.random() *100000);
		//get current time
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE dd/MM/yy k:mm:s");
		//format to form: Saturday 09/10/21 18:05:34
		this.dateCreated = dateFormatter.format(now);
		this.handlingStaff = staffID;
		this.discount = false;
		this.orderList = new ArrayList<orderItem>();
		this.totalPrice = 0;
		this.tableID = tableID;
	}
	
	public Order addOrderItem(Order order, MenuItem item, int quantity) {
		order.orderList.add(new orderItem(item, quantity));
		order.totalPrice = order.totalPrice + item.getPrice()*quantity;
		return order;
		
	}
	
	public Order removeOrderItem(Order order, int ID){
		int index = 0;
		double price = 0;
		for(orderItem oItem : order.orderList) {
			if(oItem.getItem().getItemId() == ID) {
				price = oItem.getItem().getPrice();
				order.orderList.remove(index);
				order.totalPrice = order.totalPrice - price * oItem.getQuantity();
				return order;
			}
			index++;
		}
		return order;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public int getTable() {
		return tableID;
	}
	
	public int getHandlingStaff() {
		return handlingStaff;
	}
	
	public boolean getDiscount() {
		return discount;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void printOrder() {
		for(orderItem i : this.orderList) {
			System.out.println(i.getQuantity()+ "\t" +
					i.getItem().getMenuName() + '\t' + i.getItem().getPrice() * i.getQuantity());
		}
	}
}
