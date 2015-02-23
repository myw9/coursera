package Coursera.AlgorithmsPt1.Week4;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class FindSCCTest
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
				AdjacencyListDirected adjacencyList = Common.ParseAdjacencyFileDirected(testFile.getAbsolutePath());
				
				// Parse correct SCC sizes solution
				String[] splitFileName = fileName.split("[_.]");
				ArrayList<Integer> largestSCCSizes = new ArrayList<Integer>();
				for (int index=1; index<=5; index++)
				{
					largestSCCSizes.add(Integer.parseInt(splitFileName[index]));
				}
				
				// Create test input and add to list
				testInputs.add(new TestInput(adjacencyList, largestSCCSizes, fileName));
			}
		}
	}

	@Test
	public void test()
	{
		for (TestInput testInput : this.testInputs)
		{
			ArrayList<SCC> sccList = FindSCC.FindSCCs(testInput.adjacencyList);
			ArrayList<Integer> sccSizeList = FindSCC.FindLargestSCCs(sccList, 5);
			assertEquals(testInput.fileName + ": List Size Check", testInput.largestSCCSizes.size(), sccSizeList.size());
			for (int index=0; index<5; index++)
			{
				assertEquals(testInput.fileName + ": List Index " + index + " Check", testInput.largestSCCSizes.get(index), sccSizeList.get(index));
			}
		}
	}

}
