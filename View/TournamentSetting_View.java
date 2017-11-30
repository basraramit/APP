package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.TournamentSettingController;

// TODO: Auto-generated Javadoc
/**
 * The Class TournamentSetting_View.
 */
public class TournamentSetting_View extends JDialog{
	
	/** The tournament setting panel. */
	public static JPanel tournamentSettingPanel;
	
	/** The tournament setting layout. */
	public static GridLayout tournamentSettingLayout;
    
    /** The Map label. */
    public static JLabel MapLabel;
    
    /** The confirm button. */
    public static JButton confirmButton;
    
    /** The start button. */
    public static JButton startButton;
    
    /** The Turns label. */
    public static JLabel TurnsLabel;
    
    /** The Games label. */
    public static JLabel GamesLabel;
    
    /** The turns. */
    public static JTextField turns;
    
    /** The number of map. */
    public static JComboBox <String> numberOfMap;
    
    /** The number of game. */
    public static JComboBox <String> numberOfGame;
    
    /** The n maps. */
    public static String nMaps;
    
    /** The n turns. */
    public static String nTurns;
	
	/** The n games. */
	public static String nGames;
	
	/** The maps. */
	public static String[] maps;
	
	/** The games. */
	public static String[] games;
	
	/**
	 * Instantiates a new tournament setting view.
	 *
	 * @param start_view the start view
	 * @param modality the modality
	 */
	public TournamentSetting_View(RiskStart_View start_view, boolean modality)
	{
		setTitle("Setting Tournament Mode");
        setPreferredSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        add(tournamentSettingPanel());
        setLocationRelativeTo(null);
        pack();
	}

	/**
	 * Tournament setting panel.
	 *
	 * @return the j panel
	 */
	private JPanel tournamentSettingPanel() {
		tournamentSettingPanel = new JPanel();
		tournamentSettingLayout = new GridLayout();
		
		MapLabel = new JLabel("Select the number of Maps :");
		maps = new String[] {"1","2","3","4","5"};
		numberOfMap = new JComboBox<>(maps);
		confirmButton = new JButton("Confirm");
		confirmButton.setActionCommand("confirmBtn");
		
		TurnsLabel = new JLabel("Number of turns(10-50):");
		turns = new JTextField(3);
		
		GamesLabel = new JLabel("Number of Games :");
		games = new String[] {"1","2","3","4"};
		numberOfGame = new JComboBox<>(games);
		
		startButton = new JButton("Start");
		startButton.setActionCommand("startBtn");
		
		tournamentSettingPanel.add(MapLabel);
		tournamentSettingPanel.add(numberOfMap);
		tournamentSettingPanel.add(confirmButton);
		tournamentSettingPanel.add(TurnsLabel);
		tournamentSettingPanel.add(turns);
		tournamentSettingPanel.add(GamesLabel);
		tournamentSettingPanel.add(numberOfGame);
		tournamentSettingPanel.add(startButton);

		return tournamentSettingPanel;
	}
	
	/**
	 * Adds the action listeners.
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		confirmButton.addActionListener(evt);
		startButton.addActionListener(evt);
	}


}
