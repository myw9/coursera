package Coursera.AlgorithmsPt1.Week1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.*;

public class CountInversionsBruteTest {

	public ArrayList<TestInput> unitTestInputs;
	
	@Before
	public void setUp() throws Exception {
		// Initialize test input list
		unitTestInputs = new ArrayList<TestInput>(50);
		
		// Iterate over all input files
		File directory = new File("Inputs");
		File[] inputFiles = directory.listFiles();
		if (inputFiles != null)
		{
			// Iterate over each input file
			for (File inputFile : inputFiles)
			{
				// Parse file to create test input objects	
				String fileName = inputFile.getName();
				if (fileName.startsWith("INPUT"))
				{
					String[] fileNameSplit = fileName.split("[_.]");
					long numberInversions = Long.parseLong(fileNameSplit[1]);
					
					ArrayList<Integer> inputValues = Common.ParseInputFile(inputFile.getPath());
					
					// Add test input
					unitTestInputs.add(new TestInput(inputValues, numberInversions));
				}
			}
		}
	}

	@Test
	public void testCountInversionsBrute() throws Exception {
		for (TestInput testInput : unitTestInputs)
		{
			long computedNumberInversions = CountInversions.CountInversionsBrute(testInput.inputValues);
			assertEquals("Number of Inversions must be: " + testInput.numberInversions, testInput.numberInversions, computedNumberInversions);
		}
	}

}
