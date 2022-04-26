package fr.fms.entities;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private String thematic;
	private String unitaryPrice;

	public Book(int bookId, String title, String author, String thematic, String unitaryPrice) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.thematic = thematic;
		this.unitaryPrice = unitaryPrice;

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

	public String getThematic() {
		return thematic;
	}

	public void setThematic(String thematic) {
		this.thematic = thematic;
	}

	public String getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(String unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", thematic=" + thematic
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}

}
