package Model;

import java.util.ArrayList;

/**
 * Allows the creation of Risk Continent objects.
 * @author yaomeng
 *
 */
public class Continent {
	
	public String name;
    public int bonusArmies;
    public ArrayList<Country> countries;

    public Continent(String name, int bonusArmies, ArrayList<Country> memberCountries) {
		this.name = name;
		this.bonusArmies = bonusArmies;
		countries = memberCountries;
		
		System.out.println("Created continent: " + name + "\nBonus armies: " + bonusArmies);
    }

    public String getName() {
		return name;
    }

    /**
     * Returns the number of bonus armies a player gets per round when the player controls this
     * continent
     * @return
     */
    public int getBonusArmies() {
		return bonusArmies;
    }

    /**
     * Returns a list of the country objects that are on this continent
     * @return
     */
    public ArrayList<Country> getMemberCountries() {
		return countries;
    }

}
