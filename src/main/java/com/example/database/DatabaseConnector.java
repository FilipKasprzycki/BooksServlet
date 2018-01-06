package com.example.database;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/*
 * Just a simple database connector
 * 
 * Role: create connection to database and provide statement (to allow other classes to implement CRUD)
 * 
 * Design pattern: singleton
 */
public class DatabaseConnector {

		
	
	private static DatabaseConnector instance; // singleton design pattern
	private static Statement statement;
	private static Connection connection;
	
	
		
	private DatabaseConnector() {
		
		instance = this;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			connection = getConnection( "db.properties" );
			statement = connection.createStatement();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
			
	private Connection getConnection( String path ) {
		
		Properties properties = new Properties();
		
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection(
					properties.getProperty( "url" ),
					properties.getProperty( "username" ),
					properties.getProperty( "password" ));
		}
		catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static DatabaseConnector getInstance() {
		return instance != null ? instance : new DatabaseConnector();		
	}
		
	
	
	@Override
	protected void finalize() throws Throwable {
		connection.close();
	}
	
	
	
	public Statement getStatement() {
		return statement;
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}
}
