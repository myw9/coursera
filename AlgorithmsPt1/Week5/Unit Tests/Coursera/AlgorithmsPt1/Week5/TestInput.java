package Coursera.AlgorithmsPt1.Week5;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;

public class TestInput
{
	public String fileName;
	public AdjacencyListDirected adjacencyList;
	public int srcVertexId;
	public int destVertexId;
	public long cost;
	
	public TestInput(AdjacencyListDirected adjacencyList, int srcVertexId, int destVertexId, int cost, String fileName)
	{
		this.adjacencyList = adjacencyList;
		this.srcVertexId = srcVertexId;
		this.destVertexId = destVertexId;
		this.cost = cost;
		this.fileName = fileName;
	}
}
