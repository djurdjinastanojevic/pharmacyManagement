package model;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import state.ApplicationState;
import state.IdleState;
import view.MainWindowView;
import view.StatusBarView;


public class MainWindowModel extends Subject{
	
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private String title;
	private Image iconImage;
	private Color backgroundColor;
	
	public ApplicationState applicationState;
	
	public TableDataModel tableDataModel;
	public BrowserModel browserModel;
	
	public MainWindowModel() {
		
		title = "Apoteka";
		iconImage = Toolkit.getDefaultToolkit().getImage("icons/medicine.png");
		backgroundColor = new Color(240, 248, 255);
		
	    browserModel = new BrowserModel();
	    setApplicationState(new IdleState());
	}
	
	public BrowserModel getBrowserModel() {
		return browserModel;
	}
	public void setBrowserModel(BrowserModel browserModel) {
		this.browserModel = browserModel;
	}


	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public Image getIconImage() {
		return iconImage;
	}
	public void setIconImage(Image iconImage) {
		this.iconImage = iconImage;
	}

	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	
	public TableDataModel getTableDataModel() {
		return tableDataModel;
	}
	public void setTableDataModel(TableDataModel tableDataModel) {
		this.tableDataModel = tableDataModel;
	}
	
	public ApplicationState getApplicationState() {
		return applicationState;
	}
	public void setApplicationState(ApplicationState applicationState) {
		this.applicationState = applicationState;		
	}
}
