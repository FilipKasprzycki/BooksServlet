package com.example.helper;



public class CodeHelper {

	
	
	public static final String DATABASE = "booksjdbc";
	public static final String BOOK_TABLE = "books";
	public static final String AUTHOR_TABLE = "authors";
	public static final String BOOK_AUTHOR_TABLE = "book_author";
	
	private static final String prefix = "WEB-INF/jsp/";
	private static final String suffix = ".jsp";
	
	
	
	public static String path(String file) {
		return prefix + file + suffix;
	}
}
