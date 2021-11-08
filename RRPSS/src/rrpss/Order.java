package rrpss;

import java.util.ArrayList; // import the ArrayList class
import java.lang.Math;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/**
 * Represent the entire order of a unique table, 1 order belongs to only 1 table
 * @author Chew Poshi
 *
 */
public class Order {
	/**
	 * ID of the order
	 */
	private static int orderID = 1;
	/**
	 * date and time for the creation of this order
	 */
	private String dateCreated;
	/**
	 * ID of the staff who handled this order
	 */
	private int handlingStaff;
	/**
	 * discount that should be applied based on the member type
	 */
	private boolean discount;
	/**
	 * An arraylist of orderItem objects that makes up the order
	 */
	private ArrayList<orderItem> orderList; 
	/**
	 * An arraylist of promorionalPakcages object that this order contains
	 */
	private ArrayList<PromotionalPackages> promotionalPackages;
	/**
	 * Total price of this order 
	 */
	private double totalPrice;
	/*
	 * tableID that this order is assigned to
	 */
	private int tableID;
	/**
	 * number of customer who dined in for this order
	 */
	private int pax;
	
	//constructor
	/**
	 * Constructor for the object
	 * @param staffID
	 * @param tableID
	 * @param pax
	 */
	public Order(int staffID, int tableID, int pax) {
		this.orderID = orderID++;
		//get current time
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE dd/MM/yy k:mm:s");
		//format to form: Saturday 09/10/21 18:05:34
		this.dateCreated = dateFormatter.format(now);
		this.handlingStaff = staffID;
		this.discount = false;
		this.orderList = new ArrayList<orderItem>();
		this.promotionalPackages = new ArrayList<PromotionalPackages>();

		this.totalPrice = 0;
		this.tableID = tableID;
		this.pax = pax;
	}
	
	//add alacarte item
	/**
	 * Adding new orderItems objects to the arraylist of this order when the order item's type is MenuItem type
	 * @param order
	 * @param item
	 * @param quantity
	 * @return the updated Order
	 */
	public Order addOrderItem(Order order, MenuItem item, int quantity) {
		Order temp = order; 
		temp.orderList.add(new orderItem(item, quantity, false));
		temp.totalPrice = temp.totalPrice + item.getPrice()*quantity;
		return temp;
	}
	
	/**
	 * Adding new orderItems objects to the arraylist of this order when the order item's type is promotionalPackages type
	 * @param order
	 * @param item
	 * @param quantity
	 * @return the updated Order
	 */
	public Order addOrderItem(Order order, PromotionalPackages item, int quantity) {
			for (int i=0; i<quantity; i++) {
				promotionalPackages.add(item);
			}
			Order temp = order; 
			temp.orderList.add(new orderItem(item, quantity, true));
			temp.totalPrice = temp.totalPrice + item.getPrice()*quantity;
			/*for(Food pItem : item.getPromotionSet()) {
				temp.orderList.add(new orderItem(pItem, 1, true));
				temp.totalPrice = temp.totalPrice + pItem.getPrice();
			}*/
			
			
			return temp;
		}
	//remove alacarte item
	/**
	 * Removes an orderItem from this order's arraylist of orderItems
	 * @param order
	 * @param ID
	 * @return
	 */
	public Order removeOrderItem(Order order, int ID){
		Order temp = order;
		int index = 0;
		double price = 0;
		for(orderItem oItem : temp.orderList) {
			if(oItem.getItem().getItemId() == ID) {
				price = oItem.getItem().getPrice();
				temp.orderList.remove(index);
				temp.totalPrice = temp.totalPrice - price * oItem.getQuantity();
				return temp;
			}
			index++;
		}
		return temp;
	}
	
	//remove promotion package
	public Order removeOrderItem(Order order, PromotionalPackages pack){
		Order temp = order;
		ArrayList<Integer> packList = new ArrayList<Integer>();
		int index = 0;
		double price = 0;
		
		//create a array to store all the itemId of the items in this promotional package
		for(Food mItem : pack.getPromotionSet()) {
			packList.add(mItem.getItemId());
		}
		
		//iterate through the orderItems in the order and find those orderitmes that contains the menuitems in the packList and remove it
		for(orderItem oItem : temp.orderList) {
			if(oItem.getIsPromotion()) {
				if(packList.contains(oItem.getItem().getItemId()))
				price = oItem.getItem().getPrice();
				temp.orderList.remove(index);
				temp.totalPrice = temp.totalPrice - price * oItem.getQuantity();
				return temp;
			}
			index++;
		}
		return temp;
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
	public int getPax() {
		return pax;
	}
	
	public ArrayList<orderItem> getOrderItems(){
		return this.orderList;
	}

	
	public ArrayList<PromotionalPackages>  getPromotionalPackages(){
		return this.promotionalPackages;
	}
	
	public void printOrder() {
		System.out.println("qty:  \titem  \t\tprice:  \tAla/Promo");
		for(orderItem i : this.orderList) {
			if(i.getIsPromotion())
				System.out.println(i.getQuantity()+ " x\t" +
					i.getItem().getMenuName() + "   \t" + i.getItem().getPrice() * i.getQuantity() + '\t' + "Promotion"+"\t");
			else
				System.out.println(i.getQuantity()+ " x\t" +
						i.getItem().getMenuName() + "   \t"+ i.getItem().getPrice() * i.getQuantity() + '\t' + "Alacarte"+"\t");
		}
	}
	
	public void printOrder(int x) {
		System.out.println("index:  qty:  \titem  \tprice:  \tAla/Promo");
		for(orderItem i : this.orderList) {
			if(i.getIsPromotion())
				System.out.println(i.getItemID()+":     "+i.getQuantity()+ " x\t" +
					i.getItem().getMenuName() + '\t' + i.getItem().getPrice() * i.getQuantity() + '\t' + "Promotion"+"\t");
			else
				System.out.println(i.getItemID()+":     "+i.getQuantity()+ " x\t" +
						i.getItem().getMenuName() + '\t' + i.getItem().getPrice() * i.getQuantity() + '\t' + "Alacarte"+"\t");
		}
	}
}
