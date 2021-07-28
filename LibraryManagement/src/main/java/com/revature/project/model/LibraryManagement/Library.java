package com.revature.project.model.LibraryManagement;

public class Library
{
	private Long isbn;
	private String title;
	private String author;
	private Integer price;
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn2) {
		this.isbn = isbn2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "\nLibrary [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
