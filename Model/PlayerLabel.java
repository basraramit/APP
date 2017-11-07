package Model;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class PlayerLabel extends JLabel implements Observer{
	
	/** The name. */
	public String name;
	
	/** The display. */
	public String display;
	
	/** The Player. */
	public Player player;
	
	public Risk_Model model;

	
	/**
     * Instantiates a new Player label.
     *
     * @param model the model
     * @param country the country
     */
    public PlayerLabel (Risk_Model model, Player player) {
	
        super();
        this.player = player;
        this.model = model;
		name = player.getName();
		setText(name);
    }

	@Override
	public void update(Observable obs, Object obj) {
		display = (String) obj;
		DecimalFormat df = new DecimalFormat("0.0");
		if (display.equals("player")) {
			if (player.getOwnedCountries().size() == 0) {
				setText(name);
			} else {
				setText(name + ": owns " + player.getOwnedCountries().size() + "countries, dominates " 
			+ df.format(100*((double)player.getOwnedCountries().size()/(double)model.countriesArray.length)) + "% of world");
			}
		}
	}

}
