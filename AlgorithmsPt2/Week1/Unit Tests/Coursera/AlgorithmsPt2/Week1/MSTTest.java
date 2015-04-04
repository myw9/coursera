package Coursera.AlgorithmsPt2.Week1;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MSTTest {
	ArrayList<TestInputMST> testInputs;
	
	@Before
	public void setUp() throws Exception {
		testInputs = new ArrayList<TestInputMST>();
		File testDirectory = new File("Graph Inputs");
		File[] testInputFiles = testDirectory.listFiles();
		for (File testInputFile : testInputFiles)
		{
			String testInputName = testInputFile.getName();
			if (testInputName.startsWith("INPUT"))
			{
				Graph graph = Parser.parseGraphFile(testInputFile.getAbsolutePath());
				String[] testInputNameSplit = testInputName.split("[_.]");
				long cost = Integer.parseInt(testInputNameSplit[1]);
				testInputs.add(new TestInputMST(graph, cost));
			}
		}
	}

	@Test
	public void test() {
		for (TestInputMST testInput : testInputs)
		{
			ArrayList<Edge> mst = MinimumSpanningTree.computeMST(testInput.graph);
			long mstCost = MinimumSpanningTree.computeCost(mst);
			assertEquals(testInput.cost, mstCost);
		}
	}

}
