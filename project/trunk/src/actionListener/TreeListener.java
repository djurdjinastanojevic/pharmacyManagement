package actionListener;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import actionListener.MoveActionListener;
import controller.TableController;

import state.EditingState;

import model.MainWindowModel;
import model.TableDataModel;

import view.MainWindowView;
import view.TableView;
import view.BrowserView;
import view.ToolBarView;

public class TreeListener extends MouseAdapter implements TreeSelectionListener{
	
	Object node = null;
	JTree tree = null;
	
	MainWindowModel mainWindowModel = null;
	TableDataModel tableDataModel = null;

	MainWindowView mainWindowView = null;
	TableView tableView = null;
	ToolBarView toolBarView = null;
	
	public TreeListener(BrowserView view) {
		this.mainWindowView = (MainWindowView) view.getTopLevelAncestor();
		mainWindowModel = mainWindowView.getMainWindowModel();
		tableDataModel  = mainWindowView.getMainWindowModel().getTableDataModel();	
	}	

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		tree = (JTree) e.getSource();
		node = tree.getLastSelectedPathComponent();		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (tree != null)
		{
			int row = tree.getRowForLocation(e.getX(), e.getY());

			if (row == -1)
			{
				tree.clearSelection();
			}
			else 
			{
		         TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		         tree.setSelectionPath(selPath);
			}
		}
		
		if (e.getSource() instanceof JTree)
		{
			if (e.getClickCount() == 2)
			{
				
				if(tableDataModel == null)
				{
					tableDataModel = new TableDataModel(node.toString());
					mainWindowView.getMainWindowModel().setTableDataModel(tableDataModel);
				}
				tableDataModel.setTabela(node.toString());
				String imeProcedure = node.toString();
				imeProcedure = imeProcedure.replaceAll("\\s+","");
				tableDataModel.executeStoredProcedure("GetAll" + imeProcedure);
				
				if(tableView == null)
				{
					tableView = new TableView(tableDataModel);
					mainWindowView.getScrollPane().setViewportView(tableView);
					JScrollPane scrollPane = new JScrollPane(tableView,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					mainWindowView.getContentPane().add(scrollPane,BorderLayout.CENTER);
					mainWindowView.setTableView(tableView);
					
					toolBarView = mainWindowModel.getApplicationState().getToolBarView(mainWindowView);
					mainWindowView.getToolBarView().registerMoveListener(new MoveActionListener(mainWindowView.getToolBarView()));
					mainWindowView.getToolBarView().registerCreateListeners(new CreateUserListener(mainWindowView.getToolBarView()));
					mainWindowView.getToolBarView().registerUpdateListeners(new UpdateUserListener(mainWindowView.getToolBarView()));
					mainWindowView.getMenuBarView().registerMoveListener(new MoveActionListener(mainWindowView.getMenuBarView()));
					tableView.cellSelectionModel.addListSelectionListener(new TableSelectionListener(tableView));
//					mainWindowView.getToolBarView().registerDeleteListeners(new DeleteActionListener(mainWindowView.getToolBarView()));
					mainWindowView.revalidate();
					TableController tableController = new TableController(tableDataModel, tableView);
				}
				else
					tableView.setModel(tableDataModel);
				mainWindowModel.setApplicationState(new EditingState());
				mainWindowView.getStatusBarView().update();
				mainWindowModel.getApplicationState().enableButtons(toolBarView);
				
			}
			else if (e.isMetaDown()) 
			{
				JOptionPane.showMessageDialog(SwingUtilities.getRoot(tree), "Desni klik na " + node,
						"Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
