package Test;

import java.util.ArrayList;

import Model.Card;
import Model.Country;
import Model.Hand;
import junit.framework.TestCase;

public class HandTest extends TestCase
{
	// Objects to test
	private	Hand hand;
	private Card card0;
	private Card card1;
	private Card card2;

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
		
		hand = new Hand();
		hand.add(card0);
		hand.add(card1);
		hand.add(card2);
		
	} 

	public void testAddCards()
	{
		
		assertTrue(hand.getCards().size()==3);
		
	}
	
	public void testGetCards(){
		assertSame(card0, hand.getCards().get(hand.getCards().size()-3));
		assertSame(card1, hand.getCards().get(hand.getCards().size()-2));
		assertSame(card2, hand.getCards().get(hand.getCards().size()-1));
	}
	
	public void testMustTurnInCards(){
		assertTrue(hand.mustTurnInCards() == false);
	}
	
	public void testRemoveCardsFromHand()
	{
		hand.removeCardsFromHand(0,1,2);
		assertTrue(hand.getCards().size()==0);
	}


}// end class HandTest
