package Strategy;

import Model.Country;
import Model.Risk_Model;

public class Benevolent_Bot implements IStrategy{

	private Country countryA;
	private Country countryB;

	@Override
	public int reinforce(String country, Risk_Model model) {
		countryA = model.board.getCountryByName(country);
		//System.out.println(model.calculateReinfoece(model.currentPlayer));
        try {
            if (model.currentPlayer.getArmies() > 0) {
                int armies = model.currentPlayer.getArmies();
                model.currentPlayer.decrementArmies(armies);
                countryA.incrementArmies(armies);
                System.out.println(model.currentPlayer.getName() + " has chosen to reinforce " + countryA.getName() + " with " + armies + " armies.");
                if (model.currentPlayer.getArmies() == 0) {
                	System.out.println("You do not have any armies left to reinforce");
                    //model.setState("Attack");
                    model.canAttack = true;
                }
            }

        } catch (Exception e) {
        	System.out.println("System Error or Exception is thrown for reinforce method");
        }
		return model.calculateReinfoece(model.currentPlayer);
	}

	@Override
	public int attack(String country1, String country2, Risk_Model model) {
		System.out.println(model.currentPlayer.getName() + " is Benevolent Bot, who will always skip Attack Phase!");
		return 0;
	}

	@Override
	public int fortify(String country1, String country2, Risk_Model model) {
		countryA = model.board.getCountryByName(country1);
		countryB = model.board.getCountryByName(country2);
		
		int armies = countryA.getArmies() - 1;
		
		System.out.println(model.currentPlayer.getName() + " has chosen to fortify " + country2 + " with " + armies + " armies from " + country1 + ".");
		
		countryA.decrementArmies(armies);
		countryB.incrementArmies(armies);
		
		model.nextPlayer();
		return armies;
	}

	
}