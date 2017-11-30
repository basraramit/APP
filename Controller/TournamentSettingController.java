package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Risk_Model;
import Model.Tournament_Model;
import View.Board_View;
import View.TournamentPlay_View;
import View.TournamentSetting_View;

// TODO: Auto-generated Javadoc
/**
 * The Class TournamentSettingController.
 */
public class TournamentSettingController implements ActionListener{

	/** The selected files. */
	List<String> selectedFiles=new ArrayList<String>();
    
    /** The string builder. */
    StringBuilder stringBuilder = new StringBuilder();
	
	/** The Tournament play view. */
	private TournamentPlay_View TournamentPlayView;
	
	/** The view. */
	private TournamentSetting_View view;

	/**
	 * Instantiates a new tournament setting controller.
	 *
	 * @param view the view
	 */
	public TournamentSettingController(TournamentSetting_View view) {
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand(); 
		if(actionEvent.equals("confirmBtn")){
			TournamentSetting_View.nMaps = (String) TournamentSetting_View.numberOfMap.getSelectedItem();
			int mapNum = Integer.valueOf(TournamentSetting_View.nMaps);
			stringBuilder.append(mapNum + " maps to be loaded.");
			for(int i = 0; i < mapNum; i++){
				String mapPath = JOptionPane.showInputDialog("Please type in the file path of Map " + (i+1));
				selectedFiles.add(mapPath);
				stringBuilder.append("Map File " + i + " : "+ mapPath +"\n");
			}
		}
		if(actionEvent.equals("startBtn")){
			TournamentSetting_View.nTurns = TournamentSetting_View.turns.getText();
			TournamentSetting_View.nGames = (String) TournamentSetting_View.numberOfGame.getSelectedItem();
			int maxTurn =Integer.valueOf(TournamentSetting_View.nTurns);
			int numberOfGames =Integer.valueOf(TournamentSetting_View.nGames);
			stringBuilder.append("Number of Turns :"+ maxTurn +"\n");
			stringBuilder.append("Number of Games :"+ numberOfGames +"\n");
			TournamentPlay_View.displayLog(stringBuilder.toString());
			
			if(maxTurn >= 10 && maxTurn <= 50){
				StringBuilder finalResult =new StringBuilder();
				Tournament_Model tournamentModel = new Tournament_Model(selectedFiles,numberOfGames,maxTurn);
				for (String mapFile : tournamentModel.getMapFiles()){
					Risk_Model model = new Risk_Model();
					Risk_Model.parseCountry(mapFile);
					Risk_Model.parseContinents(mapFile);
					Risk_Model.parseAdajencies(mapFile);
					int currentGame=1;
                    StringBuilder result = new StringBuilder();
                    result.append("=== Map ::"+ mapFile+" ===\n");
                    TournamentPlay_View.displayLog("=== Now Playing for map :" + mapFile + " === \n");
                    for (int i = 1; i <= tournamentModel.getNumberOfGames(); i++){
                    	currentGame=i;
                    	TournamentPlay_View.displayLog("Game"+i+"Starts");
                    	System.out.println("Game"+i+"Starts");
                        try {
							model.initializeGame(tournamentModel.getPlayerNames(),tournamentModel.getPlayerTypes());
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        model.setDrawTurns(tournamentModel.getNumberOfTurns());
                        model.startGame();
                        TournamentPlayView = new TournamentPlay_View();
                        
                        result.append("Game"+ i+"\n");
                        result.append("Result ::"+ model.winner + "\n");
                        TournamentPlayView.setVisible(true);
                        if(model.winner == null){
                        	model.winner = "Draw";
                        }
                        TournamentPlay_View.displayLog("------------------------->Game"+currentGame+"Ends");
                        TournamentPlay_View.displayLog("Results is -->"+result.toString());
                        System.out.println("------------------------->Game"+currentGame+"Ends");
                        System.out.println("Results is -->"+result.toString());
                    }
                    finalResult.append(result);
				}
				TournamentPlay_View.displayLog("All Game Ends \n"+finalResult.toString());
				System.out.println("All Game Ends \n"+finalResult.toString());
			}
			
		}
		
	}

}
