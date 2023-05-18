package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import model.DBConnection;
import model.MainWindowModel;
import model.TableDataModel;

public class CreateUserView extends JFrame {
	
	public JPanel panel = null;
	
	public JComboBox<String> tipKorisnikaCb = null;
	public JComboBox<String> poslovniSistemi = null;
	public JTextField ime = null;
	public JTextField prezime = null;
	public JTextField imeOca = null;
	public JTextField maticniBroj = null;
	public JComboBox<String> pol = null;
	public JTextField password = null;
	public JTextField username = null;
	JButton confirmButton = null;
	MainWindowView mainWindowView = null;
	TableView tableView = null;
	TableDataModel tableDataModel = null;
	public Vector<Integer> id = new Vector<Integer>();
	public Vector<String> naziv = new Vector<String>();
	
	public CreateUserView(MainWindowView mainWindowView) {

		this.mainWindowView = mainWindowView;
		this.tableView = mainWindowView.getTableView();
		this.tableDataModel = mainWindowView.getTableView().getTableDataModel();
		
		setLayout(null);
		setContentPane(panel = new JPanel());		
		setLocation(new Point(100, 100));
		panel.setLayout(null);
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
public void createUser() {
		
		this.setSize(new Dimension(600,600));
		panel.setSize(new Dimension(600, 600));
		
		JLabel izborPoslovnogSistema = new JLabel("Izbor poslovnog sistema ");
		izborPoslovnogSistema.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		izborPoslovnogSistema.setLocation(new Point(100, 70));
		izborPoslovnogSistema.setSize(new Dimension(600, 30));
		panel.add(izborPoslovnogSistema);

		int i = 0;
		getPoslovniSistem();
		
		 poslovniSistemi = new JComboBox<String>(naziv); //
		 poslovniSistemi.setSelectedIndex(0);
		 poslovniSistemi.setSize(new Dimension(150, 20));
		 poslovniSistemi.setLocation(new Point(100, 100)); //
		 panel.add(poslovniSistemi);
		 
		JLabel imeLbl = new JLabel("Ime zaposlenog");
		imeLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		imeLbl.setLocation(new Point(100, 130));
		imeLbl.setSize(new Dimension(600, 30));
		panel.add(imeLbl);

		ime = new JTextField();
		ime.setSize(new Dimension(200, 30));
		ime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ime.setLocation(new Point(100, 160));
		ime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(ime);

		JLabel prezimeLbl = new JLabel("Prezime zaposlenog");
		prezimeLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		prezimeLbl.setLocation(new Point(100, 200));
		prezimeLbl.setSize(new Dimension(600, 30));
		panel.add(prezimeLbl);

		prezime = new JTextField();
		prezime.setSize(new Dimension(200, 30));
		prezime.setFont(new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		prezime.setLocation(new Point(100, 230));
		prezime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(prezime);

		JLabel imeOcaLbl = new JLabel("Ime oca");
		imeOcaLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		imeOcaLbl.setLocation(new Point(100, 265));
		imeOcaLbl.setSize(new Dimension(600, 30));
		panel.add(imeOcaLbl);

		imeOca = new JTextField();
		imeOca.setSize(new Dimension(200, 30));
		imeOca.setFont(new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		imeOca.setLocation(new Point(100, 290));
		imeOca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		panel.add(imeOca);

		JLabel mbLbl = new JLabel("Maticni broj");
		mbLbl.setFont(new Font("Calibri", Font.PLAIN, 20));
		mbLbl.setLocation(new Point(100, 330));
		mbLbl.setSize(new Dimension(600, 30));
		panel.add(mbLbl);

		maticniBroj = new JTextField();
		maticniBroj.setSize(new Dimension(200, 30));
		maticniBroj.setFont(new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		maticniBroj.setLocation(new Point(100, 360));
		maticniBroj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(maticniBroj);

		JLabel polLbl = new JLabel("Unesite pol korisnika");
		polLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		polLbl.setLocation(new Point(100, 390));
		polLbl.setSize(new Dimension(600, 30));
		panel.add(polLbl);

		String[] polString = { "Musko", "Zensko" };
		pol = new JComboBox<String>(polString);
		pol.setSelectedIndex(0);
		pol.setSize(new Dimension(100, 20));
		pol.setLocation(new Point(100, 420));
		panel.add(pol);

		JLabel usernameLbl = new JLabel("Korisnicko ime");
		usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		usernameLbl.setLocation(new Point(350, 70));
		usernameLbl.setSize(new Dimension(600, 30));
		panel.add(usernameLbl);

		username = new JTextField();
		username.setSize(new Dimension(200, 30));
		username.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		username.setLocation(new Point(350, 100));
		panel.add(username);

		JLabel passwordLbl = new JLabel("Lozinka");
		passwordLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordLbl.setLocation(new Point(350, 130));
		passwordLbl.setSize(new Dimension(600, 30));
		panel.add(passwordLbl);

		password = new JTextField();
		password.setSize(new Dimension(200, 30));
		password.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		password.setLocation(new Point(350, 160));
		panel.add(password);


		JLabel tipLbl = new JLabel("Izaberite tip korisnika");
		tipLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tipLbl.setLocation(new Point(350, 190));
		tipLbl.setSize(new Dimension(500, 30));
		panel.add(tipLbl);

		String[] ulogaString = { "Administrator", "Radnik" };
		tipKorisnikaCb = new JComboBox<String>(ulogaString);
		tipKorisnikaCb.setSelectedIndex(0);
		tipKorisnikaCb.setSize(new Dimension(150, 20));
		tipKorisnikaCb.setLocation(new Point(350, 220));
		panel.add(tipKorisnikaCb);

		confirmButton = new JButton("Kreiraj korisnika");
		confirmButton.setAlignmentX(CENTER_ALIGNMENT);
		confirmButton.setMnemonic(KeyEvent.VK_ENTER);
		confirmButton.setLocation(new Point(210, 500));
		confirmButton.setSize(new Dimension(180, 40));
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long date = new java.util.Date().getTime();
				java.sql.Date sqlDate = new java.sql.Date(date);
				String uloga = "";
				for(int i = 0; i<2;i++)
					uloga += ulogaString[tipKorisnikaCb.getSelectedIndex()].charAt(i);
				String polS = "";
				polS += polString[pol.getSelectedIndex()].charAt(0);
				tableDataModel.executeCreateStoredProcedure("InsertKorisnickiNalog(?,?,?,?,?,?,?,?,?,?,?)",Integer.parseInt(id.get(poslovniSistemi.getSelectedIndex()).toString()),prezime.getText(),ime.getText(),imeOca.getText(),polS,maticniBroj.getText(),sqlDate,username.getText(),password.getText(),username.getText(),uloga);
			
			
				int rowCount = tableDataModel.getRowCount();
				
				tableDataModel.setRowCount(rowCount + 1);
				
				tableDataModel.polja.add(username.getText());
				tableDataModel.polja.add(ime.getText());
				tableDataModel.polja.add(prezime.getText());
				tableDataModel.polja.add(ulogaString[tipKorisnikaCb.getSelectedIndex()]);
				tableDataModel.polja.add(username.getText());
				tableDataModel.polja.add(password.getText());
				
				tableView.setModel(tableDataModel);
				tableDataModel.fireTableStructureChanged();
				dispose();
			}
		});
		
		panel.add(confirmButton);
	}
public void updateUser()
{
	this.setSize(new Dimension(600,400));
	panel.setSize(new Dimension(600, 600));
	JLabel imeLbl = new JLabel("Ime zaposlenog");
	imeLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	imeLbl.setLocation(new Point(100, 70));
	imeLbl.setSize(new Dimension(600, 30));
	panel.add(imeLbl);

	ime = new JTextField();
	ime.setSize(new Dimension(200, 30));
	ime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	ime.setLocation(new Point(100, 100));
	ime.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE)
					|| (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			}
		}
	});
	

	JLabel prezimeLbl = new JLabel("Prezime zaposlenog");
	prezimeLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	prezimeLbl.setLocation(new Point(100, 130));
	prezimeLbl.setSize(new Dimension(600, 30));
	panel.add(prezimeLbl);

	prezime = new JTextField();
	prezime.setSize(new Dimension(200, 30));
	prezime.setFont(new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	prezime.setLocation(new Point(100, 160));
	prezime.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE)
					|| (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			}
		}
	});
	
	JLabel usernameLbl = new JLabel("Korisnicko ime");
	usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	usernameLbl.setLocation(new Point(350, 70));
	usernameLbl.setSize(new Dimension(600, 30));
	panel.add(usernameLbl);

	username = new JTextField();
	username.setSize(new Dimension(200, 30));
	username.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	username.setLocation(new Point(350, 100));
	

	JLabel passwordLbl = new JLabel("Lozinka");
	passwordLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	passwordLbl.setLocation(new Point(350, 130));
	passwordLbl.setSize(new Dimension(600, 30));
	panel.add(passwordLbl);

	password = new JTextField();
	password.setSize(new Dimension(200, 30));
	password.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	password.setLocation(new Point(350, 160));
	


	JLabel tipLbl = new JLabel("Izaberite tip korisnika");
	tipLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	tipLbl.setLocation(new Point(350, 190));
	tipLbl.setSize(new Dimension(500, 30));
	panel.add(tipLbl);

	String[] ulogaString = { "Administrator", "Radnik" };
	tipKorisnikaCb = new JComboBox<String>(ulogaString);
	tipKorisnikaCb.setSelectedIndex(0);
	tipKorisnikaCb.setSize(new Dimension(150, 20));
	tipKorisnikaCb.setLocation(new Point(350, 220));
	

	getUser();
	panel.add(tipKorisnikaCb);
	panel.add(ime);
	panel.add(prezime);
	panel.add(username);
	panel.add(password);
	confirmButton = new JButton("Izmjeni korisnika");
	confirmButton.setAlignmentX(CENTER_ALIGNMENT);
	confirmButton.setMnemonic(KeyEvent.VK_ENTER);
	confirmButton.setLocation(new Point(210, 300));
	confirmButton.setSize(new Dimension(180, 40));
	
	confirmButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String uloga = "";
			for(int i = 0; i<2;i++)
				uloga += ulogaString[tipKorisnikaCb.getSelectedIndex()].charAt(i);
			
			tableDataModel.executeCreateStoredProcedure("dbo_KorisnikUpdate(?,?,?,?,?,?)",tableDataModel.getValueAt(tableView.getSelectedRow(), 0),ime.getText(),prezime.getText(),username.getText(),password.getText(),uloga);
		
		
			int rowCount = tableView.getSelectedRow();
			
			tableDataModel.getPolja().set(tableDataModel.getPoljeIndex(rowCount, 1), ime.getText());
			tableDataModel.getPolja().set(tableDataModel.getPoljeIndex(rowCount, 2), prezime.getText());
			tableDataModel.getPolja().set(tableDataModel.getPoljeIndex(rowCount, 3), tipKorisnikaCb.getSelectedItem());
			tableDataModel.getPolja().set(tableDataModel.getPoljeIndex(rowCount, 4), username.getText());
		//	tableDataModel.getPolja().set(tableDataModel.getPoljeIndex(rowCount, 5), password.getText());
			
			
			
			tableView.setModel(tableDataModel);
			tableDataModel.fireTableStructureChanged();
			dispose();
		}
	});
	
	panel.add(confirmButton);

}

private void getPoslovniSistem() {
	Connection connection = DBConnection.createConnection();
	CallableStatement callableStatement;
	try {
		callableStatement =  connection.prepareCall("{ call dbo_PoslovniSistemReadAll() }",SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = callableStatement.executeQuery();
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		while(resultSet.next())
		{
			id.add((Integer) resultSet.getObject(1));
			naziv.add((String) resultSet.getObject("PS_NAZIV"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
private void getUser()
{
	Connection connection = DBConnection.createConnection();
	CallableStatement callableStatement;
	try
	{
		callableStatement =  connection.prepareCall("{ call dbo_SelektovaniKorisnikRead(?) }",SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);
		callableStatement.setObject(1,tableDataModel.getValueAt(tableView.getSelectedRow(), 0));
		ResultSet resultSet = callableStatement.executeQuery();
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		while(resultSet.next())
		{
			ime.setText( resultSet.getObject(1).toString());
			prezime.setText(resultSet.getObject(2).toString());
			username.setText(resultSet.getObject(3).toString());
			password.setText(resultSet.getObject(4).toString());
			tipKorisnikaCb.setSelectedItem(resultSet.getObject(5).toString());
			
		}
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
}
}