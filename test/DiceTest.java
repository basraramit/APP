package Test;

import java.util.Random;

import Model.Dice;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class DiceTest.
 */
public class DiceTest extends TestCase{
	
		/** The dice. */
		//The objects to test
		private Dice dice;
		
		/** The generator. */
		//Random generator to test the class in general manner
		private Random generator;
		
		/**
		 * Setup.
		 */
		protected void setUp ()
		{
			dice= new Dice();
			generator = new Random();
		} 
		
		/**
		 * Test roll.
		 */
		public void testRoll()
		{
			/**
			 * test case: 100 random sessions of rolling dices 
			 * @expected: the returned array contains the correct number of elements with each element falling in the range 1-6
			 */
			 
			//Variables to hold the number of dices to roll
			int attacking = 0;
			int defending = 0;
			
			

			for ( int i=0; i<100; i++)
			{
				// randomly generate the number of attacking dices to roll: 1-3
				attacking = generator.nextInt(3) + 1;
				// randomly generate the number of defending dices to roll: 1-2
				defending = generator.nextInt(2) + 1;

				// call the roll method passing in attacking and defending variables
				int[] results = dice.roll(attacking+defending);
				
				for(int j=0;j<attacking+defending;j++)
				{
					assertTrue ( results[j] <= 6 && results[j] >= 1 ); // The elements should be an integer in the range 1-6
				}

			}

		}

}
