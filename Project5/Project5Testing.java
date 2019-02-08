package proj5;
/**
 * Project5Testing 
 * tests the DiceArray class and makes sure it runs smoothly
 * @author Shaista Ahmad N00861186
 *
 */
public class Project5Testing {

	/**
	 * Main method
	 * implements methods taken from the DiceArray class
	 * @param args sent to the main method for testing
	 */
	public static void main(String[] args) {

		//first we test the regular constructor
		System.out.println("Testing the parameterized constructor with an argument of 5:");
		DiceArray game1 = new DiceArray(5);
		System.out.println(game1.toString());

		//roll method test
		System.out.println("\nTesting the roll method:");
		game1.roll();
		System.out.println(game1.toString());

		//keep method test with number 1 & roll
		System.out.println("\nCall the keep method with an argument of 1, then roll again:");
		game1.keep(1);
		game1.roll();
		System.out.println(game1.toString());

		//keep method test with number 2 & roll
		System.out.println("\nCall the keep method with an argument of 2, then roll again:");
		game1.keep(2);
		game1.roll();
		System.out.println(game1.toString());

		//keep method test with number 3 & roll
		System.out.println("\nCall the keep method with an argument of 3, then roll again:");
		game1.keep(3);
		game1.roll();
		System.out.println(game1.toString());
		
		//reset method
		System.out.println("\nCall the reset method, then roll again:");
		game1.reset();
		game1.roll();
		System.out.println(game1.toString());
		
		//calculate all the totals
		System.out.println("\nCalculating the sum of all the 1s: " + game1.calculateTotal(1));
		System.out.println("Calculating the sum of all the 2s: " + game1.calculateTotal(2));
		System.out.println("Calculating the sum of all the 3s: " + game1.calculateTotal(3));
		System.out.println("Calculating the sum of all the 4s: " + game1.calculateTotal(4));
		System.out.println("Calculating the sum of all the 5s: " + game1.calculateTotal(5));
		System.out.println("Calculating the sum of all the 6s: " + game1.calculateTotal(6));





	}

}
