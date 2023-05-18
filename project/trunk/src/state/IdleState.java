package state;

import java.awt.BorderLayout;

import state.ApplicationState;

import view.MainWindowView;
import view.ToolBarView;

public class IdleState implements ApplicationState{
	
	

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
		// TODO Auto-generated method stub
	}

	@Override
	public ToolBarView getToolBarView(MainWindowView mainWindowView) {
		mainWindowView.setToolBarView(new ToolBarView());
		mainWindowView.add(mainWindowView.getToolBarView(), BorderLayout.NORTH);
		return mainWindowView.getToolBarView();
	}
	
	@Override
	public String toString()
	{
		return "Idle";
	}
	
}
