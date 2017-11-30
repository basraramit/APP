package Test;

import java.util.ArrayList;

import Model.Card;
import Model.Country;
import Model.Hand;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class HandTest.
 */
public class HandTest extends TestCase
{
	
	/** The hand. */
	// Objects to test
	private	Hand hand;
	
	/** The card 0. */
	private Card card0;
	
	/** The card 1. */
	private Card card1;
	
	/** The card 2. */
	private Card card2;

	/**
	 * Setup.
	 */
	protected void setUp ()
	{
		Country china = new Country("china");
		Country japan = new Country("japan");
		Country india = new Country("india");
		
		card0 = new Card("type0",china);
		card1 = new Card("type1",japan);
		card2 = new Card("type2",india);
		
		hand = new Hand();
		hand.add(card0);
		hand.add(card1);
		hand.add(card2);
		
	} 

	/**
	 * Test add cards.
	 */
	public void testAddCards()
	{
		
		assertTrue(hand.getCards().size()==3);
		
	}
	
	/**
	 * Test get cards.
	 */
	public void testGetCards(){
		assertSame(card0, hand.getCards().get(hand.getCards().size()-3));
		assertSame(card1, hand.getCards().get(hand.getCards().size()-2));
		assertSame(card2, hand.getCards().get(hand.getCards().size()-1));
	}
	
	/**
	 * Test must turn in cards.
	 */
	public void testMustTurnInCards(){
		assertTrue(hand.mustTurnInCards() == false);
	}
	
	/**
	 * Test remove cards from hand.
	 */
	public void testRemoveCardsFromHand()
	{
		hand.removeCardsFromHand(0,1,2);
		assertTrue(hand.getCards().size()==0);
	}


}// end class HandTest
