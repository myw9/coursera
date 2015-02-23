package Coursera.AlgorithmsPt1.Week4;

import java.util.ArrayList;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;

public class TestInput
{
	public String fileName;
	public AdjacencyListDirected adjacencyList;
	public ArrayList<Integer> largestSCCSizes;
	
	public TestInput(AdjacencyListDirected adjacencyList, ArrayList<Integer> largestSCCSizes, String fileName)
	{
		this.adjacencyList = adjacencyList;
		this.largestSCCSizes = largestSCCSizes;
		this.fileName = fileName;
	}
}
