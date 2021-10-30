package controller;

import database.RestaurantDB;
import controller.TableController;

import java.util.Scanner;

import controller.FoodMenuController;
import rrpss.Table;
import rrpss.Order;
import rrpss.Invoice;
import rrpss.orderItem;
import rrpss.MenuItem;
import rrpss.Order;

import rrpss.Food;

public class TableOrderInvoiceController {
	
	
	public void printCurrentOrderForTable(int tableID) {
		
		
		Table table = TableController.getTableFromTableNo(tableID);

		
		Order order = table.getOrder();
		
		order.printOrder();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public boolean setOrderToTable(int staffID, int tableID){
		Table table = TableController.getTableFromTableNo(tableID);
		//if order for this table is empty
		if(table.getOrder() == null) {
			int pax=0;
			Scanner sc = new Scanner(System.in);
			System.out.println("How many pax: ");
			pax = sc.nextInt();
			Order order = new Order(staffID,tableID, pax);
			//print the menu (YF)
			for(Food item : RestaurantDB.menu) {
				FoodMenuController.printFood(item);
			}
			//Order = returned
			table.setOrder(order);
			System.out.println("Order set!");
			return true;
		}
		else {
			//if order exist, add item
		}
		
		
		return false;
	}
	
	public Invoice setInvoiceToTable(boolean discount, int tableID){
		Table table = TableController.getTableFromTableNo(tableID);
		Invoice invoice = new Invoice(table.getTableNo(), table.getOrder().getPax(), discount, table.getOrder());
		table.setInvoice(invoice);
		return invoice;
	}
	
}
