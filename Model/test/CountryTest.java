package test;

import java.util.ArrayList;

import Model.*;
import junit.framework.TestCase;

public class CountryTest extends TestCase{
	
	private Country Forgoth; 
	private Country Rove;
	private ArrayList<Country> ForgothNeighbors;
	
	/**
	 * set up
	 */
	protected void setUp ()
	{
		ForgothNeighbors = new ArrayList<Country>();
		//initialize 2 sample Countories:name      , continent    , Neighbors
		Forgoth = new Country("Forgoth");
		Rove = new Country("Rove" );
	} 
	/**
	 * test method GetOccupant()
	 */
	public void testGetOccupant(){
		assertNull(Forgoth.getOccupant());
		
		Player player1= new Player("player1", 0, 0);
		Forgoth.setOccupant(player1);
		assertSame( player1, Forgoth.getOccupant());
	}
	/**
	 * test method SetOccupant()
	 */
	public void testSetOccupant(){
		Player player2= new Player("player2", 0, 1);			// create a new object of Player to test
		Forgoth.setOccupant(player2);
		assertSame ( player2, Forgoth.getOccupant()); 	// these two references should refer to the same object
		
		Player player3= new Player("player3", 0, 2);			// create another object of Player to test
		Rove.setOccupant(player3);
		assertSame ( player3, Rove.getOccupant());	// these two references should refer to the same object	
	}
	/**
	 * test method GetArmies()
	 */
	public void testGetArmies(){
		assertTrue(Forgoth.getArmies()== 0);
		assertTrue(Rove.getArmies()== 0);
	}
	/**
	 * test increase and decrease Armies
	 */
	public void testSetNumArmies(){
		Forgoth.setNumArmies(100);
		assertTrue (Forgoth.getArmies() == 100);
	}
	/**
	 * test method hasPlayer()
	 */
	public void testHasPlayer(){
		assertTrue(Forgoth.hasPlayer());
	}

}
