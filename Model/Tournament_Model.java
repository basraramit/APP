package Model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Tournament_Model.
 */
public class Tournament_Model {
	
	 /** The player names. */
 	private ArrayList<String> playerNames;
	    
    	/** The player types. */
    	private ArrayList<String> playerTypes;

		/** The map files. */
		List<String> mapFiles;
		
		/** The number of games. */
		int numberOfGames=1;
		
		/** The number of turns. */
		int numberOfTurns=1;
		
		
		/**
		 * Instantiates a new tournament model.
		 *
		 * @param mapFiles the map files
		 * @param numberOfGames the number of games
		 * @param numberOfTurns the number of turns
		 */
		public Tournament_Model(List<String> mapFiles, int numberOfGames, int numberOfTurns) {
			super();
			this.mapFiles = mapFiles;
			this.numberOfGames = numberOfGames;
			this.numberOfTurns = numberOfTurns;
			playerNames = new ArrayList<String>();
			playerTypes = new ArrayList<String>();

			playerNames.add("Aggressive");
			playerNames.add("Benevolent");
			playerNames.add("Random");
			playerNames.add("Cheater");
			playerTypes.add("Aggressive_Bot");
			playerTypes.add("Benevolent_Bot");
			playerTypes.add("Random_Bot");
			playerTypes.add("Cheater_Bot");

		}
		
		/**
		 * Gets the map files.
		 *
		 * @return the map files
		 */
		public List<String> getMapFiles() {
			return mapFiles;
		}
		
		/**
		 * Sets the map files.
		 *
		 * @param mapFiles the new map files
		 */
		public void setMapFiles(List<String> mapFiles) {
			this.mapFiles = mapFiles;
		}
		
		/**
		 * Gets the number of games.
		 *
		 * @return the number of games
		 */
		public int getNumberOfGames() {
			return numberOfGames;
		}
		
		/**
		 * Sets the number of games.
		 *
		 * @param numberOfGames the new number of games
		 */
		public void setNumberOfGames(int numberOfGames) {
			this.numberOfGames = numberOfGames;
		}
		
		/**
		 * Gets the number of turns.
		 *
		 * @return the number of turns
		 */
		public int getNumberOfTurns() {
			return numberOfTurns;
		}
		
		/**
		 * Sets the number of turns.
		 *
		 * @param numberOfTurns the new number of turns
		 */
		public void setNumberOfTurns(int numberOfTurns) {
			this.numberOfTurns = numberOfTurns;
		}
	    
    	/**
    	 * Gets the player names.
    	 *
    	 * @return the player names
    	 */
    	public ArrayList<String> getPlayerNames() {
	        return playerNames;
	    }

	    /**
    	 * Sets the player names.
    	 *
    	 * @param playerNames the new player names
    	 */
    	public void setPlayerNames(ArrayList<String> playerNames) {
	        this.playerNames = playerNames;
	    }

	    /**
    	 * Gets the player types.
    	 *
    	 * @return the player types
    	 */
    	public ArrayList<String> getPlayerTypes() {
	        return playerTypes;
	    }

	    /**
    	 * Sets the player types.
    	 *
    	 * @param playerTypes the new player types
    	 */
    	public void setPlayerTypes(ArrayList<String> playerTypes) {
	        this.playerTypes = playerTypes;
	    }

}
