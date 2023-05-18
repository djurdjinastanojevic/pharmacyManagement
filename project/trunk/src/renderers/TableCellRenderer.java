package renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderer extends DefaultTableCellRenderer{
	
private static final long serialVersionUID = 1L;
	
	public TableCellRenderer(){
		setHorizontalAlignment(JLabel.CENTER);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
		for(int i = 0; i< table.getModel().getRowCount();i++)
			table.setRowHeight(i,40);
		
		component.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        if(row % 2 == 0)
		{
			component.setBackground(new Color(242, 230, 255));
			component.setForeground(Color.black);
		}
		else
		{
			component.setBackground(Color.white);
			component.setForeground(Color.black);
		}
        
        if (isSelected)
        {
        	component.setBackground(new Color(51, 153, 255));
        	component.setForeground(Color.white);
        	table.scrollRectToVisible(table.getCellRect(row,0, false));
        }
        return component;
	}
}