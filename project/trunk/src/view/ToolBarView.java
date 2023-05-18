package view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import actionListener.CreateUserListener;
import actionListener.DeleteActionListener;
import actionListener.MoveActionListener;
import actionListener.UpdateUserListener;

public class ToolBarView extends JToolBar implements Observer{
	
	private static final long serialVersionUID = 1L;
	JButton btnNovi = null;
	JButton btnIzmjeni = null;
	JButton btnObrisi = null;
	JButton btnPotvrdi = null;
	JButton btnOdustani = null;
	JButton btnIzvjestaj = null;
	JButton btnPrvi = null;
	JButton btnSljedeci = null;
	JButton btnPrethodni = null;
	JButton btnKraj = null;
	public Vector<JButton> buttons = new Vector<>();
	
	public ToolBarView() {
		
		setFloatable(false);
		
		btnNovi = new JButton("Novi");
		btnNovi.setBackground(Color.WHITE);
		btnNovi.setToolTipText("Novi");
		btnNovi.setIcon(new ImageIcon("icons/new.png"));
		btnNovi.setActionCommand("new");
		this.add(btnNovi);
		this.addSeparator();
		
		btnIzmjeni = new JButton("Izmijeni");
		btnIzmjeni.setBackground(Color.WHITE);
		btnIzmjeni.setToolTipText("Izmijeni");
		btnIzmjeni.setIcon(new ImageIcon("icons/edit.png"));
		btnIzmjeni.setActionCommand("edit");
		this.add(btnIzmjeni);
		this.addSeparator();
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setBackground(Color.WHITE);
		btnObrisi.setToolTipText("Obrisi");
		btnObrisi.setIcon(new ImageIcon("icons/delete.png"));
		btnObrisi.setActionCommand("delete");
		btnObrisi.setEnabled(true);
		this.add(btnObrisi);
		this.addSeparator();
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.WHITE);
		btnPotvrdi.setToolTipText("Potvrdi");
		btnPotvrdi.setIcon(new ImageIcon("icons/accept.png"));
		btnPotvrdi.setActionCommand("accept");
		this.add(btnPotvrdi);
		this.addSeparator();
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(Color.WHITE);
		btnOdustani.setToolTipText("Odustani");
		btnOdustani.setIcon(new ImageIcon("icons/cancel.png"));
		btnOdustani.setActionCommand("cancel");
		this.add(btnOdustani);
		this.addSeparator();
		
		btnIzvjestaj = new JButton("Izvjestaj");
		btnIzvjestaj.setBackground(Color.WHITE);
		btnIzvjestaj.setToolTipText("Izvjestaj");
		btnIzvjestaj.setIcon(new ImageIcon("icons/report.png"));
		btnIzvjestaj.setActionCommand("report");
		this.add(btnIzvjestaj);
		this.addSeparator();
		
		btnPrvi = new JButton("Na pocetak");
		btnPrvi.setToolTipText("Idi na pocetak");
		btnPrvi.setBackground(Color.WHITE);
		btnPrvi.setIcon(new ImageIcon("icons/first.png"));
		btnPrvi.setActionCommand("first");
		this.add(btnPrvi);
		this.addSeparator();
		
		btnSljedeci = new JButton("Sljedeci");
		btnSljedeci.setToolTipText("Sljedeci");
		btnSljedeci.setBackground(Color.WHITE);
		btnSljedeci.setIcon(new ImageIcon("icons/next.png"));
		btnSljedeci.setActionCommand("next");
		this.add(btnSljedeci);
		this.addSeparator();
		
		btnPrethodni = new JButton("Prethodni");
		btnPrethodni.setToolTipText("Prethodni");
		btnPrethodni.setBackground(Color.WHITE);
		btnPrethodni.setIcon(new ImageIcon("icons/previous.png"));
		btnPrethodni.setActionCommand("previous");
		this.add(btnPrethodni);
		this.addSeparator();
		
		btnKraj = new JButton("Na kraj");
		btnKraj.setToolTipText("Idi na kraj");
		btnKraj.setBackground(Color.WHITE);
		btnKraj.setIcon(new ImageIcon("icons/last.png"));
		btnKraj.setActionCommand("last");
		this.add(btnKraj);			
		
		buttons.add(btnNovi);
		buttons.add(btnKraj);
		buttons.add(btnPrethodni);
		buttons.add(btnPrvi);
		buttons.add(btnSljedeci);
		buttons.add(btnIzvjestaj);
		buttons.add(btnOdustani);
		buttons.add(btnObrisi);
		buttons.add(btnPotvrdi);
		buttons.add(btnIzmjeni);
		
		this.setVisible(true);
	}

	public void registerDeleteListeners(DeleteActionListener deleteActionListener) {
		btnObrisi.addActionListener(deleteActionListener);		
	}

	public void registerMoveListener(MoveActionListener moveActionListener) {
		btnPrvi.addActionListener(moveActionListener);
		btnPrethodni.addActionListener(moveActionListener);
		btnKraj.addActionListener(moveActionListener);
		btnSljedeci.addActionListener(moveActionListener);
	}

	public void registerCreateListeners(CreateUserListener createUserListener) {
		btnNovi.addActionListener(createUserListener);
	}

	public void registerUpdateListeners(UpdateUserListener updateUserListener) {
		btnNovi.addActionListener(updateUserListener);
	}
	
	public JButton getBtnPrvi() {
		return btnPrvi;
	}

	public void setBtnPrvi(JButton btnPrvi) {
		this.btnPrvi = btnPrvi;
	}

	public JButton getBtnSljedeci() {
		return btnSljedeci;
	}

	public void setBtnSljedeci(JButton btnSljedeci) {
		this.btnSljedeci = btnSljedeci;
	}

	public JButton getBtnPrethodni() {
		return btnPrethodni;
	}

	public void setBtnPrethodni(JButton btnPrethodni) {
		this.btnPrethodni = btnPrethodni;
	}

	public JButton getBtnKraj() {
		return btnKraj;
	}

	public void setBtnKraj(JButton btnKraj) {
		this.btnKraj = btnKraj;
	}
	

	public JButton getBtnNovi() {
		return btnNovi;
	}

	public void setBtnNovi(JButton btnNovi) {
		this.btnNovi = btnNovi;
	}

	public JButton getBtnObrisi() {
		return btnObrisi;
	}

	public void setBtnObrisi(JButton btnObrisi) {
		this.btnObrisi = btnObrisi;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public Vector<JButton> getButtons() {
		return buttons;
	}

	public void setButtons(Vector<JButton> buttons) {
		this.buttons = buttons;
	}


}
