package controller;

import database.RestaurantDB;
import controller.TableController;
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
			Order order = new Order(staffID,tableID);
			//print the menu
			for(MenuItem item : RestaurantDB.menu) {
				FoodMenuController.printFood(item);
			}
			table.setOrder(null);
		}
		
		
		return false;
	}
	
	public boolean setInvoiceToTable(int tableID){
		Table table = TableController.getTableFromTableNo(tableID);
		Re
	}
	
}
