package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Risk_Model;
import View.BoardView;
import View.MenuView;

/**
 * This class maps the user's actions in the BoardView to the data and methods in the model.
 * @author yaomeng
 *
 */
public class BoardViewController implements ActionListener {

	private Risk_Model model;
	private BoardView view;
	private MenuView menuDialog;
	
	public BoardViewController(Risk_Model model, BoardView view) {		
		this.model = model;
		this.view = view;
		model.startGame();
	}
	
	public void actionPerformed(ActionEvent evt) {
	
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("menuBtn")) {
			//System.out.println("User pressed menuButton.");
			menuDialog = new MenuView(view, true);
			menuDialog.addActionListeners(new MenuController(model, menuDialog));
			menuDialog.setVisible(true);
			
		} else if (actionEvent.equals("turnInBtn")) {
			//System.out.println("User pressed turnInButton.");
			model.turnInCards(view.getCardsToRemove());
			
		} else if (actionEvent.equals("reinforceBtn")) {
			//System.out.println("User pressed reinforceButton.");view.getSelectedComboBox();
			model.reinforce(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			
		} else if (actionEvent.equals("attackBtn")) {
			
			System.out.println(" 'Attack' function is not avalible in this build.");
			
		} else if (actionEvent.equals("fortifyBtn")) {
			//System.out.println("User pressed fortifyButton.");
			model.fortify(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""), view.getCountryB().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			
		} else if (actionEvent.equals("endTurnBtn")) {
			model.nextPlayer();
		
		} else {
			System.out.println("actionEvent not found: " + actionEvent);
		}
	}
}