package proj6;
/**
 * The Library class
 * This class stores Book objects into an array and the number of books
 * stored in total
 * @author Shaista Ahmad
 *
 */
public class Library {

	private Book[] library;
	private int numBooks;

	/**
	 * Default constructor
	 * Creates a Library object that can store 50 Book objects into an array
	 * and the number of books into an integer variable
	 */
	public Library() {
		library = new Book[50];
		numBooks = 0;
	}

	/**
	 * insert method
	 * Takes Book object from parameter and stores it into the Library object 
	 * after making sure that there is space. 
	 * @param newBook
	 */
	public void insert(Book newBook) {
		if (numBooks < 50) {
			library[numBooks] = newBook;
			numBooks++;
		}
	}
	/**
	 * findTitle method
	 * This method takes a title String and searches for the title in the array of the Library object
	 * @param bookTitle is sent to the parameter
	 * @return titleNum a reference in the array of the location of the found title
	 */
	public int findTitle(String bookTitle) {
		int titleNum = -1;
		for (int i = 0; i < numBooks; i++) {
			if (library[i].getTitle().compareTo(bookTitle) == 0) {
				titleNum = i;
				break;
			}
		}
		return titleNum;
	}

	/**
	 * checkOut method
	 * This method checks whether a book is available and allows a user to check it out
	 * @param bookTitle
	 * @return boolean checkedOut verifying whether a Book object has been checked out
	 */
	public boolean checkOut(String bookTitle) {
		int libraryBook = this.findTitle(bookTitle);
		boolean checkedOut = false;
		if(libraryBook > -1) {
			String bookStatus = library[libraryBook].getStatus();
			if(bookStatus.equals("Available")) {
				library[libraryBook].setStatus("Out");
				checkedOut = true;
			}
		}
		return checkedOut;
	}

	/**
	 * returnBook method
	 * Takes a title String and determines whether a book has been out or overdue before accepting it 
	 * as a return
	 * @param bookTitle
	 * @return a boolean saying whether a book was succesfully returned
	 */
	public boolean returnBook(String bookTitle) {
		boolean returned = false;
		int libraryBook = this.findTitle(bookTitle);
		if(libraryBook > -1) {
			String bookStatus = library[libraryBook].getStatus();
			if (bookStatus.equals("Available") == false) {
				library[libraryBook].setStatus("Available");
				returned = true;
			}
		}
		return returned;
	}

	/**
	 * markOverdue method
	 * This method checks whether a title is found in a library and then checks whether it is out
	 * before marking it overdue
	 * @param bookTitle
	 * @return a boolean that specifies whether a book has successfully been marked overdue
	 */
	public boolean markOverdue(String bookTitle) {
		boolean overdue = false;
		int libraryBook = this.findTitle(bookTitle);
		if(libraryBook > -1) {
			String bookStatus = library[libraryBook].getStatus();
			if (bookStatus.equals("Out")) {
				library[libraryBook].setStatus("Overdue");
				overdue = true;
			}
		}
		return overdue;
	}

	/**
	 * available method
	 * determines whether each book in the array is available before putting it into a string 
	 * @return a string with all the names of the books available in this library
	 */
	public String available() {
		String str = "";
		String a = "Available";
		for(int i = 0; i < numBooks; i++) {
			if (library[i].getStatus().equals(a)) {
				str += (library[i].toString() + "\n");
			}
		}
		return str;
	}

	/**
	 * checkIfOut method
	 * determines whether each book in the array is available before putting it into a string 
	 * @return a string with all the names of the books out in this library
	 */
	public String checkIfOut() {
		String str = "";
		String b = "Out";
		
		for(int i = 0; i < numBooks; i++) {
			if (library[i].getStatus().equals(b) == true) {
				str += (library[i].toString() + "\n");
			}
		}
		return str;
	}
	
	/**
	 * checkOverdue method
	 * determines whether each book in the array is oveerdue before putting it into a string 
	 * @return a string with all the names of the books overdue in this library
	 */
	public String checkOverdue() {
		String str = "";
		String c = "Overdue";
		
		for(int i = 0; i < numBooks; i++) {
			if (library[i].getStatus().equals(c) == true) {
				str += (library[i].toString() + "\n");
			}
		}
		return str;
	}
	
	/**
	 * toString method
	 * Takes all the information stored in the array and stores it into a readable string
	 * @return str a String containing all the Book object info
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < numBooks; i++) {
			str += (library[i].toString() + "\n");
		}
		return str;
	}

}
