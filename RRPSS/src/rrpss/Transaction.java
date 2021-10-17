package rrpss;

import java.time.LocalDateTime;

public class Transaction {

	LocalDateTime date;
	String type;
	double amount;

	Transaction(LocalDateTime date, String type, double amount) {
		this.date = date;
		this.type = type;
		this.amount = amount;

	}

	public LocalDateTime getDate() {

		return this.date;
	}

	public String getType() {

		return this.type;
	}

	public double getAmount() {

		return this.amount;
	}

	public void setDate(LocalDateTime date) {

		this.date = date;
	}

	public void setType(String type) {

		this.type = type;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

}
