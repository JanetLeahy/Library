/*
 * Class representing a Book object, which can be borrowed from
 *  or returned to a library collection
 *
 * Janet Leahy
 * Oct 10 2017
 */

public class Book extends RentableObject {
	private String author;

	public Book(String title, String author) {
		super(title);
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return title + ", by " + author;
	}
	

}
