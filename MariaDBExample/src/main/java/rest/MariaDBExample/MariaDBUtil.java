package rest.MariaDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

//Utility class final so it can't be inherited
public final class MariaDBUtil {
	
	private static java.sql.Connection con = null;
	private static String url;
	private static String serverName;
	private static String portNumber;
	private static String userName;
	private static String password;
	private static String database;
	private static String driver;
	
	// private so it can't be instantiated
	private MariaDBUtil() {
		
	}
	
	// static block loads when app starts
	static {
		// pulls jdbc properties
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		url = rb.getString("mariadb.url");
		serverName = rb.getString("mariadb.serverName");
		portNumber = rb.getString("mariadb.portNumber");
		userName = rb.getString("mariadb.userName");
		password = rb.getString("mariadb.password");
		database = rb.getString("mariadb.database");
		driver = rb.getString("mariadb.driver");
	}
	
	public static Connection getConnection() {
		
		try {
			String connectionURL = url + serverName + ":" + portNumber + "/" + database;
			
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : " + e.getMessage());
		}
		return con;
	}
	
}
