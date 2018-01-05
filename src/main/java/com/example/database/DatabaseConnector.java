package com.example.database;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	
		
	private DatabaseConnector() throws Exception {
		
		instance = this;

		Connection connection;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			connection = getConnection( "db.properties" );
			statement = connection.createStatement();
		} 
		catch (ClassNotFoundException e) {
			throw new Exception( "Can't find mysql driver class" );
		} 
		catch (FileNotFoundException e) {
			throw new Exception( "db.properties file not found" );
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
			
	private Connection getConnection( String path ) throws Exception {
		Properties properties = new Properties();
		
		properties.load( new FileInputStream( path ) );
		
		return DriverManager.getConnection(
				properties.getProperty( "url" ),
				properties.getProperty( "username" ),
				properties.getProperty( "password" ));
	}
	
	
	
	public static DatabaseConnector getInstance() throws Exception {
		try {
			return instance != null ? instance : new DatabaseConnector();
		}
		catch(Exception e) {
			throw new Exception( "Can't return DatabaseConnector instance" );
		}
	}
	
	
	
	public Statement getStatement() {
		return statement;
	}
}
