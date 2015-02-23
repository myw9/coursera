package Coursera.AlgorithmsPt1.Week3;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.AdjacencyListUndirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class MinCutTest
{
	private ArrayList<TestInput> testInputs;
	
	@Before
	public void setUp() throws Exception
	{
		testInputs = new ArrayList<TestInput>();
		File testDirectory = new File("Inputs");
		File[] testFiles = testDirectory.listFiles();
		for (File testFile : testFiles)
		{
			if (testFile.getName().startsWith("TestCase"))
			{				
				int minCutValue = Integer.parseInt(testFile.getName().split("[_.]")[1]);
				AdjacencyListUndirected adjacencyList = Common.ParseAdjacencyFileUndirected(testFile.getAbsolutePath());
				testInputs.add(new TestInput(adjacencyList, minCutValue, testFile.getName()));
			}
		}
	}

	@Test
	public void test() throws Exception
	{
		for (TestInput testInput : testInputs)
		{
			int n = testInput.adjacencyList.VertexCount();
			int numRepeats = (int) (Math.pow(n,2)*Math.log(n));
			int minCut = MinCut.FindMinCut(testInput.adjacencyList, numRepeats);
			assertEquals(testInput.inputName, testInput.minCutValue, minCut);
		}
	}

}
