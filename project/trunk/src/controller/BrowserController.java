package controller;

import actionListener.TreeListener;
import model.BrowserModel;
import view.BrowserView;

public class BrowserController {
	
	private BrowserModel browserModel;
	private BrowserView browserView;
	
	public BrowserController(BrowserModel browserModel,BrowserView browserView)
   {
	   this.browserModel = browserModel;
	   this.browserView = browserView;
	   
	   browserView.addTreeSelectionListener(new TreeListener(browserView));
   }
}
