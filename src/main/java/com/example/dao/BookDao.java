package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.database.DatabaseConnector;
import com.example.helper.CodeHelper;
import com.example.model.Book;

public class BookDao {

	
	
	private static BookDao instance;
	private static Statement statement;
	
	
	
	private BookDao() {
		instance = this;
		
		try {
			statement = DatabaseConnector.getInstance().getStatement();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	
	public static BookDao getInstance() {
		return instance != null ? instance : new BookDao();
	}
	
	
	
	public Book getBookById( Long id ) {
		
		Book book = null;
		
		String query = "SELECT * FROM " + CodeHelper.BOOK_TABLE + " WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement( query );
			
			preparedStatement.setLong( 1, id );
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			book = new Book( resultSet.getString( 2 ), resultSet.getInt( 3 ) );
		} 
		catch ( Exception e ) {
			return null;
		}
		
		return book;
	}
	
	
	
	public List< Book > getAllBooks() {
		
		List< Book > books = new ArrayList< Book >();
		
		String query = "SELECT * FROM " + CodeHelper.BOOK_TABLE;
		
		try {
			PreparedStatement preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement( query );			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while( resultSet.next() ) {				
				books.add( new Book( 
						resultSet.getLong( 1 ),
						resultSet.getString( 2 ),
						resultSet.getString( 3 ),
						resultSet.getInt( 4 ) ) );
			}
		} 
		catch ( Exception e ) {
			return null;
		}		
		
		return books;
	}
}
