package Model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Allows the creation of Risk Country objects.
 * @author yaomeng
 *
 */
public class Country {

    /** The armies. */
    public int armies;
	
	/** The has player. */
	public boolean hasPlayer;
	
    /** The name. */
    public String name;
    
    /** The occupant. */
    public Player occupant;
    
    /** The adjacencies. */
    public ArrayList<Country> adjacencies;
	
	/** The adjacent. */
	private List<String> adjacent;
	
	/** The Continent. */
	private String Continent;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The cid. */
	private int CID;
	
	/** The player name. */
	private String playerName;

    /**
     * Instantiates a new country.
     *
     * @param name the name
     */
    public Country(String name) {
	
		this.name = name;
		hasPlayer = false;
		armies = 0;
		
		System.out.println("Created country: " + name);
	}

    /**
     * Used only when constructing the country object, it should not be called after
     * the board is initialized.
     *
     * @param adjacencies the adjacencies
     */
    public void addAdjacencies(ArrayList<Country> adjacencies) {
	
		this.adjacencies = adjacencies;
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
     * When a player conquers a country the player object is set as the occupant of the 
     * country.
     *
     * @param occupant the new occupant
     */
    public void setOccupant(Player occupant) {
		hasPlayer = true;
		this.occupant = occupant;
    }

    /**
     * Returns the player object who currently occupies the country.
     *
     * @return the occupant
     */
    public Player getOccupant() {
		return occupant;
    }
	
    /**
     * Used to set the number of armies currently stationed in this country.
     *
     * @param numArmies the new num armies
     */
    public void setNumArmies(int numArmies) {
		armies = numArmies;
    }
	
	/**
	 * Increment armies.
	 *
	 * @param numArmies the num armies
	 */
	public void incrementArmies(int numArmies) {
		armies = armies + numArmies;
		System.out.println(occupant.getName() + " added " + numArmies + " armies to " + name + ".");
	}
	
	/**
	 * Decrement armies.
	 *
	 * @param numArmies the num armies
	 */
	public void decrementArmies(int numArmies) {
		armies = armies - numArmies;
		System.out.println(occupant.getName() + " lost " + numArmies + " armies in " + name + ".");
	}
	
	/**
	 * Use armies.
	 *
	 * @param numArmies the num armies
	 */
	public void useArmies(int numArmies) {
		armies = armies - numArmies;
		System.out.println(occupant.getName() + " place " + numArmies + " armies in " + name + ".");
	}

    /**
     * Returns the number of armies currently stationed in this country.
     *
     * @return the armies
     */
    public int getArmies() {
		return armies;
    }

    /**
     * Returns a list of the country objects that are adjacent to this country on the board.
     *
     * @return the adjacencies
     */
    public ArrayList<Country> getAdjacencies() {
		return adjacencies;
    }
	
    /**
     * judge whether this country has owned by any player.
     *
     * @return true, if successful
     */
	public boolean hasPlayer() {
		return hasPlayer;
	}
	
	/**
	 * Sets the adjacent.
	 *
	 * @param a the new adjacent
	 */
	public void setAdjacent(List<String> a){
	    adjacent = a;
	}
	
	/**
	 * Gets the adjacents.
	 *
	 * @return the adjacents
	 */
	public List<String> getAdjacents(){
		return adjacent;
	}
	
	/**
	 * Sets the continent.
	 *
	 * @param Continent the new continent
	 */
	public void setContinent(String Continent) {
		this.Continent=Continent;
	}
	
	/**
	 * Sets the cid.
	 *
	 * @param CID the new cid
	 */
	public void setCID(int CID) {
    	this.CID = CID;
    }
	
	/**
	 * Sets the player name.
	 *
	 * @param playerName the new player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName=playerName;
	}
	
	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
	public String getContinent() {
		return Continent;
	}
	
	/**
	 * Sets the coordinate X.
	 *
	 * @param x the new coordinate X
	 */
	public void setCoordinateX(int x) {
		this.x=x;
	  // this.y=y;
	}
	
	/**
	 * Sets the country name.
	 *
	 * @param name the new country name
	 */
	public void setCountryName(String name) {
    	this.name = name;
    }


	/**
	 * Gets the coordinate X.
	 *
	 * @return the coordinate X
	 */
	public int getCoordinateX() {
	   return x;
	}

	/**
	 * Sets the coordinate Y.
	 *
	 * @param y the new coordinate Y
	 */
	public void setCoordinateY(int y) {
		
	  this.y=y;
	}

	/**
	 * Gets the coordinatey.
	 *
	 * @return the coordinatey
	 */
	public int getCoordinatey() {
	   return y;
	}

	/**
	 * Gets the cid.
	 *
	 * @return the cid
	 */
	public int getCID() {
		// TODO Auto-generated method stub
		return CID;
	}
}
