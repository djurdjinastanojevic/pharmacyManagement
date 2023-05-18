package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainWindowModel;
import view.CreateUserView;
import view.CreateUserView;
import view.MainWindowView;
import view.ToolBarView;

public class CreateUserListener implements ActionListener{
	
	private MainWindowModel mainWindowModel;
	
	private ToolBarView toolBarView;
	private MainWindowView mainWindowView;
	
	public CreateUserListener(ToolBarView toolBarView)
	{
		this.toolBarView = toolBarView;
		mainWindowView = (MainWindowView) toolBarView.getTopLevelAncestor();
		mainWindowModel = mainWindowView.getMainWindowModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainWindowModel.getTableDataModel().getTabela().equals("KorisniciServisa"))
		{
			CreateUserView createUserView = new CreateUserView(mainWindowView);
			createUserView.createUser();
			createUserView.show();
		}
	}
}
