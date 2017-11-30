package Test;

import java.util.ArrayList;
import java.util.List;

import Model.Country;
import Model.Player;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryTest.
 */
public class CountryTest extends TestCase
{
	
	/** The Russia. */
	//The Country Objects to test
	private Country Russia; 
	
	/** The Australia. */
	private Country Australia;
	
	/** The russia neighbors. */
	private ArrayList<Country> russiaNeighbors;
	
	/**
	 * Setup.
	 */
	protected void setUp ()
	{
		russiaNeighbors = new ArrayList<Country>();
		Russia = new Country("Russia");
		Australia = new Country("Australia");
		russiaNeighbors.add(Australia);
	} 

	/**
	 * Test method getName.
	 */
	public void testGetName()
	{
		assertEquals("Russia",Russia.getName());
		assertEquals("Australia",Australia.getName());
	}

	/**
	 * Test method getOccupant.
	 */
	public void testGetOccupant()
	{
		assertNull(Russia.getOccupant()); // should return null
		
		Player player1= new Player("player1", 0, 0, "human", false);
		Russia.setOccupant(player1);
		assertSame(player1, Russia.getOccupant()); //should refer to the same object
	}				

	/**
	 * Test method setOccupant.
	 */
	public void testSetOccupant()
	{
		Player player2= new Player("player2", 0, 1, "human", false);			// create a new object of Player to test
		Russia.setOccupant(player2);
		assertSame (player2, Russia.getOccupant()); 	// these two references should refer to the same object
		
		Player player3= new Player("player3", 0, 2, "human", false);			// create another object of Player to test
		Russia.setOccupant(player3);
		assertSame (player3, Russia.getOccupant());	// these two references should refer to the same object

	}				
 
	/**
	 * Test method getNumArmies.
	 */
	public void testGetNumArmies()
	{
		assertTrue(Russia.getArmies()== 0);
		assertTrue(Australia.getArmies()== 0);
	}				

	/**
	 * Test method updateNumArmies
	 * Used to update the number of armies in a territory.
	 *
	 * @modify: positive value : add / negative value : subtract
	 */
	public void testUpdateNumArmies()
	{
		Player player1= new Player("player1", 0, 0, "human", false);
		Russia.setOccupant(player1);
		Russia.incrementArmies(10);			// test case: positive
		assertTrue ( Russia.getArmies()== 10 );
		
		Russia.decrementArmies(10);		// test case: 0
		assertTrue ( Russia.getArmies()== 0 );

	}				
	
	/**
	 * Test method getNeighbors.
	 */	 
	public void testGetNeighbors()
	{
		Russia.addAdjacencies(russiaNeighbors);
		assertSame( russiaNeighbors, Russia.getAdjacencies()); 	// test case: simple
		assertNull( Australia.getAdjacencies()); 		// test case: null
	
	}
	
	/**
	 * Test has player.
	 */
	public void testHasPlayer(){
		assertFalse(Russia.hasPlayer);
		Player player1= new Player("player1", 0, 0, "human", false);
		Russia.setOccupant(player1);
		assertTrue(Russia.hasPlayer);
		
	}

}// end class CountryTest
