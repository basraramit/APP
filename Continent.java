
package Map;



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
    //public ArrayList<Country> countries;
    List<String> countries= new ArrayList<String>();

    public Continent(String name, int bonusArmies, List<String> memberCountries) {
		this.name = name;
		this.bonusArmies = bonusArmies;
		countries = memberCountries;
		
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
    public void setBonusArmies(int bonusArmies) {
    	this.bonusArmies = bonusArmies;
    }
    public int getBonusArmies() {
		return bonusArmies;
    }
    

    /**
     * Returns a list of the country objects that are on this continent
     * @return
     */
   
    public void setMemberCountries( List<String> countries) {
    	this.countries = countries;
    }
    
    public List<String>  getMemberCountries() {
		return countries;
    }

}
