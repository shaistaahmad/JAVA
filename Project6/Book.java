package proj6;
/**
 * The Book Class
 * This class enables a user to create Book objects that 
 * contain information such as the title name, author, and current status.
 * @author Shaista Ahmad
 *
 */

public class Book {

	private String title;
	private String author;
	private String status;

	/**
	 * Parameterized constructor
	 * This method creates a Book object using the information sent
	 * to the parameters.
	 * @param t sent to define title
	 * @param a sent to define author
	 * @param s sent to define status
	 */
	public Book(String t, String a, String s) {
		title = t;
		author = a;
		status = s;

	}

	/**
	 * setTitle
	 * Mutator method for title using the information sent to
	 * the parameter
	 * @param newTitle sent to parameter to change the title 
	 */
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	/**
	 * setAuthor
	 * Mutator method for author using the information sent to
	 * the parameter
	 * @param newAuthor sent to parameter to change the title 
	 */
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}

	/**
	 * setStatus
	 * Mutator method that first checks that the input is valid 
	 * before accepting it and changing the status of the Book object
	 * @param statusUpdate sent to the parameter to change status
	 */
	public void setStatus(String statusUpdate) {
		if(statusUpdate == "Available") {
			status = statusUpdate;
		}
		if(statusUpdate == "Out") {
			status = statusUpdate;
		}
		if(statusUpdate == "Overdue") {
			status = statusUpdate;
		}
	}

	/**
	 * getTitle
	 * Accessor method that returns the title of the Book object
	 * @return title of the Book object
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getAuthor
	 * Accessor method that returns the author of the Book object
	 * @return author of the Book object
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * getStatus
	 * Accessor method that returns the status of the Book object
	 * @return status of the Book object
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * toString
	 * Method that returns all the Book object variables
	 * in the form of a String
	 * @return a String with all the variables
	 */
	public String toString() {
		String str = new String();
		str = (this.getTitle() + " by " + this.getAuthor() + " is currently " + this.getStatus());
		return str;
	}
	
}
