package view;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.MainWindowModel;

public class StatusBarView extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	
	private MainWindowModel mainWindowModel;
	private JLabel label;

	public StatusBarView(MainWindowModel mainWindowModel) {
		this.mainWindowModel = mainWindowModel;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(0, 40));
		
		label = new JLabel();
		label.setText("Current state of Application: " + this.mainWindowModel.getApplicationState().toString());
		add(Box.createHorizontalStrut(5));
		add(label);
		
		setVisible(true);
	}

	@Override
	public void update()
	{
		label.setText("Current state of Application: " + mainWindowModel.getApplicationState().toString());
	}
}
