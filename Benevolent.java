package Strategy;

import java.util.ArrayList;
import java.util.Random;

import Model.Country;
import Model.Player;
import Model.Risk_Model;

public class Benevolent extends Risk_Model implements IStrategy{
	
	private Player player = currentPlayer;
	private ArrayList<Country> priorityCountries;
	int i = 0;
	private static Random ran = new Random();
	
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
			int min = player.getArmies();
	    	for(i = 0; i < player.getOwnedCountries().size(); i++) {
	    		if(player.getOwnedCountries().get(i).getArmies() < min) {
	    			min = player.getOwnedCountries().get(i).getArmies();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country attack(Country origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int attackAmount(Country origin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moveAmount(Country origin, Country attacked, int minAmount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Country fortifyFrom() {
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
	public Country fortify(Country origin) {
		int min = origin.getArmies();
    	Country temp = null;
		ArrayList<Country> fortifiable = new ArrayList<>();
		fortifiable = origin.getAdjacencies();
		for(i = 0; i < fortifiable.size(); i++){
			if(player.getOwnedCountries().get(i).getArmies() < min){
				min = fortifiable.get(i).getArmies();
				temp = fortifiable.get(i);
			}
			
		}
		return temp;
	}

	@Override
	public int fortifyAmount(Country origin, Country toFortify) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		
	}

}
