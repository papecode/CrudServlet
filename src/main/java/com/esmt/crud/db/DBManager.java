package com.esmt.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
private static Connection connection = null;
	
	public static Connection getConnection () throws Exception {
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			// Ouverture de la connexion
			connection = DriverManager.getConnection ("jdbc:mysql://localhost/javaee", "root", "");
			return connection;
		} catch (ClassNotFoundException e) {
				throw new Exception ("Driver Class not found : '" + e.getMessage () + "' ");
		} catch (SQLException e) {
				throw new Exception ("Error : Unable to open connection with database !");
		}
	}
}
