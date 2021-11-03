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
			//for(Food item : RestaurantDB.menu) {
			//	FoodMenuController.printFood(item);
			//}
			
			//loop to add order
			int c;
			System.out.println("1. add order item\n0. stop");
			c = sc.nextInt();
			while(c == 1) {
				while(true) {
					System.out.println("Enter order item ID: \n0 to go back: ");
					int id = sc.nextInt();
					MenuItem selected_item = null;
					if(id == 0)
						break;
					//check if ID valid and retrieve item
					for(MenuItem item : RestaurantDB.menu) {
						if(item.getItemId() == id) {
							selected_item = item;
							break;
						}
					}
					if(selected_item == null)
						System.out.println("Invalid ID");
					else {
						//add item into order
						int quantity = 0;
						System.out.println("Enter quantity");
						quantity = sc.nextInt();
						
					}
				}
				
				//retrieved object from db
				
				
				
				System.out.println("1. add order item\n0. stop");
				c = sc.nextInt();
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
