package Test;

import Model.Card;
import Model.Country;
import junit.framework.TestCase;

public class CardTest extends TestCase{
	// Objects to test
	private Card regularCard;


	/**
	 * Setup
	 */
	protected void setUp ()
	{
		regularCard= new Card("infantry", new Country("Vietnam"));
	}

	/**
	 * Method to be tested: getType()
	 *@return the type(infantry, cavalry, artillery) of the card as a String
	 *@interface: String getType();
	 */
	
	public void testGetType()
	{
		assertEquals( "infantry", regularCard.getType() );
	}

	/**
	 * Method to be tested: getTerritoryName()
	 *@return the name of the territory marked on the card as a String
	 *@interface: String getTerritoryName();
	 */
	public void testgetTerritoryName()
	{
		assertEquals( "Vietnam", regularCard.getCountry().getName());
	}

}// end class CardTest
