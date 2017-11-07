package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Risk_Model;
import View.MenuView;

// TODO: Auto-generated Javadoc
/**
 * This class maps the user's actions in the MenuDialog to the data and methods in the model.
 *
 * @author yaomeng
 */
public class MenuController implements ActionListener {

	/** The model. */
	private Risk_Model model;
	
	/** The view. */
	private MenuView view;
	
	
	/**
	 * Instantiates a new menu controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public MenuController(Risk_Model model, MenuView view) {
	
		this.model = model;
		this.view = view;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
	
		String actionEvent = evt.getActionCommand();
	
		if (actionEvent.equals("returnBtn")) {
			view.dispose();	
		} else if (actionEvent.equals("saveBtn")) {
		
		} else if (actionEvent.equals("quitBtn")) {
			model.quitGame();
		}else {
			System.out.println("actionEvent not found: " + actionEvent);
		}
	}
}