package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Risk_Model;
import View.Board_View;
import View.MenuView;

// TODO: Auto-generated Javadoc
/**
 * This class maps the user's actions in the BoardView to the data and methods in the model.
 * @author yaomeng
 *
 */
public class BoardViewController implements ActionListener {

	/** The model. */
	private Risk_Model model;
	
	/** The view. */
	private Board_View view;
	
	/** The menu dialog. */
	private MenuView menuDialog;
	
	/**
	 * Instantiates a new board view controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public BoardViewController(Risk_Model model, Board_View view) {		
		this.model = model;
		this.view = view;
		model.startGame();
		view.update(model, model.state);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
			view.update(model, model.state);
		} else if (actionEvent.equals("reinforceBtn")) {
			//System.out.println("User pressed reinforceButton.");view.getSelectedComboBox();
			//int army = Integer.parseInt(JOptionPane.showInputDialog("How many armies u want to sent to reinforce ?"));
			//model.setArmy(army);
			model.reinforce(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			view.update(model, model.state);
		} else if (actionEvent.equals("attackBtn")) {
			//int aDice = Integer.parseInt(JOptionPane.showInputDialog("Owner of " + view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", "") + " are attacking ! How many dice will you roll?"));
			//int dDice = Integer.parseInt(JOptionPane.showInputDialog("Owner of " + view.getCountryB().replaceAll("[0-9]", "").replaceAll("\\-", "") + " you are attacked ! How many dice will you roll?"));
			//model.setAttackDice(aDice);
			//model.setDefenderDice(dDice);
			model.attack(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""), view.getCountryB().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			view.update(model, model.state);
		} else if (actionEvent.equals("fortifyBtn")) {
			//System.out.println("User pressed fortifyButton.");
			//int army = Integer.parseInt(JOptionPane.showInputDialog("How many armies u want to fortify ?"));
			//model.setArmy(army);
			model.fortify(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""), view.getCountryB().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			view.update(model, model.state);
		} else if (actionEvent.equals("endTurnBtn")) {
			model.nextPlayer();
			view.update(model, model.state);
		}else if(actionEvent.equals("skipAttackBtn")){
			model.skipAttack();
			view.update(model, model.state);
		}else {
			System.out.println("actionEvent not found: " + actionEvent);
		}
	}
}