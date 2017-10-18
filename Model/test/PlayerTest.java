package test;

import java.util.HashMap;

import Model.*;
import junit.framework.TestCase;

public class PlayerTest extends TestCase{
	
	private Player player1;
	private Player player2;
	private Country country0;
	private Country country1;
	private Continent continent0;
	private Continent continent1;
	/**
	 * set up
	 */
	protected void setUp (){
		
		//initialize some sample Territory and Continent objects to be tested
		country0 = new Country("country0");
		country1 = new Country("country1");
		continent0 = new Continent("cont0",5,null);
		continent1 = new Continent("cont1",10,null);

		// Initialize a GameBoard object to be used in tests
		HashMap<String,Country> temp= new HashMap<String,Country>();
		temp.put("country0",country0);
		temp.put("country1",country1);

		// initiziale sample Player objects to be tested
		player1= new Player("Hung Le", 10, 1);
		player2= new Player("Jeanne Vu", 0, 2);
		
	}
	/**
	 * test the method getArmies
	 */
	public void testGetNumArmies(){
		assertTrue( player1.getArmies()== 10 );
	}

}
