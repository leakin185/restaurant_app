package controller;

import database.RestaurantDB;
import controller.TableController;
import rrpss.Table;
import rrpss.Order;
import rrpss.orderItem;

public class TableOrderInvoiceController {
	public boolean setOrderToTable(int staffID, int tableID){
		//TableController TC = new TableController();
		Table table = TableController.getTableFromTableNo(tableID);
		
		if(table.)
		Order order = new Order(staffID,tableID);
		
		table.setOrder(null);
		
		return false;
	}
}
