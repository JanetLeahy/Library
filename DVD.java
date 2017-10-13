/*
 * Class representing a DVD object, which can be borrowed from
 *  or returned to a library collection
 *
 * Janet Leahy
 * Oct 10 2017
 */

public class DVD {
	private String title;
	private int year;

	public DVD(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}

}
