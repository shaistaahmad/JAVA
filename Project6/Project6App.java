package proj6;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
/**
 * Project6App class
 * This class takes all the methods of the Book and Library class and implements them 
 * after reading and scanning a txt file with all the Book object information to be saved into a Library
 * object.
 * @author Shaista Ahmad
 */

public class Project6App {

	public static void main(String[] args) throws Exception {
		Library archive = new Library();
		Scanner fileScan = new Scanner(new File("libraryHoldings.txt")); 


		int numBooks;
		String title;
		String author;
		String status;
		String bookTotal;

		//scanning the text file
		bookTotal = fileScan.nextLine();
		numBooks = Integer.parseInt(bookTotal);
		Book book;

		for(int i = 0; i < numBooks; i++) {
			title = fileScan.nextLine();
			author = fileScan.nextLine();
			status = fileScan.nextLine();
			book = new Book(title, author, status);
			archive.insert(book);
		}

		fileScan.close();

		//using the JOptionPane class
		String[] choices = {"Check Out Book", "Return Book", "Mark Book As Overdue", "Show Books", "Quit"};
		int choice = JOptionPane.showOptionDialog(
				null,
				"Enter your choice...",
				"Main Menu",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choices,
				choices[0]);

		/**
		 * Check out book
		 */
		if (choice == 0) { 

			String searchTitle = JOptionPane.showInputDialog("Enter the book title you're interested in checking out");
			boolean checkedOut = archive.checkOut(searchTitle);

			if (checkedOut == true) {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " has successfully been checked out.",
						"Check Out Book",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " is not available.",
						"Check Out Book",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		/**
		 * Returns
		 */
		if (choice == 1) { 
			String searchTitle = JOptionPane.showInputDialog("Enter the book title you're returning");
			boolean returnedBack = archive.returnBook(searchTitle);

			if (returnedBack == true) {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " has successfully been returned.",
						"Returns",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " cannot be returned",
						"Returns",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		/**
		 * Mark Book as Overdue
		 */
		if (choice == 2) { 
			String searchTitle = JOptionPane.showInputDialog("Enter the book title you're marking overdue");
			boolean overdue = archive.markOverdue(searchTitle);

			if (overdue == true) {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " has been marked overdue",
						"Mark Book as Overdue",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(
						null,
						"The book " + searchTitle + " cannot be marked overdue",
						"Mark Book as Overdue",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}


		/**
		 * Show Book List
		 */
		if (choice == 3) {
			String bookString = new String();
			String[] secondChoice = {"Available", "Out", "Overdue"};
			
			int second = JOptionPane.showOptionDialog(
					null,
					"Choose which book list you'd like to see",
					"Book List Options",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					secondChoice,
					secondChoice[0]);
			
			if (second == 0) { //if user selects 'available'
				JOptionPane.showMessageDialog(
						null,
						"The books available are\n" + archive.available(),
						"Books Available",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if (second == 1) { // if user selects 'out'
				JOptionPane.showMessageDialog(
						null,
						"The books currently out are\n" + archive.checkIfOut(),
						"Books Out",
						JOptionPane.INFORMATION_MESSAGE);
				
			}

			else { //if user selects 'overdue'
				JOptionPane.showMessageDialog(
						null,
						"The books currently overdue are\n" + archive.checkOverdue(),
						"Books Overdue",
						JOptionPane.INFORMATION_MESSAGE);
				
				
			}

		}
		
		
	}


}


