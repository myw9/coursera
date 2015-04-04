package Coursera.AlgorithmsPt2.Week1;

import java.util.ArrayList;
import java.util.HashSet;

public class MinimumSpanningTree {
	// Compute minimum spanning tree
	public static ArrayList<Edge> computeMST(Graph graph)
	{
		if (graph == null || graph.nodes.size() == 0)
		{
			return null;			
		}
		
		ArrayList<Edge> edgesMST = new ArrayList<Edge>();
		ArrayList<Node> nodesToProcess = new ArrayList<Node>(graph.nodes);
		Node node = nodesToProcess.remove(0);		
		HashSet<Integer> nodesToProcessSet = new HashSet<Integer>();
		for (Node n : nodesToProcess)
		{
			nodesToProcessSet.add(n.id);
		}
		
		while(nodesToProcess.size() > 0)
		{
			int minCost = Integer.MAX_VALUE;
			Edge minEdge = null;
			Node minNode = null;
			for (Node n : nodesToProcess)
			{
				for (Edge e : n.edges)
				{
					if (!nodesToProcessSet.contains(e.startNode.id) || !nodesToProcessSet.contains(e.endNode.id))
					{
						if (e.cost < minCost)
						{
							minCost = e.cost;
							minEdge = e;
							minNode = n;
						}
					}
				}
			}
			
			edgesMST.add(minEdge);
			nodesToProcess.remove(minNode);
			nodesToProcessSet.remove(minNode.id);
		}
		
		return edgesMST;
	}
	
	// Compute cost of MST
	public static long computeCost(ArrayList<Edge> mst)
	{
		long totalCost = 0;
		for (Edge e : mst)
		{
			totalCost += e.cost;
		}
		return totalCost;
	}
}
