package src;
import src.Country;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class DrawMap4 extends JFrame
{
   public DrawMap4()
	{
		

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		
		
	     String fileName= "adjacency.txt";
	        File file= new File(fileName);

	        // this gives you a 2-dimensional array of strings
	        List<List<String>> lines = new ArrayList<>();
	       // List<List<String>> AdjMatrix = new ArrayList<>();
	        int[][] adjMatrix = new int[20][20];
	        
	        Scanner inputStream;

	        try{
	            inputStream = new Scanner(file);

	            while(inputStream.hasNext()){
	                String line= inputStream.next();
	                String[] values = line.split(",");
	                // this adds the currently parsed line to the 2-dimensional string array
	                lines.add(Arrays.asList(values));
	            }

	            inputStream.close();
	        }catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }			
		try
		{    
	        int lineNo = 0;

	        for(List<String> line: lines) {
	      
	           int columnNo = 0;
	           int id = Integer.valueOf(line.get(0));
	           int CID;
	      
	            for (String value: line) {
	             
	            	if (id == Integer.valueOf(value))
	            	
	            	adjMatrix[id][Integer.valueOf(value)] = 0;
	            	else 
	            	adjMatrix[id][Integer.valueOf(value)] = 1;
	            	
	           
	              columnNo++;
	            }
	          
	            lineNo++;
	        }
	      
	        Random rand1 = new Random();
	
	        for (int i = 0; i< 4; i++){
	            int x1 = rand1.nextInt(200) + 1;
		        int y1 = rand1.nextInt(200) + 1;
		        
	            for (int j = i ; j < 4 ; j++ ){
	            	
	            	if( (adjMatrix[i][j]) == 1 &&  (i != j)){
	                
	 	          
	 	           int x2 = rand1.nextInt(800) + 1;
	 	           int y2 = rand1.nextInt(800) + 1;
	 	      
	 	          Object v1 = graph.insertVertex(parent, null, i , x1,y1,60,30);
	 	           Object v2 = graph.insertVertex(parent, null, j , x2,y2,60,30);
	 	           graph.insertEdge(parent, null, "", v1, v2);
	            	}
	            	System.out.print(adjMatrix[i][j] + " "); 
	            }
	           	System.out.println();
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
		DrawMap4 frame = new DrawMap4();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);				
		
	}

}