package com.Risk;

public class Player{

	public String player_name;
	String CountryID;
	int ArmyNo;
	
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
	
	public int GetArmy(int Army){
		this.ArmyNo=Army;
		return ArmyNo;
	}
		
		public int SetArmy(){
			return ArmyNo;

		}
		
}
