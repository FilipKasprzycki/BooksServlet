package com.example.helper;



public class CodeHelper {

	
	
	public static final String DATABASE = "booksjdbc";
	public static final String BOOK_TABLE = "book";

	public static final String BOOK_ID = "id";
	public static final String BOOK_TITLE = "title";
	public static final String BOOK_AUTHOR = "author";
	public static final String BOOK_PAGES = "pages";
	
	private static final String prefix = "WEB-INF/jsp/";
	private static final String suffix = ".jsp";
	
	
	
	public static String path(String file) {
		return prefix + file + suffix;
	}
}
