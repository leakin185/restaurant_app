package rrpss;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Report {

	private LocalDateTime startPeriod;
	private LocalDateTime endPeriod;
	private double revenue;
	private String saleItemType;
	private ArrayList<Transaction> transactions;

	Report(LocalDateTime start, LocalDateTime end, String type, ArrayList<Transaction> transactions) {
		startPeriod = start;
		endPeriod = end;
		saleItemType = type;
		this.transactions = transactions;
	}

	public void retrieveSales() {

		transactions = new ArrayList<Transaction>();

		for (int i = 0; i < transactions.size(); i++) {

			Transaction t = transactions.get(i);

			if (t.getType() == saleItemType && t.getDate().isAfter(startPeriod) && t.getDate().isBefore(endPeriod)) {

				this.revenue += t.getAmount();

			}
		}

	}

	public double getRevenue() {

		return this.revenue;
	}

	public void printReport() {

		System.out.println("Total revenue earned from " + startPeriod + "to " + endPeriod + " for transaction of type "
				+ saleItemType + " :$" + revenue);
	}
}
