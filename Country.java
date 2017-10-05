package Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * This class stores the information of a country
 * in the game of Risk.
 * 
 */

public class Country {
	String CountryId,adjv1, Continent;
    int x,y;
    int[] adj= new int[10];
    int adjv2;
    String PlayerName;
    List<String> adjacent= new ArrayList<String>();
   
         /**
	 * This constructor creates a new country object 
	 *
	 * @param 
	 */

    Country(String CountryId, String Continent,int x,int y, String PlayerName){
       this.CountryId = CountryId;
       this.x=x;
       this.y=y;
       this.Continent=Continent;
       this.PlayerName=PlayerName;
        
   }

  
public void setCountryId(String CountryId) {
	this.CountryId = CountryId;
}

/**
* @return the countryID
*/
public String getCountryId() {
return CountryId;
}

public void setContinent(String Continent) {
	this.Continent=Continent;
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


public int getCoordinateX() {
   return x;
}

public void setCoordinateY(int y) {
	
  this.y=y;
}

public int getCoordinatey() {
   return y;
}

public void setAdjacent(List<String> a){
    adjacent = a;
}
public List<String> getAdjacents(){
	return adjacent;
}

public String getadjv() {
   return adjv1;
}


public void setadjv(String adjv1) {
	this.adjv1= adjv1;
}
public void setPlayerName(String Continent) {
	this.PlayerName=PlayerName;
}

/**
* @return the Player name
*/
public String getPlayerName() {
return PlayerName;
}

         /**
	 * This method returns the current
	 * player that occupies the country.
	 * @return
	 */
	public Player getOwner(){
		return currentOwner;
	}
	
	/**
	 * This method will set the current
	 * owner to the passed in player.
	 * @param player
	 */
	public void setOwner(Player player){
		currentOwner = player;
	}
	
	/**
	 * This method returns the current
	 * army amount occupying the country.
	 * @return
	 */
	public int getArmy(){
		return currentArmy;
	}
	
	/**
	 * This method will add the specified
	 * amount of armies to the current total
	 * occupying the country.
	 * @param armies
	 */
	public void addArmies(int armies){
		currentArmy += armies;
	}
	
	/**
	 * This method will remove the specified
	 * amount of armies from the current total
	 * occupying the country.  Granted the amount
	 * is less than the current amount.
	 * @param armies
	 */
	public void removeArmies(int armies){
		if(armies <= currentArmy){
			currentArmy -= armies;
		}
	}
	
	/**
	 * This method checks the list of borders
	 * for the country to see if it is in fact
	 * a border country.
	 * @param borderCountry
	 * @return
	 */
	public boolean isAdjacent(String adjacentCountry){
		for(int i = 0; i < adjacent.size(); i++){
			if(borderList.get(i).equalsIgnoreCase(adjacentCountry)){
				return true;
			}
		}
		return false;
	}
	
	


}






    
