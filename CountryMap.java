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
    Map<String,Object> lstVertex=new HashMap<String,Object>();
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
	               String PlayerName="Roy";
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
	              String style;
	              
	              
	              
	      //Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	             Object vertex= graph.insertVertex(parent, null, id, x1,y1,60,20,"defaultVertex;fillColor=lightblue");
	             lstVertex.put(id, vertex);
	           
	                }
	             for(Country c: country){
	            		 	 List<String> values =c.getAdjacents();
	            			 Object parentVertex=lstVertex.get(c.getCountryId());
	            			for(int i = 0; i < values.size(); i++){
	            				 Object childVertex=lstVertex.get(values.get(i));
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
	
	public void addVertex(){
			
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
		  
		  newLine = newLine + continent + ",";
		  
		  Object vertex= graph.insertVertex(parent, null, Countryid, x,y,60,20,"defaultVertex;fillColor=lightblue");
	      lstVertex.put(Countryid, vertex);
	      System.out.println("Enter no. of adjacent countries: \n");
	      int noAdjacents=sc.nextInt();
	      System.out.println("noAdjacents : " + noAdjacents );
	      
	      for(int i=1;i<=noAdjacents;i++){
	    	  System.out.println("Enter adjacent countries" + i + ":"+" \n");	    	  	  	    	  
	    	  String adjacent=sc.next();
	    	  System.out.println("adjacent : " + adjacent );
	    	  newLine = newLine + adjacent + ",";
	          adjacents.add(adjacent);	          	         
	          Object childVertex=lstVertex.get(adjacents.get(i-1));
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
