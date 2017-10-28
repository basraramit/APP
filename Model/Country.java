package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows the creation of Risk Country objects.
 * @author yaomeng
 *
 */
public class Country {

    public int armies;
	public boolean hasPlayer;
	
    public String name;
    public Player occupant;
    public ArrayList<Country> adjacencies;
	private List<String> adjacent;
	private String Continent;
	private int x;
	private int y;
	private int CID;
	private String playerName;

    public Country(String name) {
	
		this.name = name;
		hasPlayer = false;
		armies = 0;
		
		System.out.println("Created country: " + name);
	}

    /**
     * Used only when constructing the country object, it should not be called after
     * the board is initialized
     * @param adjacencies
     */
    public void addAdjacencies(ArrayList<Country> adjacencies) {
	
		this.adjacencies = adjacencies;
    }

    public String getName() {
		return name;
    }

    /**
     * When a player conquers a country the player object is set as the occupant of the 
	 * country
     * @param occupant
     */
    public void setOccupant(Player occupant) {
		hasPlayer = true;
		this.occupant = occupant;
    }

    /**
     * Returns the player object who currently occupies the country
     * @return
     */
    public Player getOccupant() {
		return occupant;
    }
	
    /**
     * Used to set the number of armies currently stationed in this country
     * @param numArmies
     */
    public void setNumArmies(int numArmies) {
		armies = numArmies;
    }
	
	public void incrementArmies(int numArmies) {
		armies = armies + numArmies;
		System.out.println(occupant.getName() + " added " + numArmies + " armies to " + name + ".");
	}
	
	public void decrementArmies(int numArmies) {
		armies = armies - numArmies;
		System.out.println(occupant.getName() + " lost " + numArmies + " armies in " + name + ".");
	}

    /**
     * Returns the number of armies currently stationed in this country
     * @return
     */
    public int getArmies() {
		return armies;
    }

    /**
     * Returns a list of the country objects that are adjacent to this country on the board
     * @return
     */
    public ArrayList<Country> getAdjacencies() {
		return adjacencies;
    }
	
    /**
     * judge whether this country has owned by any player
     * @return
     */
	public boolean hasPlayer() {
		return hasPlayer;
	}
	
	public void setAdjacent(List<String> a){
	    adjacent = a;
	}
	public List<String> getAdjacents(){
		return adjacent;
	}
	
	public void setContinent(String Continent) {
		this.Continent=Continent;
	}
	public void setCID(int CID) {
    	this.CID = CID;
    }
	public void setPlayerName(String playerName) {
		this.playerName=playerName;
	}
	public String getPlayerName() {
		return playerName;
	}

	/**
	* @return the continent
	*/
	public String getContinent() {
	return Continent;
	}
	
	public void setCoordinateX(int x) {
		this.x=x;
	  // this.y=y;
	}
	
	public void setCountryName(String name) {
    	this.name = name;
    }


	public int getCoordinateX() {
	   return x;
	}

	public void setCoordinateY(int y) {
		
	  this.y=y;
	}

	public int getCoordinatey() {
	   return y;
	}

	public int getCID() {
		// TODO Auto-generated method stub
		return CID;
	}
}
