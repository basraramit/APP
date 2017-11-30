package Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Model.Risk_Model;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class Risk_ModelTest.
 */
public class Risk_ModelTest extends TestCase{
	
	/** The model. */
	Risk_Model model;
	
	/** The player names. */
	ArrayList<String> playerNames;

	/** The player type. */
	ArrayList<String> playerType;
	
	/** The countries file. */
	public static String countriesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countries.txt";
	
	/** The continents file. */
	public static String continentsFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/continents.txt";
	
	/** The adjacencies file. */
	public static String adjacenciesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/adajencies.txt";
	
	
	/**
	 * Setup.
	 */
	protected void setUp (){
		model = new Risk_Model();
		playerNames = new ArrayList<String>();
		playerNames.add("XI");
	
	}
	
	/**
	 * Test get map file path.
	 */
	public void testGetMapFilePath(){
		model.setMapFilePath("map.txt");
		assertSame("map.txt", model.getMapFilePath());
	}
	
	/**
	 * Test initialize game.
	 */
	public void testInitializeGame(){
		try {
			assertTrue(model.initializeGame(playerNames, playerType));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test get state.
	 */
	public void testGetState(){
		model.setState("attack");
		assertTrue(model.getState() == "attack");
	}
	
	
	

}
