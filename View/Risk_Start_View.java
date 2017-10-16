package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;

/**
 * These classes set up the start GUI of the Risk program.
 * @author yaomeng
 *
 */


public class Risk_Start_View extends JFrame{
	
	private JPanel buttonPanel;
	
	private ImageComponent imageComponent;
	private Images welcomePic;
	
	private JButton newGameButton;
	private JButton loadGameButton;
	private JButton quitButton;
	
	/**
	 * Constructs the start menu.
	 */
	public Risk_Start_View(){

		welcomePic = new Images("C:/Users/yaome/workspace/Risk_Game/StartViewPic.jpg");
		imageComponent = new ImageComponent(welcomePic.getImage(900,500));
		
		// BorderLayout for the Start View
		setLayout( new BorderLayout());
		
		// FlowLayout for the ButtonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		newGameButton = new JButton("New Game");
		newGameButton.setPreferredSize(new Dimension(150,40));
		buttonPanel.add(newGameButton);
		buttonPanel.add( Box.createRigidArea(new Dimension(10,0)));
		loadGameButton = new JButton("Load Saved Game");
		loadGameButton.setPreferredSize(new Dimension(150,40));
		buttonPanel.add(loadGameButton);
		buttonPanel.add( Box.createRigidArea(new Dimension(10,0)));
		quitButton = new JButton("Quit Game");
		quitButton.setPreferredSize(new Dimension(150,40));
		buttonPanel.add(quitButton);
		
		// Sets button commands
		newGameButton.setActionCommand("newGameBtn");
		loadGameButton.setActionCommand("loadGameBtn");
		quitButton.setActionCommand("quitBtn");

		add(buttonPanel,BorderLayout.SOUTH);
		add(imageComponent,BorderLayout.CENTER);

	}
	
	/**
	 * add action listener
	 * @param evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		newGameButton.addActionListener(evt);
		loadGameButton.addActionListener(evt);
		quitButton.addActionListener(evt);
	}
	
}
