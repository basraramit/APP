package Map;

import Map.Country;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;

public class CountryMap extends JFrame{
	
	Country c;
	List<Country> country = new ArrayList<Country>();
    Map<String,Object> listVertex=new HashMap<String,Object>();
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	 File filename;
	 
	public CountryMap(){
		graph.getModel().beginUpdate();
		try{
			int x,y;
		    
		      //filename= new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/mapInput.txt");
			filename=setFilename();
		     Scanner reader = new Scanner(filename);
		    
			
			while (reader.hasNextLine()){
	               String line = reader.nextLine();
	               if (line.equals("[Territories]")){
	            	   while (reader.hasNextLine()){
	            	   line = reader.nextLine();
	               String[] tokens = line.split(",");
	               String CountryId= tokens[0];
	               String Continent= tokens[3];
	               x= Integer.parseInt(tokens[1]);
	               y= Integer.parseInt(tokens[2]);
	               String PlayerName=NameGenerator();
	               c = new Country(CountryId,Continent,x,y,PlayerName);
	               country.add(c);
	               System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[3]+" Adjacent{");
	               c.setCountryId(CountryId);
	               c.setContinent(Continent);
	               c.setCoordinateX(x);
	               c.setCoordinateY(y);
	               c.setPlayerName(PlayerName);
	               int length= tokens.length;
	               List<String> adjToken= new ArrayList<String>();
	
	                for(int i = 4; i < tokens.length; i++){
	
	                  adjToken.add(tokens[i]);
	                  
	                 }
	            	 
	             c.setAdjacent(adjToken);
	            	   }
	               }
	            } 
	             for(Country c: country){
                  String id=c.getCountryId();
	              String Continent=c.getContinent();
	              int x1= c.getCoordinateX();
	              int y1= c.getCoordinatey();
	             
	              String Pname=c.getPlayerName();
	              String color=getColor(Continent);
	              
	              Object vertex= graph.insertVertex(parent, null, id+" "+Pname+"\n"+Continent, x1,y1,80,30,color);
	             listVertex.put(id, vertex);
	           
	                }
	             for(Country c: country){
	            		 	 List<String> values =c.getAdjacents();
	            			 Object parentVertex=listVertex.get(c.getCountryId());
	            			for(int i = 0; i < values.size(); i++){
	            				 Object childVertex=listVertex.get(values.get(i));
	            	 		 graph.insertEdge(parent, null, "",parentVertex,childVertex);
	            			 }
	            		
	             }
	                           
	            			} catch(Exception ex){System.out.println("Error");
		}
		finally{
			graph.getModel().endUpdate();
		}
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
	public void removeCountry(){
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter Country Name: \n");
		  String Countryid=sc.nextLine();
		 Object vertex=listVertex.get(Countryid);
		  graph.removeCells(new Object[]{vertex});
			
			
		 try{
			
		        File tempFile = new File("TempFile.txt");

		        BufferedReader reader = new BufferedReader(new FileReader(filename));
		        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		        String lineToRemove = "";
		        String currentLine;
		        int position = 0 ;
		        String RemoveString = Countryid + ",";
		        while((currentLine = reader.readLine()) != null) {
		        	
		        	if(currentLine.contains(RemoveString) && (currentLine.indexOf(Countryid)  == 0))
		        		lineToRemove = currentLine;	
		        	else if(currentLine.contains(RemoveString) && (currentLine.indexOf(Countryid)  != 0))
		        	currentLine = currentLine.replace(RemoveString,"");
		        	else if (currentLine.contains(Countryid) && (currentLine.indexOf(Countryid)  != 0))
		        	currentLine = currentLine.replace("," + Countryid,"");
		        	
		        	
		            String trimmedLine = currentLine.trim();
		            if(trimmedLine.equals(lineToRemove)) continue;
		            writer.write(currentLine + System.getProperty("line.separator"));
		        }
		        writer.close(); 
		        reader.close(); 
		        boolean successful = tempFile.renameTo(inputFile);
		        System.out.println(successful);

		        }catch(IOException ioe){
		           System.out.println("Exception occurred:");
		      	 ioe.printStackTrace();
		         }
			
			
	  }
	 public String NameGenerator() {
		  
		    String[] peoples = {"Bob", "Jill", "Tom", "Brandon"};
		    List<String> names = Arrays.asList(peoples);
		    int index = new Random().nextInt(names.size());
		    String name = names.get(index);
		    //System.out.println(name+"");
		    return name;
		    }
	public File setFilename(){
		  Scanner sc=new Scanner(System.in);

		  System.out.println("Select map \n");

		  String map=sc.next();	
		  if(map.equals("1")){
			  filename=new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/mapInput.txt");
		  }
		  else if(map.equals("2")){
			  filename=new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/input3.txt"); 
		  }
		  else{
			  filename=new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/input4.txt"); 
		  }
			 
		  return this.filename;
		  
	  }
	public String getColor(String Continent){
		String color="fillColor=lightblue";
		if(Continent.equals("Cockpit")){
        	color= "fillColor=lightblue";
        	}
          else if(Continent.equals("Hyperdrive")){
            	color= "fillColor=red";
            	}
          else if(Continent.equals("Left Cargo")||Continent.equals("LeftCargo")||Continent.equals("Left Wing")||Continent.equals("LeftWing")||Continent.equals("Kala")){
        	  color= "fillColor=lightgreen";
          }
          else if(Continent.equals("Right Cargo")||Continent.equals("RightCargo")||Continent.equals("Right Wing")||Continent.equals("RightWing")||Continent.equals("Enevim")){
        	  color= "fillColor=lightpink";
          }
          else if(Continent.equals("Right Thruster")||Continent.equals("RightThruster")||Continent.equals("Tail")||Continent.equals("Nova")){
        	  color= "fillColor=lightgray";
          }
          else if(Continent.equals("Left Thruster")||Continent.equals("LeftThruster")||Continent.equals("Engine")||Continent.equals("BarakLos")||Continent.equals("Barak Los")){
        	  color= "fillColor=cyan";
          }
          else if(Continent.equals("Right Escape Pod")||Continent.equals("RightEscapePod")||Continent.equals("Fuselage")||Continent.equals("Neimaach")){
        	  color= "fillColor=orange";
          }
          else if(Continent.equals("Left Escape Pod")||Continent.equals("LeftEscapePod")||Continent.equals("Barba Moya")||Continent.equals("BarbaMoya")){
        	  color= "fillColor=magenta";
          }
          else{
        	  color="fillColor=Pink";
          }
        	 
		return color;
	}
	
	public void addCountry(){
		
	   String newLine = "";		  

	   List<String> adjacents= new ArrayList<String>();

	   Scanner sc=new Scanner(System.in);

	   System.out.println("Enter Country Name: \n");

	   String Countryid=sc.nextLine();		

	   newLine = newLine + Countryid + ",";
           System.out.println("Enter x coordinate: \n");

	   int x=sc.nextInt();
           newLine = newLine + x + ",";
           System.out.println("Enter y coordinate: \n");

	   int y=sc.nextInt();
           newLine = newLine + y + ",";
           System.out.println("Enter continent: \n");

	   String continent =sc.next();
	   String color=getColor(continent);
	   String PlayerName=NameGenerator();
	   c.setPlayerName(PlayerName);
	   c = new Country(Countryid,continent,x,y,PlayerName);

	   newLine = newLine + continent + ",";
		  
           Object vertex= graph.insertVertex(parent, null, Countryid+" "+PlayerName+"\n"+continent, x,y,80,30,color);

	   listVertex.put(Countryid, vertex);

	   System.out.println("Enter no. of adjacent countries: \n");

	   int noAdjacents=sc.nextInt();

	   for(int i=1;i<=noAdjacents;i++){

	    	System.out.println("Enter adjacent countries" + i + ":"+" \n");	    	  	  	    	  

	    	String adjacent=sc.next();

	    	System.out.println("adjacent : " + adjacent );

	    	newLine = newLine + adjacent + ",";

	        adjacents.add(adjacent);	          	         

	        Object childVertex=listVertex.get(adjacents.get(i-1));

		graph.insertEdge(parent, null, "New edges",vertex,childVertex);

				 			 				 

	      }	     	
    	  newLine = newLine.substring(0, newLine.length() - 1);
	  try{
  	      	
    	 FileWriter fw = new FileWriter(filename,true);	      

    	 BufferedWriter bw = new BufferedWriter(fw);

    	 bw.write("\n"+ newLine);	      	

    	 bw.close();

    	 System.out.println("NewLine final : " + newLine );

	 System.out.println("Data successfully appended at the end of file");



      }catch(IOException ioe){

         System.out.println("Exception occurred:");

    	 ioe.printStackTrace();

       }

}
public void addContinent(){
			
			  String newContinentLine = "";	
			  String newCountryLine = "";
			 		  
			  Scanner sc=new Scanner(System.in);
			  
			  System.out.println("Enter Continent Name: \n");
			  String Continentid=sc.next();		
			  newContinentLine = newCountryLine + Continentid + "=";
			 
			  System.out.println("Enter no. of countries for this continent: \n");
		      int nocountries=sc.nextInt();
		      
		      for(int j=1;j<=nocountries;j++){
		    	  
		      newCountryLine = "";
		      List<String> adjacents= new ArrayList<String>();
			  System.out.println("Enter Country Name: \n");
			  String Countryid=sc.next();		
			  newCountryLine = newCountryLine + Countryid + ",";
			 
			  System.out.println("Enter x coordinate: \n");
			  int x=sc.nextInt();
			  
			  newCountryLine = newCountryLine + x + ",";
			 
			  
			  System.out.println("Enter y coordinate: \n");
			  int y=sc.nextInt();
			  
			  newCountryLine = newCountryLine + y + ",";
			 		
			  
			  newCountryLine = newCountryLine + Continentid + ",";
			  String color=getColor(Continentid);
			  String PlayerName=NameGenerator();
			  
			  Object vertex= graph.insertVertex(parent, null, Countryid+" "+PlayerName+"\n"+Continentid, x,y,80,30,color);
		      listVertex.put(Countryid, vertex);
		      
		      System.out.println("Enter no. of adjacent countries: \n");
		      int noAdjacents=sc.nextInt();
		      for(int i=1;i<=noAdjacents;i++){
		    	  System.out.println("Enter adjacent countries" + i + ":"+" \n");	    	  	  	    	  
		    	  String adjacent=sc.next();
		    	  System.out.println("adjacent : " + adjacent );
		    	  newCountryLine = newCountryLine + adjacent + ",";
		          adjacents.add(adjacent);	          	         
		          Object childVertex=listVertex.get(adjacents.get(i-1));
				  graph.insertEdge(parent, null, "New edges",vertex,childVertex);
					 			 				 
		      }	     	
		      newCountryLine = newCountryLine.substring(0, newCountryLine.length() - 1);
				
		      try{
		    	      	
		      	FileWriter fw = new FileWriter(filename,true);	      
		      	BufferedWriter bw = new BufferedWriter(fw);
		      	bw.write("\n"+ newCountryLine);	      	
		      	bw.close();
		      	
		      	System.out.println("NewLine final : " + newCountryLine );
		      	System.out.println("Data successfully appended at the end of file");

		        }catch(IOException ioe){
		           System.out.println("Exception occurred:");
		      	 ioe.printStackTrace();
		         }
		      
		      }
		      
		      try{
		    	  		    	 
			        File tempFile = new File("TempFile.txt");

			        BufferedReader reader = new BufferedReader(new FileReader(filename));
			        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			       
			        String ContinentsBlock = "";
			        String currentLine;
			        int position = 0 ;			       
			        while((currentLine = reader.readLine()) != null) {
			        	
			        	if(currentLine.contains("[Continents]") ){
			        		
			        		
			        		writer.write(currentLine + System.getProperty("line.separator"));
			        		writer.write(newContinentLine + System.getProperty("line.separator"));
			        	}
			        	
			        	else 
			        		writer.write(currentLine + System.getProperty("line.separator"));
			        					        					            				            			            
			        }
			        writer.close(); 
			        reader.close(); 
			        boolean successful = tempFile.renameTo(filename);
			        System.out.println(successful);

			        }catch(IOException ioe){
			           System.out.println("Exception occurred:");
			      	 ioe.printStackTrace();
			        }
			            	   		      		      		      
		     }
		
	
	
	public void deleteContinentWithCountries(){
		
		  	String newContinentLine = "";	
		  	String newCountryLine = "";
		  	List<String> countries= new ArrayList<String>();
		 		  
		  	Scanner sc=new Scanner(System.in);
		  
		  	System.out.println("Enter Continentttt Name: \n");
		  	String Continentid=sc.next();		
									
			 try{
				    File tempFile = new File("TempFile.txt");

			        BufferedReader reader = new BufferedReader(new FileReader(filename));
			        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			        String lineToRemove = "";
			        String currentLine;
			        int position = 0 ;
			        String RemoveString = Continentid;
			        while((currentLine = reader.readLine()) != null) {
			        	
			        	if(currentLine.contains(RemoveString) ){			        					        					        
			        		lineToRemove = currentLine;	
			        		String[] tokens = lineToRemove.split(",");
				            String CountryId= tokens[0];
				            Object vertex=listVertex.get(CountryId);
							graph.removeCells(new Object[]{vertex});
			        		
			        	}
			        	
			            String trimmedLine = currentLine.trim();
			            if(trimmedLine.equals(lineToRemove)) continue;
			            writer.write(currentLine + System.getProperty("line.separator"));
			        }
			        writer.close(); 
			        reader.close(); 
			        boolean successful = tempFile.renameTo(filename);
			        System.out.println(successful);

			        }catch(IOException ioe){
			           System.out.println("Exception occurred:");
			      	 ioe.printStackTrace();
			         }
				
		
	}
	
public void deleteContinentWithoutCountries(){
	
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter Continent Name: \n");
	 String Continentid=sc.nextLine();
					
	 try{
		  	
	        File tempFile = new File("TempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(filename));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String lineToRemove = "";
	        String currentLine;
	        int position = 0 ;
	        String RemoveString = Continentid + "=";
	        while((currentLine = reader.readLine()) != null) {
	        	
	           if(currentLine.contains(RemoveString) )
	           lineToRemove = currentLine;	
	           else if(currentLine.contains(Continentid)) 	        					
	           currentLine = currentLine.replace(Continentid,"");	        		        		        	
	           String trimmedLine = currentLine.trim();
	           if(trimmedLine.equals(lineToRemove)) continue;
	           writer.write(currentLine + System.getProperty("line.separator"));
	    }
	        writer.close(); 
	        reader.close(); 
	        boolean successful = tempFile.renameTo(filename);
	        System.out.println(successful);

	        }catch(IOException ioe){
	           System.out.println("Exception occurred:");
	      	 ioe.printStackTrace();
	        }		
	}

	
public static void main(String[] args){
		CountryMap frame = new CountryMap();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		}
 }
