package com.Risk;
import java.util.Scanner;


public class PlayerArmySelection{
	
	PlayerArmySelection(){

	int six_Value=1;     
	int five_value=2;
	int four_Value=3;
	int three_Value=4;
	int two_Value=5;

	int six_Army=20;
	int five_Army=25;
	int four_Army=30;
	int three_Army=35;
	int two_Army=40;

	     
	        Scanner keyboard = new Scanner(System.in);

	        System.out.println("Choose Player");
	        System.out.println("6 Players");
	        System.out.println("5 Players ");
	        System.out.println("4 Players");
	        System.out.println("3 Players");
	        System.out.println("2 Players ");



	        int Option_Selected = keyboard.nextInt();

	        if (Option_Selected  == six_Value) {
	            Option_Selected  = six_Army;
	            }
	        else if (Option_Selected  == five_value) {
	            Option_Selected =five_Army;
	        } 
	        else if (Option_Selected  ==four_Value) {
	            Option_Selected  = four_Army;
	        }
	        else if (Option_Selected  ==three_Value){
	            Option_Selected  =three_Army;
	        }  
	        else if (Option_Selected  ==two_Value){
	            Option_Selected  =two_Army;
	        }  	 
	        }

}
