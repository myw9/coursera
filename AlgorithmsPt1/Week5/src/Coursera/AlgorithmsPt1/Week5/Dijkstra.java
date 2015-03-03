package Coursera.AlgorithmsPt1.Week5;

import java.util.ArrayList;
import java.util.HashMap;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;
import Coursera.AlgorithmsPt1.Common.Edge;
import Coursera.AlgorithmsPt1.Common.MinHeap;
import Coursera.AlgorithmsPt1.Common.Vertex;

public class Dijkstra
{
	public static HashMap<Integer,VertexDijkstra> ComputeShortestPath(AdjacencyListDirected adjacencyList, int startVertexId)
	{
		// Initialize vertex heap
		MinHeap<VertexDijkstra> minHeap = new MinHeap<VertexDijkstra>(400);
		for (Vertex vertex : adjacencyList.vertices.values())
		{
			minHeap.Insert(new VertexDijkstra(vertex, 1000000));
		}
		
		// Initialize hash map to track shortest paths
		HashMap<Integer,VertexDijkstra> shortestMap = new HashMap<Integer,VertexDijkstra>();
		
		// Remove start vertex from heap and update shortest paths
		Vertex startVertex = adjacencyList.vertices.get(startVertexId);
		VertexDijkstra startVertexDijkstra = minHeap.Delete(new VertexDijkstra(startVertex, 1000000));
		startVertexDijkstra.greedyScore = 0;
		for (Edge edge : startVertex.edges)
		{
			Vertex destVertex = edge.destVertex;
			VertexDijkstra deletedVertexDijkstra = minHeap.Delete(new VertexDijkstra(destVertex, 1000000));
			if (deletedVertexDijkstra != null)
			{
				long newDistance = (startVertexDijkstra.greedyScore + edge.weight);
				deletedVertexDijkstra.greedyScore = (newDistance < deletedVertexDijkstra.greedyScore) ? newDistance : deletedVertexDijkstra.greedyScore;
				minHeap.Insert(deletedVertexDijkstra);
			}
		}
		shortestMap.put(startVertexDijkstra.vertex.id, startVertexDijkstra);
		
		// Iterate until no nodes left in min heap
		VertexDijkstra minVertex = minHeap.ExtractMin();
		while (minVertex != null)
		{
			for (Edge edge : minVertex.vertex.edges)
			{
				Vertex destVertex = edge.destVertex;
				VertexDijkstra deletedVertexDijkstra = minHeap.Delete(new VertexDijkstra(destVertex, 1000000));
				if (deletedVertexDijkstra != null)
				{
					long newDistance = (minVertex.greedyScore + edge.weight);
					deletedVertexDijkstra.greedyScore = (newDistance < deletedVertexDijkstra.greedyScore) ? newDistance : deletedVertexDijkstra.greedyScore;
					minHeap.Insert(deletedVertexDijkstra);
				}
			}
			shortestMap.put(minVertex.vertex.id, minVertex);
			minVertex = minHeap.ExtractMin();
		}
		
		return shortestMap;
	}
	
	public static HashMap<Integer,VertexDijkstra> ComputeShortestPathBrute(AdjacencyListDirected adjacencyList, int startVertexId)
	{
		// Initialize list of vertices to process
		ArrayList<Vertex> vertexToProcess = new ArrayList<Vertex>();
		for (Vertex vertex : adjacencyList.vertices.values())
		{
			vertexToProcess.add(vertex);
		}
		
		// Initialize shortest path map
		HashMap<Integer, VertexDijkstra> shortestMap = new HashMap<Integer, VertexDijkstra>();
		for (Vertex vertex : adjacencyList.vertices.values())
		{
			shortestMap.put(vertex.id, new VertexDijkstra(vertex, 1000000));
		}
		
		// Process start vertex
		VertexDijkstra startVertex = shortestMap.get(startVertexId);
		startVertex.greedyScore = 0;
		VertexDijkstra currentVertex = startVertex;
				
		while (!vertexToProcess.isEmpty())
		{
			// Update shortest paths lengths from current vertex
			Vertex vertex = adjacencyList.vertices.get(currentVertex.vertex.id);
			VertexDijkstra vertexDijkstra = shortestMap.get(vertex.id);
			for (Edge edge : vertex.edges)
			{
				if (vertexToProcess.contains(edge.destVertex))
				{
					VertexDijkstra vertexDest = shortestMap.get(edge.destVertex.id);
					long newDistance = (vertexDijkstra.greedyScore + edge.weight);
					vertexDest.greedyScore = (newDistance < vertexDest.greedyScore) ? newDistance : vertexDest.greedyScore;
				}
			}
			vertexToProcess.remove(vertex);
			
			// Find next vertex (lowest greedy score)
			long minDistance = Integer.MAX_VALUE;
			for (Vertex tempVertex : vertexToProcess)
			{
				if (shortestMap.get(tempVertex.id).greedyScore < minDistance)
				{
					currentVertex = shortestMap.get(tempVertex.id);
					minDistance = shortestMap.get(tempVertex.id).greedyScore;
				}
			}
		}
		
		return shortestMap;
	}
}
