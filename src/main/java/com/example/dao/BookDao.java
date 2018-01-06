package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.database.DatabaseConnector;
import com.example.helper.CodeHelper;
import com.example.model.Book;

public class BookDao {

	
	
	private static BookDao instance;
	private static Statement statement;
	
	
	
	/*
	 * Constructor
	 */
	
	private BookDao() {
		instance = this;
		
		try {
			statement = DatabaseConnector.getInstance().getStatement();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	
	// getInstance
	public static BookDao getInstance() {
		return instance != null ? instance : new BookDao();
	}
	
	
	
	/*
	 * CRUD methods
	 */
	
	// getBookById
	public Book getBookById( Long id ) {
		
		Book book = null;
		
		String query = "SELECT * FROM book WHERE id = ?";
		
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
	
	
	
	// getAllBooks
	public List< Book > getAllBooks() {
		
		List< Book > books = new ArrayList< Book >();
		
		String query = "SELECT * FROM book";
		
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
	
	
	
	// addBook
	public void addBook( Book book ) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO book (title, author, pages) VALUES (?, ?, ?)";
		
		try {
			preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement( query );
			preparedStatement.setString( 1, book.getTitle() );
			preparedStatement.setString( 2, book.getAuthor() );
			preparedStatement.setInt( 3, book.getPages() );
			
			preparedStatement.executeUpdate();
		} 
		catch ( Exception e ) {
			
			e.printStackTrace();
		}
		finally {
			if( preparedStatement != null ) {
				preparedStatement.close();
			}
		}
	}
	
	
	
	// deleteBook
	public void deleteBook( Long id ) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		String query = "DELETE FROM book WHERE id = ?";
		
		try {
			preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement( query );
			
			preparedStatement.setLong( 1, id );
			
			preparedStatement.executeUpdate();
		} 
		catch ( Exception e ) {
			
			e.printStackTrace();
		}
		finally {
			if( preparedStatement != null ) {
				preparedStatement.close();
			}
		}
	}
}
