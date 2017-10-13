import java.util.ArrayList;
import java.util.ListIterator;

/*
 * Library class maintains catalogs of items it owns that are currently in stock
 * 
 * Janet Leahy
 * Oct 10 2017
 */

public class LibraryBranch {
	private String name;
	private ArrayList<Book> bookCatalog;
	private ArrayList<DVD> dvdCatalog;
	
	public LibraryBranch(String name) {
		this.name = name;
		//ArrayList used for catalog to allow duplicates
		bookCatalog = new ArrayList<Book>();
		dvdCatalog = new ArrayList<DVD>();
	}
	
	public String getName() {
		return name;
	}
	
	public void printBook(Book book) {
		System.out.println(book.getTitle() + ", by " + book.getAuthor());
	}
	
	public void printDVD(DVD dvd) {
		System.out.println(dvd.getTitle() + " (" + dvd.getYear() + ")");
	}
	
	//prints all books in the catalog
	public void printBooks() {
		ListIterator<Book> li = bookCatalog.listIterator();
		while (li.hasNext()) {
			printBook(li.next());
		}
	}
	
	//prints all dvds in the catalog
	public void printDVDs() {
		ListIterator<DVD> li = dvdCatalog.listIterator();
		while (li.hasNext()) {
			printDVD(li.next());
		}
	}
	
	public int getNumBooks() {
		return bookCatalog.size();
	}
	
	public int getNumDVDs() {
		return dvdCatalog.size();
	}
	
	//overloaded method to deal with different item types
	public void add(Book book) {
		bookCatalog.add(book);
	}
	
	public void add(DVD dvd) {
		dvdCatalog.add(dvd);
	}
	
	
	//finds a book with the given title, removes it from the catalog, and returns it
	public Book checkoutBook(String title) {
		ListIterator<Book> li = bookCatalog.listIterator();
		Book current;
		while (li.hasNext()) {
			current = li.next();
			if (current.getTitle() == title) {
				bookCatalog.remove(current);
				return current;
			}
		}
		return null;
	}
	
	
	//finds a dvd with the given title, removes it from the catalog, and returns it
	public DVD checkoutDVD(String title) {
		ListIterator<DVD> li = dvdCatalog.listIterator();
		DVD current;
		while (li.hasNext()) {
			current = li.next();
			if (current.getTitle() == title) {
				dvdCatalog.remove(current);
				return current;
			}
		}
		return null;
	}
}
