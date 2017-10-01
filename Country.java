package Map;

public class Country{
	String CountryId,OwnerID,adjv1,Continent,PlayerName;
    int x,y;
   
    Country(String CountryId,OwnerId,String Continent,int x,int y, String adjv1,String PlayerName){
    	
    	this.CountryId = CountryId;
	this.OwnerId =   OwnerId;  
        this.x=x;
        this.y=y;
        this.adjv1= adjv1;
	    this.Continent=Continent;
	    this.PlayerName=PlayerName;
       
    }
 
    public void setCountryId(String CountryId) {
	    this.CountryId = CountryId;
    }


    public String getCountryId() {
    	
        return CountryId;
    }
	
	public void setContinent(String Continent) {
	this.Continent=Continent;
    }
	
    public void setOwnerId(String OwnerId) {
	    this.OwnerId = OwnerId;
    }


    public String getOwnerId() {
    	
        return OwnerId;
    }
	


/**
* @return the continent
*/
public String getContinent() {
return Continent;
}


    public void setCoordinateX(int x) {
	    this.x=x;
       
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


    public String getadjv() {
        return adjv1;
    }


    public void setadjv(String adjv1) {
	    this.adjv1= adjv1;
    }

   // public void setadjv(String adjv1) {
	//this.adjv1= adjv1;
//}
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
   

