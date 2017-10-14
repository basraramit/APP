package com.Risk;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.Country;
import src.CountryMap;
import src.player;

public class RoundRobin{
	private ArrayList<player> players;
	private List<Country> countries;
	CountryMap map;
	private player curPlayer=new player();
	private int gameState;
	
	public void RoundRobin(ArrayList<player> PlayerList){

		players=PlayerList;
		countries=map.getCountryList();

		
		initializePlayer();
	}

	public void initializePlayer(){
		curPlayer=players.get(0);
	}

	public player getCurrentPlayer(){
		return curPlayer;
	}
	public ArrayList<player> getPlayers(){
        return players;
    }
    public int getState(){
        return gameState;
    }

    public void setState(int state){
        gameState = state;
    }

	void placeArmy(String CountryID){
		for(int i=0;i<countries.size();i++){
			Country temp=countries.get(i);
			if(temp.getCountryId()==CountryID && temp.getPlayerName()==curPlayer.SetPlayerName()){
				if(curPlayer.getArmy()>0){
					temp.addArmies(1);
					int temp1=curPlayer.getArmy();
					curPlayer.setArmy(temp1--);		
				}else{
					System.out.println("You have no army left");

				}
				
			}else{
					System.out.println("This is not you territory");
					return;
			}
		}
		 if(players.indexOf(curPlayer)<players.size()){
                curPlayer=players.get(players.indexOf(curPlayer)+1);
            }else{
               // setState(ACTIVE_TURN);
            	//START NEXT PHASE (NOT IMPLEMENTED YET)
         }

	}
}
