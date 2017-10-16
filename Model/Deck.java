package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Allows the creation of the Risk deck containing total Risk cards.
 * @author yaomeng
 *
 */
public class Deck {
	
	public int i;
	
	public String[] typesArray;
	
	public ArrayList<Card> deck;
	public Card drawCard;

	/**
	* Creates all cards, one for each territory. Each card has either 
	* a type of Infantry, Cavalry, or Artillery. Ensure that the number of
	* Infantry, Cavalry, and Artillery are the same
	* @param countries
	*/
	public Deck (ArrayList<Country> countries) {		
	
		Collections.shuffle(countries);
		
		//Types of cards
		typesArray = new String[]{ "Infantry", "Cavalry", "Artillery" };
		
		deck = new ArrayList<Card>();
		
		for (i = 0; i < countries.size(); i++) {
		// Add new cards to deck
			deck.add(new Card(typesArray[i / (countries.size()/3)], countries.get(i)));
			System.out.println("Added new card to deck: " + deck.get(i).getName());
		}
		Collections.shuffle(deck);
	}

	/**
	 * Removes a card from the deck and return it
	 * @return
	 */
	public Card draw() {
	
		drawCard = deck.get(0);
		deck.remove(0);
		
		return drawCard;
	}

	/**
	 * Add a card to the deck
	 * @param card
	 */
	public void add(Card card) {
	
		deck.add(card);
	}

	/**
	 * Shuffle the deck of cards
	 */
	public void shuffle() {
	
		Collections.shuffle(deck);
	}

}
