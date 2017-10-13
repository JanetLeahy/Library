/*
 * General class representing an object that can be borrowed from
 *  or returned to a library collection
 *
 * Janet Leahy
 * Oct 10 2017
 */
public class RentableObject {
	protected String title;
	
	public RentableObject(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

}
