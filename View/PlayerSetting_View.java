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

/**
 * This class creates a panel to set the player name
 * @author yaomeng
 *
 */
public class PlayerSetting_View extends JDialog {
	
	private JPanel textPanel;
	private JPanel playerNamesPanel;
	
	private GridLayout mainLayout;
	private GridLayout playerNamesLayout;
	private GridLayout textLayout;
	
	private JButton startBtn;
	private JButton backBtn;
	
	private String startBtnName = "startBtn";
	private String backBtnName = "backBtn";
	
	private JTextField player1TextField;
	private JTextField player2TextField;
	private JTextField player3TextField;
	private JTextField player4TextField;
	private JTextField player5TextField;
	private JTextField player6TextField;
	
	private int playerCount;
	
	/**
	 * Constructs the dialog for typing in player's name.
	 * @param view
	 * @param modality
	 * @param playerCount
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
	 * player name panel
	 * @return
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
	 * @param evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		startBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}
	
	/**
	 * Get methods for text fields
	 * @param playerNum
	 * @return
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
