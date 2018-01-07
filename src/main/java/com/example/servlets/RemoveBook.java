package com.example.servlets;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.BookDao;
import com.example.helper.CodeHelper;
import com.example.model.Book;



/**
 * Servlet handling remove book
 */



@WebServlet(urlPatterns = {"/remove"})
public class RemoveBook extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	/*
	 * delete book by id
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			BookDao.getInstance().deleteBook( Long.parseLong( request.getParameter( "id" ) ) );
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		response.sendRedirect( "index" );
	}

	
	
	/**
	 * POST request just call GET request :)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
