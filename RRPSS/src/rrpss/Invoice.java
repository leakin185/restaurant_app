package rrpss;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Represent an invoice for a table's order, 1 invoice belongs to only 1 table
 * @author Chew Poshi
 *
 */
public class Invoice {
	/**
	 * Incrementing invoice ID
	 */
	private static int invoiceNo = 1;
	/**
	 * data time of the creation of the invoice
	 */
	private String timeStamp;
	/**
	 * table ID that this invoice belongs to
	 */
	private int tableNo;
	/**
	 * discount that should be assigned to this table
	 */
	private double discount;
	/**
	 * order that belongs to this invoice
	 */
	private Order order;
	/**
	 * price before discount is applied
	 */
	private double price;
	/**
	 * final price after discount
	 */
	private double finalPrice;
	/**
	 * pax of the invoice
	 */
	private int pax;
	/**
	 * datetime variable used for when  interacting with transaction object
	 */
	private Date dateTime;
	/**
	 * Constructor for the object
	 * @param tableNo
	 * @param pax
	 * @param discount
	 * @param order
	 */
	public Invoice(int tableNo, int pax,double discount, Order order) {
		invoiceNo = invoiceNo++;
		dateTime = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE dd/MM/yy k:mm:s");
		timeStamp = dateFormatter.format(dateTime);
		this.tableNo = tableNo;
		this.discount = discount;
		this.order = order;
		this.price = this.order.getTotalPrice();
		if(discount != 1)
			finalPrice = this.order.getTotalPrice()*1.17*this.discount;
		else
			finalPrice = this.order.getTotalPrice()*1.17;
		this.pax = pax;
	}
	/**
	 * returns the Datetime variable
	 * @return the Datetime variable
	 */
	public Date getDatetime() {
		return this.dateTime;
	}
	/**
	 * returns the invoice ID
	 * @return the invoice ID
	 */
	public int getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * returns the table ID that is invoice belongs to
	 * @return the table ID that is invoice belongs to
	 */
	public int getTableNo() {
		return tableNo;
	}
	/**
	 * returns the final price 
	 * @return the final price
	 */
	public double getFinalPrice() {
		return finalPrice;
	}
	/**
	 * returns the timeStamp variable 
	 * @return the timeStamp variable 
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * returns the order that belongs to this invoice
	 * @return the order that belongs to this invoice
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * prints the invoice with details
	 */
	public void print() {
		System.out.println("-------------------------------------------------");
		System.out.println("                  cz2002 bar                     ");
		System.out.println("            50 Nanyang Ave, 639798               ");
		System.out.println("                                                 ");
		System.out.println("Server: " + this.order.getHandlingStaff() + "\t\t" + "Date & Time: " + this.timeStamp);
		System.out.println("Table: " + this.tableNo + "                              pax: " +this.order.getPax());
		System.out.println("-------------------------------------------------");
		this.order.printOrder();
		System.out.println("-------------------------------------------------");
		System.out.println("Sub-Total: " + String.format("%.2f", this.price)                      );
		System.out.println("Gst: " + String.format("%.2f", this.price*0.07)                          );
		System.out.println("Service Charge: " + String.format("%.2f", this.price*0.1)               );
		if(discount != 1)
			System.out.println("Total after discount: " + String.format("%.2f", this.finalPrice) );
		System.out.println("-------------------------------------------------");
		System.out.println("Total: " + String.format("%.2f", this.finalPrice)                       );
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("     Thank you and we hope to see you again!     ");
		System.out.println(" ");
		
		
	}
}
