package Test;

import static org.junit.Assert.*;

import java.io.File;

import Model.AdjacencyMatrixConnectedContinent;
import Model.AdjacencyMatrixConnectedGraph;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class AdjacencyMatrixConnectedContinentTest.
 */
public class AdjacencyMatrixConnectedContinentTest extends TestCase{
	
	/** The file. */
	File file= new File("MatrixFile.txt");
	//CountryMap cMap=new CountryMap();
			
	/** The adj matrix. */
	AdjacencyMatrixConnectedContinent adjMatrix;
	
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
		AdjacencyMatrixConnectedContinent adjMatrix = new AdjacencyMatrixConnectedContinent();
		assertTrue(adjMatrix.checkAdjacency());
	}

}
