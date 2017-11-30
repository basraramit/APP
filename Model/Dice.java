package Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * 
 * Allows the creation of Risk Dice objects used to handle player rolling.
 * @author yaome
 *
 */
 
public class Dice implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;

	/** The roll. */
	private int roll;
	
	/** The dice array. */
	private int[] diceArray;
    
    /** The dice. */
    private Random dice;

    /**
     * Instantiates a new dice.
     */
    public Dice() {
	
    }

    /**
     * Returns an integer array of values between 1 and 6 representing the
     * outcome of rolling the dice.  The number of values in the array should be
     * between 1 and 3, depending on the number of dice rolled by the player.  The 
     * number of dice rolled by the player is specified by the argument numberOfDice
     *
     * @param numberOfDice the number of dice
     * @return the int[]
     */
    public int[] roll(int numberOfDice) {
	
		diceArray = new int[numberOfDice];
		
		for(int i = 0; i < diceArray.length; i++) {
			dice = new Random();
			roll = dice.nextInt(5) + 1;
			diceArray[i] = roll;
		}
		
		Arrays.sort(diceArray);
		
		return diceArray;
    }
}
