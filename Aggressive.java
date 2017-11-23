package Strategy;

import java.util.ArrayList;
import java.util.Random;

import Model.Country;
import Model.Player;
import Model.Risk_Model;

public class Aggressive extends Risk_Model implements IStrategy {

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
		Country temp = null;
		priorityCountries = new ArrayList<Country>();
		if(deployTurn < countriesArray.length){
			for(i = 0; i < player.getOwnedCountries().size(); i++){
				if(player.getOwnedCountries().get(i).getArmies()==0){
					priorityCountries.add(player.getOwnedCountries().get(i));
				}
			}
			if (priorityCountries.size() > 0) {
				int r = ran.nextInt(priorityCountries.size());
				temp = priorityCountries.get(r);
			}
		}else{
			int max = 0;
	    	for(i = 0; i < player.getOwnedCountries().size(); i++) {
	    		if(player.getOwnedCountries().get(i).getArmies() > max) {
	    			max = player.getOwnedCountries().get(i).getArmies();
	    			temp = player.getOwnedCountries().get(i);
	    		}
	    	}
		}
		return temp;
	}

	@Override
	public int deployAmount() {
		int deployAmount = 0;
		deployAmount = player.getArmies();
		return deployAmount;
	}

	@Override
	public Country attackFrom() {
		int max = 0;
    	Country temp = null;
		for(i = 0; i < player.getOwnedCountries().size(); i++) {
    		if(player.getOwnedCountries().get(i).getArmies() > max) {
    			max = player.getOwnedCountries().get(i).getArmies();
    			temp = player.getOwnedCountries().get(i);
    		}
    	}
		return temp;
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
		int max = 0;
    	Country temp1 = null;
    	Country temp2 = null;
		for(i = 0; i < player.getOwnedCountries().size(); i++) {
    		if(player.getOwnedCountries().get(i).getArmies() > max) {
    			max = player.getOwnedCountries().get(i).getArmies();
    			temp1 = player.getOwnedCountries().get(i);
    		}
    	}
		ArrayList<Country> fortifiable = new ArrayList<>();
		fortifiable = temp1.getAdjacencies();
		for(i = 0; i < fortifiable.size(); i++){
			if(player.getOwnedCountries().get(i).getArmies() > max){
				max = fortifiable.get(i).getArmies();
				temp2 = fortifiable.get(i);
			}
			
		}
		return temp2;
	}

	@Override
	public Country fortify(Country origin) {
		int max = 0;
    	Country temp = null;
		for(i = 0; i < player.getOwnedCountries().size(); i++) {
    		if(player.getOwnedCountries().get(i).getArmies() > max) {
    			max = player.getOwnedCountries().get(i).getArmies();
    			temp = player.getOwnedCountries().get(i);
    		}
    	}
		return temp;
	}

	@Override
	public int fortifyAmount(Country origin, Country toFortify) {
		// TODO Auto-generated method stub
		return origin.getArmies()-1;
	}

	@Override
	public void endTurn() {
		nextPlayer();
	}

	

}
