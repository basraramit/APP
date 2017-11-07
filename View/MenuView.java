package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * This class creates a menu panel allows player save game, pause game and quit.
 * @author yaomeng
 *
 */
public class MenuView extends JDialog {
	
	/** The menu panel. */
	private JPanel menuPanel;
	
	/** The menu layout. */
	private GridLayout menuLayout;
	
	/** The return btn. */
	private JButton returnBtn;
	
	/** The save btn. */
	private JButton saveBtn;
	
	/** The quit btn. */
	private JButton quitBtn;
	
	/** The return btn name. */
	private String returnBtnName = "returnBtn";
	
	/** The save btn name. */
	private String saveBtnName = "saveBtn";
	
	/** The quit btn name. */
	private String quitBtnName = "quitBtn";
	
	/**
	 * Instantiates a new menu view.
	 *
	 * @param view the view
	 * @param modality the modality
	 */
	public MenuView(Board_View view, boolean modality)
	{
		super(view, modality);
		setTitle("Java-Risk");
		
		setPreferredSize(new Dimension(200, 150));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		add(menuPanel());
		
		setLocationRelativeTo(view);
		
		pack();
	}
	
	/**
	 * Menu panel.
	 *
	 * @return the j panel
	 */
	private JPanel menuPanel()
	{
		menuPanel = new JPanel();
		
		menuLayout = new GridLayout(4, 1, 5, 5);
		menuPanel.setLayout(menuLayout);
		
		returnBtn = new JButton("Return to Game");
		saveBtn = new JButton("Save Game");
		quitBtn = new JButton("Quit");
		
		returnBtn.setActionCommand(returnBtnName);
		saveBtn.setActionCommand(saveBtnName);
		quitBtn.setActionCommand(quitBtnName);
		
		menuPanel.add(returnBtn);
		menuPanel.add(saveBtn);
		menuPanel.add(quitBtn);
		
		return menuPanel;
	}
	
	/**
	 * Adds the action listeners. 
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		returnBtn.addActionListener(evt);
		saveBtn.addActionListener(evt);
		quitBtn.addActionListener(evt);
	}
}
