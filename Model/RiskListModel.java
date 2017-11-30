package Model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

// TODO: Auto-generated Javadoc
/**
 * Allows the creation of JLists with updating strings from the RiskModel.
 * This class allows the creation of lists that stay updated to the lists of current 
 * player's hand, occupied countries, and countries adjacent to the selected, occupied 
 * country.
 * @author yaomeng
 *
 */
public class RiskListModel extends DefaultListModel implements Observer , Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;

	/** The i. */
	public int i;
	
	/** The type. */
	public String type;
	
	/** The display. */
	public String display;
	
	/** The model. */
	public Risk_Model model;
	
    /**
     * Instantiates a new risk list model.
     *
     * @param model the model
     * @param type the type
     */
    public RiskListModel (Risk_Model model, String type) {
	
        super();
        this.model = model;
		this.type = type;
    }
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	// Updates the state of the RiskList
	public void update(Observable obs, Object obj) {
		
		// System.out.println("Refreshing...");
		
		display = (String)obj;
		
		if (type == "cards" && type == display) {
		
			// System.out.println("Notified cards list.");
			
			removeAllElements();
			
			for (i = 0; i < model.getCardsList().size(); i++) {
			
				addElement(model.getCardsList().get(i));
			}
			
		} else if (type == "countryA" && type == display) {
		
			// System.out.println("Notified country A list.");
			
			removeAllElements();
			
			for (i = 0; i < model.getCountryAList().size(); i++) {
			
				addElement(model.getCountryAList().get(i));
			}
			
		} else if (type == "countryB" && type == display) {
		
			// System.out.println("Notified country B list.");
			
			removeAllElements();
			
			for (i = 0; i < model.getCountryBList().size(); i++) {
			
				addElement(model.getCountryBList().get(i));
			}
		} 
	}
}