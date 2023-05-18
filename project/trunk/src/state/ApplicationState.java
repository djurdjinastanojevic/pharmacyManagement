
package state;

import java.util.*;

import view.MainWindowView;
import view.ToolBarView;

public interface ApplicationState {
	   Boolean isIdle();
	   Boolean isReady();
	   Boolean isEditing();
	   Boolean isSelection();
	   void enableButtons(ToolBarView toolBarView);
	   ToolBarView getToolBarView(MainWindowView mainWindowView);
	   String toString();  
}