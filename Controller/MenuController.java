package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Risk_Model;
import View.MenuView;

/**
 * This class maps the user's actions in the MenuDialog to the data and methods in the model
 * @author yaomeng
 *
 */
public class MenuController implements ActionListener {

	private Risk_Model model;
	private MenuView view;
	
	public MenuController(Risk_Model model, MenuView view) {
	
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent evt) {
	
		String actionEvent = evt.getActionCommand();
	
		if (actionEvent.equals("returnBtn")) {
			view.dispose();
			
		} else if (actionEvent.equals("saveBtn")) {
		
		} else if (actionEvent.equals("quitBtn")) {
			model.quitGame();
			
		} else {
			System.out.println("actionEvent not found: " + actionEvent);
		}
	}
}