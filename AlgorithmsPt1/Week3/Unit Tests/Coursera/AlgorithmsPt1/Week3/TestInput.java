package Coursera.AlgorithmsPt1.Week3;

import Coursera.AlgorithmsPt1.Common.AdjacencyListUndirected;

public class TestInput
{
	public int minCutValue;	
	public AdjacencyListUndirected adjacencyList;
	public String inputName;
	
	public TestInput(AdjacencyListUndirected adjacencyList, int minCutValue, String inputName)
	{
		this.adjacencyList = adjacencyList;
		this.minCutValue = minCutValue;
		this.inputName = inputName;
	}
}
