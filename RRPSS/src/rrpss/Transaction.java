package rrpss;

import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Represents Transaction which will be used to store sales information specified in Invoice.
 *
 * @author Tjandy Putra
 * @version 1.0
 * @since 2021-10-30
 */

public class Transaction {

	/**
	 * The date of transaction made.
	 */
	private Date date;
	/**
	 * The type of transaction made, either Alacarte or Promotional Type
	 * */
	private String type;
	/**
	 * The price of item per quantity.
	 * */
	private double pricePerQty;
	/**
	 * The number of items.
	 * */
	private int quantity;
	/**
	 * The name of the item.
	 * */
	private String itemName;

	/**
	 * Creates a new Transaction with the given date, type, price, quantity and item name.
	 * @param date This transaction's date.
	 * @param type This transaction's type.
	 * @param price This transaction's item's price per quantity.
	 * @param quantity This transaction's number of items.
	 * @param itemName This transaction's item name.
	 * */
	public Transaction(Date date, String type, double price, int quantity, String itemName) {
		this.date = date;
		this.type = type;
		this.pricePerQty = price;
		this.itemName = itemName;
	}

	/**
	 *
	 * @return this Transaction's item quantity.
	 */
	public int getQuantity(){
		return this.quantity;
	}

	/**
	 *
	 * @return this Transaction's date.
	 */
	public Date getDate() {

		return this.date;
	}

	/**
	 *
	 * @return this Transaction's type.
	 */
	public String getType() {

		return this.type;
	}

	/**
	 *
	 * @return this Transaction's item name.
	 */
	public String getName() {

		return this.itemName;
	}

	/**
	 *
	 * @return this Transaction's item price per quantity.
	 */
	public double getAmount() {

		return this.pricePerQty;
	}


	/**
	 * Changes the date of this Transaction
	 * @param date This Transaction's new date.
	 */
	public void setDate(Date date) {

		this.date = date;
	}
	/**
	 * Changes the type of this Transaction
	 * @param type This Transaction's new ty[e.
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * Changes the quantity of this Transaction
	 * @param qty This Transaction's new quantity.
	 */
	public void setQuantity(int qty) {

		this.quantity = qty;
	}

	/**
	 * Changes the price per quantity of this Transaction
	 * @param amount This Transaction's new price per quantity.
	 */

	public void setAmount(double amount) {

		this.pricePerQty = amount;
	}

}
