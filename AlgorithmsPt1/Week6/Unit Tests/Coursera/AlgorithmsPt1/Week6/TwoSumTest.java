package Coursera.AlgorithmsPt1.Week6;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.Common;

public class TwoSumTest
{
	ArrayList<TestInputTwoSum> testInputs;
	
	@Before
	public void setUp() throws Exception
	{
		// Initialize test inputs
		testInputs = new ArrayList<TestInputTwoSum>();
		
		// Iterate over all input files
		File inputDirectory = new File("Inputs");
		File[] inputFiles = inputDirectory.listFiles();
		for (File inputFile : inputFiles)
		{
			// Check for inputs for Q1
			String fileName = inputFile.getName();
			if (fileName.startsWith("InputQ1"))
			{
				String[] fileNameSplit = fileName.split("[_.]");
				int solution = Integer.parseInt(fileNameSplit[2]);
				ArrayList<Long> inputData = Common.ParseInputFileLarge(inputFile.getAbsolutePath());
				testInputs.add(new TestInputTwoSum(inputData, solution, fileName));
			}
		}
	}

	@Test
	public void test()
	{
		for (TestInputTwoSum testInput : testInputs)
		{
			int twoSumValue = TwoSum.CalculateTwoSum(testInput.inputData, -10000, 10000);
			assertEquals(testInput.inputFileName, testInput.solution, twoSumValue); 
		}
	}

}
