package actionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.TableDataModel;
import state.SelectionState;
import view.MainWindowView;
import view.TableView;
import view.ToolBarView;

public class TableSelectionListener implements ListSelectionListener{

	TableView tableView = null;
	TableDataModel tableDataModel = null;
	ToolBarView toolBarView = null;
	MainWindowView mainWindowView;
	
	public TableSelectionListener(TableView tableView)
	{
		this.tableView = tableView;
		this.tableDataModel = tableView.getTableDataModel();
		this.mainWindowView = (MainWindowView) tableView.getTopLevelAncestor();
		this.toolBarView = mainWindowView.getToolBarView();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		mainWindowView.getMainWindowModel().setApplicationState(new SelectionState());
		mainWindowView.getStatusBarView().update();
		mainWindowView.getMainWindowModel().getApplicationState().enableButtons(toolBarView);
		
		if(tableView.getSelectedRow() == tableDataModel.getRowCount() - 1)
		{
			toolBarView.getBtnSljedeci().setEnabled(false);
			toolBarView.getBtnKraj().setEnabled(false);
		}
		else if(tableView.getSelectedRow() == 0)
		{
			toolBarView.getBtnPrethodni().setEnabled(false);
			toolBarView.getBtnPrvi().setEnabled(false);
		}
		else
		{
			toolBarView.getBtnSljedeci().setEnabled(true);
			toolBarView.getBtnPrethodni().setEnabled(true);
			toolBarView.getBtnPrvi().setEnabled(true);
			toolBarView.getBtnKraj().setEnabled(true);
		}	
	}
}
