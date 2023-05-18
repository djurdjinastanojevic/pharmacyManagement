package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.MainWindowModel;
import view.LogInView;
import view.MainWindowView;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainWindowModel mainWindowModel = new MainWindowModel();
		LogInView logInView = new LogInView(mainWindowModel);
	}
	
//	ZA DJINU
	
	

}
