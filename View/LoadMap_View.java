package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * This class define the GUI for load a game map.
 * @author yaomeng
 *
 */
public class LoadMap_View extends JFrame{
	
	/** The fc. */
	final JFileChooser fc = new JFileChooser();
	
	/** The load map panel. */
	JPanel loadMapPanel = new JPanel();
	
	/** The load map btn. */
	private JButton loadMapBtn;
	
	/** The next btn. */
	private JButton nextBtn;
	
	/** The back btn. */
	private JButton backBtn;
	
	/** The load map layout. */
	private GridLayout loadMapLayout;

	/** The load map label. */
	private JLabel loadMapLabel;
	
	/** The next label. */
	private JLabel nextLabel;

	/**
	 * Constructs the dialog for map selection.
	 *
	 * @param start_view the start view
	 * @param modality the modality
	 */
	public LoadMap_View(RiskStart_View start_view, boolean modality)
	{
		super();
		setTitle("Java-Risk");
		
		setPreferredSize(new Dimension(500, 200));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		add(LoadMapPanel());
		
		setLocationRelativeTo(null);
		
		pack();
	}

	/**
	 * The map select panel.
	 *
	 * @return the j panel
	 */
	private JPanel LoadMapPanel() {
		
		loadMapPanel = new JPanel();
		
		loadMapLayout = new GridLayout(3, 2, 10, 10);
		loadMapPanel.setLayout(loadMapLayout);
		
		loadMapLabel = new JLabel("Click Button to Load a Map");
		nextLabel = new JLabel("Click Button to Select Number of Players");
		
		loadMapBtn = new JButton("Load a Map");
		nextBtn = new JButton("Next");
		backBtn = new JButton ("Back");
		
		loadMapBtn.setActionCommand("LoadMap");
		nextBtn.setActionCommand("Next");
		backBtn.setActionCommand("Back");
		
		loadMapPanel.add(loadMapBtn);
		loadMapPanel.add(loadMapLabel);
		loadMapPanel.add(nextBtn);
		loadMapPanel.add(nextLabel);
		loadMapPanel.add(backBtn);
		
		return loadMapPanel;
	}
	
	/**
	 * Adds the action listeners.
	 *
	 * @param evt the evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		loadMapBtn.addActionListener(evt);
		nextBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}
}
