package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows the creation of Risk Continent objects.
 * @author yaomeng
 *
 */
public class Continent {
	
	public String name;
    public int bonusArmies;
    public ArrayList<Country> countries;
    public List<String> country;

    public Continent(String name, int bonusArmies, ArrayList<Country> memberCountries) {
		this.name = name;
		this.bonusArmies = bonusArmies;
		countries = memberCountries;
		
		System.out.println("Created continent: " + name + "\nBonus armies: " + bonusArmies);
    }
    
    public Continent() {
		this.name = "";
		this.bonusArmies = 0;
		this.country = new ArrayList<>();;
		
		System.out.println("Created continent: " + name + "\nBonus armies: " + bonusArmies);
    }

    public void setName(String name) {
    	this.name = name;
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
    public void setBonusArmies(int bonusArmies) {
    	this.bonusArmies = bonusArmies;
    }

    /**
     * Returns a list of the country objects that are on this continent
     * @return
     */
    public ArrayList<Country> getMemberCountries() {
		return countries;
    }
    
    /**
     * Returns a list of the country objects that are on this continent
     * @return
     */
   
    public void setMemberCountry( List<String> country) {
    	this.country = country;
    }
    
    public List<String>  getMemberCountry() {
		return country;
    }

}
