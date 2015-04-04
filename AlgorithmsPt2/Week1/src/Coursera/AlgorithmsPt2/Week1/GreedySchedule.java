package Coursera.AlgorithmsPt2.Week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Greedy algorithms for minimizing weighted sum of job completion times
public class GreedySchedule {
	
	// Sort job list using comparator
	public static ArrayList<Job> sortJobs(ArrayList<Job> jobList, Comparator<Job> comparator)
	{
		ArrayList<Job> sortedJobList = new ArrayList<Job>(jobList);
		Collections.sort(sortedJobList, comparator);
		return sortedJobList;
	}
	
	// Compute weighted completion time
	public static long computeWeightedCompletionTime(ArrayList<Job> jobList)
	{
		long weightedSum = 0;
		long completionTime = 0;
		for (int index=0; index<jobList.size(); index++)
		{
			completionTime += jobList.get(index).length;
			weightedSum += jobList.get(index).weight*completionTime;
		}
		return weightedSum;
	}
}
