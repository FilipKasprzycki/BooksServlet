package com.example.model;

import java.io.Serializable;

public class Author implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int id;
	private String name;
	private String surname;
	
	
	
	/*
	 * Consturctors
	 */
	
	public Author() {
	}
	
	
	public Author( String name, String surname ) {
		this.name = name;
		this.surname = surname;
	}
	
	
	
	/*
	 * Getters & setters
	 */
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; }	
	
	
	
	/*
	 * toString
	 */
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
}
