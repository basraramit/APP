package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Map.RiskGame;
import Model.Risk_Model;
import View.PlayerCount_View;
import View.Risk_Start_View;

/**
 * This class maps the user's actions in the Risk View to the data and methods in the model.
 * @author yaomeng
 *
 */
public class Start_View_Controller implements ActionListener {

	private Risk_Start_View view;
	private Risk_Model model;
	private PlayerCount_View playerCountDialog;
	RiskGame a;
	
	public Start_View_Controller(Risk_Model model, Risk_Start_View view) {
		
		System.out.println("Loaded Risk!");
		
		this.model = model;
		this.view = view;
		//Add this class' actionListener to risk start View's buttons
		view.addActionListeners(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("newGameBtn")) {
		
			System.out.println("Loading PlayerCountDialog...");
			//Opens the playerCountDialog
			playerCountDialog = new PlayerCount_View(view, true);
			playerCountDialog.addActionListeners(new PlayerCountController(model, playerCountDialog));
			playerCountDialog.setVisible(true);
		
		}else if (actionEvent.equals("loadGameBtn")) {
			RiskGame a= new RiskGame();
			a.setVisible(true);
			//a.setSize(500,500);
			a.setBounds(250, 250, 400,400);
		}else if (actionEvent.equals("quitBtn")) {
			model.quitGame();
		} else {
			System.out.println("Error: " + actionEvent + " actionEvent not found!");
		}
	}
}
