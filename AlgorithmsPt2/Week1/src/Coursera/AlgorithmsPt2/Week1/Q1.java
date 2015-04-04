package Coursera.AlgorithmsPt2.Week1;

import java.io.IOException;
import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) throws IOException {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		ArrayList<Job> jobList = Parser.parseJobFile("Job Inputs\\jobs.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Minimizing Weighted Completion Time (Difference)...");
		startTime = System.currentTimeMillis();
		ArrayList<Job> sortedJobList = GreedySchedule.sortJobs(jobList, Job.compareDifference);
		long weightedCompletionTime = GreedySchedule.computeWeightedCompletionTime(sortedJobList);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.println("Weighted Completion Time: " + weightedCompletionTime);
	}

}
