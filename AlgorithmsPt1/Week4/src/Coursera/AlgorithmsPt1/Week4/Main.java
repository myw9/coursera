package Coursera.AlgorithmsPt1.Week4;

import java.util.ArrayList;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		long startTime;
		long stopTime;
		
		System.out.print("Parsing Input File...");
		startTime = System.currentTimeMillis();
		AdjacencyListDirected adjacencyList = Common.ParseAdjacencyFileDirected("Inputs\\SCC.txt");
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + " ms");
		
		System.out.print("Computing SCCs...");
		startTime = System.currentTimeMillis();
		ArrayList<SCC> sccList = FindSCC.FindSCCs(adjacencyList);
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + " ms");
		
		System.out.print("Finding Largest SCCs...");
		startTime = System.currentTimeMillis();
		ArrayList<Integer> largestSCCs = FindSCC.FindLargestSCCs(sccList, 5);
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + " ms");
		
		String solution = "";
		for (int index=0; index<5; index++)
		{
			solution += largestSCCs.get(index) + ",";
		}
		solution = solution.substring(0, solution.length()-1);
		System.out.println("Solution: " + solution);
	}

}
