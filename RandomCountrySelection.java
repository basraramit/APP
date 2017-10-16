package com.Risk;

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

import Map.Country;
import Map.CountryMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


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
	int Playerno = pn.nextInt();
	
	//get list of country from Map.CountryMap 
	CountryMap cp= new CountryMap(); 
	List <Country> ReplicaListCountry= CountryMap. getCountryList();
	
	
	//get only countryIDs
	List <String> CountryIds = new ArrayList <String>();
	for(Country c: ReplicaListCountry){
		CountryIds.add(Country.CountryId);
	}
	
	//randomize list
		Collections.shuffle(CountryIds);	
	
	//assign random countries to players
		 int GetIndex= (int) Math.ceil(CountryIds.size()/Playerno);
		 List<String> sublist = new ArrayList<String>();
		 int x=0;
		 List<String>[] NewList = new List[Playerno];
		 for (int i = 0; i < Playerno; i++) {
		     NewList[i] = new ArrayList<>();
		     {
		 for(int p=0; p<GetIndex; p++)
		    {
		        if(CountryIds.size()>=(x+Playerno))
		       
		            sublist = new ArrayList<String>(CountryIds.subList(x,GetIndex-1));
		        NewList[i]=sublist;
		        
		    }	
		        }
		      
		            x=GetIndex+1;
		            GetIndex=2*GetIndex-1;
		            
		        }
	}

	

		
		
		
		
		
		
		
		
		


}
