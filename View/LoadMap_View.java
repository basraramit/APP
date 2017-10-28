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

/**
 * This class define the GUI for load a game map.
 * @author yaomeng
 *
 */
public class LoadMap_View extends JFrame{
	
	final JFileChooser fc = new JFileChooser();
	
	JPanel loadMapPanel = new JPanel();
	
	private JButton loadMapBtn;
	private JButton nextBtn;
	private JButton backBtn;
	
	private GridLayout loadMapLayout;

	private JLabel loadMapLabel;
	private JLabel nextLabel;

	/**
	 * Constructs the dialog for map selection.
	 * @param start_view
	 * @param modality
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
	 * @return
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
	 * @param evt
	 */
	public void addActionListeners(ActionListener evt)
	{
		loadMapBtn.addActionListener(evt);
		nextBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}
}
