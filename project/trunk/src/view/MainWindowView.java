package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.BrowserModel;
import model.MainWindowModel;
import model.TableDataModel;

import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import actionListener.TreeListener;
import java.awt.event.ActionListener;
import state.*;

public class MainWindowView extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JTable table;
	private JFrame frame;

	private MainWindowModel mainWindowModel;
	private TableDataModel tableDataModel;
	private BrowserModel browserModel;
	
	private ToolBarView toolBarView;
	private StatusBarView statusBarView;
	private BrowserView browserView;
    private TableView tableView;
	private MenuBarView menuBarView;
	private Toolkit toolkit=null;
	
	public MainWindowView(MainWindowModel model) 
	{
		mainWindowModel = model;
		
		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		setIconImage(mainWindowModel.getIconImage());
		setTitle(mainWindowModel.getTitle());
		toolkit = Toolkit.getDefaultToolkit();	
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;	
		setMinimumSize(new Dimension(width, height));
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		scrollPane = new JScrollPane();
		
		Container contentPane = getContentPane();
		contentPane.setBackground(mainWindowModel.getBackgroundColor());
		contentPane.setLayout(new BorderLayout());
		
		menuBarView = new MenuBarView();
		setJMenuBar(menuBarView);
		
		toolBarView = new ToolBarView();
		contentPane.add(toolBarView, BorderLayout.NORTH);
		
		statusBarView = new StatusBarView(getMainWindowModel());
		contentPane.add(statusBarView, BorderLayout.SOUTH);

		browserView = new BrowserView(mainWindowModel.getBrowserModel());
		contentPane.add(this.browserView, BorderLayout.WEST);
		browserView.addTreeSelectionListener(new TreeListener(browserView));
			
//		JPanel racunPanel = new JPanel();
//		racunPanel.setBackground(Color.white);
//		contentPane.add(racunPanel, BorderLayout.EAST);
//		racunPanel.setLayout(new BorderLayout(10,10));
//		racunPanel.add(new Button("Izdaj racun"), BorderLayout.SOUTH);					
//		JLabel artikliNaRacunu = new JLabel("Artikli na racunu: ");
//		racunPanel.add(artikliNaRacunu, BorderLayout.NORTH);
			
		setVisible(true);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public MenuBarView getMenuBarView() {
		return menuBarView;
	}
	public void setMenuBarView(MenuBarView menuBarView) {
		this.menuBarView = menuBarView;
	}

	public TableView getTableView() {
		return tableView;
	}
	public void setTableView(TableView tableView) {
		this.tableView = tableView;
	}

	public MainWindowModel getMainWindowModel() {
		return mainWindowModel;
	}
	public void setMainWindowModel(MainWindowModel mainWindowModel) {
		this.mainWindowModel = mainWindowModel;
	}
	
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	public TableDataModel getTableDataModel() {
		return tableDataModel;
	}
	public void setTableDataModel(TableDataModel tableDataModel) {
		this.tableDataModel = tableDataModel;
	}
	
	
	public ToolBarView getToolBarView() {
		return toolBarView;
	}
	public void setToolBarView(ToolBarView toolBarView) {
		this.toolBarView = toolBarView;
	}
	
	
	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	public void setStatusBarView(StatusBarView statusBarView) {
		this.statusBarView = statusBarView;
	}
	
	
	public BrowserView getBrowserView() {
		return browserView;
	}
	public void setBrowserView(BrowserView browserView) {
		this.browserView = browserView;
	}
}