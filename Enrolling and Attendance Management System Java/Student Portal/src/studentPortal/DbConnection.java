package studentPortal;

import java.sql.*;


public class DbConnection {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	String dbnameString ="profile";
	String tableString  = "Customer_data";
	String dbusernameString = "root";
	String dbpassString = "";
	// for online database
	
	String onlinedataBase = "mysql-69656-0.cloudclusters.net:10617"; //username = root pass = 12345678
	
public DbConnection() {
	
	 
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ dbnameString,dbusernameString,dbpassString );
		System.out.println("Connected");
		
		
	

		
	
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	

	
}	

public Connection connection() {
	
	return connection;
	
}

public ResultSet resultSet() {
	
	return resultSet;
}


	
	
	
	
	
	
	
	
	
	
}
