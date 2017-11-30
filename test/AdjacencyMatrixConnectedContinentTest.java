package Model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import Model.AdjacencyMatrixConnectedGraph;
import junit.framework.TestCase;

public class AdjacencyMatrixConnectedContinentTest extends TestCase{
	
	File file= new File("MatrixFile.txt");
	//CountryMap cMap=new CountryMap();
			
	AdjacencyMatrixConnectedContinent adjMatrix;
	
	protected void setUp (){
		
		
		
	}
	
	public void testCheckAdjacency(){
		//cMap.makeMatrixFile();
		AdjacencyMatrixConnectedContinent adjMatrix = new AdjacencyMatrixConnectedContinent();
		assertTrue(adjMatrix.checkAdjacency());
	}

}