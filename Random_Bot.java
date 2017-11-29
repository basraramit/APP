package Strategy;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Model.Country;
import Model.Dice;
import Model.Player;
import Model.Risk_Model;

public class Random_Bot implements IStrategy{

	private Country countryA;
	private Country countryB;
	private Dice dice;
	private int attackerLosses;
	private int defenderLosses;
	private int attackerDice;
	private int defenderDice;
	private int[] attackerRolls;
	private int[] defenderRolls;
	private Random rng = new Random();

	public int reinforce(String country, Risk_Model model) {
		countryA = model.board.getCountryByName(country);
		//System.out.println(model.calculateReinfoece(model.currentPlayer));
        try {
            if (model.currentPlayer.getArmies() > 0) {
                int armies = rng.nextInt(model.currentPlayer.getArmies());
                model.currentPlayer.decrementArmies(armies+1);
                countryA.incrementArmies(armies+1);
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
		countryA = model.board.getCountryByName(country1);
		countryB = model.board.getCountryByName(country2);
		while (countryA.getArmies() > 1 && countryA.getOccupant()!=countryB.getOccupant()){
			dice = new Dice();

            // Set default values
            attackerLosses = 0;
            defenderLosses = 0;
            attackerDice = 1;
            defenderDice = 1;
            
            if(countryA.getArmies() >= 3){
            	attackerDice = 3;
            }else if(countryA.getArmies() == 2){
            	attackerDice = 2;
            }else{
            	attackerDice = 1;
            }
            attackerRolls = dice.roll(attackerDice);
			for(int i = 0; i < attackerRolls.length; i++){
				System.out.println("the Attacker's dice: " + attackerRolls[i]);
			}
            
            try{
            	if(countryB.getOccupant().getAI() == true){
            		if (countryB.getArmies() == 1) {
                        defenderDice = 1;
                    } else {
                        defenderDice = rng.nextInt(1) + 1;
                    }
            	}else{
            		defenderDice = Integer.parseInt(JOptionPane.showInputDialog(countryB.getOccupant().getName() + ", you are defending " + country2 + " ! How many dice will you roll?"));
            	}
            	
            }catch (Exception e) {
                // Error: defender inputs invalid number of dice
                defenderDice = 1;
                System.out.println("Roll either 1 or 2 dice. To roll 2 dice, you must have at least 2 armies on your country.");
            }
            defenderRolls = dice.roll(defenderDice);
			for(int i = 0; i < defenderRolls.length; i++){
				System.out.println("the Defender's dice: " + defenderRolls[i]);
			}
			
			if (attackerRolls[attackerRolls.length-1] > defenderRolls[defenderRolls.length-1]) {
				defenderLosses++;
			}
			else {
				attackerLosses++;
			}
			// Index 1 = second highest pair
			if (attackerDice > 1 && defenderDice > 1) {
			
				if (attackerRolls[attackerRolls.length-2] > defenderRolls[attackerRolls.length-2]) {
					defenderLosses++;
					
				} else {
					attackerLosses++;
				}
			}
			
			// Calculate losses
			System.out.println("<COMBAT REPORT>");
			countryA.decrementArmies(attackerLosses);
			countryB.decrementArmies(defenderLosses);
			if(countryB.getArmies() < 0){
				countryB.setNumArmies(0);
			}
			
			if (countryB.getArmies() == 0) {
				System.out.println("WORLD NEWS: " + countryA.getOccupant().getName() + " has defeated all of " + countryB.getOccupant().getName() + "'s armies in " + country2 + " and has occupied the country!");
				
				// Remove country from defender's list of occupied territories and adds to attacker's list

				// Check if defender is eliminated from game
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
				// Set country occupant to attacker
				countryB.getOccupant().removeCountry(country2);
				countryA.getOccupant().addCountry(countryB);
				countryB.setOccupant(countryA.getOccupant());
				countryA.decrementArmies(1);
				countryB.incrementArmies(1);
				model.count++;
			
			}
		}
		return 0;
	}

	@Override
	public int fortify(String country1, String country2, Risk_Model model) {
		countryA = model.board.getCountryByName(country1);
		countryB = model.board.getCountryByName(country2);
		
		int armies = rng.nextInt(countryA.getArmies() - 1);
		
		System.out.println(model.currentPlayer.getName() + " has chosen to fortify " + country2 + " with " + armies + " armies from " + country1 + ".");
		
		countryA.decrementArmies(armies);
		countryB.incrementArmies(armies);
		
		model.nextPlayer();
		return armies;
	}

}
