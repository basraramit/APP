package Map;
import Map.Country;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class CountryMap extends JFrame
{
   public CountryMap()
	{
		//super("Hello, World!");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{    int x,y;
		String adjv1;
			Scanner reader = new Scanner(new File("/C:/Users/kjasp/CodeRepository/Risk/src/Map/input2.txt"));
			List<Country> country = new ArrayList<Country>();
	        while (reader.hasNextLine()) {
	            String line = reader.nextLine();
		    String[] tokens = line.split(",");
	           String CountryId= tokens[0];
	            String Continent= tokens[3];
	             x= Integer.parseInt(tokens[1]);
	             y= Integer.parseInt(tokens[2]);
	            adjv1= tokens[4];
	            String PlayerName="Roy";
	            Country c = new Country(CountryId,Continent, x,y,adjv1,PlayerName);
	            country.add(c);
	            System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[2]+" "+tokens[4]);
	            c.setCountryId(CountryId);
	               c.setContinent(Continent);
	               c.setCoordinateX(x);
	               c.setCoordinateY(y);
	               c.setPlayerName(PlayerName);
	            
	     
			/*Object v1 = graph.insertVertex(parent, null, "Territory1", 40,20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "Territory2", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2); */}
	        
	        for(Country c: country){
	        	String id=c.getCountryId();
	        	String Continent=c.getContinent();
	        	  int x1= c.getCoordinateX();
	        	  int y1= c.getCoordinatey();
	        	  String adj=c.getadjv();
	        	  String Pname=c.getPlayerName();
	        	  
	        	  System.out.println("Afterinput "+id+" "+Continent+" "+x1+" "+y1+" "+adj+" "+Pname);
	        	Object v1 = graph.insertVertex(parent, null, id, x1,y1,60,
						30);
	        	Object v2 = graph.insertVertex(parent, null, "Territory2", 240, 150,
						80, 30);
	        	graph.insertEdge(parent, null, "", v1, v2);
            }
		} catch(Exception ex) {System.out.println("Error");}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}

	public static void main(String[] args)
	{
		CountryMap frame = new CountryMap();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		
		
	}

}



