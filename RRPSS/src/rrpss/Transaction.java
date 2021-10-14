package rrpss;

import java.time.LocalDateTime;

public class Transaction {

	LocalDateTime date;
	String type;
	double amount;
	Transaction(LocalDateTime date, String type, double amount){
		this.date = date;
		this.type = type;
		this.amount = amount;
		
	}
	
}
