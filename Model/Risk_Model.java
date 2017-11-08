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

// TODO: Auto-generated Javadoc
/**
 * This class is the model for the Risk program.
 * It contains the data, methods, and functions that are required to manipulate the data of 
 * the Risk Game.
 * @author yaome
 *
 */
public class Risk_Model extends Observable {

	/** The Country name. */
	private static String CountryName;
	
	/** The Adajencies name. */
	private static String AdajenciesName;
	
	/** The can turn in cards. */
	public boolean canTurnInCards;
	
	/** The can reinforce. */
	public boolean canReinforce;
	
	/** The can fortify. */
	public boolean canFortify;
	
	/** The deploy phase. */
	public boolean deployPhase;
	
	/** The deployed. */
	public boolean deployed;
	
	/** The is int. */
	public boolean isInt;
	
	/** The is loaded. */
	public boolean isLoaded;
	
	/** The i. */
	public int i;
	
	/** The player count. */
	public int playerCount;
	
	/** The player index. */
	public int playerIndex;
	
	/** The deploy turn. */
	public int deployTurn;
	
	/** The no armies count. */
	public int noArmiesCount;
	
	/** The turn in count. */
	public int turnInCount;
	
	/** The armies. */
	public int armies;
	
	/** The countries file. */
	public static String countriesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countries.txt";
	
	/** The continents file. */
	public static String continentsFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/continents.txt";
	
	/** The adjacencies file. */
	public static String adjacenciesFile = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/adajencies.txt";
	
	/** The line. */
	public String line;
	
	/** The input. */
	public String input;
	
	/** The country A selection. */
	public String countryASelection;
	
	/** The map to load. */
	public String mapToLoad;
	
	/** The countries array. */
	public String[] countriesArray;
	
	/** The continents array. */
	public String[] continentsArray;
	
	/** The adjacencies array. */
	public String[] adjacenciesArray;
	
	/** The list. */
	public ArrayList<String> list;
	
	/** The players. */
	public ArrayList<Player> players;
	
	/** The string builder. */
	public StringBuilder stringBuilder;
	
	/** The reader. */
	public BufferedReader reader;
	
	/** The board. */
	public Board board;
	
	/** The deck. */
	public Deck deck;
	
	/** The current player. */
	public Player currentPlayer;
	
	/** The country A. */
	public Country countryA;
	
	/** The country B. */
	public Country countryB;
	
	/** The countries. */
	public Country[] countries;
	
	/** The player. */
	public Player[] player;

	/** The can attack. */
	public boolean canAttack;

	/** The dice. */
	private Dice dice;

	/** The attacker losses. */
	private int attackerLosses;

	/** The defender losses. */
	private int defenderLosses;

	/** The attacker dice. */
	private int attackerDice;

	/** The defender dice. */
	private int defenderDice;

	/** The attacker rolls. */
	private int[] attackerRolls;

	/** The defender rolls. */
	private int[] defenderRolls;

	/** The state. */
	public String state;
	
	
	/**
	 * This is the constructor for the RiskModel object.
	 */
	public Risk_Model() {
		super();
	}
	
	/**
	 * Save game.
	 */
	public void saveGame() {
	
	}
	
	/**
	 * This method handles exiting the game.
	 */
	public void quitGame() {
		System.exit(0);
	}
	
	/**
	 * set the map file path.
	 *
	 * @param mapToLoad the new map file path
	 */
	public void setMapFilePath(String mapToLoad) {
		this.mapToLoad = mapToLoad;
	}
	
	/**
	 * get the map's file path.
	 *
	 * @return the map file path
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
	 *
	 * @param playerNames is an ArrayList of the player names.
	 * @return true if the game was successfully initialized
	 * @throws FileNotFoundException the file not found exception
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
			canAttack = false;
			canFortify = false;
			setState("Place Army");
			
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
		
		Collections.shuffle(board.countriesList);
		for (i = 0; i < board.countriesList.size(); i++){
			board.countriesList.get(i).setOccupant(players.get(i % (players.size())));
			players.get(i % (players.size())).addCountry(board.countriesList.get(i));
		}
		setChanged();
		notifyObservers("player");
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
				setState("Place Army");
				setChanged();
				notifyObservers("cards");
				
			} else {
				setState("Place Army");
				System.out.println("You must trade in three cards of the same type or one of each three types.");
			}			
		} else {
			setState("Place Army");
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
			if (currentPlayer.equals(countryA.getOccupant())) {
			// If countryA is occupied by player or unoccupied
				if (deployTurn >= countriesArray.length) {
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
								canAttack = true;
								//canFortify = true;
								setState("Attack");
							}
						} else {
							System.out.println("You do not have enough armies to reinforce " + countryAName + " with " + armies + " armies.\nReinforcements available: " + currentPlayer.getArmies());
						}
					}
				} else if (countryA.getArmies() == 0) {
				// If there are remaining countries to claim, makes sure country is unoccupied
					//countryA.setOccupant(currentPlayer);
					//currentPlayer.addCountry(countryA);
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
	 * Handles the attack function.
	 * Attacking allows the player to engage in battles, with outcomes decided by RNG, with
	 * opposing players in order to lower the number of armies in a territory to 0 in order
	 * to occupy it.
	 *
	 * @param countryAName the country A name
	 * @param countryBName the country B name
	 */
	public void attack(String countryAName, String countryBName) {
	
		int count = 0;
		countryA = board.getCountryByName(countryAName);
		countryB = board.getCountryByName(countryBName);
		
		if (canAttack == true) {
			setState("Attack");
			if (!currentPlayer.equals(countryB.getOccupant())) {
			// Check if countryB is occupied by an opponent
				if (board.checkAdjacency(countryA.getName(), countryB.getName()) == true) {
				// Check if countryA is adjacent to countryB
				
					dice = new Dice();
					
					// Set default values
					attackerLosses = 0;
					defenderLosses = 0;
					attackerDice = 1;
					defenderDice = 1;
					isInt = false;
					
					
					// If current player is Human
					try {
					// Attacker chooses how many dice to roll
							
						attackerDice = Integer.parseInt(JOptionPane.showInputDialog(countryA.getOccupant().getName() + ", you are attacking " + countryAName + " from " + countryBName + "! How many dice will you roll?"));
							
						if (attackerDice < 1 || attackerDice > 3 || attackerDice >= countryA.getArmies()) {
							throw new IllegalArgumentException();
						}
						isInt = true;
							
					} catch (NumberFormatException e) {
						// Error: attacker inputs non-integer
						System.out.println("Commander, please take this seriously. We are at war.");
							
					} catch (IllegalArgumentException e) {
						// Error: attacker inputs invalid number of dice
						System.out.println("Roll 1, 2 or 3 dice. You must have at least one more army in your country than the number of dice you roll.");
					}
					
					if (isInt == true) {
						attackerRolls = dice.roll(attackerDice);
						for(int i = 0; i < attackerRolls.length; i++){
							System.out.println("the Attacker's dice: " + attackerRolls[i]);
						}
						isInt = false;	
						
						while(isInt == false) {
							try {
								// Defender chooses how many dice to roll after attacker
								defenderDice = Integer.parseInt(JOptionPane.showInputDialog(countryB.getOccupant().getName() + ", you are defending " + countryBName + " from " + countryA.getOccupant().getName() + "! How many dice will you roll?"));
									
								if (defenderDice < 1 || defenderDice > 2 || defenderDice > countryB.getArmies()) {
									throw new IllegalArgumentException();
								}
								isInt = true;
									
							} catch (NumberFormatException e) { 
								// Error: defender inputs non-integer
								System.out.println("Commander, please take this seriously. We are at war.");
									
							} catch (IllegalArgumentException e) {
								// Error: defender inputs invalid number of dice
								System.out.println("Roll either 1 or 2 dice. To roll 2 dice, you must have at least 2 armies on your country.");
							}
						}
						
						if (isInt == true) {
							defenderRolls = dice.roll(defenderDice);
							for(int i = 0; i < defenderRolls.length; i++){
								System.out.println("the Defender's dice: " + defenderRolls[i]);
							}
							// Rolls arrays have been ordered in descending order. Index 0 = highest pair
							if (attackerRolls[attackerRolls.length-1] > defenderRolls[defenderRolls.length-1]) {
								defenderLosses++;
							}
							else {
								attackerLosses++;
							}
							// Index 1 = second highest pair
							if (attackerDice > 1 && defenderDice > 1) {
							
								if (attackerRolls[attackerRolls.length-2] > defenderRolls[attackerRolls.length-2]) {
									defenderLosses++;
									
								} else {
									attackerLosses++;
								}
							}
							// Calculate losses
							System.out.println("<COMBAT REPORT>");
							countryA.decrementArmies(attackerLosses);
							countryB.decrementArmies(defenderLosses);
							
							setChanged();
							notifyObservers("countryA");
							setChanged();
							notifyObservers("countryB");
							
							// If defending country loses all armies
							if (countryB.getArmies() == 0) {
							
								System.out.println("WORLD NEWS: " + countryA.getOccupant().getName() + " has defeated all of " + countryB.getOccupant().getName() + "'s armies in " + countryBName + " and has occupied the country!");
								
								// Remove country from defender's list of occupied territories and adds to attacker's list
								countryB.getOccupant().removeCountry(countryBName);
								countryA.getOccupant().addCountry(countryB);

								// Check if defender is eliminated from game
								if (countryB.getOccupant().getOwnedCountries().size() == 0)	{
									
									System.out.println("WORLD NEWS: " + countryB.getOccupant().getName() + " has surrendered to " + currentPlayer.getName()
											+ " after his last military defeat at " + countryBName + ". " + currentPlayer.getName() + " has issued an execution, with " 
											+ countryB.getOccupant().getName() + " charged as a war criminal.");
									
									players.remove(countryB.getOccupant().getIndex());
								}
								// Set country occupant to attacker
								countryB.setOccupant(countryA.getOccupant());
								
								try {
									// Defender chooses how many dice to roll after attacker
									int moveArmy = Integer.parseInt(JOptionPane.showInputDialog(countryB.getOccupant().getName() + 
											", how many armies do U plan to move to " + countryBName + " from " + countryA.getName() + " ?"));
										
									if (moveArmy >= countryA.getArmies()) {
										throw new IllegalArgumentException();
									}else{
										countryA.decrementArmies(moveArmy);
										countryB.incrementArmies(moveArmy);
										count++;
									}
									if(count > 0){
										currentPlayer.addRiskCard(deck.draw());
									}
								} catch (NumberFormatException e) { 
									// Error: defender inputs non-integer
									System.out.println("Commander, please leave at least 1 army in " + countryA.getName());
										
								} catch (IllegalArgumentException e) {
									// Error: defender inputs invalid number of dice
									System.out.println("Roll either 1 or 2 dice. To roll 2 dice, you must have at least 2 armies on your country.");
								}
								
								setChanged();
								notifyObservers("countryA");
								setChanged();
								notifyObservers("countryB");
								setChanged();
								notifyObservers("player");
								
							}
							canReinforce = false;
						}
					}
				} else {
					System.out.println("Commander, " + countryAName + " is not adjacent to " + countryBName + ".");
				}
			} else {
				System.out.println("Commander, you cannot attack your own territories.");
			}
		} else {
			System.out.println("Commander, our forces are not prepared to launch an attack right now.");
		}
	}
	
	/**
	 * Skip attack.
	 */
	public void skipAttack(){
		setState("Fortify");
		canFortify = true;
	}
	
	/**
	 * Handles the fortify function.
	 * Fortifying allows the player to move armies from one country to another occupied 
	 * country once per turn.
	 *
	 * @param countryAName the country A name
	 * @param countryBName the country B name
	 */
	public void fortify(String countryAName, String countryBName) {	
		//countryAName = JOptionPane.showInputDialog("Move army from:");
		//countryBName = JOptionPane.showInputDialog("Move army to:");
		countryA = board.getCountryByName(countryAName);
		countryB = board.getCountryByName(countryBName);
		
		if (canFortify == true) {
			//setState("Fortification");
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
						
						if (countryA.getArmies() > armies) {
							System.out.println(currentPlayer.getName() + " has chosen to fortify " + countryBName + " with " + armies + " armies from " + countryAName + ".");
							
							countryA.decrementArmies(armies);
							countryB.incrementArmies(armies);
							
							setChanged();
							notifyObservers("countryA");
							setChanged();
							notifyObservers("countryB");
							
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
				canAttack = false;
				canFortify = false;
				playerIndex++;
				
				if (playerIndex >= players.size()) {
				// Loops player index back to 0 when it exceeds the number of players
					playerIndex = 0;
				}
				currentPlayer = players.get(playerIndex);
				noArmiesCount = 0;
				
				for(i = 0; i < players.size(); i++) {
				//
					if (players.get(i).getArmies() == 0) {
						// Used to determine when to end the deploy phase
						noArmiesCount++;
					}
					if (deployPhase == true && noArmiesCount == players.size()) {
						deployPhase = false;
						deployed = true;
						System.out.println("\n=== The Game Play Phase! ===\nWhat to do:\n1. Get new armies by turning in matching cards\n2. Attack and conquer neighbor territories.\n3. End your turn by fortifying a country with armies from another occupied country.\nGood luck, commander!");
					}
				}
				if (deployPhase == false) {
					// If game phase is active
					// Draw card
					System.out.println("\n===" + currentPlayer.getName().toUpperCase() +  "===");
					//currentPlayer.addRiskCard(deck.draw());	
					
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
						setState("TurnInCards");
						
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
						System.out.println("\n===" + currentPlayer.getName().toUpperCase() +  "===\n" + currentPlayer.getName() + "'s turn is ready! (startup Phase)\nReinforcements available: " + currentPlayer.getArmies());
						setChanged();
						notifyObservers("countryA");
						
						canReinforce = true;
						setState("Place Army");
						
					}
				}
			} else {
				System.out.println("Commander, you must place your reinforcements during the reinforcement phase.");
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
		
		for (i = 0; i < currentPlayer.getOwnedCountries().size(); i++) {
			list.add(currentPlayer.getOwnedCountries().get(i).getArmies() + "-" + currentPlayer.getOwnedCountries().get(i).getName());
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
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Parse the selected mapfile into Countries file  .
	 *
	 * @param filePath the file path
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
	 * Parse the selected mapfile into Continents file.
	 *
	 * @param filePath the file path
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
	 * Parse the selected mapfile into Adajencies file.
	 *
	 * @param filePath the file path
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
	
	/**
	 * set the state of current phase.
	 *
	 * @param newState the new state
	 */
	public void setState(String newState){
		this.state = newState;
		setChanged();
		notifyObservers(state);
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState(){
		return state;
	}

	
}