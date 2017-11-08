package Test;

import java.io.File;
import java.util.List;

import Model.AdjacencyMatrixConnectedGraph;
import junit.framework.TestCase;

public class AdjacencyMatrixConnectedGraphTest extends TestCase{
	
	File file= new File("C:/Users/yaome/workspace/Risk_Game/src/Map_Info/map.txt");
	AdjacencyMatrixConnectedGraph adjMatrix;
	
	protected void setUp (){
		
		
		
	}
	
	public void testCheckAdjacency(){
		AdjacencyMatrixConnectedGraph adjMatrix = new AdjacencyMatrixConnectedGraph();
		assertTrue(adjMatrix.checkAdjacency());
	}

}
