package Model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * Allows the creation of JLists with updating strings from the RiskModel.
 * This class allows the creation of lists that stay updated to the lists of current 
 * player's hand, occupied countries, and countries adjacent to the selected, occupied 
 * country.
 * @author yaomeng
 *
 */
public class CountryLabel extends JLabel implements Observer {
	public String name;
	public String display;
	public Country country;
	
    public CountryLabel (Risk_Model model, Country country) {
	
        super();
        this.country = country;
		name = country.getName();
		setText(name);
    }
	
	// Updates the state of the RiskList
	public void update(Observable obs, Object obj) {
		
		display = (String) obj;
		
		if (display.equals("countryA")) {
			if (country.getOccupant() == null) {
				setText(name);
			} else {
				setText(name + ": " + country.getArmies() + ", " + country.getOccupant().getName());
			}
		}
	}
}