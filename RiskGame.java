package Map;
import Map.CountryMap;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RiskGame extends JFrame {
	RiskGame game;
	CountryMap a;
	JFrame frame;
    
	public static void main(String[] args){
		RiskGame game= new RiskGame();
		game.setVisible(true);
	}
	
	public RiskGame(){
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
				a.setVisible(true);
				a.setSize(800, 800);
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
