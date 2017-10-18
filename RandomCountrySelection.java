package Risk;

import java.util.Scanner;


import Map.Country;
import Map.CountryMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/** This class takes number of players, 
 *  generate random countries to each player
 * @author Urbashi
 */

public class RandomCountrySelection {

	public static void main(String args[]){
		
		
		//choose player number
			Scanner pn = new Scanner(System.in);

			System.out.println("Choose Player");
			System.out.println("6 Players");
			System.out.println("5 Players ");
			System.out.println("4 Players");
			System.out.println("3 Players");
			System.out.println("2 Players ");
			System.out.println();
		int playerNo = pn.nextInt();
		
		//get list of country from Map.CountryMap 
		
		CountryMap cp= new CountryMap();
		List <String> ReplicaListCountry= CountryMap.getCountryList();
		
		//get only countryIDs
		List <String> CountryIds = new ArrayList <String>();
		for(String c: ReplicaListCountry){
			CountryIds.add(c);
		}
		
		//randomize list
			Collections.shuffle(CountryIds);
			
		//assign random countries to players
			 double GetIndex= (double) Math.ceil((float)CountryIds.size()/(float)playerNo);
			 List<String> sublist = new ArrayList<String>();
			 int x=0;
			 System.out.println(GetIndex);
		
			 List<String>[] NewList = new List[playerNo];
			 for (int i = 0; i < playerNo; i++) {
			     NewList[i] = new ArrayList<>();
			     
			     int lastIndex=x+(int)GetIndex;
			     	if(lastIndex>CountryIds.size()){
			     		lastIndex=CountryIds.size();
			     	}
			        sublist = new ArrayList<String>(CountryIds.subList(x,lastIndex));
			        NewList[i]=sublist;
			        
			        x+=GetIndex;
			        
			            
			       }
			 for(int i =0;i<NewList.length;i++){

				 System.out.println("Player "+i+" Country List");
				 for(int k=0;k<NewList[i].size();k++){
					 System.out.println("->"+NewList[i].get(k));
				 }
			 }
			 
	// player number gets initial armies	 
			
			 if (playerNo  == 6) {
		            int ArmyNo  = 20;
		            System.out.println("ArmyNo is" + ArmyNo);
		            }
		        else if (playerNo  == 5) {
		        	int ArmyNo =25;
		            System.out.println("ArmyNo is"+ArmyNo);
		        } 
		        else if (playerNo  ==4) {
		        	int ArmyNo  = 30;
		        	System.out.println("ArmyNo is"+ArmyNo);
		        }
		        else if (playerNo ==3){
		        	int ArmyNo = 35;
		        	System.out.println("ArmyNo is"+ArmyNo);
		        }  
		        else if (playerNo  ==2){
		        	int ArmyNo  =40;
		        	System.out.println("ArmyNo is"+ArmyNo);
		        }  	 
		        

			 
		}
	
	
}
