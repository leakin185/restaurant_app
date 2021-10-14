package rrpss;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Report {

	private LocalDateTime startPeriod;
	private LocalDateTime endPeriod;
	private double revenue;
	private String saleItemType;
	private ArrayList<Transaction> transactions;
	Report(LocalDateTime start, LocalDateTime end, String type){
		startPeriod = start;
		endPeriod = end;
		saleItemType = type;
	}

	public void retrieveSales() {
		
	
		transactions  = new ArrayList<Transaction>();
		
		// logic to search transactions
		
		// add to revenue for each transaction entry
	}

	public double getRevenue() {
		
		return this.revenue;
	}
	
	public void printReport() {
		
		// print report
		

	}
}
