package state;

import view.MainWindowView;
import view.ToolBarView;

public class ReadyState implements ApplicationState{

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
		for(int i = 0; i<toolBarView.getButtons().size() ; i++)
		{
			toolBarView.getButtons().get(i).setEnabled(false);
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
		return "Ready";
	}

}
