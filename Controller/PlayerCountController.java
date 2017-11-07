package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Risk_Model;
import View.PlayerCount_View;
import View.PlayerSetting_View;

// TODO: Auto-generated Javadoc
/**
 * This class maps the user's actions in the PlayerCountDialog to the data and methods in 
 * the model.
 */
public class PlayerCountController implements ActionListener {

	/** The model. */
	private Risk_Model model;
	
	/** The view. */
	private PlayerCount_View view;
	
	/** The player settings dialog. */
	private PlayerSetting_View playerSettingsDialog;
	
	/**
	 * Instantiates a new player count controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	//Constructor
	public PlayerCountController(Risk_Model model, PlayerCount_View view)
	{
		System.out.println("Loaded PlayerCountController!");
		
		this.model = model;
		this.view = view;
		
		view.addActionListeners(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
	
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("twoPlayersBtn")) {
		
			model.setPlayerCount(2);
			
			System.out.println("Loading PlayerSettingsDialog...");
			
			playerSettingsDialog = new PlayerSetting_View(view, true, model.getPlayerCount());
			playerSettingsDialog.addActionListeners(new PlayerSettingsController(model, playerSettingsDialog));
			playerSettingsDialog.setVisible(true);
		}
		else if (actionEvent.equals("threePlayersBtn")) {
		
			model.setPlayerCount(3);
			
			System.out.println("Loading PlayerSettingsDialog...");
			
			playerSettingsDialog = new PlayerSetting_View(view, true, model.getPlayerCount());
			playerSettingsDialog.addActionListeners(new PlayerSettingsController(model, playerSettingsDialog));
			playerSettingsDialog.setVisible(true);
		}
		else if (actionEvent.equals("fourPlayersBtn"))
		{
			model.setPlayerCount(4);
			
			System.out.println("Loading PlayerSettingsDialog...");
			
			playerSettingsDialog = new PlayerSetting_View(view, true, model.getPlayerCount());
			playerSettingsDialog.addActionListeners(new PlayerSettingsController(model, playerSettingsDialog));
			playerSettingsDialog.setVisible(true);
		}
		else if (actionEvent.equals("fivePlayersBtn"))
		{
			model.setPlayerCount(5);
			
			System.out.println("Loading PlayerSettingsDialog...");
			
			playerSettingsDialog = new PlayerSetting_View(view, true, model.getPlayerCount());
			playerSettingsDialog.addActionListeners(new PlayerSettingsController(model, playerSettingsDialog));
			playerSettingsDialog.setVisible(true);
		}
		else if (actionEvent.equals("sixPlayersBtn"))
		{
			model.setPlayerCount(6);
			
			System.out.println("Loading PlayerSettingsDialog...");
			
			playerSettingsDialog = new PlayerSetting_View(view, true, model.getPlayerCount());
			playerSettingsDialog.addActionListeners(new PlayerSettingsController(model, playerSettingsDialog));
			playerSettingsDialog.setVisible(true);
		}
		else if (actionEvent.equals("backBtn"))
		{
			view.dispose();
		}
		
		else
		{
			System.out.println("Error: " + actionEvent + " actionEvent not found!");
		}
	}
}
