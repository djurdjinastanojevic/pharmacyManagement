package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainWindowModel;

import view.MainWindowView;
import view.ToolBarView;
import view.CreateUserView;

public class UpdateUserListener implements ActionListener{
	
	private MainWindowModel mainWindowModel = null;
	
	private ToolBarView toolBarView = null;
	private MainWindowView mainWindowView = null;
	
	public UpdateUserListener(ToolBarView toolBarView) {
		this.toolBarView = toolBarView;
		mainWindowView  = (MainWindowView) toolBarView.getTopLevelAncestor();
		mainWindowModel = mainWindowView.getMainWindowModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainWindowModel.getTableDataModel().getTabela().equals("Korisnicki Nalog"))
		{
			CreateUserView updateUser = new CreateUserView(mainWindowView);
			updateUser.updateUser();
			updateUser.show();
		}
	}
}
