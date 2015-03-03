package Coursera.AlgorithmsPt1.Week5;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class DijkstraTest
{
	private ArrayList<TestInput> testInputs;
	
	@Before
	public void setUp() throws Exception
	{
		testInputs = new ArrayList<TestInput>();		
		File testFileDirectory = new File("Inputs");
		File[] testFiles = testFileDirectory.listFiles();
		for (File testFile : testFiles)
		{
			String fileName = testFile.getName();
			if (fileName.startsWith("INPUT"))
			{
				// Generate adjacency list
				AdjacencyListDirected adjacencyList = Common.ParseAdjacencyFileWeighted(testFile.getAbsolutePath());
				
				// Parse shortest path solution
				String[] splitFileName = fileName.split("[_.]");
				int srcVertexId = Integer.parseInt(splitFileName[1]);
				int destVertexId = Integer.parseInt(splitFileName[2]);
				int cost = Integer.parseInt(splitFileName[3]);
				
				// Create test input and add to list
				testInputs.add(new TestInput(adjacencyList, srcVertexId, destVertexId, cost, fileName));
			}
		}
	}

	@Test
	public void test()
	{
		for (TestInput testInput : this.testInputs)
		{
			HashMap<Integer,VertexDijkstra> shortestMap = Dijkstra.ComputeShortestPath(testInput.adjacencyList, testInput.srcVertexId);
			long computedCost = shortestMap.get(testInput.destVertexId).greedyScore;					
			assertEquals(testInput.fileName + ": Cost Check", testInput.cost, computedCost);
		}
	}

}
