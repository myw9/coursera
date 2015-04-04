package Coursera.AlgorithmsPt2.Week1;

import java.util.ArrayList;

public class TestInputJob {
	ArrayList<Job> jobList;
	long ratioSolution;
	long differenceSolution;
	
	public TestInputJob()
	{
		this(null, 0, 0);
	}
	
	public TestInputJob(ArrayList<Job> jobList, int ratioSolution, int differenceSolution)
	{
		this.jobList = jobList;
		this.ratioSolution = ratioSolution;
		this.differenceSolution = differenceSolution;
	}
}
