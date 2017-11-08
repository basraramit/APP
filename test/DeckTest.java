package Test;

import java.util.ArrayList;

import Model.Card;
import Model.Country;
import Model.Deck;
import junit.framework.TestCase;

public class DeckTest extends TestCase{
	// Objects to test
	private Deck deck;
	private Card card0;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;

	/**
	 * Setup
	 */
	protected void setUp ()
	{
		Country china = new Country("china");
		Country japan = new Country("japan");
		Country india = new Country("india");
		
		card0 = new Card("type0",china);
		card1 = new Card("type1",japan);
		card2 = new Card("type2",india);

		ArrayList<Country> initialCardList = new ArrayList<Country>();
		initialCardList.add(china);
		initialCardList.add(japan);
		initialCardList.add(india);
		
		//initialize a sample deck using a sample card list
		deck  = new Deck(initialCardList);
	} 


	public void testDraw(){
		assertNotSame(card0, deck.draw());
		
	}
}// end class DeckTest
