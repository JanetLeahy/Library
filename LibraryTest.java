import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testAdd() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 0);
		lib.addBook(new Book("Title", "Author"), "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 1);
	}
	
	@Test
	public void testAddToInvalidBranch() {
		Library lib = new Library();
		lib.addBook(new Book("Title", "Author"), "Foothills");
		assertEquals(lib.getTotalItems(), 0);
	}
	
	@Test
	public void testNumItems() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBranch("Central");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author2"), "Foothills");
		lib.addDVD(new DVD("aDVD", 2014), "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 2);
		assertEquals(lib.getNumDVDs("Foothills"), 1);
		assertEquals(lib.getNumBooks("Central"), 0);
		lib.addBook(new Book("Title3", "Author"), "Central");
		assertEquals(lib.getNumBooks("Foothills"), 2);
		assertEquals(lib.getNumBooks("Central"), 1);
	}
	
	@Test
	public void testTotalItems() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBranch("Central");
		assertEquals(lib.getTotalItems(), 0);
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author2"), "Foothills");
		assertEquals(lib.getTotalItems(), 2);
		lib.addBook(new Book("Title3", "Author"), "Central");
		assertEquals(lib.getTotalItems(), 3);
	}
	
	@Test
	public void testNumStocked() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBranch("Central");
		assertEquals(lib.getNumStockedItems(), 0);
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author2"), "Foothills");
		assertEquals(lib.getNumStockedItems(), 2);
	}
	
	@Test
	public void testCheckout() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author"), "Foothills");
		
		lib.checkoutBook("Title", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 1);
		assertEquals(lib.getTotalItems(), 2);
		assertEquals(lib.getNumStockedItems(), 1);
	}
	
	@Test
	public void testCheckoutInvalidBook() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		
		lib.checkoutBook("XXX", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 1);
		assertEquals(lib.getTotalItems(), 1);
	}

	@Test
	public void testCheckoutInvalidBranch() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		
		lib.checkoutBook("Title", "XXX");
		assertEquals(lib.getNumBooks("Foothills"), 1);
		assertEquals(lib.getTotalItems(), 1);
	}

	@Test
	public void testCheckoutDuplicateBook() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		
		//checkout one copy
		lib.checkoutBook("Title", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 1);
		assertEquals(lib.getTotalItems(), 2);
		//checkout the other
		lib.checkoutBook("Title", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 0);
		assertEquals(lib.getTotalItems(), 2);
	}

	
	@Test
	public void testReturnBook() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author"), "Foothills");
		lib.checkoutBook("Title", "Foothills");

		assertEquals(lib.getNumBooks("Foothills"), 1);
		lib.returnBook("Title", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 2);
	}
	
	@Test
	public void testReturnInvalidBook() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author"), "Foothills");
		lib.checkoutBook("Title", "Foothills");
		
		assertEquals(lib.getNumBooks("Foothills"), 1);
		lib.returnBook("XXX", "Foothills");
		assertEquals(lib.getNumBooks("Foothills"), 1);
	}
	
	@Test
	public void testReturnInvalidBranch() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.checkoutBook("Title", "Foothills");
		
		lib.returnBook("Title", "XXX");
		assertEquals(lib.getNumBooks("Foothills"), 0);
		assertEquals(lib.getTotalItems(), 1);
	}
	
	@Test
	public void testReturnToDifferentBranch() {
		Library lib = new Library();
		lib.addBranch("Foothills");
		lib.addBranch("Central");
		lib.addBook(new Book("Title", "Author"), "Foothills");
		lib.addBook(new Book("Title2", "Author"), "Foothills");
		lib.checkoutBook("Title", "Foothills");
		
		lib.returnBook("Title", "Central");
		assertEquals(lib.getNumBooks("Foothills"), 1);
		assertEquals(lib.getNumBooks("Central"), 1);
	}
}
