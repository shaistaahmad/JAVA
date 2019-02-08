package proj5;
import java.util.Scanner;
/**
 * Project5App class
 * the actual Yahtzee game
 * @author Shaista Ahmad N00861186
 *
 */
public class Project5App {
	/**
	 * Main method of Yahtzee game
	 * uses the DiceArray class to make a Yahtzee game
	 * @param args sent to the method for the game
	 */
	public static void main(String[] args) {

		DiceArray diceArray = new DiceArray(5);
		GUI gui = new GUI();
		int keep = 0;
		//declare and instantiate an integer array named score that can hold 6 elements.
		int[] score = {0, 0, 0, 0, 0, 0}; 
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;

		for (int i = 1; i <= 6; i++) 
		{	
			System.out.println("Round " + i);
			diceArray.roll();

			//This is roll 1 for the dice game
			System.out.println("Roll 1:");
			gui.showDice(diceArray);
			System.out.println("Which die value do you want to keep?");
			keep = scanner.nextInt(); // the user will choose which die value wants to keep
			diceArray.keep(keep); // use the keep method to keep the dice user wants to.
			diceArray.roll(); //use the roll method to roll the dice

			//This is roll 2 for the dice game
			System.out.println("Roll 2:");
			gui.showDice(diceArray);
			System.out.println("Which die value do you want to keep?");
			keep = scanner.nextInt();
			diceArray.keep(keep);
			diceArray.roll();

			//This is roll 3 for the dice game
			System.out.println("Roll 3:");
			gui.showDice(diceArray);

			System.out.println("Which location would you like to record this round?");
			scoreChart(score);

			// User Input taken
			userInput = scanner.nextInt();
			while(score[userInput - 1] != 0) 
			{
				System.out.println("There is already a score for location " + userInput 
						+ ". Which location would you like to record this round?");
				scoreChart(score);
				userInput = scanner.nextInt();
			}

			score[userInput - 1] = diceArray.calculateTotal(userInput);
			System.out.println("Round " + i + " complete.");
			scoreChart(score);

			diceArray.reset(); // reset method - will allow all dice to be rolled 
			//the next time the roll method is called.
		}

		int sum = 0;
		for (int i = 0; i < 6; i++) 
		{
			sum += score[i];
		}

		// After 6 rounds, this is output that's displayed.
		System.out.println("\nGame over! Your total score is " + sum);
	}

	/**
	 * scoreChart method 
	 * @param score - will display the score chart
	 */
	public static void scoreChart(int[] score) 
	{	
		//Output for the Score Chart
		System.out.println("Scores:");

		for (int i = 1; i <= 6; i++) 
		{	
			System.out.println(i + "s: " + score[i - 1] + " points");
		}
	}
}

