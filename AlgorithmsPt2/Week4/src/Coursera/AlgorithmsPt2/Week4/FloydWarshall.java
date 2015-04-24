package Coursera.AlgorithmsPt2.Week4;

import Coursera.AlgorithmsPt2.Week1.*;

public class FloydWarshall {
	// Compute the shortest path amongst all pairs of source and destination nodes using the Floyd-Warshall algorithm
	public static Integer computeAllPairsShortestPath(Graph graph) throws Exception
	{
		if (graph == null)
		{
			throw new Exception("Invalid Graph");
		}
		
		if (graph.getEdges().size() == 0)
		{
			return 0;
		}
		
		// Create and initialize 3D solutions array for memoization
		int numNodes = graph.getNodes().size();
		Integer[][][] solutions = new Integer[numNodes+1][numNodes+1][2];	// Nodes are 1-indexed
		for (int i=1; i<=numNodes; i++)
		{
			for (int j=1; j<=numNodes; j++)
			{
				// Path from node to self
				if (i == j)
				{
					solutions[i][j][0] = 0;
				}				
				else
				{
					Node nodei = graph.getNode(i);
					boolean edgeFound = false;
					for (Edge edge : nodei.getEdges())
					{
						if (edge.getEndNode().getId() == j)
						{
							// Direct path from node i to j
							solutions[i][j][0] = edge.getCost();
							edgeFound = true;
							break;
						}
					}
					
					if (!edgeFound)
					{
						// Path does not exist
						solutions[i][j][0] = Integer.MAX_VALUE;
					}
				}				
			}
		}
		
		// Execute dynamic program
		for (int maxNodeId=1; maxNodeId<=numNodes; maxNodeId++)
		{
			// Iterate over all pairs of source and destination nodes to compute shortest paths
			for (int startNodeId=1; startNodeId<=numNodes; startNodeId++)
			{
				for (int endNodeId=1; endNodeId<=numNodes; endNodeId++)
				{
					int case1Value = solutions[startNodeId][endNodeId][0];
					int case2Value = Integer.MAX_VALUE;
					if (solutions[startNodeId][maxNodeId][0] != Integer.MAX_VALUE && solutions[maxNodeId][endNodeId][0] != Integer.MAX_VALUE)
					{
						case2Value = solutions[startNodeId][maxNodeId][0] + solutions[maxNodeId][endNodeId][0]; 
					}
					int minValue = Math.min(case1Value, case2Value);
					solutions[startNodeId][endNodeId][1] = minValue;
				}
			}
			
			// Update "k-1" values
			for (int startNodeId=1; startNodeId<=numNodes; startNodeId++)
			{
				for (int endNodeId=1; endNodeId<=numNodes; endNodeId++)
				{
					solutions[startNodeId][endNodeId][0] = solutions[startNodeId][endNodeId][1];
				}
			}
		}
		
		// Check for negative cycles
		for (int nodeId=1; nodeId<=numNodes; nodeId++)
		{
			if (solutions[nodeId][nodeId][1] < 0)
			{
				return null;
			}
		}
		
		// Return shortest shortest path
		int shortestShortestPath = Integer.MAX_VALUE;
		for (int startNodeId=1; startNodeId<=numNodes; startNodeId++)
		{
			for (int endNodeId=1; endNodeId<=numNodes; endNodeId++)
			{
				if (startNodeId != endNodeId)
				{
					int newPathLength = solutions[startNodeId][endNodeId][1];
					if (newPathLength < shortestShortestPath)
					{
						shortestShortestPath = newPathLength;
					}
				}
			}
		}
		
		return shortestShortestPath;
	}
}
