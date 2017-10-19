package Map;
import java.util.ArrayList;

import java.util.List;
import java.util.Vector;


/** This class creates country object. 
 * Country has CountryID, adjacency vector, continent and x & y coordinate
 * getter & setter for parameters 
 * @author USER
 *
 */

public class Country {
	public static String CountryId;
	String adjv1;
	String Continent;
    int x,y,CID;
    
    int[] adj= new int[10];
    int adjv2;
    String PlayerName;
    List<String> adjacent= new ArrayList<String>();

/**This is a constructor for country class 
* @param CountryID,Continent, x coordinate, y coordinate, PlayerName
*/
       Country(String CountryId, String Continent,int x,int y, String PlayerName){
       this.CountryId = CountryId;
       this.x=x;
       this.y=y;
       this.Continent=Continent;
       this.PlayerName=PlayerName;
        
  }

/**This method sets IDs to country
* @param CountryID
*/
public void setCountryId(String CountryId) {
	this.CountryId = CountryId;
}
	
/**This method sets IDs to country
* @param CountryID
*/	
	
public void setCID(int CID) {
	this.CID = CID;
}

/**This method gets IDs for country
*@return  CountryId
*/

public String getCountryId() {
return CountryId;
}

/**This method gets IDs for country
*@return CountryId
*/
public int getCID() {
return CID;
}

/**This method sets continent for country
*@param continent
*/
public void setContinent(String Continent) {
	this.Continent=Continent;
}

/**This method gets continent for country
*@return Continent
*/
public String getContinent() {
return Continent;
}

/**This method sets X coordiantes for country
*@param x coordiantes
*/
public void setCoordinateX(int x) {
	this.x=x;
}


/**This method gets X Coordinate for country
*@return X Coordinate
*/
public int getCoordinateX() {
   return x;
}

/**This method sets Y Coordinate for country
*@param Y Coordinate
*/
public void setCoordinateY(int y) {
	
  this.y=y;
}

/**This method gets Y Coordinate for country
*@return Y Coordinate
*/

public int getCoordinatey() {
   return y;
}

/**This method sets adjacency list for country
*@param adjacency list
*/
	
public void setAdjacent(List<String> a){
    adjacent = a;
}

/**This method gets adjacency list for country
*@return adjacency list
*/	
public List<String> getAdjacents(){
	return adjacent;
}
	
/**This method gets adjacency vector for country
*@return adjacency vector
*/

public String getadjv() {
   return adjv1;
}

/**This method sets adjacency vector for country
*@param adjacency vector
*/
public void setadjv(String adjv1) {
	this.adjv1= adjv1;
}

/**This method sets Player name for country
*@param Continent
*/
public void setPlayerName(String Continent) {
	this.PlayerName=PlayerName;
}

/** This method sets Player name for country
* @return the Player name
*/
public String getPlayerName() {
return PlayerName;
}



}






    
