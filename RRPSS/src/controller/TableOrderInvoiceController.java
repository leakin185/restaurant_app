package controller;

import database.RestaurantDB;

import controller.TableController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import controller.FoodMenuController;
import rrpss.Table;
import rrpss.Order;
import rrpss.PromotionalPackages;
import rrpss.Invoice;
import rrpss.orderItem;
import rrpss.MenuItem;
import rrpss.Order;
import rrpss.Transaction;

import rrpss.Food;

public class TableOrderInvoiceController {

	public void printCurrentOrderForTable(int tableID) {

		Table table = TableController.getTableFromTableNo(tableID);

		Order order = table.getOrder();

		order.printOrder();

	}

	public boolean setOrderToTable(int staffID, int tableID) {
		Table table = TableController.getTableFromTableNo(tableID);
		// if order for this table is empty
		if (table.getOrder() == null) {
			System.out.println("No order yet! ");
			System.out.println(" ");
			int pax = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("How many pax: ");
			System.out.println(" ");
			pax = sc.nextInt();
			Order order = new Order(staffID, tableID, pax);
			// print the menu (YF)
			// for(Food item : RestaurantDB.menu) {
			// FoodMenuController.printFood(item);
			// }
			System.out.println("menu items count: "+RestaurantDB.menu.size());
			System.out.println(" ");
			// loop to add order
			int c;
			System.out.println("1. add order item\n0. stop");
			c = sc.nextInt();
			while (c == 1) {
				while (true) {
					System.out.println(" ");
					System.out.println("Enter order item ID: \n0 to go back: ");
					int id = sc.nextInt();
					MenuItem selected_item = null;
					if (id == 0)
						break;
					// check if ID valid and retrieve item
					for (MenuItem item : RestaurantDB.menu) {
						if (item.getItemId() == id) {
							selected_item = item;
							System.out.println(" ");
							System.out.println("item name: "+selected_item.getDesc());
							//check alacarte or pakcage
							if(item instanceof Food) System.out.println("Type: Alacarte");
							if(item instanceof PromotionalPackages) System.out.println("Type: Promotional Package");
							System.out.println(" ");
							break;
						}
					}
					if (selected_item == null) {
						System.out.println("Invalid ID");
						System.out.println(" ");
					}
					else {
						// add item into order
						int quantity = 0;
						System.out.println("Enter quantity");
						quantity = sc.nextInt();
						if(selected_item instanceof Food) 
							order = order.addOrderItem(order, selected_item, quantity);
						if(selected_item instanceof PromotionalPackages)
							order = order.addOrderItem(order, (PromotionalPackages)selected_item, quantity);
						table.setOrder(order);
						
					}
				}
				System.out.println(" ");
				System.out.println("1. add order item\n0. stop");
				c = sc.nextInt();
			}
			System.out.println(" ");
			System.out.println("Order set!");
			System.out.println(" ");
			return true;
		} else {
			// if order exist, add item
			System.out.println("Chose menu item to add");
			System.out.println(" ");
			
			
		}

		return false;
	}

	public Invoice setInvoiceToTable(boolean discount, int tableID) {
		Table table = TableController.getTableFromTableNo(tableID);

		if (table.getOrder() == null) {

			System.out.println("No order has been placed for this table yet. Unable to print invoice!");
			return null;
		}
		Invoice invoice = new Invoice(table.getTableNo(), table.getOrder().getPax(), discount, table.getOrder());
		table.setInvoice(invoice);
		
		return invoice;
	}


	public static void insertTransactionForTableOrder(Invoice invoice) {

		Order order = invoice.getOrder();

		ArrayList<PromotionalPackages> promotionalPackages = order.getPromotionalPackages();

		ArrayList<orderItem> orderItems = order.getOrderItems();

		for (int i = 0; i < orderItems.size(); i++) {
			RestaurantDB.transactions
					.add(new Transaction(invoice.getDatetime(), "Alacarte", orderItems.get(i).getItem().getPrice(),
							orderItems.get(i).getQuantity(), orderItems.get(i).getItem().getMenuName()));

			// Transaction(LocalDateTime date, String type, double price, double quantity,
			// String itemName) {

		}

		for (int i = 0; i < promotionalPackages.size(); i++) {
			RestaurantDB.transactions.add(new Transaction(invoice.getDatetime(), "PromotionalPackage",
					promotionalPackages.get(i).getPrice(), 1, promotionalPackages.get(i).getMenuName()));

		}

	}

}