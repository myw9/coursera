package Coursera.AlgorithmsPt1.Week3;

import java.util.ArrayList;
import java.util.Random;

import Coursera.AlgorithmsPt1.Common.*;

public class MinCut
{
	// Find minimum cut of adjacency list using Karger's Min Cut Algorithm
	public static int FindMinCut(AdjacencyList adjacencyList, int numRepeats) throws Exception
	{
		int minCut = Integer.MAX_VALUE;
		Random generator = new Random(System.currentTimeMillis());
		for (int iteration=0; iteration<numRepeats; iteration++)
		{
			// Copy adjacency list
			AdjacencyList adjacencyListCopy = new AdjacencyList(adjacencyList);
			
			// Iterate until only 2 nodes remain			
			while (adjacencyListCopy.VertexCount() > 2)
			{
				// Pick random edge in adjacency list
				int randomIndex = (int) Math.floor(generator.nextDouble() * adjacencyListCopy.EdgeCount());
				Edge randomEdge = adjacencyListCopy.GetEdge(randomIndex);
				
				// Merge vertices
				adjacencyListCopy.MergeVertices(randomEdge.vertex1, randomEdge.vertex2);
			}
			
			// Store cut if less than current minimum
			if (adjacencyListCopy.EdgeCount()/2 < minCut)
			{
				minCut = adjacencyListCopy.EdgeCount()/2; 
			}
		}		
		return minCut;
	}
}
