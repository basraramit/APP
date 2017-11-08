package Test;

import java.util.ArrayList;
import Model.Continent;
import Model.Country;
import junit.framework.TestCase;

public class ContinentTest extends TestCase{
	//The Continent Objects to test
	private Continent Africa;
	private ArrayList<Country> AfricanTerritories;
	
	/**
	 * Setup
	 */
	protected void setUp ()
	{
		// create a sample map of Territories
		Country SouthAfrica = new Country("South Africa");
		Country Nigeria = new Country("Nigeria");
		AfricanTerritories = new ArrayList<Country>();
		AfricanTerritories.add(SouthAfrica);
		AfricanTerritories.add(Nigeria);

		// initialize a sample Continent: name   , numBonusArmies, territoriesMap
		Africa = new Continent("Africa", 4 , AfricanTerritories);
	} 

	/**
	 * Test method getName
	 */
	public void testGetName()
	{
		assertEquals("Africa", Africa.getName());
	}								

	/**
	 * Test method getNumBonusArmies
	 */
	public void testGetNumBonusArmies()
	{
		assertTrue(Africa.getBonusArmies() == 4);
	}	// returns the continent's value of bonus armies


	 /**
	 * Test method getTerritoriesMap
	 * @require the Continent have at least one territory 
	 */
	public void testGetMemberCountries()
	{
		assertSame ( AfricanTerritories, Africa.getMemberCountries()); // should refer to the same object		
		// add one more territory to the list 
		Country Algeria= new Country("Algeria");
		Africa.getMemberCountries().add(Algeria);
		assertTrue (Africa.getMemberCountries().size() == 3); // should be consistent 
		
	}



}// end class ContinentTest
