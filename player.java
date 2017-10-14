package com.Risk;

public class player{

	public String player_name;
	String CountryID;
	int infantry,cavalry,artillery;
	public int i;
	

	public int getArmy(){
		return i;
	}
	
	public int setArmy(int i){
		this.i=i;
		return i;
	}
	
	public String GetplayerName(String PlayerName){ 
	 this.player_name=PlayerName;
	 return player_name;
	}
	
	public String SetPlayerName(){
		return player_name;
	}

	public String GetCountryID(String ID){
	this.CountryID=ID;
	return CountryID;
	}
	
	public String SetCountryID(){
		return CountryID;
	}
	
	public int GetInfantry(int A){
		this.infantry=A;
		return infantry;
	}
		
		public int SetInfantry(){
			return infantry;

		}
		public int Getcavalry(int A){
			this.cavalry=A;
			return cavalry;
		}
		
		public int SetCavalry(){
			return cavalry;

		}
		
		public int GetArtillary(int A){
			this.artillary=A;
			return artillary;
		}
		
}
