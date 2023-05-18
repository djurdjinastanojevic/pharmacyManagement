package state;

import view.MainWindowView;
import view.ToolBarView;

public class EditingState implements ApplicationState{

	@Override
	public Boolean isIdle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isReady() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isEditing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableButtons(ToolBarView toolBarView) {
		for(int i = 0; i<toolBarView.getButtons().size();i++)
		{
			toolBarView.getButtons().get(i).setEnabled(false);
			if(toolBarView.getButtons().get(i).getToolTipText() == "Novi")
			{
				toolBarView.getButtons().get(i).setEnabled(true);
			}
		}
	}

	@Override
	public ToolBarView getToolBarView(MainWindowView mainWindowView) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString()
	{
		return "Editing";	
	}
	

}
