package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import Model.CountryMap;

/**
 * This class maps the user's actions in the MapEdit View to edit map
 */
public class MapEdit_View extends JFrame {
	
	MapEdit_View view;
	CountryMap a;
	JFrame frame;
	String defaultMap = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/map.txt";
    
	public static void main(String[] args){
		MapEdit_View view= new MapEdit_View();
		view.setVisible(true);
	}
	
	/**
	 * Constructor of this class
	 */
	public MapEdit_View(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 400,400);
		JPanel Panel = new JPanel();
	    Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		
		
		JLabel lblRiskGame = new JLabel("Risk Game");
		lblRiskGame.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRiskGame.setForeground(Color.GRAY);
		
		JButton btnAddContinent= new JButton("Add Continent");
		btnAddContinent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddContinent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountryMap a= new CountryMap();
				a.addContinent();
				a.setVisible(true);
				a.setSize(800, 800);
				}
				
		}
		);
		
		JButton btnRemoveContinent= new JButton("Remove Continent with countries");
		btnRemoveContinent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoveContinent.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					a= new CountryMap();
					a.deleteContinentWithCountries();
					a.setVisible(true);
					a.setSize(800, 800);
				}
					
				}
					);
		JButton btnRemoveContinentWithout= new JButton("Remove Continent without countries");
		btnRemoveContinentWithout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveContinentWithout.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					a= new CountryMap();
					a.deleteContinentWithoutCountries();
					a.setVisible(true);
					a.setSize(800, 800);
				}
					
				}
					);
		
		
		JButton btnPlay= new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountryMap a= new CountryMap();
				//a.DrawMap();
				a.setSize(800, 800);
				a.setVisible(true);
				a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				a.setSize(800, 800);
				a.setVisible(true);
				
				BufferedImage  bi = new BufferedImage(a.getWidth(), a.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics2D  g2d = bi.createGraphics();
				a.paint(g2d);
				try {
					ImageIO.write(bi, "PNG", new File("C:/Users/yaome/workspace/Risk_Game/src/Map_Info/countryMap.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			}
				);
		
		JButton btnAddCountry= new JButton("Add Country");
		 btnAddCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnAddCountry.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					CountryMap	a= new CountryMap();
					a.addCountry();
					a.setVisible(true);
					a.setSize(800, 800);
					
				}
					
				}
					);
		 
		 JButton btnRemoveCountry= new JButton("Remove Country");
		 btnRemoveCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnRemoveCountry.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					a= new CountryMap();
					a.removeCountry();
					a.setVisible(true);
					a.setSize(800, 800);
				}
					
				}
					);
		
		
		GroupLayout groupLayout= new GroupLayout(Panel);
		Panel.setLayout(groupLayout);
		
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		
		
		
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblRiskGame))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
												
												.addComponent(btnRemoveContinent, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
												.addGap(70)
												.addComponent(btnAddContinent,GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
										        .addContainerGap(70, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
				.addComponent(btnRemoveContinentWithout, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
				)
				.addGap(70)
				
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addGroup(groupLayout.createSequentialGroup()
				.addComponent(btnAddCountry, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRemoveCountry, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
				.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
				.addGap(151))
						);
				
		
		groupLayout.setVerticalGroup(
				groupLayout.createSequentialGroup()
				.addComponent(lblRiskGame)
				.addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						
				.addComponent(btnAddContinent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						
					    .addComponent(btnRemoveContinent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addGap(28)
					    )
				.addGap(28)
				.addComponent(btnRemoveContinentWithout)
				 
				 .addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
				 .addComponent(btnAddCountry)
				 .addComponent(btnRemoveCountry))
				 .addComponent(btnPlay)
						
				);
		
		
		
		}
			
	}
