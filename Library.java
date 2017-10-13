import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * Central library, which owns and controls several branches. Keeps track of
 * books that are on loan, and handles borrowing and returning from the
 * individual branches
 * 
 * Janet Leahy
 * Assignment 1 for CPSC 501, Fall 2017
 * 10104311
 * 
 * Oct 10 2017
 * 
 */

public class Library {
	//Stores the branches in a hash map, so they can be accessed by name
	private HashMap<String, LibraryBranch> branches;
	//Stores the items checked out in an array, to allow for duplicate titles
	private ArrayList<Book> booksOut;
	private ArrayList<DVD> dvdsOut;
	
	public Library() {
		branches = new HashMap<String, LibraryBranch>();
		booksOut = new ArrayList<Book>();
		dvdsOut = new ArrayList<DVD>();
	}

	public void addBranch(String branchName) {
		branches.put(branchName, new LibraryBranch(branchName));
	}
	
	//returns the number of books currently held at a particular branch
	// (returns 0 if branch with given name does not exist)
	public int getNumBooks(String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch == null) {
			return 0;
		}
		else {
			return branch.getNumBooks();
		}
	}
	
	//returns the number of books currently held at a particular branch
	// (returns 0 if branch with given name does not exist)
	public int getNumDVDs(String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch == null) {
			return 0;
		}
		else {
			return branch.getNumDVDs();
		}
	}
	
	//returns the total number of items currently held in all of the branches
	public int getNumStockedItems() {
		int total = 0;
		Iterator<LibraryBranch> it = branches.values().iterator();
		LibraryBranch current;
		while(it.hasNext()) {
			current = it.next();
			total += current.getNumBooks();
			total += current.getNumDVDs();
		}
		return total;
	}
	
	//returns the total number of items, both checked out and in stock
	public int getTotalItems() {
		int total = getNumStockedItems();
		total += booksOut.size();
		total += dvdsOut.size();
		return total;
	}

	
	//prints the names of the branches
	public void printBranches() {
		System.out.println("Library branches: ");
		Iterator<String> it = branches.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	//prints the books available at a particular branch
	public void printItemsAtBranch(String branchname) {
		LibraryBranch branch = branches.get(branchname);
		if (branch != null) {
			branch.printBooks();
			branch.printDVDs();
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	//adds the book to the branch with the matching name, if the branch exists
	public void addBook(Book book, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch != null) {
			branch.add(book);
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	//adds the dvd to the branch with the matching name, if the branch exists
	public void addDVD(DVD dvd, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch != null) {
			branch.add(dvd);
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	//removes a copy of the book with the given title from the branch with the
	// provided name, if it exists, and stores the book in booksOut
	public void checkoutBook(String title, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		Book book;
		if (branch != null) {
			book = branch.checkoutBook(title);
			if (book != null) {
				booksOut.add(book);
			}
			else {
				System.out.println("Library branch does not contain the requested title");
			}
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	//removes a copy of the dvd with the given title from the branch with the
	// provided name, if it exists, and stores the dvd in dvdsOut
	public void checkoutDVD(String title, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		DVD dvd;
		if (branch != null) {
			dvd = branch.checkoutDVD(title);
			if (dvd != null) {
				dvdsOut.add(dvd);
			}
			else {
				System.out.println("Library branch does not contain the requested title");
			}
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	
	
	//returns a book to the specified branch by removing it from the booksOut list
	// and adding it to the library branch's catalog
	public void returnBook(String title, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch != null) {
			ListIterator<Book> li = booksOut.listIterator();
			Book current = null;
			while (li.hasNext()) {
				current = li.next();
				System.out.println(title);
				if (current.title.equals(title)) {
					booksOut.remove(current);
					branch.add(current);
					return;
				}
			}
			System.out.println("The requested book has not been checked out");
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	//returns a dvd to the specified branch by removing it from the dvdsOut list
	// and adding it to the library branch's catalog
	public void returnDVD(String title, String branchName) {
		LibraryBranch branch = branches.get(branchName);
		if (branch != null) {
			ListIterator<DVD> li = dvdsOut.listIterator();
			DVD current = null;
			while (li.hasNext()) {
				current = li.next();
				System.out.println(title);
				if (current.title.equals(title)) {
					dvdsOut.remove(current);
					branch.add(current);
					return;
				}
			}
			System.out.println("The requested dvd has not been checked out");
		}
		else {
			System.out.println("Library branch not found");
		}
	}
	
	
	
}
