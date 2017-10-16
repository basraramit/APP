package Controller;

import javax.swing.JFrame;

import Model.Risk_Model;
import View.Risk_Start_View;

/**
 * This class contains the main() method that creates a model, a view, and a controller, passing the
 * model and the view to the controller.
 *
 **/

public class Risk_Main {
	
	public static void main(String[] args) {
		
		Risk_Model model = new Risk_Model();
		Risk_Start_View view = new Risk_Start_View();
		new Start_View_Controller(model, view);
		
		view.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		view.setSize(900,600);
		view.setLocationRelativeTo(null);
		view.setVisible( true );
		
	}

}
