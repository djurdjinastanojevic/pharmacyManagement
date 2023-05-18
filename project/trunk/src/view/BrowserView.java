package view;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;

import actionListener.TreeListener;
import model.BrowserModel;
import renderers.TreeCellRenderer;

public class BrowserView extends JScrollPane implements Observer{
	
	private static final long serialVersionUID = 1L;
	public BrowserModel browserModel;
	public JTree tree = null;
	
	public BrowserView(BrowserModel browserModel) {
		this.browserModel=browserModel;
		
		tree= new JTree(browserModel);
		tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(new TreeCellRenderer());
		setViewportView(tree);
		
		setVisible(true);
	}
	

	public void addTreeSelectionListener(TreeListener treeSelectionListener)
	{
		tree.addTreeSelectionListener(treeSelectionListener);
		tree.addMouseListener(treeSelectionListener);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
