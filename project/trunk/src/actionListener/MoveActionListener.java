package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.TableDataModel;

import view.MainWindowView;
import view.MenuBarView;
import view.ToolBarView;
import view.TableView;

public class MoveActionListener implements ActionListener{

	private TableDataModel tableDataModel;
	
	private ToolBarView toolBarView;
	private MainWindowView mainWindowView;
	private TableView tableView;
	private MenuBarView menuBarView;
	public MoveActionListener(ToolBarView toolBarView)
	{
		this.toolBarView = toolBarView;
		this.mainWindowView = (MainWindowView) toolBarView.getTopLevelAncestor();
		this.tableDataModel = mainWindowView.getMainWindowModel().getTableDataModel();
		this.tableView = mainWindowView.getTableView();
	}
	
	public MoveActionListener(MenuBarView menuBarView) {
		this.menuBarView = menuBarView;
		this.mainWindowView = (MainWindowView) menuBarView.getTopLevelAncestor();
		this.tableDataModel = mainWindowView.getMainWindowModel().getTableDataModel();
		this.tableView = mainWindowView.getTableView();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "first":
			tableView.setRowSelectionInterval(0, 0);
			break;
		case "previous" :
			tableView.setRowSelectionInterval(tableView.getSelectedRow() - 1,tableView.getSelectedRow() - 1);
			break;
		case "next" :
			tableView.setRowSelectionInterval(tableView.getSelectedRow() + 1,tableView.getSelectedRow() + 1);
			break;
		case "last" :
			tableView.setRowSelectionInterval(tableDataModel.getRowCount() - 1, tableDataModel.getRowCount() -1);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}	
	}

}
