package Coursera.AlgorithmsPt2.Week2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Coursera.AlgorithmsPt2.Week1.Graph;

public class ClusteringTest {
	private ArrayList<TestInputClustering> testInputs; 
	
	@Before
	public void setUp() throws Exception 
	{
		testInputs = new ArrayList<TestInputClustering>();
		File testDirectory = new File("Q1 Inputs");
		File[] testFiles = testDirectory.listFiles();
		for (File testFile : testFiles)
		{
			String testFileName = testFile.getName();
			if (testFileName.startsWith("INPUT"))
			{
				String[] testFileNameSplit = testFileName.split("[_.]");
				Graph graph = Parser.parseClusterGraph(testFile.getAbsolutePath());
				int k = Integer.parseInt(testFileNameSplit[1]);
				int minDistance = Integer.parseInt(testFileNameSplit[2]);
				testInputs.add(new TestInputClustering(graph, k, minDistance));
			}
		}
	}

	@Test
	public void test() 
	{
		for (TestInputClustering testInput : testInputs)
		{
			int minSpacing = Clustering.computeMaxSpacing(testInput.graph, testInput.k);
			assertEquals(testInput.minSpacing, minSpacing);
		}
	}

}
