package Strategy;

import javax.swing.JOptionPane;

import Model.Country;
import Model.Risk_Model;

public class Cheater_Bot implements IStrategy{

	private Country countryA;
	private Country countryB;

	@Override
	public int reinforce(String country, Risk_Model model) {
		countryA = model.board.getCountryByName(country);
		if (countryA !=null){
            int armies = countryA.getArmies();
            countryA.incrementArmies(armies);
            System.out.println("Cheater has doubled it's armies on " + country);
        }
		return 0;
	}

	@Override
	public int attack(String country1, String country2, Risk_Model model) {
		countryA = model.board.getCountryByName(country1);
		countryB = model.board.getCountryByName(country2);
		
		System.out.println(countryA.getOccupant().getName() + " has defeated all of " + countryB.getOccupant().getName() + "'s armies in " + country2 + " and has occupied the country!");
		// Set country occupant to attacker
		countryB.getOccupant().removeCountry(country2);
		if (countryB.getOccupant().getOwnedCountries().size() == 0)	{
			
			System.out.println("WORLD NEWS: " + countryB.getOccupant().getName() + " has surrendered to " + model.currentPlayer.getName()
					+ " after his last military defeat at " + country2 + ". " + model.currentPlayer.getName() + " has issued an execution, with " 
					+ countryB.getOccupant().getName() + " charged as a war criminal.");
			
			model.players.remove(countryB.getOccupant().getIndex());
			if(model.checkWin(model.players) == true){
				model.setState("endGame");
				JOptionPane.showMessageDialog(null, "Congratulations! "+model.currentPlayer.getName()+" win this game.");
			}
			
		}
		countryA.getOccupant().addCountry(countryB);
		countryB.setOccupant(countryA.getOccupant());
		countryB.incrementArmies(1);
		return 0;
	}

	@Override
	public int fortify(String country1, String country2, Risk_Model model) {
		countryA = model.board.getCountryByName(country1);
		countryB = model.board.getCountryByName(country2);
		 if (countryA != null ){
	            int armies = countryA.getArmies();
	            countryA.incrementArmies(armies);
	            System.out.println("Cheater has doubled it's armies on " + country1);
	        }
		model.nextPlayer();
		return 0;
	}

	

}
