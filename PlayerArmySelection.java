package com.Risk;
import java.util.Scanner;


public class PlayerArmySelection{
	public static void main(String [] args){
		
	
		PlayerArmySelection p = new PlayerArmySelection();
		Scanner keyboard = new Scanner(System.in);

        System.out.println("Choose Player");
        System.out.println("6 Players");
        System.out.println("5 Players ");
        System.out.println("4 Players");
        System.out.println("3 Players");
        System.out.println("2 Players ");
        
        int Option_Selected = keyboard.nextInt();

	//int six_Value=1;     
	//int five_value=2;
	//int four_Value=3;
	//int three_Value=4;
	//int two_Value=5;

	//int six_Army=20;
	//int five_Army=25;
	//int four_Army=30;
	//int three_Army=35;
	//int two_Army=40;

	     
	        if (Option_Selected  == 6) {
	            int ArmyNo  = 20;
	            System.out.println(ArmyNo);
	            }
	        else if (Option_Selected  == 5) {
	        	int ArmyNo =25;
	            System.out.println(ArmyNo);
	        } 
	        else if (Option_Selected  ==4) {
	        	int ArmyNo  = 30;
	        	System.out.println(ArmyNo);
	        }
	        else if (Option_Selected ==3){
	        	int ArmyNo = 35;
	        	System.out.println(ArmyNo);
	        }  
	        else if (Option_Selected  ==2){
	        	int ArmyNo  =40;
	        	System.out.println(ArmyNo);
	        }  	 
	        }

}
