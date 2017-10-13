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
	private ArrayList<RentableObject> bookCatalog;
	private ArrayList<RentableObject> dvdCatalog;
	
	public LibraryBranch(String name) {
		this.name = name;
		//ArrayList used for catalog to allow duplicates
		bookCatalog = new ArrayList<RentableObject>();
		dvdCatalog = new ArrayList<RentableObject>();
	}
	
	public String getName() {
		return name;
	}

	
	//prints all books in the catalog
	public void printBooks() {
		ListIterator<RentableObject> li = bookCatalog.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
	}
	
	//prints all dvds in the catalog
	public void printDVDs() {
		ListIterator<RentableObject> li = dvdCatalog.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next());
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
	
	
	public RentableObject checkout(String title, ArrayList<RentableObject> catalog) {
		ListIterator<RentableObject> li = catalog.listIterator();
		RentableObject current;
		while (li.hasNext()) {
			current = li.next();
			if (current.getTitle() == title) {
				catalog.remove(current);
				return current;
			}
		}
		return null;
	}
	
	//finds a book with the given title, removes it from the catalog, and returns it
	public Book checkoutBook(String title) {
		return (Book) checkout(title, bookCatalog);
	}
	
	
	//finds a dvd with the given title, removes it from the catalog, and returns it
	public DVD checkoutDVD(String title) {
		return (DVD) checkout(title, dvdCatalog);
	}
}
