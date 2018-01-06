package com.example.servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.BookDao;
import com.example.database.DatabaseConnector;
import com.example.helper.CodeHelper;
import com.example.model.Book;



/**
 * Servlet that handling index page
 * 
 * Role: show all books table with possibility to full CRUD
 */



@WebServlet(urlPatterns = {"/", "/index"})
public class Index extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book = BookDao.getInstance().getBookById( 1L );
		request.setAttribute( "book", book );		
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher( CodeHelper.path( "index" ) );
		requestDispatcher.forward(request, response);
	}

	
	
	/**
	 * POST request just call GET request :)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
