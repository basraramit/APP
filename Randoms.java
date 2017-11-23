package Strategy;

import java.util.ArrayList;
import java.util.Random;

import Model.Country;
import Model.Player;
import Model.Risk_Model;

public class Randoms extends Risk_Model implements IStrategy{
	
	private ArrayList<Country> priorityCountries;
	private static Random ran = new Random();
	private Player player = currentPlayer;
	int i = 0;
	
	private int getRandomSelection(int min, int max) {
	      if (min > max) {
	         throw new RuntimeException();
	      }
	    
		return ran.nextInt(max - min + 1) + min;
	   }

	@Override
	public int getToDeploy() {
		int toDeploy = Math.max(3, player.getOwnedCountries().size() / 3);
		for (i = 0; i < board.getContinents().size(); i++) {
			// Check continent ownership for bonus armies
				if (currentPlayer.getOwnedCountries().containsAll(board.getContinents().get(i).getMemberCountries())) {
				// If the current player's list of owned territories contains all the territories within a continent
					toDeploy += board.getContinents().get(i).getBonusArmies();
				}
			}
			System.out.println(currentPlayer.getName() + " has received " + board.getContinents().get(i).getBonusArmies() 
					+ " bonus reinforcements from controlling " + board.getContinents().get(i).getName() + "!");
			return toDeploy;
	}

	@Override
	public Country deployTo(int deployAmount) { 
		ArrayList<Country> owned = player.getOwnedCountries();
		int selectedCountry = 0;
		while(player.getArmies()>0){
			  selectedCountry = getRandomSelection(1, owned.size()) - 1;
		}
		  
	      return owned.get(selectedCountry);
	}

	@Override
	public int deployAmount() {
		int deployAmount = 0;
		deployAmount = getRandomSelection(0, player.getArmies());
		return deployAmount;
	}

	@Override
	public Country attackFrom() {
		  ArrayList<Country> attackable = player.getOwnedCountries();
	      int selection = getRandomSelection(0, attackable.size()) - 1;

	      return attackable.get(selection);
	}

	@Override
	public Country attack(Country origin) {
		ArrayList<Country> attackable = new ArrayList<>();
	      for (Country country : origin.getAdjacencies()) {
	         if (!country.getOccupant().equals(player)) {
	            attackable.add(country);
	         }
	      }

	      int selection = getRandomSelection(0, attackable.size()) - 1;

	      if (selection == -1) {
	         return null;
	      }
	      return attackable.get(selection);
	   
	}

	@Override
	public int attackAmount(Country origin) {
		return getRandomSelection(0, Math.min(3, origin.getArmies() - 1));
	}

	@Override
	public int moveAmount(Country origin, Country attacked, int minAmount) {
		return getRandomSelection(minAmount, origin.getArmies() - 1);
	}

	@Override
	public Country fortifyFrom() {
		ArrayList<Country> moveable = player.getOwnedCountries();
	      int selection = getRandomSelection(0, moveable.size()) - 1;

	      return moveable.get(selection);
	}

	@Override
	public Country fortify(Country origin) {
		ArrayList<Country> movable = new ArrayList<>();
		for(i = 0; i < origin.getAdjacencies().size(); i++){
			if(origin.getAdjacencies().get(i).getOccupant() == origin.getOccupant()){
				movable.add(origin.getAdjacencies().get(i));
			}
		}
	      int selection = getRandomSelection(0, movable.size()) - 1;

	      // Cancel
	      if (selection == -1) {
	         return null;
	      }
	      return movable.get(selection);
	}

	@Override
	public int fortifyAmount(Country origin, Country toFortify) {
		return getRandomSelection(1, origin.getArmies() - 1);
	}

	@Override
	public void endTurn() {
		nextPlayer();
	}

}
