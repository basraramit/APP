package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;

import Model.Board;
import Model.CountryLabel;
import Model.PlayerLabel;
import Model.RiskListModel;
import Model.Risk_Model;
import Model.TextAreaOutputStream;

// TODO: Auto-generated Javadoc
/**
 * This class creates a panel to play game.
 *
 * @author yaomeng
 */
public class Board_View extends JDialog implements Observer{
	
	/** The i. */
	public int i;
	
	/** The message panel. */
	public JPanel messagePanel;
	
	/** The map panel. */
	public JPanel mapPanel;
	
	/** The action panel. */
	public JPanel actionPanel;
	
	/** The country info panel. */
	public JPanel countryInfoPanel;
	
	/** The c. */
	public GridBagConstraints c;
	
	/** The main layout. */
	public GridBagLayout mainLayout;
	
	/** The message layout. */
	public GridBagLayout messageLayout;
	
	/** The action layout. */
	public GridBagLayout actionLayout;
	
	/** The selected label. */
	public JLabel selectedLabel;
	
	/** The target label. */
	public JLabel targetLabel;
	
	/** The menu btn name. */
	public String menuBtnName = "menuBtn";
	
	/** The reinforce btn name. */
	public String reinforceBtnName = "reinforceBtn";
	
	/** The attack btn name. */
	public String attackBtnName = "attackBtn";
	
	/** The skip attack btn name. */
	private String skipAttackBtnName = "skipAttackBtn";
	
	/** The fortify btn name. */
	public String fortifyBtnName = "fortifyBtn";
	
	/** The turn in btn name. */
	public String turnInBtnName = "turnInBtn";
	
	/** The end turn btn name. */
	public String endTurnBtnName = "endTurnBtn";
	
	/** The menu btn. */
	public JButton menuBtn;
	
	/** The reinforce btn. */
	public JButton reinforceBtn;
	
	/** The attack btn. */
	public JButton attackBtn;
	
	/** The Skip attack btn. */
	public JButton skipAttackBtn;
	
	/** The fortify btn. */
	public JButton fortifyBtn;
	
	/** The turn in btn. */
	public JButton turnInBtn;
	
	/** The end turn btn. */
	public JButton endTurnBtn;
	
	/** The print text area. */
	public JTextArea printTextArea;
	
	/** The cards list. */
	public JList<Object> cardsList;
	
	/** The country A list. */
	public JList<Object> countryAList;
	
	/** The country B list. */
	public JList<Object> countryBList;
	
	/** The map scroll pane. */
	public JScrollPane mapScrollPane;
	
	/** The message scroll pane. */
	public JScrollPane messageScrollPane;
	
	/** The country B scroll pane. */
	public JScrollPane countryBScrollPane;
	
	/** The country A scroll pane. */
	public JScrollPane countryAScrollPane;
	
	/** The caret. */
	public DefaultCaret caret;
	
	/** The map image icon. */
	public ImageIcon mapImageIcon;
	
	/** The model. */
	public Risk_Model model;
	
	/** The cards list model. */
	public RiskListModel cardsListModel;
	
	/** The country A list model. */
	public RiskListModel countryAListModel;
	
	/** The country B list model. */
	public RiskListModel countryBListModel;

	/** The country label. */
	public CountryLabel countryLabel;

	/** The j. */
	private int j;

	/** The player label. */
	private PlayerLabel playerLabel;

	
	/**
	 * Constructs the Risk game board.
	 *
	 * @param view the view
	 * @param modality the modality
	 * @param model the model
	 */
	public Board_View(PlayerSetting_View view, boolean modality, Risk_Model model) {		
		
		super(view, modality);
		setTitle("Java-Risk");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		this.model = model;
		
		//  GridBagLayout allows a flexible sizing of components
		mainLayout = new GridBagLayout();
		setLayout(mainLayout);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		add(messagePanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 8;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		add(mapPanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(actionPanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(countryInfoPanel(model.getBoard()));
		
		setLocationRelativeTo(null);
		
		pack();
	}
	
	public Board_View(Risk_Model model) throws IOException {
		setTitle("Java-Risk-Tournament Mode");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		//  GridBagLayout allows a flexible sizing of components
		mainLayout = new GridBagLayout();
		setLayout(mainLayout);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		add(messagePanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 8;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		add(mapPanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(actionPanel());
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(countryInfoPanel(model.getBoard()));
		
		setLocationRelativeTo(null);
		
		pack();
	}

	/**
	 * The panel for the card display and turn-in button.
	 *
	 * @return the j panel
	 */
	public JPanel messagePanel() {
	
		messagePanel = new JPanel();
		messagePanel.setPreferredSize(new Dimension(300, 980));
		messageLayout = new GridBagLayout();
		messagePanel.setLayout(messageLayout);
		
		c = new GridBagConstraints();
		
		printTextArea = new JTextArea();
		System.setOut(new PrintStream(new TextAreaOutputStream(printTextArea)));
		printTextArea.setFocusable(false);
		printTextArea.setLineWrap(true);
		printTextArea.setWrapStyleWord(true);
		caret = (DefaultCaret)printTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		messageScrollPane = new JScrollPane(printTextArea);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 14;
		c.gridx = 0;
		c.gridy = 0;
		messagePanel.add(messageScrollPane, c);
		
		return messagePanel;
	}
	
	/**
	 * The panel containing the scrollable Risk map image.
	 *
	 * @return the j panel
	 */
	public JPanel mapPanel() {
	
		mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(1, 1, 5, 5));
		mapImageIcon = new ImageIcon("C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countryMap.png");
		mapScrollPane = new JScrollPane(new JLabel(mapImageIcon));
		mapScrollPane.setPreferredSize(new Dimension(1080, 980));
		mapPanel.add(mapScrollPane);
		
		return mapPanel;
	}
	
	/**
	 * The panel for the buttons which allow the user to perform actions.
	 *
	 * @return the j panel
	 */
	@SuppressWarnings("unchecked")
	public JPanel actionPanel() {
	
		actionPanel = new JPanel();
		
		actionPanel.setPreferredSize(new Dimension(200, 980));
		
		actionLayout = new GridBagLayout();
		actionPanel.setLayout(actionLayout);
		
		selectedLabel = new JLabel("Selected Country:");
		targetLabel = new JLabel("Adjacent Country:");
		
		menuBtn = new JButton("Menu");
		turnInBtn = new JButton("Turn In Cards");
		reinforceBtn = new JButton("Place Reinforcements");
		attackBtn = new JButton("Attack!");
		skipAttackBtn = new JButton("Skip Attack");
		fortifyBtn = new JButton("Fortify");
		endTurnBtn = new JButton("End Turn");
		
		menuBtn.setActionCommand(menuBtnName);
		turnInBtn.setActionCommand(turnInBtnName);
		reinforceBtn.setActionCommand(reinforceBtnName);
		attackBtn.setActionCommand(attackBtnName);
		skipAttackBtn.setActionCommand(skipAttackBtnName );
		fortifyBtn.setActionCommand(fortifyBtnName);
		endTurnBtn.setActionCommand(endTurnBtnName);
		
		cardsListModel = new RiskListModel(model, "cards");
		countryAListModel = new RiskListModel(model, "countryA");
		countryBListModel = new RiskListModel(model, "countryB");
		
		model.addObserver((RiskListModel)cardsListModel);
		model.addObserver((RiskListModel)countryAListModel);
		model.addObserver((RiskListModel)countryBListModel);
		
		cardsList = new JList<Object>(cardsListModel);
		cardsList.setLayoutOrientation(JList.VERTICAL_WRAP);
		cardsList.setVisibleRowCount(6);
		
		countryAList = new JList<Object>(countryAListModel);
		countryAList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		countryAList.setLayoutOrientation(JList.VERTICAL_WRAP);
		countryAList.setVisibleRowCount(21);
		
		countryBList = new JList<Object>(countryBListModel);
		countryBList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		countryBList.setLayoutOrientation(JList.VERTICAL_WRAP);
		countryBList.setVisibleRowCount(10);
		
		countryAScrollPane = new JScrollPane(countryAList);
		countryBScrollPane = new JScrollPane(countryBList);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		actionPanel.add(menuBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 5;
		c.gridx = 0;
		c.gridy = 2;
		actionPanel.add(cardsList, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		actionPanel.add(turnInBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		actionPanel.add(selectedLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 5;
		actionPanel.add(countryAScrollPane, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		actionPanel.add(reinforceBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 7;
		actionPanel.add(targetLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 8;
		actionPanel.add(countryBScrollPane, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 9;
		actionPanel.add(attackBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 10;
		actionPanel.add(skipAttackBtn, c);

		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 11;
		actionPanel.add(fortifyBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 12;
		actionPanel.add(endTurnBtn, c);
		
		return actionPanel;
	}
	
	/**
	 * Show the continents and countries' info in this panel.
	 *
	 * @param board the board
	 * @return the j panel
	 */
	public JPanel countryInfoPanel(Board board) {
		countryInfoPanel = new JPanel();
		countryInfoPanel.setPreferredSize(new Dimension(320, 980));
		countryInfoPanel.setLayout(new GridBagLayout());
		
		for(i = 0; i < board.getContinents().size(); i++){
			JPanel continentPanel = new JPanel();
			continentPanel.setPreferredSize(new Dimension(320, 100));
			continentPanel.setLayout(new GridLayout(6, 2, 3, 3));
			
			for (j = 0; j < board.getMemberCountries(board.getContinents().get(i).getName()).size(); j++) {
				countryLabel = new CountryLabel(model, board.getMemberCountries(board.getContinents().get(i).getName()).get(j));
				countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
				continentPanel.add(countryLabel);
				model.addObserver((CountryLabel) countryLabel);
				
			}
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(5, 5, 5, 5);
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.gridx = 0;
			c.gridy = 2 * i;
			countryInfoPanel.add(new JLabel(board.getContinents().get(i).getName()), c);
			
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(5, 5, 5, 5);
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.gridx = 0;
			c.gridy = 2 * i + 1;
			countryInfoPanel.add(continentPanel, c);
		}
		for(int n = 0; n < model.players.size(); n++){
			playerLabel = new PlayerLabel(model, model.players.get(n));
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(5, 5, 5, 5);
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.gridx = 0;
			c.gridy = 15+n;
			countryInfoPanel.add(playerLabel,c);
			model.addObserver((PlayerLabel)playerLabel);
		}
		
		return countryInfoPanel;
	}
	
	/**
	 * Adds the action listeners for the buttons and lists.
	 *
	 * @param evt1 the evt 1
	 * @param evt2 the evt 2
	 */
	public void addActionListeners(ActionListener evt1, ListSelectionListener evt2) {
	
		menuBtn.addActionListener(evt1);
		turnInBtn.addActionListener(evt1);
		reinforceBtn.addActionListener(evt1);
		attackBtn.addActionListener(evt1);
		skipAttackBtn.addActionListener(evt1);
		fortifyBtn.addActionListener(evt1);
		endTurnBtn.addActionListener(evt1);
		
		countryAList.addListSelectionListener(evt2);
	}
	
	/**
	 * Used for adjusting the country B list according to the country A selecion.
	 * @return the integer of the selected index in the country A list.
	 */
	public int getCountryAIndex() {
		return countryAList.getSelectedIndex();
	}
	
	/**
	 * Passes the indices of the cards to remove from the current player's hand.
	 * @return the array of selected indices in the cards list.
	 */
	public int[] getCardsToRemove() {
		return cardsList.getSelectedIndices();
	}
	
	/**
	 * Passes countryA for the model.
	 * @return the String of the selected value in country A list.
	 */
	public String getCountryA() {
		return countryAList.getSelectedValue().toString();
	}
	
	/**
	 * Passes countryB for the model.
	 * @return the String of the selected value in country B list.
	 */
	public String getCountryB() {
		return countryBList.getSelectedValue().toString();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object state) {
		if(state == this.model.getState()){
			 System.out.println( "In update of Player Turn View" );
             
	         String subViewName = this.model.getState();

             System.out.println( "Current Phase of the Player : " + subViewName );
		
             if(state.equals("TurnInCards")){
            	 this.cardsList.setVisible(true);
            	 this.turnInBtn.setVisible(true);
            	 this.countryAList.setVisible(false);
            	 this.countryBList.setVisible(false);
            	 this.reinforceBtn.setVisible(false);
            	 this.attackBtn.setVisible(false);
            	 this.skipAttackBtn.setVisible(false);
            	 this.fortifyBtn.setVisible(false);
             }else if(state.equals("Place Army")){
            	 this.cardsList.setVisible(false);
            	 this.turnInBtn.setVisible(false);
            	 this.countryAList.setVisible(true);
            	 this.countryBList.setVisible(true);
            	 this.reinforceBtn.setVisible(true);
            	 this.attackBtn.setVisible(false);
            	 this.skipAttackBtn.setVisible(false);
            	 this.fortifyBtn.setVisible(false);
             }else if(state.equals("Attack")){
            	 this.countryAList.setVisible(true);
            	 this.countryBList.setVisible(true);
            	 this.attackBtn.setVisible(true);
            	 this.skipAttackBtn.setVisible(true);
            	 this.fortifyBtn.setVisible(false);
            	 this.cardsList.setVisible(false);
            	 this.turnInBtn.setVisible(false);
            	 this.reinforceBtn.setVisible(false);
             }else if(state.equals("Fortify")){
            	 this.countryAList.setVisible(true);
            	 this.countryBList.setVisible(true);
            	 this.attackBtn.setVisible(false);
            	 this.skipAttackBtn.setVisible(false);
            	 this.fortifyBtn.setVisible(true);
            	 this.cardsList.setVisible(false);
            	 this.turnInBtn.setVisible(false);
            	 this.reinforceBtn.setVisible(false);
             }else if(state.equals("endGame")){
            	 this.countryAList.setVisible(false);
            	 this.countryBList.setVisible(false);
            	 this.attackBtn.setVisible(false);
            	 this.skipAttackBtn.setVisible(false);
            	 this.fortifyBtn.setVisible(false);
            	 this.cardsList.setVisible(false);
            	 this.turnInBtn.setVisible(false);
            	 this.reinforceBtn.setVisible(false);
            	 System.out.println("This Risk Game is Over ! The Winner is " + model.currentPlayer.getName());
             }
		}
	}

	
	
}




