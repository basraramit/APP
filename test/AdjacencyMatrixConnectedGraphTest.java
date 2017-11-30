package Test;

import static org.junit.Assert.*;

import java.io.File;


import Model.AdjacencyMatrixConnectedGraph;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class AdjacencyMatrixConnectedGraphTest.
 */
public class AdjacencyMatrixConnectedGraphTest extends TestCase{
	
	/** The file. */
	File file= new File("MatrixFileTest.txt");
	//CountryMap cMap=new CountryMap();
			
	/** The adj matrix. */
	AdjacencyMatrixConnectedGraph adjMatrix;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp (){
		
		
		
	}
	
	/**
	 * Test check adjacency.
	 */
	public void testCheckAdjacency(){
		//cMap.makeMatrixFile();
		AdjacencyMatrixConnectedGraph adjMatrix = new AdjacencyMatrixConnectedGraph();
		assertTrue(adjMatrix.checkAdjacency());
	}

}
