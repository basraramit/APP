package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class creates a menu panel allows player save game, pause game and quit.
 * @author yaomeng
 *
 */
public class MenuView extends JDialog {
	private JPanel menuPanel;
	
	private GridLayout menuLayout;
	
	private JButton returnBtn;
	private JButton saveBtn;
	private JButton quitBtn;
	
	private String returnBtnName = "returnBtn";
	private String saveBtnName = "saveBtn";
	private String quitBtnName = "quitBtn";
	
	public MenuView(Board_View view, boolean modality)
	{
		super(view, modality);
		setTitle("Java-Risk");
		
		setPreferredSize(new Dimension(200, 120));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		add(menuPanel());
		
		setLocationRelativeTo(view);
		
		pack();
	}
	
	private JPanel menuPanel()
	{
		menuPanel = new JPanel();
		
		menuLayout = new GridLayout(3, 1, 5, 5);
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
	 * @param evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		returnBtn.addActionListener(evt);
		saveBtn.addActionListener(evt);
		quitBtn.addActionListener(evt);
	}
}
