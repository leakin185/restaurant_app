package controller;

import database.RestaurantDB;
import controller.TableController;
import controller.FoodMenuController;
import rrpss.Table;
import rrpss.Order;
import rrpss.orderItem;
import rrpss.MenuItem;

public class TableOrderInvoiceController {
	public boolean setOrderToTable(int staffID, int tableID){
		//TableController TC = new TableController();
		Table table = TableController.getTableFromTableNo(tableID);
		//if order for this table is empty
		if(table.getOrder() == null) {
			Order order = new Order(staffID,tableID);
			//print the menu
			for(MenuItem item : RestaurantDB.menu) {
				
			}
			table.setOrder(null);
		}
		
		
		return false;
	}
}
