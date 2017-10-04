package com.Risk;

import java.util.List;

import Map.CountryMap;

public class GetCountryList {

	CountryMap c= new CountryMap();
	List<Map.Country> country;
	GetCountryList() {
		
			// TODO Auto-generated method stub
			country=c.getCountryList();
			System.out.println(country.size());
			for(Map.Country n: country){
				System.out.println(n.getCountryId());
			}
			System.out.println( System.getProperty("user.dir"));
			
		}
	public void random(){
		
	}

}
