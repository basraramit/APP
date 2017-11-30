package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Allows the creation of Risk Continent objects.
 * @author yaomeng
 *
 */
public class Continent implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;
	
	/** The name. */
	public String name;
    
    /** The bonus armies. */
    public int bonusArmies;
    
    /** The countries. */
    public ArrayList<Country> countries;
    
    /** The country. */
    public List<String> country;

    /**
     * Instantiates a new continent.
     *
     * @param name the name
     * @param bonusArmies the bonus armies
     * @param memberCountries the member countries
     */
    public Continent(String name, int bonusArmies, ArrayList<Country> memberCountries) {
		this.name = name;
		this.bonusArmies = bonusArmies;
		countries = memberCountries;
		
		System.out.println("Created continent: " + name + "\nBonus armies: " + bonusArmies);
    }
    
    /**
     * Instantiates a new continent.
     */
    public Continent() {
		this.name = "";
		this.bonusArmies = 0;
		this.country = new ArrayList<>();;
		
		System.out.println("Created continent: " + name + "\nBonus armies: " + bonusArmies);
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
		return name;
    }

    /**
     * Returns the number of bonus armies a player gets per round when the player controls this
     * continent.
     *
     * @return the bonus armies
     */
    public int getBonusArmies() {
		return bonusArmies;
    }
    
    /**
     * Sets the bonus armies.
     *
     * @param bonusArmies the new bonus armies
     */
    public void setBonusArmies(int bonusArmies) {
    	this.bonusArmies = bonusArmies;
    }

    /**
     * Returns a list of the country objects that are on this continent.
     *
     * @return the member countries
     */
    public ArrayList<Country> getMemberCountries() {
		return countries;
    }
    
    /**
     * Returns a list of the country objects that are on this continent.
     *
     * @param country the new member country
     */
   
    public void setMemberCountry( List<String> country) {
    	this.country = country;
    }
    
    /**
     * Gets the member country.
     *
     * @return the member country
     */
    public List<String>  getMemberCountry() {
		return country;
    }

}
