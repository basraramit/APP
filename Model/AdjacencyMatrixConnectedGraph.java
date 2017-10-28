package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrixConnectedGraph {
	
	public boolean checkAdjacency(){
    	String fileName= "C:/Users/yaome/workspace/Risk_Game/src/MatrixFile.txt";
        int lineNo = 0;
        File file= new File(fileName);
        List<List<String>> lines = new ArrayList<>();    
        List<List<String>> adjcencyMatrix = new ArrayList<>();         
        Scanner inputStream;
        
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext())
            {
                     String line= inputStream.next();
                              if (line.equals("[Territories]")){
                                      inputStream.nextLine();
                                      lineNo = 0;
                while (inputStream.hasNextLine())
                {       	                		
  	                  line = inputStream.nextLine();
                      String[] values = line.split(",");             
                      lines.add(Arrays.asList(values));
                      lineNo++;
                }
                	   
              }
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
           e.printStackTrace();
        }
          	        	                 	           	        
          
        int[][] adjMatrix = new int[lineNo][lineNo];
        for(List<String> line: lines)
        {    	        	       	
                 int id = Integer.valueOf(line.get(0));    	        	            
             for (int i=4; i<line.size(); i++)
             {	    	              
                adjMatrix[id][Integer.valueOf(line.get(i))] = 1;    	                    	              
             }    	            	           
        }
        
        String mLine = "";
        for (int i = 0; i< lineNo; i++)
        {
            for (int j = 0; j < lineNo ; j++ )
            {
            	if (i == j)
            	adjMatrix[i][j] = 0;   	            	    	            	          	   	            	
            }    	          
         }   	               	       	           

        boolean result = isConnected(adjMatrix);

        if (result)
        {
        	System.out.println("The graph is connected");
        }else
        {
        	System.out.println("The graph is disconnected");
        }
        return result;
	}

	/** This method checks connectivity of graph
	 * @param aadjacencyMatrix
	 * @return
	 */

	private static boolean isConnected(int[][] adjacencyMatrix) 
	{
		int visited[] = new int[adjacencyMatrix.length];

		for(int row=0; row< adjacencyMatrix.length; row++)
		{
			for(int col=0; col < adjacencyMatrix.length; col++)
            	{
    	         	if(adjacencyMatrix[row][col]==1 && visited[row]==0)
    	         	{
    	         		visited[row] = 1;
    	         	}  
            	}
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
