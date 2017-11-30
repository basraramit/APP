package Test;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Continent;
import Model.Country;
import Model.Player;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest extends TestCase{
	
	/** The player 1. */
	private Player player1;
	
	/** The player 2. */
	private Player player2;
	
	/** The china. */
	private Country china;
	
	/** The england. */
	private Country england;
	
	/** The asia. */
	private Continent asia;
	
	/** The europe. */
	private Continent europe;
	
	/** The asia country. */
	private ArrayList<Country> asiaCountry;
	
	/** The europe country. */
	private ArrayList<Country> europeCountry;
	
	/**
	 * Setup.
	 */
	protected void setUp (){
		player1 = new Player("XI", 0, 0, "human", false);
		player2 = new Player("LI", 5, 1, "bot", true);
		
		asiaCountry = new ArrayList<Country>();
		europeCountry = new ArrayList<Country>();
		
		china = new Country("china");
		england = new Country("england");
		asia = new Continent("asia", 3, asiaCountry);
		europe = new Continent("europe", 1, europeCountry);
		
		asiaCountry.add(china);
		europeCountry.add(england);
		
	}
	
	/**
	 * Method to be tested: String getName()
	 * return the Player's name.
	 */
	public void testGetName()
	{
		assertEquals("XI",player1.getName() );
		assertEquals("LI",player2.getName() );
	} 
	
	/**
	 * Method to be tested: int getNumArmies()
	 * return: the number of armies to be placed.
	 */
	public void testGetArmies()
	{
		player1.incrementArmies(7);
		assertTrue( player1.getArmies()== 7 );
		player2.decrementArmies(2);
		assertTrue( player2.getArmies()== 3 );

	}
	
	/**
	 * Test add country.
	 */
	public void testAddCountry(){
		player1.addCountry(china);
		player2.addCountry(england);
		assertSame(china, player1.getOwnedCountries().get(0));
		assertSame(england, player2.getOwnedCountries().get(0));
	}
	
	/**
	 * Test remove country.
	 */
	public void testRemoveCountry(){
		player1.addCountry(china);
		assertTrue( player1.getOwnedCountries().size() == 1 );
		player1.removeCountry("china");
		assertTrue( player1.getOwnedCountries().size() == 0 );
	}
	
	/**
	 * Test get owned countries.
	 */
	public void testGetOwnedCountries(){
		player1.addCountry(china);
		player2.addCountry(england);
		assertTrue( player1.getOwnedCountries().size() == 1);
		assertTrue( player2.getOwnedCountries().size() == 1);
		assertTrue( player1.getOwnedCountries().containsAll(asiaCountry));
		assertTrue( player2.getOwnedCountries().containsAll(europeCountry));
	}
	
	/**
	 * Test get AI.
	 */
	public void testGetAI(){
		assertTrue(player1.getAI() == false);
		assertTrue(player2.getAI());
	}
	
	/**
	 * Test get player type.
	 */
	public void testGetPlayerType(){
		assertSame(player1.getPlayerType(), "human");
		assertSame(player2.getPlayerType(), "bot");
	}

}
