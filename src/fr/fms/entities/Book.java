package fr.fms.entities;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private int thematic;
	private double unitaryPrice;

	public Book(int bookId, String title, String author, int thematic, double unitaryPrice) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.thematic = thematic;
		this.unitaryPrice = unitaryPrice;
	}
	
	public Book(String title, String author, int thematic, double unitaryPrice) {
		this.title = title;
		this.author = author;
		this.thematic = thematic;
		this.unitaryPrice = unitaryPrice;
	}
	
	public Book() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public int getThematic() {
		return thematic;
	}

	public void setThematic(int thematic) {
		this.thematic = thematic;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", thematic=" + thematic
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}

}
