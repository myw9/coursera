package Coursera.AlgorithmsPt1.Week6;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt1.Common.Common;

public class MedianMaintenanceTest
{
	ArrayList<TestInputMedianMaintenance> testInputs;
	
	@Before
	public void setUp() throws Exception
	{
		testInputs = new ArrayList<TestInputMedianMaintenance>();
		
		File inputDirectory = new File("Inputs");
		File[] inputFiles = inputDirectory.listFiles();
		for (File inputFile : inputFiles)
		{
			String fileName = inputFile.getName();
			if (fileName.startsWith("InputQ2"))
			{
				String[] fileNameSplit = fileName.split("[_.]");
				long solution = Long.parseLong(fileNameSplit[2]);
				ArrayList<Long> inputData = Common.ParseInputFileLarge(inputFile.getAbsolutePath());
				testInputs.add(new TestInputMedianMaintenance(inputData, solution, fileName));
			}
		}
	}

	@Test
	public void test()
	{
		for (TestInputMedianMaintenance testInput : testInputs)
		{
			long medianModValue = MedianMaintenance.CalculateMedianMod(testInput.inputData, 10000);
			assertEquals(testInput.fileName, testInput.solution, medianModValue); 
		}
	}

}
