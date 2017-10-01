package src;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {
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

        //Filling the adjacency Matrix    
        
        int lineNo = 0;
        for(List<String> line: lines) {
           int columnNo = 0;
           int id = Integer.valueOf(line.get(0));
            for (String value: line) {
               // System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
                adjMatrix[id][Integer.valueOf(value)] = 1;
              columnNo++;
            }
            lineNo++;
       }
        
        
        for (int i = 0; i< 4; i++){
            for (int j = 0; j < 4 ; j++ ){
            	if (i == j)
            	adjMatrix[i][j] = 0;
            	System.out.print(adjMatrix[i][j] + " "); 
            }
           	System.out.println();
            }
    }

}

