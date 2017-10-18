package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrixConnectedGraph 
{
     
    	    public static void main(String[] args) {
              
    	        String fileName= "MatrixFile.txt";
    	        int lineNo = 0;
    	        File file= new File(fileName);

    	        // this gives you a 2-dimensional array of strings
    	        List<List<String>> lines = new ArrayList<>();    
    	        List<List<String>> adjcencyMatrix = new ArrayList<>();    	          	        
    	        Scanner inputStream;
    	        
    	        try{
    	            inputStream = new Scanner(file);

    	            while(inputStream.hasNext()){
    	                String line= inputStream.next();
    	                if (line.equals("[Territories]")){
    	                   inputStream.nextLine();
    	                   lineNo = 0;
    	                   while (inputStream.hasNextLine()){       	                		
    	  	              line = inputStream.nextLine();
    	                   String[] values = line.split(",");             
    	                   // this adds the currently parsed line to the 2-dimensional string array
    	                   lines.add(Arrays.asList(values));
    	                  //System.out.println(line);
    	                  lineNo++;
    	            }
    	                	   
    	                }
    	            }

    	            inputStream.close();
    	        }catch (FileNotFoundException e) {
    	           e.printStackTrace();
    	        }
    	          	        	                 	           	        
    	        //Filling the adjacency Matrix    
    	        //System.out.println(lineNo);  
    	        int[][] adjMatrix = new int[lineNo][lineNo];
    	        for(List<String> line: lines) {    	        	       	
    	           int id = Integer.valueOf(line.get(0));    	        	            
    	           for (int i=4; i<line.size(); i++){	    	              
    	                adjMatrix[id][Integer.valueOf(line.get(i))] = 1;    	                    	              
    	            }    	            	           
    	       }
    	        
    	        String mLine = "";
    	        for (int i = 0; i< lineNo; i++){
    	            for (int j = 0; j < lineNo ; j++ ){
    	            	if (i == j)
    	            	adjMatrix[i][j] = 0;   	            	    	            	          	   	            	
    	            	//System.out.print(adjMatrix[i][j] + " "); 
    	            }    	          
    	           	//System.out.println();
    	            }   	               	       	           
        boolean result = isConnected(adjMatrix);
  
        if (result)
        {
            System.out.println("The graph is connected");
        }else
        {
            System.out.println("The graph is disconnected");
        }
     }
  
    private static boolean isConnected(int[][] adjacencyMatrix) 
    {
        int visited[] = new int[adjacencyMatrix.length ];
  
        for(int row=0; row< adjacencyMatrix.length; row++)
        {
            for(int col=0; col < adjacencyMatrix.length; col++)
            {
            	//System.out.print(adjacencyMatrix[row][col]);
                if(adjacencyMatrix[row][col]==1 && visited[row]==0)
                {
                    visited[row] = 1;
                }  
            }
            //System.out.println();
        }
  
        boolean connected = false;
  
        for (int vertex = 0; vertex < adjacencyMatrix.length; vertex++)
        {
            if (visited[vertex] == 1) 
            {
                connected = true;
            } else
            {
                connected = false;
                break;
            }
        }
  
        return connected;
  
    }
     
}
