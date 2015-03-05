package Coursera.AlgorithmsPt1.Week6;

import java.util.ArrayList;

import Coursera.AlgorithmsPt1.Common.Common;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		long startTimeMs;
		long stopTimeMs;
		
		// Question 1
		System.out.println("QUESTION 1");
		
		System.out.print("Parsing File...");
		startTimeMs = System.currentTimeMillis();
		ArrayList<Long> inputDataQ1 = Common.ParseInputFileLarge("Inputs\\algo1-programming_prob-2sum.txt");
		stopTimeMs = System.currentTimeMillis();
		System.out.println(stopTimeMs-startTimeMs + " ms");
		
		System.out.print("Calculating Two Sums...");
		startTimeMs = System.currentTimeMillis();
		long twoSumValue = TwoSum.CalculateTwoSum(inputDataQ1, -10000, 10000);
		stopTimeMs = System.currentTimeMillis();
		System.out.println(stopTimeMs-startTimeMs + " ms");
		System.out.println("Two Sum Value: " + twoSumValue);		
		
		// Question 2
		System.out.println("");
		System.out.println("QUESTION 2");
		
		System.out.print("Parsing File...");
		startTimeMs = System.currentTimeMillis();
		ArrayList<Long> inputDataQ2 = Common.ParseInputFileLarge("Inputs\\Median.txt");
		stopTimeMs = System.currentTimeMillis();
		System.out.println(stopTimeMs-startTimeMs + " ms");
		
		System.out.print("Calculating Median Mod...");
		startTimeMs = System.currentTimeMillis();
		long medianModValue = MedianMaintenance.CalculateMedianMod(inputDataQ2, 10000);
		stopTimeMs = System.currentTimeMillis();
		System.out.println(stopTimeMs-startTimeMs + " ms");
		System.out.println("Median Mod Value: " + medianModValue);
	}

}
