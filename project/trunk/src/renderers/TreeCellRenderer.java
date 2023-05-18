package renderers;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeCellRenderer extends DefaultTreeCellRenderer{
	Icon databaseIcon = new ImageIcon("icons/database.png");
	Icon packageIcon = new ImageIcon("icons/folder.png");
	Icon tableIcon = new ImageIcon("icons/table.png");
	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		
		if (leaf) 
		{
			setIcon(tableIcon);
		}
		
		else if (tree.getModel().getRoot() == value) 
		{
			setIcon(databaseIcon);
		}
		
		else 
		{
			setIcon(packageIcon);
		}
		
		return this;
	}
}
