package Map;

import Map.Country;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;

public class CountryMap extends JFrame{
	
	Country c;
	List<Country> country = new ArrayList<Country>();
    Map<String,Object> lstVertex=new HashMap<String,Object>();
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	public CountryMap(){
		

		graph.getModel().beginUpdate();
		try{
			int x,y;
		    
		     File filename1= new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/input2.txt");
		     Scanner reader = new Scanner(filename1);
			
			while (reader.hasNextLine()){
	               String line = reader.nextLine();
	               String[] tokens = line.split(",");
	               String CountryId= tokens[0];
	               String Continent= tokens[3];
	               x= Integer.parseInt(tokens[1]);
	               y= Integer.parseInt(tokens[2]);
	              // adjv1= tokens[4];
	               String PlayerName="Roy";
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
	                           
	            			} catch(Exception ex){System.out.println("Error");
		}
		finally{
			graph.getModel().endUpdate();
		}
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
  
	
	public static void main(String[] args){
		CountryMap frame = new CountryMap();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		}
 }
