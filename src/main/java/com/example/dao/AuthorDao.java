package com.example.dao;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.database.DatabaseConnector;
import com.example.helper.CodeHelper;
import com.example.model.Author;



public class AuthorDao {

	

	private static AuthorDao instance;
	private static Statement statement;
	
	
	
	private AuthorDao() throws Exception {
		instance = this;
		statement = DatabaseConnector.getInstance().getStatement();
	}
	
	
	
	public static AuthorDao getInstance() throws Exception {
		return instance != null ? instance : new AuthorDao();
	}
	
	
	
	/*
	 * CRUD methods
	 */
	
	// create author
	public boolean addAuthor( Author author ) {
		
		String query = "INSERT INTO " + CodeHelper.AUTHOR_TABLE + "(name, surname) VALUES (?, ?);";
		try {
			PreparedStatement preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement( query );
			
			preparedStatement.setString( 1, author.getName() );
			preparedStatement.setString( 2, author.getSurname() );
			
			preparedStatement.execute();
		} 
		catch ( Exception e ) {
			return false;
		}
		
		return true;
	}
		
	
	// read author
	//public Author getAuthorById( int id )
	
	
	// update author
	
	
	// delete author
}
