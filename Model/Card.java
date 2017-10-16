package Model;

/**
 * Allows the creation of Risk Card objects.
 * @author yaomeng
 *
 */
public class Card {

	public final String type;
    public final Country country;

    public Card( String type, Country country ) {
		this.type = type;
		this.country = country;
    }
	
	public String getName() {
		return country.getName() + ", " + type;
	}

    public String getType() {
		return type;
    }

    public Country getCountry() {
		return country;
    }
}
