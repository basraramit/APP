package Model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerLabel.
 */
public class PlayerLabel extends JLabel implements Observer, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;
	
	/** The name. */
	public String name;
	
	/** The display. */
	public String display;
	
	/** The Player. */
	public Player player;
	
	/** The model. */
	public Risk_Model model;

	
	/**
	 * Instantiates a new Player label.
	 *
	 * @param model the model
	 * @param player the player
	 */
    public PlayerLabel (Risk_Model model, Player player) {
	
        super();
        this.player = player;
        this.model = model;
		name = player.getName();
		setText(name);
    }

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
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
