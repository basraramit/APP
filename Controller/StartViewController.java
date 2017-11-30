package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.Risk_Model;
import View.LoadMap_View;
import View.MapEdit_View;
import View.RiskStart_View;
import View.TournamentSetting_View;

// TODO: Auto-generated Javadoc
/**
 * This class maps the user's actions in the Risk View to the data and methods in the model.
 * @author yaomeng
 *
 */
public class StartViewController implements ActionListener {

	/** The view. */
	private RiskStart_View view;
	
	/** The model. */
	private Risk_Model model;
	
	/** The Load map dialog. */
	private LoadMap_View LoadMapDialog;
	
	/** The tournament setting dialog. */
	private TournamentSetting_View tournamentSettingDialog;
	
	/**
	 * Instantiates a new start view controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public StartViewController(Risk_Model model, RiskStart_View view) {
		
		System.out.println("Loaded Risk!");
		
		this.model = model;
		this.view = view;
		//Add this class' actionListener to risk start View's buttons
		view.addActionListeners(this);
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("newGameBtn")) {
		
			System.out.println("Loading PlayerCountDialog...");
			//Opens the playerCountDialog
			LoadMapDialog = new LoadMap_View(view, true);
			LoadMapDialog.addActionListeners(new LoadMapController(model, LoadMapDialog));
			LoadMapDialog.setVisible(true);
		
		}else if (actionEvent.equals("editMapBtn")) {
			MapEdit_View v= new MapEdit_View();
			v.setVisible(true);
			//a.setSize(500,500);
			v.setBounds(250, 250, 400,400);
		}else if (actionEvent.equals("loadSavedBtn")) {
			try{
				model.loadPlayerList();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else if (actionEvent.equals("tournamentBtn")) {
			System.out.println("Loading PlayerCountDialog...");
			tournamentSettingDialog = new TournamentSetting_View(view, true);
			tournamentSettingDialog.addActionListeners(new TournamentSettingController(tournamentSettingDialog));
			tournamentSettingDialog.setVisible(true);
		}else if (actionEvent.equals("quitBtn")) {
			model.quitGame();
		} else {
			System.out.println("Error: " + actionEvent + " actionEvent not found!");
		}
	}
}
