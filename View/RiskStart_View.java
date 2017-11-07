package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;

// TODO: Auto-generated Javadoc
/**
 * These classes set up the start GUI of the Risk program.
 * @author yaomeng
 *
 */


public class RiskStart_View extends JFrame{
	
	/** The button panel. */
	private JPanel buttonPanel;
	
	/** The image component. */
	private ImageComponent imageComponent;
	
	/** The welcome pic. */
	private Images welcomePic;
	
	/** The new game button. */
	private JButton newGameButton;
	
	/** The edit map button. */
	private JButton editMapButton;
	
	/** The quit button. */
	private JButton quitButton;
	
	/**
	 * Constructs the start menu.
	 */
	public RiskStart_View(){

		welcomePic = new Images("C:/Users/yaome/workspace/Risk_Game/src/Map_Info/StartViewPic.jpg");
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
		editMapButton = new JButton("Edit Map");
		editMapButton.setPreferredSize(new Dimension(150,40));
		buttonPanel.add(editMapButton);
		buttonPanel.add( Box.createRigidArea(new Dimension(10,0)));
		quitButton = new JButton("Quit Game");
		quitButton.setPreferredSize(new Dimension(150,40));
		buttonPanel.add(quitButton);
		
		// Sets button commands
		newGameButton.setActionCommand("newGameBtn");
		editMapButton.setActionCommand("editMapBtn");
		quitButton.setActionCommand("quitBtn");

		add(buttonPanel,BorderLayout.SOUTH);
		add(imageComponent,BorderLayout.CENTER);

	}
	
	/**
	 * add action listener.
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		newGameButton.addActionListener(evt);
		editMapButton.addActionListener(evt);
		quitButton.addActionListener(evt);
	}
	
}
