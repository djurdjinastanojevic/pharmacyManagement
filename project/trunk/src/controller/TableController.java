package controller;

import model.TableDataModel;
import view.TableView;

public class TableController {
	
	private TableDataModel tableDataModel;
	private TableView tableView;

	public TableController(TableDataModel tableDataModel, TableView tableView) {
		   this.tableDataModel = tableDataModel;
		   this.tableView = tableView;	   
	   }
}
