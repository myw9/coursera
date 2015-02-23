package Coursera.AlgorithmsPt1.Week3;

import Coursera.AlgorithmsPt1.Common.AdjacencyListUndirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		System.out.print("Parsing Adjacency File...");
		AdjacencyListUndirected adjacencyList = Common.ParseAdjacencyFileUndirected("Inputs\\kargerMinCut.txt");
		System.out.println("DONE");
		
		System.out.print("Finding Min Cut...");
		int n = adjacencyList.VertexCount();
		int minCut = MinCut.FindMinCut(adjacencyList, (int) (Math.pow(n, 1)*Math.log(n)));
		System.out.println(minCut);
	}
}
