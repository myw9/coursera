package Coursera.AlgorithmsPt2.Week2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt2.Week1.Graph;

public class HammingTest {
	private ArrayList<TestInputHamming> testInputs; 
	
	@Before
	public void setUp() throws Exception
	{
		testInputs = new ArrayList<TestInputHamming>();
		File testDirectory = new File("Q2 Inputs");
		File[] testFiles = testDirectory.listFiles();
		for (File testFile : testFiles)
		{
			String testFileName = testFile.getName();
			if (testFileName.startsWith("INPUT"))
			{
				String[] testFileNameSplit = testFileName.split("[_.]");
				HammingData hammingData = Parser.parseHammingGraph(testFile.getAbsolutePath());
				int clusters = Integer.parseInt(testFileNameSplit[1]);
				testInputs.add(new TestInputHamming(hammingData.hammingMap, hammingData.bitsPerNode, clusters));
			}
		}
	}

	@Test
	public void test() {
		for (TestInputHamming testInput : testInputs)
		{
			int clusters = Hamming.computeMaxClusters(testInput.hammingMap, testInput.bitsPerCode);
			assertEquals(testInput.maxClustersSolution, clusters);
		}
	}

}
