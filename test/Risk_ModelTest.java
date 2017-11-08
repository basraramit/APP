package Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Model.Risk_Model;
import junit.framework.TestCase;

public class Risk_ModelTest extends TestCase{
	
	Risk_Model model;
	
	ArrayList<String> playerNames;
	
	public static String countriesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countries.txt";
	
	public static String continentsFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/continents.txt";
	
	public static String adjacenciesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/adajencies.txt";
	
	
	/**
	 * Setup
	 */
	protected void setUp (){
		model = new Risk_Model();
		playerNames = new ArrayList<String>();
		playerNames.add("XI");
	
	}
	
	public void testGetMapFilePath(){
		model.setMapFilePath("map.txt");
		assertSame("map.txt", model.getMapFilePath());
	}
	
	public void testInitializeGame(){
		try {
			assertTrue(model.initializeGame(playerNames));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGetState(){
		model.setState("attack");
		assertTrue(model.getState() == "attack");
	}
	

}
