package controller.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/crown_app";
		String user = "root";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, user, password);
	
		return connection;
	}
}