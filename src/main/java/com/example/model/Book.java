package com.example.model;



public class Book {

	
	
	private Long id;
	private String title;
	private Author author;
	private int pages;
	
	
	
	/*
	 * Getters & setters
	 */
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public Author getAuthor() { return author; }
	public void setAuthor(Author author) { this.author = author; }
	
	public int getPages() { return pages; }
	public void setPages(int pages) { this.pages = pages; }	
}
