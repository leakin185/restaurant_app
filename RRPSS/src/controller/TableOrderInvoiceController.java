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
import rrpss.Food;

public class TableOrderInvoiceController {
	public boolean setOrderToTable(int staffID, int tableID){
		//TableController TC = new TableController();
		Table table = TableController.getTableFromTableNo(tableID);
		//if order for this table is empty
		if(table.getOrder() == null) {
			
			//ask for pax
			int pax=0;
			Scanner sc = new Scanner(System.in);
			System.out.println("How many pax: ");
			pax = sc.nextInt();
			Order order = new Order(staffID,tableID, pax);
			//print the menu
			for(MenuItem item : RestaurantDB.menu) {
				FoodMenuController.printFood(item);
			}
			table.setOrder(null);
		}
		
		
		return false;
	}
	
	public boolean setInvoiceToTable(boolean discount, int tableID){
		Table table = TableController.getTableFromTableNo(tableID);
		//to-do, figure out how to get pax
		Invoice invoice = new Invoice(table.getTableNo(), table.getOrder().getPax(), discount, table.getOrder());
	}
	
}
