package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * 
 * Create new map class
 *
 */
public class NewMap {

	
	/**
	 * Constructor
	 */
	public void createNewMap(){
		try{

			File tempFile = new File("C:/Users/yaome/workspace/Risk_Game/src/Map_Info/NewMap.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			writer.write("[Map]");
			writer.newLine();
			writer.write("author=Iceworm72" );
			writer.newLine();
			writer.newLine();
			writer.write("[Continents]");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter no. of continents: ");
			int noOfContinents= sc.nextInt();
			
			for(int i=1;i<=noOfContinents;i++){
				System.out.println("Enter name of continent"+i+": ");
				String Continent=sc.next();
				System.out.println("Enter control value: ");
				int controlValue= sc.nextInt();
				writer.newLine();
				writer.write(Continent+"="+controlValue);
				
			}
			writer.newLine();
			writer.newLine();
			writer.write("[Territories]");
			writer.newLine();
			System.out.println("Enter total no. of countries: ");
			int noOfCountries= sc.nextInt();
			for(int j=1;j<=noOfCountries;j++){
				
				System.out.println("Enter Country Name"+j+": \n");
                String Countryid=sc.next();		

				System.out.println("Enter x coordinate: \n");
                int x=sc.nextInt();
		       
		        System.out.println("Enter y coordinate: \n");
                int y=sc.nextInt();
		        
		        System.out.println("Enter continent: \n");
                String continent =sc.next();
                
                writer.write(Countryid+","+x+","+y+","+continent+",");
                System.out.println("Enter no. of adjacent countries: \n");
                int noAdjacents=sc.nextInt();
                for(int k=1;k<=noAdjacents;k++){

      	    	  System.out.println("Enter adjacent country" + k + ":"+" \n");	    	  	  	    	  
                  String adjacent=sc.next();
                  System.out.println("adjacent : " + adjacent );
                  if(k<noAdjacents){
                  writer.write(adjacent+",");
                  }
                  else
                	  writer.write(adjacent);
                	
			}
             writer.newLine();   
			
			}    
			writer.close(); 
		}catch(IOException ioe){
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}
	/*public static void main(String[] args){
		newMap map=new newMap();
		map.createNewMap();
	}*/
}
