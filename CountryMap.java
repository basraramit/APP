package Map;

import Map.Country;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;

public class CountryMap{
	
	Country c;
	public List<Country> country = new ArrayList<Country>();
    Map<String,Object> listVertex=new HashMap<String,Object>();
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	
		graph.getModel().beginUpdate();
		try{
			int x,y;
		    File filename1= new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/input.txt");
		     Scanner reader = new Scanner(filename1);
			
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

				   // adjv1= tokens[4];
	               String PlayerName=NameGenerator();
	               c = new Country(CountryId,Continent,x,y,PlayerName);
	               this.country.add(c);
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
	              String adj=c.getadjv();
	              String Pname=c.getPlayerName();
	             String color=getColor(Continent);
	              
	              Object vertex= graph.insertVertex(parent, null, id, x1,y1,60,20,color);
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
	                           
	            			} catch(Exception ex){System.out.println(ex.getMessage());
		}
		finally{
			graph.getModel().endUpdate();
		}
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		return this.country;
	}
              public String NameGenerator() {
	  
		    String[] peoples = {"Bob", "Jill", "Tom", "Brandon"};
		    List<String> names = Arrays.asList(peoples);
		    int index = new Random().nextInt(names.size());
		    String name = names.get(index);
		    //System.out.println(name+"");
		    return name;
		    }
public String getColor(String Continent){
		String color="fillColor=lightblue";
		if(Continent.equals("Cockpit")){
        	color= "fillColor=lightblue";
        	}
          else if(Continent.equals("Hyperdrive")){
            	color= "fillColor=red";
            	}
          else if(Continent.equals("Left Cargo")||Continent.equals("LeftCargo")){
        	  color= "fillColor=lightgreen";
          }
          else if(Continent.equals("Right Cargo")||Continent.equals("RightCargo")){
        	  color= "fillColor=lightpink";
          }
          else if(Continent.equals("Right Thruster")||Continent.equals("RightThruster")){
        	  color= "fillColor=lightgray";
          }
          else if(Continent.equals("Left Thruster")||Continent.equals("LeftThruster")){
        	  color= "fillColor=cyan";
          }
          else if(Continent.equals("Right Escape Pod")||Continent.equals("RightEscapePod")){
        	  color= "fillColor=orange";
          }
          else if(Continent.equals("Left Escape Pod")||Continent.equals("LeftEscapePod")){
        	  color= "fillColor=magenta";
          }
		return color;
	}
	public void removeCountry(){
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter Country Name: \n");
	  String Countryid=sc.nextLine();
	 Object vertex=listVertex.get(Countryid);
	  graph.removeCells(new Object[]{vertex});
  }
	public void addCountry(){
			
		  String newLine = "";		  
		  List<String> adjacents= new ArrayList<String>();
		  
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter Country Name: \n");
		  String Countryid=sc.next();		
		  newLine = newLine + Countryid + ",";
		 
		  System.out.println("Enter x coordinate: \n");
		  int x=sc.nextInt();
		  
		  newLine = newLine + x + ",";
		 
		  
		  System.out.println("Enter y coordinate: \n");
		  int y=sc.nextInt();
		  
		  newLine = newLine + y + ",";
		 
		  
		  System.out.println("Enter continent: \n");
		  String continent =sc.next();
		  
		  newLine = newLine + continent + ",";
		String PlayerName=NameGenerator();
		  
		  Object vertex= graph.insertVertex(parent, null, Countryid, x,y,60,20,"defaultVertex;fillColor=lightblue");
	      listVertex.put(Countryid, vertex);
	      System.out.println("Enter no. of adjacent countries: \n");
	      int noAdjacents=sc.nextInt();
	      System.out.println("noAdjacents : " + noAdjacents );
	      
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
	    	      	
	      	FileWriter fw = new FileWriter("input.txt",true);	      
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

	      
  
	public static void main(String[] args){
		CountryMap frame = new CountryMap();
		
		}
	
 }
