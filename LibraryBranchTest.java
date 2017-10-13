import static org.junit.Assert.*;

import org.junit.Test;

/*
* Janet Leahy
* Oct 10 2017
*/


public class LibraryBranchTest {

	@Test 
	public void testAdd() {
		LibraryBranch br = new LibraryBranch("Test Branch");
		assertEquals(br.getNumBooks(), 0);
		br.add(new Book("Title", "Author"));
		assertEquals(br.getNumBooks(), 1);

		br.add(new DVD("TitleB", 2017));
		assertEquals(br.getNumDVDs(), 1);
	}
	
	@Test
	public void testCheckoutBook() {
		LibraryBranch br = new LibraryBranch("Test Branch");
		br.add(new Book("Title1", "Author"));
		Book b2 = new Book("Title2", "Author");
		br.add(b2);
		br.add(new Book("Title3", "Author"));
		assertEquals(br.checkoutBook(b2.getTitle()), b2);
		assertEquals(br.getNumBooks(), 2);
	}
	
	@Test
	public void testCheckoutDVD() {
		LibraryBranch br = new LibraryBranch("Test Branch");
		br.add(new DVD("Title1", 2000));
		DVD dvd = new DVD("Title2", 2001);
		br.add(dvd);
		assertEquals(br.checkoutDVD(dvd.getTitle()), dvd);
		assertEquals(br.getNumDVDs(), 1);
	}
	
	@Test
	public void testCheckoutADuplicate() {
		LibraryBranch br = new LibraryBranch("Test Branch");
		br.add(new Book("Title1", "Author"));
		Book b2 = new Book("Title2", "Author");
		br.add(b2);
		br.add(new Book("Title3", "Author"));
		br.add(new Book("Title2", "Author"));
		//should only remove one of the books with that title
		assertEquals(br.checkoutBook(b2.getTitle()), b2);
		assertEquals(br.getNumBooks(), 3);
		//should checkout the second book with that title
		br.checkoutBook("Title2");
		assertEquals(br.getNumBooks(), 2);
	}
	
	@Test
	public void testCheckoutFromEmpty() {
		LibraryBranch br = new LibraryBranch("Test Branch");
		assertNull(br.checkoutBook("Title"));
	}

}
