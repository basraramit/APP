package Strategy;

import java.util.ArrayList;
import java.util.Random;

import Model.Country;
import Model.Player;
import Model.Risk_Model;

public class Cheater extends Risk_Model implements IStrategy{
	
	private ArrayList<Country> priorityCountries;
	private static Random ran = new Random();
	private Player player = currentPlayer;
	int i = 0;

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
			return toDeploy * 2;
	}

	@Override
	public Country deployTo(int deployAmount) {
		Country temp = null;
		for(i = 0; i < player.getOwnedCountries().size(); i++){
			temp = player.getOwnedCountries().get(i);
		}
		
		return temp;
	}

	@Override
	public int deployAmount() {
		int army = 0;
		for(i = 0; i < player.getOwnedCountries().size(); i++){
			army = player.getOwnedCountries().get(i).getArmies();
		}
		return army;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country fortify(Country origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fortifyAmount(Country origin, Country toFortify) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		
	}

}
