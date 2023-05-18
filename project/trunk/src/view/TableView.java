package view;

import javax.swing.JTable;

import model.TableDataModel;
import javax.swing.ListSelectionModel;


import renderers.HeaderCellRenderer;
import renderers.TableCellRenderer;

public class TableView extends JTable{
	
	private static final long serialVersionUID = 1L;
	
	public TableDataModel tableDataModel;
	public ListSelectionModel cellSelectionModel = null;
	
	public TableView(TableDataModel model) {
    	tableDataModel=model;
    	
    	setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);   	
    	setColumnSelectionAllowed(false);
    	setRowSelectionAllowed(true);
    	if (model != null)
    		setModel(model);
    	
    	cellSelectionModel = getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDefaultRenderer(Object.class, new TableCellRenderer());
        getTableHeader().setDefaultRenderer(new HeaderCellRenderer());
    }
   
	public TableDataModel getTableDataModel() {
		return tableDataModel;
	}
	
	public void update()
	{
		
	}

}
