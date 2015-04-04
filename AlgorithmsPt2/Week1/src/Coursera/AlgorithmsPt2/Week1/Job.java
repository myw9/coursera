package Coursera.AlgorithmsPt2.Week1;

import java.util.Comparator;

public class Job {
	int weight;
	int length;
	
	public Job(int weight, int length)
	{
		this.weight = weight;
		this.length = length;
	}
	
	// weight - length
	public static Comparator<Job> compareDifference = new Comparator<Job>()
	{
		@Override
		public int compare(Job j1, Job j2) {
			int j1Difference = j1.weight - j1.length;
			int j2Difference = j2.weight - j2.length;
			if (j2Difference > j1Difference)
			{
				return 1;
			}
			else if (j2Difference < j1Difference)
			{
				return -1;
			}
			else
			{
				if (j2.weight > j1.weight)
				{
					return 1;
				}
				else if (j2.weight < j1.weight)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		}
	};
	
	// weight/length
	public static Comparator<Job> compareRatio = new Comparator<Job>()
	{
		@Override
		public int compare(Job j1, Job j2) {
			double j1Ratio = (double)j1.weight/(double)j1.length;
			double j2Ratio = (double)j2.weight/(double)j2.length;
			if (j2Ratio > j1Ratio)
			{
				return 1;
			}
			else if (j2Ratio < j1Ratio)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	};
}
