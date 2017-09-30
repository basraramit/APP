package Map;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RiskGame extends JFrame {
	RiskGame game;
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
		
		JLabel lblSelectMap= new JLabel("Select Map");
		lblSelectMap.setFont(new Font("Tahoma", Font.PLAIN,15));
		lblSelectMap.setForeground(Color.GRAY);
		
		JLabel lblPlayerNo= new JLabel("Select players");
		lblPlayerNo.setFont(new Font("Tahoma", Font.PLAIN,15));
		lblPlayerNo.setForeground(Color.GRAY);
		
		
		String[] map= {"Map1","Map2", "Map3", "Map4"};
		JComboBox comboMap= new JComboBox(map);
		
		String[] PlayersNumber= {"2", "3","4","5","6"};
		JComboBox comboPlayersNo= new JComboBox(PlayersNumber);
		
		
		JButton btnPlay= new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountryMap a= new CountryMap();
				a.setVisible(true);
				game.dispose();
			}
				
			}
				);
		
		JButton btnAddCountry= new JButton("Add Country");
		 btnAddCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 
		 JButton btnRemoveCountry= new JButton("Remove Country");
		 btnRemoveCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
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
												.addComponent(lblSelectMap)
												.addComponent(lblPlayerNo))
										.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
												.addComponent(comboPlayersNo, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
												.addComponent(comboMap,GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
										      //  .addContainerGap(65, Short.MAX_VALUE)
										       // addComponent(passwordField,GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
											    .addContainerGap(70, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
				.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
				.addGap(70)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
				.addComponent(btnAddCountry, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRemoveCountry, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
				.addGap(151))
						);
				
		
		groupLayout.setVerticalGroup(
				groupLayout.createSequentialGroup()
				.addComponent(lblRiskGame)
				.addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(lblSelectMap)
						.addComponent(comboMap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(lblPlayerNo)
					    .addComponent(comboPlayersNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				 .addComponent(btnPlay)
				 .addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
				 .addComponent(btnAddCountry)
				 .addComponent(btnRemoveCountry))
						
				);
		
		
		
		}
			
	}