package Coursera.AlgorithmsPt2.Week3;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {
	ArrayList<TestInput> testInputs;
	
	@Before
	public void setUp() throws Exception 
	{
		testInputs = new ArrayList<TestInput>();
		File testDirectory = new File("Q1 Inputs");
		File[] testFiles = testDirectory.listFiles();
		for (File testFile : testFiles)
		{
			String testFileName = testFile.getName();
			if (testFileName.startsWith("INPUT"))
			{
				String[] testFileNameSplit = testFileName.split("[_.]");
				int solution = Integer.parseInt(testFileNameSplit[1]);
				KnapsackProblem problem = Parser.parseKnapsackFile(testFile.getAbsolutePath());
				testInputs.add(new TestInput(problem, solution)); 
			}
		}
		
	}
	
	@Test
	public void testIterative() {
		for (TestInput testInput : testInputs)
		{
			int actual = KnapsackDP.computeMaxKnapsackValueIterative(testInput.problem);
			int expected = testInput.solution;
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testRecursive() {
		for (TestInput testInput : testInputs)
		{
			int actual = KnapsackDP.computeMaxKnapsackValueRecursive(testInput.problem);
			int expected = testInput.solution;
			assertEquals(expected, actual);
		}
	}
}
