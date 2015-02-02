package Coursera.AlgorithmsPt1.Week2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.*;

public class CountComparisonsTest
{
	public ArrayList<TestInput> unitTestInputs;
	
	@Before
	public void setUp() throws Exception {
		// Initialize unit test inputs
		unitTestInputs = new ArrayList<TestInput>();
		
		// Iterate over files in Inputs folder
		File directory = new File("Inputs");
		File[] files = directory.listFiles();
		for (File inputFile : files)
		{
			if (inputFile.getName().startsWith("INPUT"))
			{
				// Parse test result information from filename
				String[] splitFileName = inputFile.getName().split("[_.]");
				long numberComparisonsFirst = Long.parseLong(splitFileName[1]);
				long numberComparisonsLast = Long.parseLong(splitFileName[2]);
				long numberComparisonsMedianOfThree = Long.parseLong(splitFileName[3]);
				
				// Convert file data to ArrayList
				ArrayList<Integer> inputValues = Common.ParseInputFile(inputFile.getAbsolutePath());
				
				// Add unit test data to running list
				unitTestInputs.add(new TestInput(inputValues, numberComparisonsFirst, numberComparisonsLast, numberComparisonsMedianOfThree));
			}
		}
	}

	@Test
	public void testFixedFirst()
	{
		for (TestInput testInput : unitTestInputs)
		{
			ComparisonResult comparisonResult = CountComparisons.QuickSort(testInput.inputValues, 0, testInput.inputValues.size()-1, PivotSelection.FixedFirst);
			assertEquals("Number of Comparisons must be: " + testInput.numberComparisonsFirst, testInput.numberComparisonsFirst, comparisonResult.numberComparisons);
		}
	}
	
	@Test
	public void testFixedLast()
	{
		for (TestInput testInput : unitTestInputs)
		{
			ComparisonResult comparisonResult = CountComparisons.QuickSort(testInput.inputValues, 0, testInput.inputValues.size()-1, PivotSelection.FixedLast);
			assertEquals("Number of Comparisons must be: " + testInput.numberComparisonsLast, testInput.numberComparisonsLast, comparisonResult.numberComparisons);
		}
	}
	
	@Test
	public void testFixedMedianOfThree()
	{
		for (TestInput testInput : unitTestInputs)
		{
			ComparisonResult comparisonResult = CountComparisons.QuickSort(testInput.inputValues, 0, testInput.inputValues.size()-1, PivotSelection.MedianOfThree);
			assertEquals("Number of Comparisons must be: " + testInput.numberComparisonsMedianOfThree, testInput.numberComparisonsMedianOfThree, comparisonResult.numberComparisons);
		}
	}

}
