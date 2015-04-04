package Coursera.AlgorithmsPt2.Week1;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class JobScheduleTest {
	ArrayList<TestInputJob> testInputs;	
	
	@Before
	public void setUp() throws Exception {
		testInputs = new ArrayList<TestInputJob>();
		File testDirectory = new File("Job Inputs");
		File[] testFiles = testDirectory.listFiles();
		for (File testFile : testFiles)
		{
			String testFileName = testFile.getName();
			if (testFileName.startsWith("INPUT"))
			{
				ArrayList<Job> jobList = Parser.parseJobFile(testFile.getAbsolutePath());
				String[] testFileNameSplit = testFileName.split("[_.]");
				int ratio = Integer.parseInt(testFileNameSplit[1]);
				int difference = Integer.parseInt(testFileNameSplit[2]);
				testInputs.add(new TestInputJob(jobList, ratio, difference));
			}
		}
	}

	@Test
	public void test() {
		for (TestInputJob testInput : testInputs)
		{
			ArrayList<Job> sortedJobList = GreedySchedule.sortJobs(testInput.jobList, Job.compareDifference);
			long difference = GreedySchedule.computeWeightedCompletionTime(sortedJobList);
			assertEquals("Difference", testInput.differenceSolution, difference);
			sortedJobList = GreedySchedule.sortJobs(testInput.jobList, Job.compareRatio);
			long ratio = GreedySchedule.computeWeightedCompletionTime(sortedJobList);
			assertEquals("Ratio", testInput.ratioSolution, ratio);
		}
	}

}
