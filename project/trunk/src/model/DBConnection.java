package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection  conn = null;
	public static DBConnection instance = null;
	public static String dbURL = "jdbc:jtds:sqlserver://78.28.157.8:1433/PIS2022";
	public static String username = "EtfPIS2022G5";
	public static String password = "EtfPIS2022G50972";
	
	public static DBConnection getInstance()
	{
		if(instance == null)
			instance = new DBConnection();
		return instance;
	}
	public static Connection createConnection()
	{
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("connection established!");
		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return conn;
	}
	
}
