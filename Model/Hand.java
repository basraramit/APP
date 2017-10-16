package Model;

import java.util.ArrayList;

/**
 * Allows the creation of Risk Hand objects used to handle the cards held by a player.
 * @author yaomeng
 *
 */
public class Hand {
	
	public boolean condition;
	
	public ArrayList<Card> hand;

	/**
	 * Constructor. Instantiate Deck.
	 **/
	public Hand() {
	
		hand = new ArrayList<Card>();
	}

	/**
	 * Adds the card to the hand 
	 * @param card
	 */
	public void add(Card card) {
	
		hand.add(card);
	}
	/**
	 * Removes the cards at the given indices from the hand
	 * @param index1
	 * @param index2
	 * @param index3
	 */
	public void removeCardsFromHand(int index1, int index2, int index3) {
	
		if (canTurnInCards(index1, index2, index3) == true) {
			hand.remove(index3);
			hand.remove(index2);
			hand.remove(index1);
		
		} else {
			System.out.println("You must trade in three cards of the same type or one of each type.");
		}
	}

	/**
	 * returns true if the player can turn in cards
	 * @param index1
	 * @param index2
	 * @param index3
	 * @return
	 */
	public boolean canTurnInCards(int index1, int index2, int index3) {
	
		condition = false;
		
		if (hand.size() >= 3) {
			if (hand.get(index1).getType().equals(hand.get(index2).getType()) && hand.get(index1).getType().equals(hand.get(index3).getType())) {
			//If all three cards have the same type
				condition = true;
				
			} else if (
				!hand.get(index1).getType().equals(hand.get(index2).getType()) && !hand.get(index1).getType().equals(hand.get(index3).getType()) && !hand.get(index2).getType().equals(hand.get(index3).getType())) {
			//If all three cards have different types
				condition = true;
			}
		}
		return condition;
	}

	/**
	 * Returns true if the player must turn in cards
	 * @return
	 */
	public boolean mustTurnInCards() {
	
		condition = false;
		
		if (hand.size() >= 5) {
			condition = true;
		}
		return condition;
	}

	/**
	 * Returns the hand
	 * @return
	 */
	public ArrayList<Card> getCards() {
		return hand;
	}

}
