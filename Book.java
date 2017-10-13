/*
 * Class representing a Book object, which can be borrowed from
 *  or returned to a library collection
 *
 * Janet Leahy
 * Oct 10 2017
 */

public class Book {
	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return title + ", by " + author;
	}
	

}
