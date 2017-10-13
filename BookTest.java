import static org.junit.Assert.*;

import org.junit.Test;

/*
* Janet Leahy
* Oct 10 2017
*/

public class BookTest {

	@Test
	public void testBasic() {
		Book testBook = new Book("Title", "Author");
		assertEquals(testBook.getTitle(), "Title");
		assertEquals(testBook.getAuthor(), "Author");
	}

}
