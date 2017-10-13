/*
 * Class representing a DVD object, which can be borrowed from
 *  or returned to a library collection
 *
 * Janet Leahy
 * Oct 10 2017
 */

public class DVD extends RentableObject {
	private int year;

	public DVD(String title, int year) {
		super(title);
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return title + " (" + year + ")";
	}

}
