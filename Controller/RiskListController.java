package Controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Risk_Model;
import View.Board_View;

// TODO: Auto-generated Javadoc
/**
 * This class maps the user's actions in RiskList objects to the data and methods in the 
 * model.
 * @author yaomeng
 *
 */
public class RiskListController implements ListSelectionListener {

	/** The model. */
	private Risk_Model model;
	
	/** The view. */
	private Board_View view;
	
	/**
	 * Instantiates a new risk list controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public RiskListController(Risk_Model model, Board_View view) {
		this.model = model;
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
	 */
	public void valueChanged(ListSelectionEvent evt) {
	
		if (evt.getValueIsAdjusting() == true) {
			
			if (view.getCountryAIndex() == -1) {
			
			} else {
				model.setCountryASelection(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			}
		}
	}
}