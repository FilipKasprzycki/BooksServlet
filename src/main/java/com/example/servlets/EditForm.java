package com.example.servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
 * Servlet that handling editing exist book
 */



@WebServlet(urlPatterns = {"/edit"})
public class EditForm extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	/*
	 * edit form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Book book = BookDao.getInstance().getBookById( Long.parseLong( (String) request.getParameter( "id" ) ) );
		System.out.println(request.getParameter( "id" ));
		request.setAttribute( "book", book );
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher( CodeHelper.path( "editForm" ) );
		requestDispatcher.forward(request, response);
	}

	
	
	/*
	 * save changes
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		
		Long id = Long.parseLong( request.getParameter( "id" ) );
		String title = request.getParameter( "title" );
		String author = request.getParameter( "author" );
		int pages = Integer.parseInt( request.getParameter( "pages" ) );
		
		if( title != "" && author != "" && pages > 0 ) {
			try {
				BookDao.getInstance().updateBook( id, new Book (title, author, pages ) );
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		response.sendRedirect( "index" );
	}
}
