package ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import database.RestaurantDB;
import rrpss.Table;
import rrpss.Transaction;

public class ReportUI {

	private static ArrayList<Transaction> transactions = RestaurantDB.transactions;

	public static void showReportOptions() {
		String startDate = "";
		String endDate = "";
		Scanner sc = new Scanner(System.in); // Create a Scanner object
		Date startDateObj = null;
		Date endDateObj = null;
		System.out.println("Enter the start date (DD/MM/YYYY): ");

		if (sc.hasNextLine()) {

			startDate = sc.nextLine();
		}

		System.out.println("Enter the end date: (DD/MM/YYYY)");

		if (sc.hasNextLine()) {
			endDate = sc.nextLine();
		}

		try {
			startDateObj = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
			endDateObj = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);

		}

		catch (Exception e) {
			System.out.println("Unable to retrieve transactions. Please enter a valid date format e.g 31/12/2021");
		}

		for (int i = 0; i < transactions.size(); i++) {

			if (transactions.get(i).getDate().equals(startDateObj) || transactions.get(i).getDate().equals(endDateObj)
					|| (transactions.get(i).getDate().before(endDateObj)
							&& transactions.get(i).getDate().after(startDateObj))) {

				System.out.println(transactions.get(i).getDate() + "$" + transactions.get(i).getAmount());

			}

		}

	}
}
