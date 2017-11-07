package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * This class creates a panel to set the player number.
 *
 * @author yaomeng
 */
public class PlayerCount_View extends JDialog {
	
	/** The player count panel. */
	private JPanel playerCountPanel;
	
	/** The player count layout. */
	private GridLayout playerCountLayout;
	
	/** The player count label. */
	private JLabel playerCountLabel;

	/** The two players btn. */
	private JButton twoPlayersBtn;
	
	/** The three players btn. */
	private JButton threePlayersBtn;
	
	/** The four players btn. */
	private JButton fourPlayersBtn;
	
	/** The five players btn. */
	private JButton fivePlayersBtn;
	
	/** The six players btn. */
	private JButton sixPlayersBtn;
	
	/** The back btn. */
	private JButton backBtn;
	
	/** The two players btn name. */
	private String twoPlayersBtnName = "twoPlayersBtn";
	
	/** The three players btn name. */
	private String threePlayersBtnName = "threePlayersBtn";
	
	/** The four players btn name. */
	private String fourPlayersBtnName = "fourPlayersBtn";
	
	/** The five players btn name. */
	private String fivePlayersBtnName = "fivePlayersBtn";
	
	/** The six players btn name. */
	private String sixPlayersBtnName = "sixPlayersBtn";
	
	/** The back btn name. */
	private String backBtnName = "backBtn";
	
	/**
	 * Constructs the dialog for player count selection.
	 *
	 * @param start_view the start view
	 * @param modality the modality
	 */
	public PlayerCount_View(LoadMap_View start_view, boolean modality)
	{
		super(start_view, modality);
		setTitle("Java-Risk");
		
		setPreferredSize(new Dimension(150, 280));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		add(playerCountPanel());
		
		setLocationRelativeTo(null);
		
		pack();
	}
	
	/**
	 * The player count panel.
	 *
	 * @return the j panel
	 */
	private JPanel playerCountPanel()
	{
		playerCountPanel = new JPanel();
		
		playerCountLayout = new GridLayout(7, 1, 5, 5);
		playerCountPanel.setLayout(playerCountLayout);
		
		playerCountLabel = new JLabel("Number of Players:");
		
		twoPlayersBtn = new JButton("Two");
		threePlayersBtn = new JButton("Three");
		fourPlayersBtn = new JButton("Four");
		fivePlayersBtn = new JButton("Five");
		sixPlayersBtn = new JButton("Six");
		backBtn = new JButton ("Back");
		
		twoPlayersBtn.setActionCommand(twoPlayersBtnName);
		threePlayersBtn.setActionCommand(threePlayersBtnName);
		fourPlayersBtn.setActionCommand(fourPlayersBtnName);
		fivePlayersBtn.setActionCommand(fivePlayersBtnName);
		sixPlayersBtn.setActionCommand(sixPlayersBtnName);
		backBtn.setActionCommand(backBtnName);
		
		playerCountPanel.add(playerCountLabel);
		playerCountPanel.add(twoPlayersBtn);
		playerCountPanel.add(threePlayersBtn);
		playerCountPanel.add(fourPlayersBtn);
		playerCountPanel.add(fivePlayersBtn);
		playerCountPanel.add(sixPlayersBtn);
		playerCountPanel.add(backBtn);
		
		return playerCountPanel;
	}	

	/**
	 * Adds the action listeners.
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		twoPlayersBtn.addActionListener(evt);
		threePlayersBtn.addActionListener(evt);
		fourPlayersBtn.addActionListener(evt);
		fivePlayersBtn.addActionListener(evt);
		sixPlayersBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}

}
