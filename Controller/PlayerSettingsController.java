package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Model.Risk_Model;
import View.BoardView;
import View.PlayerSetting_View;

/**
 * This class maps the user's actions in the PlayerSettingsDialog to the data and methods in 
 * the model.
 */
public class PlayerSettingsController implements ActionListener {
	boolean isLoaded = false;
	private ArrayList<String> playerNames;
	
	private Risk_Model model;
	private PlayerSetting_View view;
	
	public PlayerSettingsController(Risk_Model model, PlayerSetting_View view) {
		System.out.println("Loaded PlayerSettingsController!");
		this.model = model;
		this.view = view;
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand();
		playerNames = new ArrayList<String>();
		
		if (actionEvent.equals("startBtn")) {
		
			System.out.println("Setting up player names and teams...");
			
			playerNames.add(view.getPlayerTextField(1));
			playerNames.add(view.getPlayerTextField(2));
			
			//Gets player names based on playerCount
			if (model.getPlayerCount() > 2) {
				playerNames.add(view.getPlayerTextField(3));
			}
			if (model.getPlayerCount() > 3) {
				playerNames.add(view.getPlayerTextField(4));
			}
			if (model.getPlayerCount() > 4) {
				playerNames.add(view.getPlayerTextField(5));
			}if (model.getPlayerCount() > 5) {
				playerNames.add(view.getPlayerTextField(6));
			}
	
			System.out.println("Initializing game...");
			
			//Initializes values for a new game
			try {
				isLoaded = model.initializeGame(playerNames);
			} catch (FileNotFoundException error) {
				System.out.println(error.getMessage());
			}
			
			//Opens the Risk game board if properly loaded
			if (isLoaded == true) {
				System.out.println("Game setup complete!\nLoading BoardView...");
				
				BoardView boardView = new BoardView(view, true, model);
				boardView.addActionListeners(new BoardViewController(model, boardView), new RiskListController(model, boardView));
				
				// boardView.addListSelectionListeners(new BoardViewListSelectionController(model, boardView));
				boardView.setVisible(true);
			}
			
		} else if (actionEvent.equals("backBtn")) {
			view.dispose();
		
		} else {
			System.out.println("Error: " + actionEvent + " actionEvent not found!");
		}
	}
}