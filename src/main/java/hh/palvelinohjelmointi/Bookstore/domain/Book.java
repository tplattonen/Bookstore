package hh.palvelinohjelmointi.Bookstore.domain;

public class Book {
	private String title;
	private String author;
	private long year;
	private String isbn;
	private double price;
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public long getYear() {
		return year;
	}
	public String getIsbn() {
		return isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(String title, String author, long year, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	public Book() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = null;
		this.price = 0;
	}
	
	
}
