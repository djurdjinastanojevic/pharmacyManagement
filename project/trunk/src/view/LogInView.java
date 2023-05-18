package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AppController;
import model.DBConnection;
import model.MainWindowModel;
import state.ReadyState;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LogInView extends JFrame {

	private JPanel contentPane;
	public JTextField username;
	public JPasswordField password;
	private JButton loginBtn;
	private MainWindowView mainWindowView;
	private MainWindowModel mainWindowModel;


	public LogInView(MainWindowModel mainWindowModel) {
		this.mainWindowModel = mainWindowModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		setLocation(450, 250);
		setIconImage(new ImageIcon("images/login.png").getImage());
		setResizable(false);
		setElements();
		setVisible(true);
		}
	
	public void setElements() {
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 420, 80);
		panel.setBackground(new Color(144, 238, 144));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(140, 25, 190, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 115, 180, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 205, 180, 30);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(40, 160, 320, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(40, 245, 320, 30);
		contentPane.add(password);
		
		loginBtn = new JButton("LOG IN");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtn.setBounds(145, 310, 140, 30);
		contentPane.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = DBConnection.createConnection();
				String name = username.getText();
				String pass = new String(password.getPassword());
				
				try {
					CallableStatement procStatement = conn.prepareCall("{ call pisg5.Login(?,?)}");				
					procStatement.setString(1, name);
					procStatement.setString(2, pass);
					ResultSet rs=procStatement.executeQuery();
					if(rs.next())
					{
							mainWindowView = new MainWindowView(mainWindowModel);	
							AppController applicationController = new  AppController(mainWindowModel, mainWindowView);
							mainWindowModel.getApplicationState().getToolBarView(mainWindowView);
						    dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Korisnicko ime ili lozinka nije ispravno!", "Greska!",JOptionPane.OK_OPTION);
							}					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
}


