package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.PrintStream;

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
import Model.RiskListModel;
import Model.Risk_Model;
import Model.TextAreaOutputStream;

/**
 * This class creates a panel to play game
 * @author yaomeng
 *
 */
public class BoardView extends JDialog {
	
	public int i;
	
	public JPanel messagePanel;
	public JPanel mapPanel;
	public JPanel actionPanel;
	public JPanel countryInfoPanel;

	public JPanel leftWingPanel;
	public JPanel rightWingPanel;
	public JPanel tailPanel;
	public JPanel enginePanel;
	public JPanel cockpitPanel;
	public JPanel fuselagePanel;
	
	public GridBagConstraints c;
	public GridBagLayout mainLayout;
	public GridBagLayout messageLayout;
	public GridBagLayout actionLayout;
	
	public JLabel selectedLabel;
	public JLabel targetLabel;
	public String menuBtnName = "menuBtn";
	public String reinforceBtnName = "reinforceBtn";
	public String attackBtnName = "attackBtn";
	public String fortifyBtnName = "fortifyBtn";
	public String turnInBtnName = "turnInBtn";
	public String endTurnBtnName = "endTurnBtn";
	
	public JButton menuBtn;
	public JButton reinforceBtn;
	public JButton attackBtn;
	public JButton fortifyBtn;
	public JButton turnInBtn;
	public JButton endTurnBtn;
	
	public JTextArea printTextArea;
	
	public JList<Object> cardsList;
	public JList<Object> countryAList;
	public JList<Object> countryBList;
	
	public JScrollPane mapScrollPane;
	public JScrollPane messageScrollPane;
	public JScrollPane countryBScrollPane;
	public JScrollPane countryAScrollPane;
	
	public DefaultCaret caret;
	
	public ImageIcon mapImageIcon;
	
	public Risk_Model model;
	
	public RiskListModel cardsListModel;
	public RiskListModel countryAListModel;
	public RiskListModel countryBListModel;

	public CountryLabel countryLabel;
	
	/**
	 * Constructs the Risk game board.
	 * @param view
	 * @param modality
	 * @param model
	 */
	public BoardView(PlayerSetting_View view, boolean modality, Risk_Model model) {		
		
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
	
	/**
	 * The panel for the card display and turn-in button.
	 * @return
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
	 * @return
	 */
	public JPanel mapPanel() {
	
		mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(1, 1, 5, 5));
		mapImageIcon = new ImageIcon("C:/Users/yaome/workspace/Risk_Game/StartViewPic.jpg");
		mapScrollPane = new JScrollPane(new JLabel(mapImageIcon));
		mapScrollPane.setPreferredSize(new Dimension(1080, 980));
		mapPanel.add(mapScrollPane);
		return mapPanel;
	}
	
	/**
	 * The panel for the buttons which allow the user to perform actions.
	 * @return
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
		fortifyBtn = new JButton("Fortify");
		endTurnBtn = new JButton("End Turn");
		
		menuBtn.setActionCommand(menuBtnName);
		turnInBtn.setActionCommand(turnInBtnName);
		reinforceBtn.setActionCommand(reinforceBtnName);
		attackBtn.setActionCommand(attackBtnName);
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
		countryAList.setVisibleRowCount(57);
		
		countryBList = new JList<Object>(countryBListModel);
		countryBList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		countryBList.setLayoutOrientation(JList.VERTICAL_WRAP);
		countryBList.setVisibleRowCount(6);
		
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
		actionPanel.add(fortifyBtn, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 11;
		actionPanel.add(endTurnBtn, c);
		
		return actionPanel;
	}
	
	/**
	 * Show the continents and countries' info in this panel
	 * @param board
	 * @return
	 */
	public JPanel countryInfoPanel(Board board) {
		
		countryInfoPanel = new JPanel();
		
		countryInfoPanel.setPreferredSize(new Dimension(320, 980));
		countryInfoPanel.setLayout(new GridBagLayout());
	
		leftWingPanel = new JPanel();
		leftWingPanel.setPreferredSize(new Dimension(320, 100));
		leftWingPanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Kala").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Kala").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			leftWingPanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		rightWingPanel = new JPanel();
		rightWingPanel.setPreferredSize(new Dimension(320, 60));
		rightWingPanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Enevim").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Enevim").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			rightWingPanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		tailPanel = new JPanel();
		tailPanel.setPreferredSize(new Dimension(320, 80));
		tailPanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Nova").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Nova").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			tailPanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		enginePanel = new JPanel();
		enginePanel.setPreferredSize(new Dimension(320, 60));
		enginePanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Barak Los").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Barak Los").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			enginePanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		cockpitPanel = new JPanel();
		cockpitPanel.setPreferredSize(new Dimension(320, 120));
		cockpitPanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Neimaach").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Neimaach").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			cockpitPanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		fuselagePanel = new JPanel();
		fuselagePanel.setPreferredSize(new Dimension(320, 60));
		fuselagePanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		for (i = 0; i < board.getMemberCountries("Barba Moya").size(); i++) {
			countryLabel = new CountryLabel(model, board.getMemberCountries("Barba Moya").get(i));
			countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
			fuselagePanel.add(countryLabel);
			model.addObserver((CountryLabel) countryLabel);
		}
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		countryInfoPanel.add(new JLabel("Left Wing"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		countryInfoPanel.add(leftWingPanel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		countryInfoPanel.add(new JLabel("Right Wing"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		countryInfoPanel.add(rightWingPanel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		countryInfoPanel.add(new JLabel("Tail"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		countryInfoPanel.add(tailPanel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		countryInfoPanel.add(new JLabel("Engine"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 7;
		countryInfoPanel.add(enginePanel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 8;
		countryInfoPanel.add(new JLabel("Cockpit"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 9;
		countryInfoPanel.add(cockpitPanel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 10;
		countryInfoPanel.add(new JLabel("Fuselage"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 11;
		countryInfoPanel.add(fuselagePanel, c);
		
		return countryInfoPanel;
	}
	
	/**
	 * Adds the action listeners for the buttons and lists.
	 * @param evt1
	 * @param evt2
	 */
	public void addActionListeners(ActionListener evt1, ListSelectionListener evt2) {
	
		menuBtn.addActionListener(evt1);
		turnInBtn.addActionListener(evt1);
		reinforceBtn.addActionListener(evt1);
		attackBtn.addActionListener(evt1);
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
}




