package rrpss;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Transaction {

	Date date;
	String type; // alacarte or promotional
	double pricePerQty; // price per item

	int quantity; // quantity of item ordered
	String itemName; // item name
	
	

	public Transaction(Date date, String type, double price, int quantity, String itemName) {
		this.date = date;
		this.type = type;
		this.pricePerQty = price;
		this.itemName = itemName;
	}

	public Date getDate() {

		return this.date;
	}

	public String getType() {

		return this.type;
	}
	
	public String getName() {

		return this.itemName;
	}

	public double getAmount() {

		return this.pricePerQty;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public void setType(String type) {

		this.type = type;
	}
	

	public void setQuantity(int qty) {

		this.quantity = qty;
	}

	public void setAmount(double amount) {

		this.pricePerQty = amount;
	}

}
