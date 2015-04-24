package Coursera.AlgorithmsPt2.Week4;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt2.Week1.Graph;

public class TestFloydWarshall {
	
	ArrayList<TestInput> testInputs;
	
	@Before
	public void setUp() throws Exception {
		testInputs = new ArrayList<>();
		File inputDirectory = new File("Q1 Inputs");
		{
			File[] inputFiles = inputDirectory.listFiles();
			for (File inputFile : inputFiles)
			{
				String fileName = inputFile.getName();
				if (fileName.startsWith("INPUT"))
				{
					// Parse graph
					Graph graph = Parser.parseGraph(inputFile.getAbsolutePath());
					Integer shortestShortestPath;
					
					// Parse solution
					String[] fileNameSplit = fileName.split("[_.]");
					if(fileNameSplit[1].equals("NULL"))
					{
						shortestShortestPath = null;
					}
					else
					{
						shortestShortestPath = Integer.parseInt(fileNameSplit[1]);
					}
				
					// Create test input
					testInputs.add(new TestInput(graph, shortestShortestPath));
				}
			}
		}
	}

	@Test
	public void test() throws Exception {
		for (TestInput testInput : testInputs)
		{
			Integer solution = FloydWarshall.computeAllPairsShortestPath(testInput.graph);
			assertEquals(testInput.shortestShortestPath, solution);
		}
	}

}
