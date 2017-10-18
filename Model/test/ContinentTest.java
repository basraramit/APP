package test;

import java.util.ArrayList;
import java.util.HashMap;
import Model.*;
import junit.framework.TestCase;

public class ContinentTest extends TestCase{
	
	private Continent Kala;
	private ArrayList<Country> KalaCountories;
	
	/**
	 * set up
	 */
	protected void setUp (){
		
		Country Forgoth= new Country("Forgoth");
		Country Rove= new Country("Rove");
		KalaCountories= new ArrayList<Country> ();
		KalaCountories.add(Forgoth);
		KalaCountories.add(Rove);

		// initialize a sample Continent: name   , numBonusArmies, territoriesMap
		Kala = new Continent("Kala", 6 , KalaCountories);
		
	}
	
	/**
	 * Test method getName
	 */
	public void testGetName(){
		assertEquals ( "Kala", Kala.getName());
	}
	
	

}
