package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates a panel to set the player number
 * @author yaomeng
 *
 */
public class PlayerCount_View extends JDialog {
	
	private JPanel playerCountPanel;
	
	private GridLayout playerCountLayout;
	
	private JLabel playerCountLabel;

	private JButton twoPlayersBtn;
	private JButton threePlayersBtn;
	private JButton fourPlayersBtn;
	private JButton fivePlayersBtn;
	private JButton sixPlayersBtn;
	private JButton backBtn;
	
	private String twoPlayersBtnName = "twoPlayersBtn";
	private String threePlayersBtnName = "threePlayersBtn";
	private String fourPlayersBtnName = "fourPlayersBtn";
	private String fivePlayersBtnName = "fivePlayersBtn";
	private String sixPlayersBtnName = "sixPlayersBtn";
	private String backBtnName = "backBtn";
	
	/**
	 * Constructs the dialog for player count selection.
	 * @param start_view
	 * @param modality
	 */
	public PlayerCount_View(Risk_Start_View start_view, boolean modality)
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
	 * @return
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
	 * @param evt
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
