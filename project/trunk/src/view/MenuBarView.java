package view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JPopupMenu.Separator;

import actionListener.MoveActionListener;

public class MenuBarView extends JMenuBar implements Observer{
	
	private static final long serialVersionUID = 1L;
	
	private JMenu menuEdit = null;
	private JMenu menuFile = null;
	private JMenu menuHelp = null;

	private JMenuItem menuItemExit = null;
	private JMenuItem menuItemSwitchXML = null;
	private JMenuItem menuReport = null;
	
	private JMenuItem menuItemFirst = null;
	private JMenuItem menuItemNext = null;
	private JMenuItem menuItemPrevious = null;
	private JMenuItem menuItemLast = null;
	
	private JMenuItem menuItemStateNew = null;
	private JMenuItem menuItemStateEdit = null;
	private JMenuItem menuItemStateDelete = null;
	private JMenuItem menuItemCancel = null;
	private JMenuItem menuItemAccept = null;
	
	private JMenuItem menuItemAbout = null;

	public MenuBarView() {
	
	JMenuBar menuBar = this;

	//***** File menu  *****
	menuFile = new JMenu("File");
	menuBar.add(menuFile);
	
	menuItemExit = new JMenuItem("Exit");
	menuFile.add(menuItemExit);
	
	menuItemSwitchXML = new JMenuItem("Switch xml");
	menuFile.add(menuItemSwitchXML);
	
	menuFile.addSeparator();
	
	menuReport = new JMenuItem("Report");
	menuFile.add(menuReport);
	
	
	//*****  Edit menu  *****
	menuEdit = new JMenu("Edit");
	menuBar.add(menuEdit);
	
	menuItemFirst = new JMenuItem("First");
	menuEdit.add(menuItemFirst);		
	
	menuItemNext = new JMenuItem("Next");
	menuEdit.add(menuItemNext);

	menuItemPrevious = new JMenuItem("Previous");
	menuEdit.add(menuItemPrevious);
	
	menuItemLast = new JMenuItem("Last");
	menuEdit.add(menuItemLast);
	
	
	//*****  Help menu  *****
	menuHelp = new JMenu("Help");
	menuBar.add(menuHelp);
	
	menuItemAbout = new JMenuItem("About");
	menuHelp.add(menuItemAbout);
	
	setVisible(true);
	}
	
	public void registerMoveListener(MoveActionListener moveActionListener)
    {
	    menuItemFirst.addActionListener(moveActionListener);
	    menuItemNext.addActionListener(moveActionListener);
	    menuItemPrevious.addActionListener(moveActionListener);
	    menuItemLast.addActionListener(moveActionListener);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
