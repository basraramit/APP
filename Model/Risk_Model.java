package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.lang.StringBuilder;
import java.lang.NumberFormatException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

/**
 * This class is the model for the Risk program.
 * It contains the data, methods, and functions that are required to manipulate the data of 
 * the Risk Game.
 * @author yaome
 *
 */
public class Risk_Model extends Observable {

	private static String CountryName;
	private static String AdajenciesName;
	public boolean canTurnInCards;
	public boolean canReinforce;
	public boolean canFortify;
	public boolean deployPhase;
	public boolean deployed;
	public boolean isInt;
	public boolean isLoaded;
	public int i;
	public int playerCount;
	public int playerIndex;
	public int deployTurn;
	public int noArmiesCount;
	public int turnInCount;
	public int armies;
	public static String countriesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countries.txt";
	public static String continentsFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/continents.txt";
	public static String adjacenciesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/adajencies.txt";
	public String line;
	public String input;
	public String countryASelection;
	public String mapToLoad;
	
	public String[] countriesArray;
	public String[] continentsArray;
	public String[] adjacenciesArray;
	public ArrayList<String> list;
	public ArrayList<Player> players;
	
	public StringBuilder stringBuilder;
	public BufferedReader reader;
	public Board board;
	public Deck deck;
	public Player currentPlayer;
	public Country countryA;
	public Country countryB;
	
	public Country[] countries;
	public Player[] player;
	
	
	/**
	 * This is the constructor for the RiskModel object.
	 */
	public Risk_Model() {
		super();
	}
	
	public void saveGame() {
	
	}
	
	/**
	 * This method handles exiting the game.
	 */
	public void quitGame() {
		System.exit(0);
	}
	
	/**
	 * set the map file path
	 * @param mapToLoad
	 */
	public void setMapFilePath(String mapToLoad) {
		this.mapToLoad = mapToLoad;
	}
	
	/**
	 * get the map's file path
	 * @return
	 */
	public String getMapFilePath(){
		return mapToLoad;
		
	}
	
	/**
	 * Sets the number of players.
	 * @param playerCount is an integer input by the player in the PlayerCount GUI.
	 */
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	
	/**
	 * Gets the number of players.
	 * @return the number of players in the Risk game.
	 */
	public int getPlayerCount() {
		return playerCount;
	}
	
	/**
	 * Sets up the Risk game.
	 * @param playerNames is an ArrayList of the player names.
	 * @param playerTypes is an ArrayList of the player teams.
	 * @return true if the game was successfully initialized
	 */
	public boolean initializeGame(ArrayList<String> playerNames) throws FileNotFoundException {
		
		isLoaded = false;
		board = new Board();
		
		try {
		// Reads countries file
			reader = new BufferedReader(new FileReader(countriesFile));			
			stringBuilder = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			input = stringBuilder.toString();
			System.out.println("Input from " + countriesFile + ": " + input);
			// Splits the text in the file into an array
			countriesArray = input.split("\t");
			System.out.println("Load Board");
			
			// Reads adjacencies file
			reader = new BufferedReader(new FileReader(adjacenciesFile));			
			stringBuilder = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			input = stringBuilder.toString();
			System.out.println("Input from " + adjacenciesFile + ": " + input);
			
			// Creates an array of each line from the file
			adjacenciesArray = input.split("\t");
			
			// Reads continents file
			reader = new BufferedReader(new FileReader(continentsFile));
			stringBuilder = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			input = stringBuilder.toString();
			System.out.println("Input from " + continentsFile + ": " + input);
			
			continentsArray = input.split("\t");
			System.out.println("Numbers of Continents:" + continentsArray.length);
			// Creates game board object
			isLoaded = board.loadBoard(countriesArray, adjacenciesArray, continentsArray);
			
			// Creates deck
			System.out.println("Populating deck...");
			deck = new Deck(board.getCountries());
			
			// Creates ArrayList of players
			System.out.println("Preparing players...");
			System.out.println("Numbers of Countries:" + countriesArray.length);
			System.out.println("Numbers of Continents:" + continentsArray.length);
			players = new ArrayList<Player>();
			
			// Players are created here
			for (i = 0; i < playerNames.size(); i++) {
				players.add(new Player(playerNames.get(i), 50 - (playerNames.size() * 5), i));
			}
			
			System.out.println("Starting deploy phase...");

			deployTurn = -1;
			deployPhase = true;
			deployed = true;
			
			canTurnInCards = false;
			canReinforce = true;
			canFortify = false;
			
		} catch (FileNotFoundException error) {
			System.out.println(error.getMessage());
		} catch (IOException error) {
			System.out.println(error.getMessage());
		}
		return isLoaded;
	}	
	
	
	
	/**
	 * Starts the game and prints out welcome messages.
	 */
	public void startGame() {
	
		System.out.println("Welcome to RISK Game!\nEach player rolls a DICE in order to determine the order of turns...");
		
		Collections.shuffle(players);
		
		System.out.println("Here is the order of turns:");
	
		for (i = 0; i < players.size(); i++) {
		
			System.out.println((i + 1) + ": " + players.get(i).getName());
		}
		
		System.out.println("How to begin: Claim territories by selecting them from the list and clicking the 'Place Reinforcements' button.");
		nextPlayer();
	}
	
	/**
	 * Handles turning in Risk cards.
	 * @param cardsToRemove is an integer array of the indexes of cards to be removed.
	 */
	public void turnInCards(int[] cardsToRemove) {
	
		if (canTurnInCards == true) {
		
			if (cardsToRemove.length == 3) {
			
				if (currentPlayer.getHand().get(cardsToRemove[0]).getCountry().getOccupant().equals(currentPlayer) || currentPlayer.getHand().get(cardsToRemove[1]).getCountry().getOccupant().equals(currentPlayer) || currentPlayer.getHand().get(cardsToRemove[2]).getCountry().getOccupant().equals(currentPlayer)) {
					// Checks if player owns a country on the cards to remove
					currentPlayer.incrementArmies(2);
					
					setChanged();
					notifyObservers("cards");
					
				}
				turnInCount = currentPlayer.getTurnInCount();
				
				if (turnInCount <= 5) {
					// Increments armies according to how many turn-ins have occurred
					currentPlayer.incrementArmies(2 + (2 * turnInCount));
					
					setChanged();
					notifyObservers("cards");
					
				}
				else if (turnInCount >= 6) {
				// Increments armies by 15 for every turn-in after the 5th
					currentPlayer.incrementArmies(15);
					
					setChanged();
					notifyObservers("cards");
					
				}
				currentPlayer.removeCards(cardsToRemove);
				
				setChanged();
				notifyObservers("cards");
				
			} else {
				System.out.println("You must trade in three cards of the same type or one of each three types.");
			}			
		} else {
			System.out.println("You can't turn in cards right now.");
		}
	}
	
	/**
	 * Handles placing reinforcements.
	 * @param countryAName is a String of the country in which the reinforcements will be placed
	 */
	public void reinforce(String countryAName) {
	
		countryA = board.getCountryByName(countryAName);
		
		if (canReinforce == true) {
		
			if (countryA.hasPlayer() == false || currentPlayer.equals(countryA.getOccupant())) {
			// If countryA is occupied by player or unoccupied
				if (deployTurn >= board.countriesList.size()) {
					// If all countries have been claimed
					
					isInt = false;
					try {
						// Player inputs how many armies to reinforce selected country
						armies = Integer.parseInt(JOptionPane.showInputDialog("Commander, how many armies do you wish to send to reinforce " + countryAName + "?"));
						isInt = true;
					} catch (NumberFormatException e) {
							System.out.println("Commander, please take this seriously. We are at war.");
					}
					
					if (isInt == true) {
						
						if (currentPlayer.getArmies() >= armies) {
						// If player has enough armies
							// Subtracts player armies and adds armies to country
							currentPlayer.decrementArmies(armies);
							countryA.incrementArmies(armies);
							// Reinforce dialog
							System.out.println(currentPlayer.getName() + " has chosen to reinforce " + countryAName + " with " + armies + " armies.");
							deployed = true;
							
							setChanged();
							notifyObservers("countryA");
							
							if (currentPlayer.getArmies() == 0) {
								canFortify = true;
							}
						} else {
							System.out.println("You do not have enough armies to reinforce " + countryAName + " with " + armies + " armies.\nReinforcements available: " + currentPlayer.getArmies());
						}
					}
				} else if (countryA.hasPlayer() == false) {
				// If there are remaining countries to claim, makes sure country is unoccupied
					countryA.setOccupant(currentPlayer);
					currentPlayer.addCountry(countryA);
					// Places one army at the unoccupied territory
					countryA.incrementArmies(1);
					currentPlayer.decrementArmies(1);
					deployed = true;
					
					nextPlayer();
					
				} else {
					System.out.println("Error: Can't determine reinforce method");
				}
			} else {
				System.out.println("You do not occupy " + countryAName + ".");
			}
		} else {
			System.out.println("Commander, we are unable to send reinforcements right now.");
		}
	}
	
	/**
	 * Handles the fortify function.
	 * Fortifying allows the player to move armies from one country to another occupied 
	 * country once per turn.
	 * @param countryA is a String of the point A country.
	 * @param countryB is a String of the point B country.
	 */
	public void fortify(String countryAName, String countryBName) {	
	
		//countryAName = JOptionPane.showInputDialog("Move army from:");
		//countryBName = JOptionPane.showInputDialog("Move army to:");
		countryA = board.getCountryByName(countryAName);
		countryB = board.getCountryByName(countryBName);
		
		if (canFortify == true) {
		
			if (currentPlayer.equals(countryA.getOccupant()) && currentPlayer.equals(countryB.getOccupant())) {
			// Check player owns countryA and countryB
				if (board.checkAdjacency(countryAName, countryBName) == true) {
				// Check if countryA and countryB are adjacent
					isInt = false;
					
					
					// If current player is Human
					try {
						// Player inputs how many armies to move from country A to country B
						armies = Integer.parseInt(JOptionPane.showInputDialog("Commander, how many armies from " + countryAName + " do you wish to send to fortify " + countryBName + "?"));
						isInt = true;
							
					} catch (NumberFormatException e) {
						System.out.println("Commander, please take this seriously. We are at war.");
					}
					
					// Decrements armies in country A and increments armies in country B
					if (isInt == true) {
						
						if (countryA.getArmies() >= armies) {
							System.out.println(currentPlayer.getName() + " has chosen to fortify " + countryBName + " with " + armies + " armies from " + countryAName + ".");
							
							countryA.decrementArmies(armies);
							countryB.incrementArmies(armies);
							
							setChanged();
							notifyObservers("countryA");
							
							nextPlayer();
							
						} else {
							System.out.println("Commander, you do not have enough armies in " + countryAName + " to fortify " + countryBName + " with " + armies + " armies.\nNumber of armies in " + countryAName + ": " + countryA.getArmies());
						}
					}
				} else {
					System.out.println("Commander, " + countryAName + " is not adjacent to " + countryBName + ".");
				}
			} else {
				System.out.println("Commander, you do not occupy both " + countryAName + " and " + countryBName + ".");
			}
		} else {
			System.out.println("Commander, we can't relocate troops right now.");
		}
	}
	
	/**
	 * Handles turn transitions in both the deploy phase and game phase.
	 */
	public void nextPlayer() {
	
		if (players.size() > 1) {
			// If at least one player remains
			if (deployed == true) {
				// Prevents players from skipping turns during the deploy phase
				// Prevents actions between turn transitions
				canTurnInCards = false;
				canReinforce = false;
				canFortify = false;
				playerIndex++;
				
				if (playerIndex >= players.size()) {
				// Loops player index back to 0 when it exceeds the number of players
					playerIndex = 0;
				}
				currentPlayer = players.get(playerIndex);
				noArmiesCount = 0;
				
				for(i = 0; i < players.size(); i++) {
				
					if (players.get(i).getArmies() == 0) {
					// Used to determine when to end the deploy phase
						noArmiesCount++;
					}
					if (deployPhase == true && noArmiesCount == players.size()) {
						deployPhase = false;
						deployed = true;
						System.out.println("\n=== The deploy phase has ended! ===\nWhat to do:\n1. Get new armies by turning in matching cards\n2. Attack and conquer neighbor territories.\n3. End your turn by fortifying a country with armies from another occupied country.\nGood luck, commander!");
					}
				}
				if (deployPhase == false) {
				// If game phase is active
					// Draw card
					System.out.println("\n===" + currentPlayer.getName().toUpperCase() +  "===");
					currentPlayer.addRiskCard(deck.draw());	
					
					if (currentPlayer.getOwnedCountries().size() < 12) {
					// Increment armies based on the number of territories occupied
						currentPlayer.incrementArmies(4);
						
					} else {
						currentPlayer.incrementArmies(currentPlayer.getOwnedCountries().size() / 3);
					}
					for (i = 0; i < board.getContinents().size(); i++) {
					// Check continent ownership for bonus armies
						if (currentPlayer.getOwnedCountries().containsAll(board.getContinents().get(i).getMemberCountries())) {
						// If the current player's list of owned territories contains all the territories within a continent
							currentPlayer.incrementArmies(board.getContinents().get(i).getBonusArmies());
							System.out.println(currentPlayer.getName() + " has received " + board.getContinents().get(i).getBonusArmies() + " bonus reinforcements from controlling " + board.getContinents().get(i).getName() + "!");
						}
					}
					System.out.println(currentPlayer.getName() + "'s turn is ready!\nReinforcements available: " + currentPlayer.getArmies());
					deployed = true;
					
					 
					// Current player is human
					while(currentPlayer.mustTurnInCards()) {
					// While player has 5 or more cards
						System.out.println("Commander, your hand is full. Trade in cards for reinforcements to continue.");
					}
						canTurnInCards = true;
						canReinforce = true;
						
						setChanged();
						notifyObservers("cards");
						setChanged();
						notifyObservers("countryA");
					
				} else if (deployPhase == true) {
				// If deploy phase is active
					deployTurn++;
					
					if (currentPlayer.getArmies() == 0) {
						nextPlayer();
					} else {
						deployed = false;
						System.out.println("\n===" + currentPlayer.getName().toUpperCase() +  "===\n" + currentPlayer.getName() + "'s turn is ready! (Deploy Phase)\nReinforcements available: " + currentPlayer.getArmies());
						setChanged();
						notifyObservers("countryA");
						
						canReinforce = true;
						
					}
				}
			} else {
				System.out.println("Commander, you must place your reinforcements during the deploy phase.");
			}
		} else {
		
		}
	}
	
	/**
	 * Creates and returns the information for the cardsList in the BoardView.
	 * @return a list of Strings to be displayed in the cardsList.
	 */
	public ArrayList<String> getCardsList() {
	
		list = new ArrayList<String>();
		
		for (i = 0; i < currentPlayer.getHand().size(); i++) {	
		
			list.add(currentPlayer.getHand().get(i).getName());
		}
		return list;
	}
	
	/**
	 * Creates and returns the information for the countryAList in the BoardView.
	 * @return a list of Strings to be displayed in the countryAList.
	 */
	public ArrayList<String> getCountryAList() {
	
		list = new ArrayList<String>();
		
		if (deployTurn >= 42) {
		
			for (i = 0; i < currentPlayer.getOwnedCountries().size(); i++) {
				list.add(currentPlayer.getOwnedCountries().get(i).getArmies() + "-" + currentPlayer.getOwnedCountries().get(i).getName());
			}
		} else {
			for (i = 0; i < board.getUnoccupied().size(); i++) {
				list.add(board.getUnoccupied().get(i).getName());
			}
		}
		return list;
	}
	
	/** 
	 * Creates and returns the information for the countryBList in the BoardView.
	 * @return a list of Strings to be displayed in the countryBList.
	 */
	public ArrayList<String> getCountryBList() {
	
		list = new ArrayList<String>();
		
		for (i = 0; i < board.getCountries().size(); i++) {
		
			if (board.checkAdjacency(countryASelection, board.getCountries().get(i).getName())) {
				list.add(board.getCountries().get(i).getArmies() + "-" + board.getCountries().get(i).getName());
			}
		}
		return list;
	}
	
	/**
	 * Receives information on which country is selected in countryAList.
	 * @param country a String of the selected country
	 */
	public void setCountryASelection(String country) {
		countryASelection = country;
		setChanged();
		notifyObservers("countryB");
	}
	
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Parse the selected mapfile into Countries file  
	 * @param filePath
	 */
	public static void parseCountry(String filePath){
  	  
  	  try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
           
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
            	if (str.equals("[Territories]")){
            		while((str = br.readLine()) != null){
            			String[] tokens = str.split(",");
            			CountryName= tokens[0];
            			sb.append(CountryName + "\n"+"\t");
                 
            			//System.out.println(CountryName);
            			}
            		} 
            }

            br.close();
            reader.close();
           
            // write string to file
            FileWriter writerCountry = new FileWriter(countriesFile);
            BufferedWriter bw = new BufferedWriter(writerCountry);
            bw.write(sb.toString());
           
            bw.close();
            writerCountry.close();
      }
      catch(FileNotFoundException e) {
                  e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
  	  
  	  
    }
	
	/**
	 * Parse the selected mapfile into Continents file
	 * @param filePath
	 */
	public static void parseContinents(String filePath){
		/*Firstly, read the map.txt.*/
		List<String> mapContent = ReadWriteFileUtil.read(filePath);
		/* Secondly, get the needed contents.*/
		List<Continent> continents = new ArrayList<>();
		Iterator<String> it = mapContent.iterator();
		while (it.hasNext()) {
			String tmp = it.next().trim();
			if (tmp.equalsIgnoreCase("[Continents]")) {
				while (it.hasNext()) {
					String tmpC = it.next().trim();
					if (tmpC!= "" && tmpC.contains("=")) {
						String nameC = tmpC.split("=")[0];
						int bonus = Integer.parseInt(tmpC.split("=")[1]);
						Continent oneC = new Continent();
						oneC.setName(nameC);
						oneC.setBonusArmies(bonus);
						continents.add(oneC);
					} else {break;}
				}
			} else if (tmp.equalsIgnoreCase("[Territories]")) {
				while (it.hasNext()) {
					String tmpT = it.next().trim();
					if (tmpT != "" && tmpT.contains(",")) {
						String tName = tmpT.split(",")[0];
						String cName = tmpT.split(",")[3];
						for (int i = 0; i < continents.size(); i++) {
							if (cName.equalsIgnoreCase(continents.get(i).getName())) {
								continents.get(i).getMemberCountry().add(tName);
							}
						}
					} else {break;}
				}
			}
		}
		/*Thirdly, write the conyinents.txt file.*/
		String writeString = "";
		for (int i =0; i < continents.size(); i++) {
			Continent node = continents.get(i);
			if (i == 0) {
				writeString += node.getName() + "," + node.getBonusArmies();			
			} else {
				writeString += "\t" + node.getName() + "," + node.getBonusArmies();
			}
			for (String t : node.getMemberCountry()) {
				writeString += "," + t;
			}
			if (i != continents.size() - 1) {
				writeString += "\r\n";
			}
		}
		
		ReadWriteFileUtil.write(continentsFile, writeString);
	
	}
	
	/**
	 * Parse the selected mapfile into Adajencies file
	 * @param filePath
	 */
	public static void parseAdajencies(String filePath){
  	  
  	  try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
           
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
            	if (str.equals("[Territories]")){
            		while((str = br.readLine()) != null){
            			String[] tokens = str.split(",");
            			AdajenciesName= tokens[0];
            			sb.append(AdajenciesName + ",");
            			for(int i = 4; i < tokens.length-1; i++){
            				
            				sb.append(tokens[i] + ",");
    	                  
    	                 }
            			sb.append(tokens[tokens.length-1] + "\n" + "\t");
            			
                 
            			//System.out.println(AdajenciesName);
            			}
            		}  
            }

            br.close();
            reader.close();
           
            // write string to file
            FileWriter writerAdajencies = new FileWriter(adjacenciesFile);
            BufferedWriter bw = new BufferedWriter(writerAdajencies);
            bw.write(sb.toString());
           
            bw.close();
            writerAdajencies.close();
      }
      catch(FileNotFoundException e) {
                  e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
  	  
    }

	
}