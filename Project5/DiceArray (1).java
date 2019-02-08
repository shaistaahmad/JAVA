package proj5;
import java.util.Random;
/**
 * Title: DiceArray class
 * @author Shaista Ahmad N00861186
 *
 */
public class DiceArray {
	/**
	 * dice represents an array containing all the face values rolled
	 */
	int[] dice;
	/**
	 * diceToRoll represents an array that contains whether a user wants to roll the dice or not
	 */
	boolean[] diceToRoll;

	/**
	 * Parameterized constructor
	 * Takes number of dice needed for the game, gives initial
	 * values to the instance variables
	 * @param numOfDice an integer that represents the number of dice
	 */
	public DiceArray(int numOfDice) {

		dice = new int[numOfDice];
		diceToRoll = new boolean[numOfDice];

		for(int i = 0; i < numOfDice; i++) {
			dice[i] = -1;
			diceToRoll[i] = true;
		}

	}
	/**
	 * toString method
	 * returns a String containing the values of the dice and indicates which are not being kept
	 * @return str a string which all the values
	 */
	public String toString() {

		String str = new String();

		for (int i = 0; i < dice.length; i++) {
			str += dice[i] + " ";
		}

		str = str + "\n";

		for (int j = 0; j < dice.length; j++) {
			if(diceToRoll[j] == true)
				str += "T" + " ";
			else
				str += "F" + " ";
		}
		return str;
	}

	/**
	 * roll method
	 * rolls the appropriate dice based on which are set to roll
	 */
	public void roll() {
		Random rand = new Random();
		for(int i = 0; i < dice.length; i++)
		{
			if(diceToRoll[i] == true)
				dice[i] = (rand.nextInt(6) + 1);
		}

	}

	/**
	 * getDice accessor method
	 * returns a reference to the array storing the face value of the dice
	 * this method will not be used
	 * @return copyDice a reference to the array with face value
	 */
	public int[] getDice() {
		int[] copyDice = new int[dice.length];
		for (int i = 0; i < dice.length; i++) {
			copyDice[i] = dice[i];
		}
		return copyDice;
	}

	/**
	 * reset method
	 * allows all dice to be rolled the next time the roll method is called
	 */
	public void reset() {
		for (int i = 0; i < dice.length; i++) {
			diceToRoll[i] = true;
		}
	}

	/**
	 * keep method
	 *  accepts an integer indicating which dice value should be kept.
	 *  @param keeper an integer indicating the dice value to keep
	 */
	public void keep(int keeper) {
		for (int i = 0; i < dice.length; i++) {
			if(dice[i] == keeper)
				diceToRoll[i] = false;
			else
				diceToRoll[i] = true;
		}
	}

	/**
	 * calculateTotal method
	 * accepts an integer indicating which of the face values to calculate a total for,
	 * & it should calculate and return a total for this face value
	 * @param faceValue a face value to calculate a total for
	 * @return total of the faceValue specified
	 */
	public int calculateTotal(int faceValue) {
		int total = 0;
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == faceValue) {
				total = total + dice[i];
			}
		}
		return total;
	}










}
