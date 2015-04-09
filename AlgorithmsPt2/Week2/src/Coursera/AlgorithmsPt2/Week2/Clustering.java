package Coursera.AlgorithmsPt2.Week2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Coursera.AlgorithmsPt2.Week1.*;

public class Clustering {
	// Edge comparator (by cost)
	public static Comparator<Edge> edgeComparator = new Comparator<Edge>()
	{
		@Override
		public int compare(Edge edge1, Edge edge2)
		{
			return edge1.getCost() - edge2.getCost();
		}					
	};
			
	// Compute maximum spacing for k-clustering graph
	public static int computeMaxSpacing(Graph graph, int k)
	{
		// Check for trivial case
		if (k <= 1)
		{
			return 0;
		}
		
		// Create priority queue (heap) to hold graph edges
		PriorityQueue<Edge> edgeHeap = new PriorityQueue<Edge>(edgeComparator);
		edgeHeap.addAll(graph.getEdges());
		
		// Iterate until size of graph is in k-clusters
		while (graph.getNodes().size() > k)
		{
			Edge minEdge = edgeHeap.remove();
			ArrayList<Edge> deletedEdges = graph.mergeNodes(minEdge.getStartNode(), minEdge.getEndNode());
			edgeHeap.removeAll(deletedEdges);
		}
		
		return edgeHeap.peek().getCost();
	}
}
