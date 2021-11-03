package rrpss;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Invoice {
	private static int invoiceNo = 1;
	private String timeStamp;
	private int tableNo;
	private boolean discount;
	private Order order;
	private double price;
	private double finalPrice;
	private int pax;
	private Date dateTime;
	public Invoice(int tableNo, int pax, boolean discount, Order order) {
		invoiceNo = invoiceNo++;
		dateTime = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE dd/MM/yy k:mm:s");
		timeStamp = dateFormatter.format(dateTime);
		this.tableNo = tableNo;
		this.discount = discount;
		this.order = order;
		this.price = this.order.getTotalPrice();
		if(discount == true)
			finalPrice = this.order.getTotalPrice()*1.17*0.8;
		else
			finalPrice = this.order.getTotalPrice()*1.17;
		this.pax = pax;
	}
	
	public Date getDatetime() {
		return this.dateTime;
	}
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	
	public int getTableNo() {
		return tableNo;
	}
	
	public double getFinalPrice() {
		return finalPrice;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public Order getOrder() {
		return order;
	}
	
	public void print() {
		System.out.println("-------------------------------------------------");
		System.out.println("                  cz2002 bar                     ");
		System.out.println("            50 Nanyang Ave, 639798               ");
		System.out.println("                                                 ");
		System.out.println("Server: " + this.order.getHandlingStaff() + "\t\t" + "Date & Time: " + this.timeStamp);
		System.out.println("Table: " + this.tableNo + "      Client: " + "pax");
		System.out.println("-------------------------------------------------");
		this.order.printOrder();
		System.out.println("-------------------------------------------------");
		System.out.println("Sub-Total: " + this.price                         );
		System.out.println("Gst: " + this.price*0.07                          );
		System.out.println("Service Charger: " + this.price*0.1               );
		if(discount)
			System.out.println("Sub-Total after discount: " + this.finalPrice );
		System.out.println("-------------------------------------------------");
		System.out.println("Total: " + this.finalPrice                        );
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("     Thank you and we hope to see you again!     ");
		
		
	}
}
