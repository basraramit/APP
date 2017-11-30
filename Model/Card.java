package Model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Allows the creation of Risk Card objects.
 * @author yaomeng
 *
 */
public class Card implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;

	/** The type. */
	public final String type;
    
    /** The country. */
    public final Country country;

    /**
     * Instantiates a new card.
     *
     * @param type the type
     * @param country the country
     */
    public Card(String type, Country country ) {
		this.type = type;
		this.country = country;
    }
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return country.getName() + ", " + type;
	}

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
		return type;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public Country getCountry() {
		return country;
    }
}
