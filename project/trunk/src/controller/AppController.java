package controller;

import model.MainWindowModel;
import view.MainWindowView;

public class AppController {
	
	MainWindowModel mainWindowModel = null;
	MainWindowView mainWindowView = null;
	
	public AppController(MainWindowModel model, MainWindowView view) {
		this.mainWindowModel = model;
		this.mainWindowView = view;
		mainWindowModel.addObserver(mainWindowView);
		
		new BrowserController(mainWindowModel.getBrowserModel(), mainWindowView.getBrowserView());
	}
}
