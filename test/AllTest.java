package Test;

import junit.framework.Test; 
import junit.framework.TestSuite; 

// TODO: Auto-generated Javadoc
/**
 * The Class AllTest.
 */
public class AllTest { 

        /**
         * Suite.
         *
         * @return the test
         */
        public static Test suite() { 
                TestSuite suite = new TestSuite("Junit Tests"); 
                 
                /* add testCase class one by one */ 
                suite.addTestSuite(CardTest.class); 
                suite.addTestSuite(ContinentTest.class);
                suite.addTestSuite(DeckTest.class);
                suite.addTestSuite(AdjacencyMatrixConnectedGraphTest.class);
                suite.addTestSuite(HandTest.class);
                suite.addTestSuite(CountryTest.class);
                suite.addTestSuite(PlayerTest.class);
                suite.addTestSuite(Risk_ModelTest.class);
                suite.addTestSuite(DiceTest.class);

                return suite; 
        } 

        /**
         * The main method.
         *
         * @param args the arguments
         */
        public static void main(String args[]) { 
                junit.textui.TestRunner.run(suite()); 
        } 
}
