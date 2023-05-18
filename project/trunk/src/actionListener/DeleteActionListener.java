package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import model.DBConnection;
import model.TableDataModel;
import view.TableView;
import view.MainWindowView;
import view.ToolBarView;

public class DeleteActionListener implements ActionListener{

	private TableDataModel tableDataModel;
	
	private ToolBarView toolBarView;
	private MainWindowView mainWindowView;
	private TableView tableView;
	
	public DeleteActionListener(ToolBarView toolBarView)
	{
		this.tableDataModel = mainWindowView.getMainWindowModel().getTableDataModel();
		this.toolBarView = toolBarView;
		this.mainWindowView = (MainWindowView) toolBarView.getTopLevelAncestor();
		this.tableView = mainWindowView.getTableView();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int dialogButton = JOptionPane.YES_NO_OPTION;
		JOptionPane.showConfirmDialog(null, "Da li zelite da izbrisete selektovane podatke?","Upozorenje!",dialogButton);
		
		if(dialogButton == JOptionPane.YES_OPTION)
		{
			String idString =tableDataModel.getValueAt(tableView.getSelectedRow(), 0).toString();
			int id = Integer.parseInt(idString);
			int rowId = tableView.getSelectedRow();
			
			Connection connection = DBConnection.createConnection();
			CallableStatement callableStatement;
			
			try
			{
				String imeProcedure = tableDataModel.getTabela();
				imeProcedure = imeProcedure.replaceAll("\\s+","");
				callableStatement = connection.prepareCall("{ call Delete" + imeProcedure + "(?)}",
						SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);
				callableStatement.setObject(1, id);
				callableStatement.executeUpdate();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			for (int i = 0; i < tableDataModel.getColumnCount(); i++)
			{
			
				tableDataModel.removeFromPoljaAt(rowId, 0);
			}
			
			tableDataModel.setRowCount(tableDataModel.getRowCount() -1);
			
			tableView.setModel(tableDataModel);
			tableView.revalidate();
		}
	}
}
