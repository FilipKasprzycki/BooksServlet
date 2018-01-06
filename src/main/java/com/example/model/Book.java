package com.example.model;

import java.io.Serializable;

public class Book implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private Long id;
	private String title;
	private String author;
	private int pages;
	
	
	
	/*
	 * Consturctors
	 */
	
	public Book() {
	}
	
	
	public Book( String title, int pages ) {
		this.title = title;
		this.pages = pages;
	}
	
	
	public Book( Long id, String title, int pages ) {
		this( id, title, null, pages );
	}
	
	
	public Book( Long id, String title, String author, int pages ) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
	
	public Book( String title, String author, int pages ) {
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
	
	
	/*
	 * Getters & setters
	 */
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	
	public int getPages() { return pages; }
	public void setPages(int pages) { this.pages = pages; }	
}
