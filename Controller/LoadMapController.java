package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import Model.Risk_Model;
import View.LoadMap_View;
import View.PlayerCount_View;

public class LoadMapController implements ActionListener {
	
	private Risk_Model model;
	private LoadMap_View view;
	
	private PlayerCount_View playerCountDialog;
	final JFileChooser fc = new JFileChooser();
	String mapToLoad;
	
	//constructor
	public LoadMapController(Risk_Model model, LoadMap_View view){
		
		System.out.println("Loaded LoadMapController!");
		
		this.model = model;
		this.view = view;
		
		view.addActionListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("LoadMap")) {
			
			System.out.println("Loading LoadMapDialog...");
			int returnVal = fc.showOpenDialog(fc);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            String filePath = fc.getSelectedFile().getPath();
	            mapToLoad = filePath;
	        } else {
	        	
	        }
			model.setMapFilePath(mapToLoad);
			Risk_Model.parseCountry(model.getMapFilePath());
			Risk_Model.parseAdajencies(model.getMapFilePath());
			Risk_Model.parseContinents(model.getMapFilePath());
			System.out.println(mapToLoad);
	        
		}
		else if (actionEvent.equals("Next")) {
			System.out.println("Loading PlayerCountDialog...");
			//Opens the playerCountDialog
			playerCountDialog = new PlayerCount_View(view, true);
			playerCountDialog.addActionListeners(new PlayerCountController(model, playerCountDialog));
			playerCountDialog.setVisible(true);
			
		}
		else if(actionEvent.equals("Back")){
			view.dispose();
		}
		
	}
	
	public String getMapFilePath(){
		return mapToLoad;
		
	}

}
