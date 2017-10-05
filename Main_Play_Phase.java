import java.util.ArrayList;

public class Main_Play_Phase {
	
	private ArrayList<Continent> continentList;
	private ArrayList<Country> countryList;
	
	
	/* This method calculates the number of armies a player gets to place 
	 * at the beginning of their turn
	 * 
	 * @param player
	 * @return
	 */
	public int calculateArmies(Player player) {
		int NumOfArmies = 0;
		NumOfArmies += getContinentBonus(player);
		if(getCountriesOwned(player) < 9) {
			NumOfArmies += 3;
		}
		else{
			NumOfArmies += getCountriesOwned(player)/3;
		}
		return NumOfArmies;
	}
	
	/**
	 * This method returns the total number of countries owned by players
	 * 
	 * @param player
	 * @return 
	 */
	public int getCountriesOwned(Player player) {
		int occupiedCountries = 0;
		for(int i = 0; i < continentList.size(); i++) {
			occupiedCountries += continentList.get(i).checkCountriesOwned(player);
		}
		return occupiedCountries;
	}
	
	/**
	 * This method returns the total troop bonus the player
	 * passed into the method gets for owning entire continents.
	 * 
	 * @param player
	 * @return
	 */
	public int getContinentBonus(Player player) {
		int bonus = 0;
		for(int i = 0; i < continentList.size(); i++) {
			if(continentList.get(i).checkContinentOwned(player) == true) {
				bonus += continentList.get(i).getTroopBonus();
			}
		}
		return bonus;		
	}
	
	/**
	 * This method allows players place armies they have to specific country
	 * 
	 * @param countryName
	 * @param armies
	 */
	public void placeArmies(String countryName, int armies) {
		addArmies(countryName, armies);
	}
	
	public void fortifyCountry(String oldCountry, String newCountry, int movedArmies) {
		if(oldCountry.isAdjacent()==true){
			addArmies(newCountry, movedArmies);
			removeArmies(oldCountry, movedArmies);
		}else{
			system.out.println("Invalid path!");
		}
		
	}
	
	public void addArmies(String name, int armies) {
		
		String countryName = new String();
		for (int i = 0; i < continentList.size(); i++) {
			for (int j = 0; j < continentList.get(i).getSize(); j++) {
				countryName = continentList.get(i).getCountryName(j);
				if (countryName.equalsIgnoreCase(name) == true) {
					continentList.get(i).addArmies(j, armies);
					break;
				}
			}
		}
		
	}

	public void removeArmies(String name, int armies) {
		
		String countryName = new String();
		for (int i = 0; i < continentList.size(); i++) {
			for (int j = 0; j < continentList.get(i).getSize(); j++) {
				countryName = continentList.get(i).getCountryName(j);
				if (countryName.equalsIgnoreCase(name) == true) {
					continentList.get(i).removeArmies(j, armies);
				}
			}
		}
		
	}
	
	
}
