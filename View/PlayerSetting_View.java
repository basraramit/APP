package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * This class creates a panel to set the player name.
 *
 * @author yaomeng
 */
public class PlayerSetting_View extends JDialog {
	
	/** The text panel. */
	private JPanel textPanel;
	
	/** The player names panel. */
	private JPanel playerNamesPanel;
	
	/** The main layout. */
	private GridLayout mainLayout;
	
	/** The player names layout. */
	private GridLayout playerNamesLayout;
	
	/** The text layout. */
	private GridLayout textLayout;
	
	/** The start btn. */
	private JButton startBtn;
	
	/** The back btn. */
	private JButton backBtn;
	
	/** The start btn name. */
	private String startBtnName = "startBtn";
	
	/** The back btn name. */
	private String backBtnName = "backBtn";
	
	/** The player 1 text field. */
	private JTextField player1TextField;
	
	/** The player 2 text field. */
	private JTextField player2TextField;
	
	/** The player 3 text field. */
	private JTextField player3TextField;
	
	/** The player 4 text field. */
	private JTextField player4TextField;
	
	/** The player 5 text field. */
	private JTextField player5TextField;
	
	/** The player 6 text field. */
	private JTextField player6TextField;
	
	/** The player count. */
	private int playerCount;
	
	/**
	 * Constructs the dialog for typing in player's name.
	 *
	 * @param view the view
	 * @param modality the modality
	 * @param playerCount the player count
	 */
	public PlayerSetting_View(PlayerCount_View view, boolean modality, int playerCount)
	{		
		super(view, modality);
		setTitle("Java-Risk");
		
		this.playerCount = playerCount;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		mainLayout = new GridLayout(1, 2, 5, 5); //  Make second parameter '2' if including playerTypesPanel
		setLayout(mainLayout);
				
		add(playerNamesPanel());
		add(textPanel());
		
		setLocationRelativeTo(null);
		
		pack();
	}
	
	/**
	 * player name panel.
	 *
	 * @return the j panel
	 */
	private JPanel playerNamesPanel() {
	
		playerNamesPanel = new JPanel();
		
		playerNamesPanel.setPreferredSize(new Dimension(200, playerCount * 40 + 40));
		
		playerNamesLayout = new GridLayout(playerCount + 1, 1, 5, 5);
		playerNamesPanel.setLayout(playerNamesLayout);
		
		player1TextField = new JTextField("player1");
		player2TextField = new JTextField("player2");
		
		playerNamesPanel.add(player1TextField);
		playerNamesPanel.add(player2TextField);
		
		if (playerCount > 2) {
			player3TextField = new JTextField("player3");
			playerNamesPanel.add(player3TextField);
		}
		if (playerCount > 3) {
			player4TextField = new JTextField("player4");
			playerNamesPanel.add(player4TextField);
		}
		if (playerCount > 4) {
			player5TextField = new JTextField("player5");
			playerNamesPanel.add(player5TextField);
		}
		if (playerCount > 5) {
			player6TextField = new JTextField("player6");
			playerNamesPanel.add(player6TextField);
		}
		
		backBtn = new JButton ("Back");
		backBtn.setActionCommand(backBtnName);
		playerNamesPanel.add(backBtn);
		
		return playerNamesPanel;
	}
	
	/**
	 * Text panel.
	 *
	 * @return the j panel
	 */
	private JPanel textPanel() {

		textPanel = new JPanel();
		
		textPanel.setPreferredSize(new Dimension(200, playerCount * 40 + 40));
		
		textLayout = new GridLayout(playerCount + 1, 1, 5, 5);
		textPanel.setLayout(textLayout);
		
		JLabel label1 = new JLabel("please enter name");
		JLabel label2 = new JLabel("please enter name");
		
		textPanel.add(label1);
		textPanel.add(label2);
		
		if (playerCount > 2) {
			JLabel label3 = new JLabel("please enter name");
			textPanel.add(label3);
		}
		if (playerCount > 3) {
			JLabel label4 = new JLabel("please enter name");
			textPanel.add(label4);
		}
		if (playerCount > 4) {
			JLabel label5 = new JLabel("please enter name");
			textPanel.add(label5);
		}
		if (playerCount > 5) {
			JLabel label6 = new JLabel("please enter name");
			textPanel.add(label6);
		}
		
		startBtn = new JButton ("Start Game");
		
		startBtn.setActionCommand(startBtnName);
		
		textPanel.add(startBtn);

		return textPanel;
	}

	/**
	 * Adds the action listeners.
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		startBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}
	
	/**
	 * Get methods for text fields.
	 *
	 * @param playerNum the player num
	 * @return the player text field
	 */
	public String getPlayerTextField(int playerNum)
	{
		if (playerNum == 1)
		{
			return player1TextField.getText();
		}
		else if (playerNum == 2)
		{
			return player2TextField.getText();
		}
		else if (playerNum == 3)
		{
			return player3TextField.getText();
		}
		else if (playerNum == 4)
		{
			return player4TextField.getText();
		}
		else if (playerNum == 5)
		{
			return player5TextField.getText();
		}
		else
		{
			return player6TextField.getText();
		}
	}

}
