package Controller;

import javax.swing.JFrame;

import Model.Risk_Model;
import View.RiskStart_View;

// TODO: Auto-generated Javadoc
/**
 * This class contains the main() method that creates a model, a view, and a controller, passing the
 * model and the view to the controller.
 *
 **/

public class Risk_Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Risk_Model model = new Risk_Model();
		RiskStart_View view = new RiskStart_View();
		new StartViewController(model, view);
		
		view.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		view.setSize(900,600);
		view.setLocationRelativeTo(null);
		view.setVisible( true );
		
	}

}
