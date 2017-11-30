package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class AdjacencyMatrixConnectedGraph.
 */
public class AdjacencyMatrixConnectedContinent {
	
	/**
	 * Check adjacency.
	 *
	 * @return true, if successful
	 */
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
          	        	                 	           	        
          
       // int[][] adjMatrix = new int[lineNo][lineNo];
        int[][] adjMatrix = new int[56][56];
        for(List<String> line: lines)
        {   
        	 String continent= line.get(3);
                 int id = Integer.valueOf(line.get(0));    	        	            
             for (int i=4; i<line.size(); i++)
             {	    	              
                adjMatrix[id][Integer.valueOf(line.get(i))] = 1;    	                    	              
             }    	            	           
        }
        
        String mLine = "";
        for (int i = 0; i< 56; i++)
        {
            for (int j = 0; j < 56 ; j++ )
            {
            	if (i == j)
            	adjMatrix[i][j] = 0;   	            	    	            	          	   	            	
            }    	          
         }  
        
       // String mLine = "";
        /*sjowing Matrix
        for (int i = 0; i< 6; i++){
            for (int j = 0; j < 6 ; j++ ){
            	if (i == j)
            	adjMatrix[i][j] = 0;
            	mLine +=  adjMatrix[i][j];
            	          	
            	
            	System.out.print(adjMatrix[i][j] + " "); 
            }
           // System.out.print(mLine);
            //adjcencyMatrix.add(Arrays.asList(mLine));
           	System.out.println();
            }
            */
        boolean result = isConnected(adjMatrix);

        if (result)
        {
        	System.out.println("The continent is connected");
        }else
        {
        	System.out.println("The continent is disconnected");
        }
        return result;
	}

	/**
	 *  This method checks connectivity of graph.
	 *
	 * @param adjacencyMatrix the adjacency matrix
	 * @return true, if is connected
	 */

	private static boolean isConnected(int[][] adjacencyMatrix) 
	{
		//int visited[] = new int[adjacencyMatrix.length];
		int visited[] = new int[56];
		//for(int row=0; row< adjacencyMatrix.length; row++)
		for(int row=0; row< 56; row++)
		{
			//for(int col=0; col < adjacencyMatrix.length; col++)
			for(int col=0; col < 56; col++)
            	{
    	         	if(adjacencyMatrix[row][col]==1 && visited[row]==0 )
    	         	{
    	         		visited[row] = 1;
    	         	}  
            	}
		}

		boolean connected = false;

		//for (int vertex = 0; vertex < adjacencyMatrix.length; vertex++)
		for (int vertex = 0; vertex < 6; vertex++)
		{
			int flag = 0;
			try{
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/yaome/workspace/Risk_Game/src/MatrixFile.txt"));
			         String line;

			         while((line = reader.readLine()) != null) {
			        	 if(line.equals("[Territories]") )//{               		
			        		 line = reader.readLine();
			          //System.out.println("line:    "+ line);
			          String[] values = line.split(",");  
			         
			          //System.out.println("vertex:    "+ vertex);
			          if (vertex == Integer.valueOf(values[0])){			        	
			        	  flag = 1;
			        	  break;
			          }
			        
			   // }
			         }
			    	   
			         reader.close();
			         }catch(IOException ioe){
				         System.out.println("Exception occurred:");
				    	 ioe.printStackTrace();
				      }

		
			
			if (flag == 0)
			{
				
				continue;
			}
			
			
			
			//System.out.println(visited[vertex]);
			if (visited[vertex] == 1) 
			{
				connected = true;
			} else if ((visited[vertex] == 0) )
			{
				
				connected = false;
				break;
			}
		}

		return connected;

	}

}