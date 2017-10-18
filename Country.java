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
public void setCID(int CID) {
	this.CID = CID;
}
/**
* @return the countryID
*/
public String getCountryId() {
return CountryId;
}
public int getCID() {
return CID;
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



}






    
