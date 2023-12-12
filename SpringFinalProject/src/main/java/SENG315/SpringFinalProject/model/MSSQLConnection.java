package SENG315.SpringFinalProject.model;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("MSSQLConnection")
@PropertySource("application.properties")
public class MSSQLConnection {
    private java.sql.Connection con = null;
    @Value("${mssql.driver}")
    private String driver;
    @Value("${mssql.url}")
    private String url;
    @Value("${mssql.serverName}")
    private String serverName;
    @Value("${mssql.portNumber}")
    private String portNumber;
    @Value("${mssql.userName}")
    private String userName;
    @Value("${mssql.password}")
    private String password;
    @Value("${mssql.database}")
    String database;
    
    public MSSQLConnection() {
    	
    }
    
    public Connection getConnection(){
    	try{
    		String connectionURL = url + serverName+ ":" + portNumber + ";encrypt=false";
	        
    		Class.forName(driver);
    		con = java.sql.DriverManager.getConnection(connectionURL,userName,password);
    		
	       } catch(Exception e){
	        	e.printStackTrace();
	        	System.out.println("Error Trace in getConnection() : " + e.getMessage());
	       }
        return con;
    }

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
    
}