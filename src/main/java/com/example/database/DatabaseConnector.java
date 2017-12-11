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

	
	
	private static DatabaseConnector instance;
	private static Statement statement;
	
	
	
	private DatabaseConnector() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		instance = this;
		
		Class.forName( "com.mysql.jdbc.Driver" );
		Connection connection = getConnection( "db.properties" );
		statement = connection.createStatement();
	}
	
	
			
	private Connection getConnection( String path ) throws FileNotFoundException, IOException, SQLException {
		Properties properties = new Properties();
		
		properties.load( new FileInputStream( path ) );
		
		return DriverManager.getConnection(
				properties.getProperty( "url" ),
				properties.getProperty( "username" ),
				properties.getProperty( "password" ));
	}
	
	
	
	public static DatabaseConnector getInstance() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		return instance != null ? instance : new DatabaseConnector();
	}
	
	public Statement getStatement() {
		return statement;
	}
}
