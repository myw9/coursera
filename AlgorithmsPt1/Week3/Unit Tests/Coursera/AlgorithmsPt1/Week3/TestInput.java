package Coursera.AlgorithmsPt1.Week3;

import Coursera.AlgorithmsPt1.Common.AdjacencyList;

public class TestInput
{
	public int minCutValue;	
	public AdjacencyList adjacencyList;
	public String inputName;
	
	public TestInput(AdjacencyList adjacencyList, int minCutValue, String inputName)
	{
		this.adjacencyList = adjacencyList;
		this.minCutValue = minCutValue;
		this.inputName = inputName;
	}
}
