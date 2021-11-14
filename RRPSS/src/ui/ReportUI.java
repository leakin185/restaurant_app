package ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import database.RestaurantDB;
import rrpss.Table;
import rrpss.Transaction;

/**
 * Represents Report UI where user inputs a start and end date in order to retrieve and print all transactions within the date range.
 *
 * @author Tjandy Putra
 * @version 1.0
 * @since 2021-10-30
 */

public class ReportUI {

    private static ArrayList<Transaction> transactions = RestaurantDB.transactions;


    /**
     * Display two input prompts. User specifies
     * start date and end date in the following format: DD/MM/YYYY
     * e.g 11/11/2021
     *
     * Upon successful validation of date inputs, transactions within the specified date range are retrieved and printed to console.
     */
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



            endDateObj = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(endDate + " 23:59:59");

            Date curDate = new Date();

            if(startDateObj.after(curDate) || endDateObj.before(startDateObj)) {
                if(startDateObj.after(curDate))
                System.out.println("Start Date cannot be in the future!");
                else if(endDateObj.before(startDateObj))
                    System.out.println("End Date cannot be before Start Date!");
                return;
            }

        } catch (Exception e) {
            System.out.println("Unable to retrieve transactions. Please enter a valid date format e.g 31/12/2021");
        }


        double alacartProfit = 0.0;
        double promotionalPackageProfit  = 0.0;

        String s1 = String.format("%30s %20s %20s %10s", "Date of Transaction", "Alacarte/Promotion", "Menu Item Name", "Price");
		System.out.println(s1);
		
        for (int i = 0; i < transactions.size(); i++) {


            if (transactions.get(i).getDate().equals(startDateObj) || transactions.get(i).getDate().equals(endDateObj)
                    || (transactions.get(i).getDate().before(endDateObj)
                    && transactions.get(i).getDate().after(startDateObj))) {
            	String s2 = String.format("%30s %20s %20s %10s", transactions.get(i).getDate(), transactions.get(i).getType(), transactions.get(i).getName(), transactions.get(i).getAmount());
    			System.out.println(s2);

                //System.out.println(transactions.get(i).getDate() + "\t" + transactions.get(i).getType() + "\t" + transactions.get(i).getName() + "\t$" + transactions.get(i).getAmount());
                if(transactions.get(i).getType() == "Alacarte")
                    alacartProfit+=transactions.get(i).getAmount();
                else
                    promotionalPackageProfit+=transactions.get(i).getAmount();

            }

        }


        System.out.println("\nRevenue earned for Alarcarte: " + String.format("%.2f", alacartProfit));
        System.out.println("Revenue earned for Promotional Items: " + String.format("%.2f",promotionalPackageProfit));
        System.out.println("Total Revenue earned during this period: " + String.format("%.2f", (alacartProfit+promotionalPackageProfit)));

    }
}
