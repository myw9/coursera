package Coursera.AlgorithmsPt1.Week6;

import java.util.ArrayList;

public class TestInputMedianMaintenance
{
	String fileName;
	ArrayList<Long> inputData;
	long solution;
	
	public TestInputMedianMaintenance(ArrayList<Long> inputData, long solution, String inputFileName)
	{
		this.inputData = inputData;
		this.solution = solution;
		this.fileName = inputFileName;
	}
}
